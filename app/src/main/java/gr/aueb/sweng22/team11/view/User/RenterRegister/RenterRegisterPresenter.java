package gr.aueb.sweng22.team11.view.User.RenterRegister;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;


import java.time.LocalDate;

import gr.aueb.sweng22.team11.dao.LoginDao;
import gr.aueb.sweng22.team11.dao.RenterDao;
import gr.aueb.sweng22.team11.dao.OwnerDao;
import gr.aueb.sweng22.team11.domain.Credentials;
import gr.aueb.sweng22.team11.domain.RentAccount;
import gr.aueb.sweng22.team11.domain.User;
import gr.aueb.sweng22.team11.memoryDao.renterDaoMemory;

public class RenterRegisterPresenter {
    private RenterRegisterView view;
    private OwnerDao ownerDao;
    private LoginDao loginDao;
    private RenterDao renterDao;
    private RentAccount connectedRenter;

    /**
     * Default Constructor
     */
    public RenterRegisterPresenter() {
    }

    /**
     * sets the already saved info of a logged in renter
     * @param nickname title of renter
     */
    public void savedInfo(String nickname){
        if(nickname == null)
            return;
        connectedRenter = renterDao.findByNickname(nickname);
        if(connectedRenter == null)
            return;
        view.setNickname(connectedRenter.getNickname());
        view.setName(connectedRenter.getFirstName());
        view.setLastname(connectedRenter.getLastName());
        view.setUsername(connectedRenter.getCredentials().getUsername());
        view.setPassword(connectedRenter.getCredentials().getPassword());
        view.setBirthdate(connectedRenter.getDateOfBirth().toString());
        view.setPhone(connectedRenter.getPhoneNumber());
        view.setEmail(connectedRenter.getEmail());
        view.lock();


    }
    /**
     * handles the data
     *
     * create an renterAccount if we register
     * and starts the loginPage
     *
     * edit the already created renterAccount
     * and starts the renterPage
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void handleRenterData() {
        String username = view.getUsername();
        String password = view.getPassword();
        String name = view.getName();
        String lastname = view.getLastname();
        String phone = view.getPhone();
        String email = view.getEmail();
        String birthdate = view.getBirthdate();
        String password2 = view.getPassword2();
        String nickname = view.getNickname();
        int year = view.getYear();
        //CHECK ALL DATA
        if (!checkName(username))
            view.showPop(view, "Username must be between 5 and 20 characters");
        else if (password.length() < 4 || password2.length() < 4)
            view.showPop(view, "Password must be greater that 5 characters");
        else if (!checkConfirmed(password, password2))
            view.showPop(view, "Passwords must be the same");
        else if (!checkName(name))
            view.showPop(view, "Name must be between 5 and 20 characters");
        else if (!checkName(lastname))
            view.showPop(view, "Lastname must be between 5 and 20 characters");
        else if (!checkEmail(email))
            view.showPop(view, "Email must be: name@this.domain");

        else {
            if (connectedRenter == null) {
                if (!checkAge(year))
                    view.showPop(view, "You have to be 18 to create an account");
                if (alreadyUser(new Credentials(username, password), connectedRenter)) {
                    view.showPop(view, "Username already exits!");
                    return;
                }
                if(nicknameAlreadyUsed(nickname,connectedRenter)){
                    view.showPop(view, "Nickname already exists!");
                    return;
                }

                RentAccount renter = new RentAccount(nickname,name, lastname, phone, email, LocalDate.now(), new Credentials(username, password));
                renterDao = new renterDaoMemory();
                renterDao.save(renter);
                loginDao.setUser(renter);
                view.toLoginPage();
            }else{
                if (alreadyUser(new Credentials(username, password), connectedRenter)) {
                    view.showPop(view, "Username already exits!");
                    return;
                }
                if (nicknameAlreadyUsed(nickname, connectedRenter)) {
                    view.showPop(view, "Nickname already exists!");
                    return;
                }
                connectedRenter.setFirstName(name);
                connectedRenter.setLastName(lastname);
                connectedRenter.setCredentials(new Credentials(username, password));
                connectedRenter.setPhoneNumber(phone);
                connectedRenter.setEmail(email);
                view.startRenterPage(username);
            }
        }
    }

    /**
     * @param pass the first password
     * @param pass2 the second password
     * @return true if passwords are the same,false if not
     */
    private boolean checkConfirmed(String pass, String pass2){
        if(!pass.equals(pass2))
            return false;
        return true;
    }

    /**
     * @param val the value we want to check
     * @return true if the name is valid
     */
    private boolean checkName(String val) {
        String checkSpaces = "\\A\\w{1,20}\\z";
        if (val.isEmpty()||val.length() > 20||val.length() < 3||!val.matches(checkSpaces))
            return false;
        return true;
    }

    /**
     * checks if there is another user with the same credentials
     * @param credentials the user credentials we want to check
     * @param user the user in dao
     * @return true if user exists,false if not
     */
    public boolean alreadyUser(Credentials credentials, User user){
        boolean used = false;
        if(renterDao.credentialsUsed(credentials,user))
            used = true;
        if(ownerDao.credentialsUsed(credentials,user))
            used=true;
        return used;
    }

    /**
     * check if the title is already used by other user
     * @param nickname the title we want to check
     * @param user the user in dao
     * @return true if the title is used, false if not
     */
    public boolean nicknameAlreadyUsed(String nickname, User user){
        boolean used = false;
        if(renterDao.nicknameAlreadyUsed(nickname,user))
            used = true;
        return  used;
    }

    /**
     * @param val the value we want to check
     * @return true if the email is valid,false if not
     */
    public boolean checkEmail(String val){
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(val.isEmpty())
            return false;
        if(!val.matches(checkEmail))
            return false;
        return true;
    }

    /**
     * @param val the value we want to check
     * @return true if the age is valid,false if not
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean checkAge(int val){
        int now = LocalDate.now().getYear();
        if(now-val<18)
            return false;
        return true;
    }

    /**
     * get loginDao
     * @return the loginDao
     */
    public LoginDao getLoginDao(){return  loginDao;}

    /**
     * set loginDao
     * @param loginDao the new loginDao
     */
    public void setLoginDao(LoginDao loginDao){this.loginDao = loginDao;}

    /**
     * set a new view
     * @param view the new view
     */
    public void setView(RenterRegisterView view){this.view = view;}

    /**
     * clear the view
     */
    public void clearView(){this.view = null;}

    /**
     * set ownerDao
     * @param ownerDao the new ownerDao
     */
    public void setOwnerDao(OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }

    /**
     * set renterDao
     * @param renterDao the new renterDao
     */
    public void setRenterDao(RenterDao renterDao) {
        this.renterDao = renterDao;
    }
}
