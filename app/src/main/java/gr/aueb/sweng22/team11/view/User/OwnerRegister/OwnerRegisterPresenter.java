package gr.aueb.sweng22.team11.view.User.OwnerRegister;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;

import java.security.acl.Owner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import gr.aueb.sweng22.team11.dao.LoginDao;
import gr.aueb.sweng22.team11.dao.OwnerDao;
import gr.aueb.sweng22.team11.dao.RenterDao;
import gr.aueb.sweng22.team11.domain.Credentials;
import gr.aueb.sweng22.team11.domain.OwnerAccount;
import gr.aueb.sweng22.team11.domain.User;
import gr.aueb.sweng22.team11.memoryDao.ownerDaoMemory;

public class OwnerRegisterPresenter {
    private OwnerRegisterView view;
    private OwnerDao ownerDao;
    private LoginDao loginDao;
    private RenterDao renterDao;
    private OwnerAccount connectedOwner;

    /**
     * Default Constructor
     */
    public OwnerRegisterPresenter() {
    }

    /**
     * sets the already saved info of a logged in owner
     * @param title title of owner
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void savedInfo(String title){
        if(title == null)
            return;
        connectedOwner = ownerDao.findByTitle(title);
        if(connectedOwner == null)
            return;
        view.setName(connectedOwner.getFirstName());
        view.setLastname(connectedOwner.getLastName());
        view.setUsername(connectedOwner.getCredentials().getUsername());
        view.setPassword(connectedOwner.getCredentials().getPassword());
        view.setBirthdate(connectedOwner.getDateOfBirth().toString());
        view.setPhone(connectedOwner.getPhoneNumber());
        view.setEmail(connectedOwner.getEmail());
        view.setTitle(connectedOwner.getTitle());
        view.lock();

    }

    /**
     * handles the data
     *
     * create an ownerAccount if we register
     * and starts the loginPage
     *
     * edit the already created ownerAccount
     * and starts the ownerPage
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void handleOwnerData() {
        String username = view.getUsername();
        String password = view.getPassword();
        String name = view.getName();
        String lastname = view.getLastname();
        String phone = view.getPhone();
        String email = view.getEmail();
        String birthdate = view.getBirthdate();
        String title = view.getOwnerTitle();
        String password2 = view.getPassword2();
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
        else if(phone.length()!=10)
            view.showPop(view, "Phonenumber must ");
        else {
            if (connectedOwner == null) {
                int year = view.getYear();
                if (!checkAge(year))
                    view.showPop(view, "You have to be 18 to create an account");
                if (alreadyUser(new Credentials(username, password), connectedOwner)) {
                    view.showPop(view, "Username already exits!");
                    return;
                }
                if (titleAlreadyUsed(title, connectedOwner)) {
                    view.showPop(view, "Title already exists!");
                    return;
                }
                OwnerAccount owner = new OwnerAccount(title, name, lastname, phone, email, LocalDate.now(), new Credentials(username, password));
                ownerDao = new ownerDaoMemory();
                ownerDao.save(owner);
                loginDao.setUser(owner);
                view.toLoginPage();
            }else{
                if (alreadyUser(new Credentials(username, password), connectedOwner)) {
                    view.showPop(view, "Username already exits!");
                    return;
                }
                if (titleAlreadyUsed(title, connectedOwner)) {
                    view.showPop(view, "Title already exists!");
                    return;
                }
                connectedOwner.setFirstName(name);
                connectedOwner.setLastName(lastname);
                connectedOwner.setCredentials(new Credentials(username, password));
                connectedOwner.setPhoneNumber(phone);
                connectedOwner.setEmail(email);
                connectedOwner.setTitle(title);
                view.startOwnerPage(title);
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
        if (val.isEmpty()||val.length() > 20||val.length() < 5||!val.matches(checkSpaces))
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
     * @param title the title we want to check
     * @param user the user in dao
     * @return true if the title is used, false if not
     */
    public boolean titleAlreadyUsed(String title, User user){
        boolean used = false;
        if(ownerDao.titleUsed(title, user))
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
    public void setView(OwnerRegisterView view){this.view = view;}

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
