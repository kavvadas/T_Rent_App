package gr.aueb.sweng22.team11.view.User.Login;

import gr.aueb.sweng22.team11.dao.LoginDao;
import gr.aueb.sweng22.team11.dao.OwnerDao;
import gr.aueb.sweng22.team11.dao.RenterDao;
import gr.aueb.sweng22.team11.domain.Credentials;
import gr.aueb.sweng22.team11.domain.OwnerAccount;
import gr.aueb.sweng22.team11.domain.RentAccount;

public class LoginPresenter {

    private LoginView view;
    private OwnerDao ownerDao;
    private RenterDao renterDao;
    private LoginDao loginDao;

    /**
     * Default Constructor
     */
    public LoginPresenter(){ }

    /**
     * Here we check if the credentials parsed are in ownerDao or renterDao
     * if yes, we set the user as logged in
     * if not we show a pop up for invalid credentials
     * @param username input
     * @param password input
     */
    public void checkInDao(String username, String password){
        Credentials credentialsCheck = new Credentials(username,password);
        if(ownerDao.verify(credentialsCheck)){
            OwnerAccount loggedInOwner = ownerDao.findByCredentials(credentialsCheck);
            loginDao.setUser(loggedInOwner);
            view.startOwnerPage(loggedInOwner.getTitle());
        } else if(renterDao.verify(credentialsCheck)) {
            RentAccount loggedInRenter = renterDao.findByCredentials(credentialsCheck);
            loginDao.setUser(loggedInRenter);
            view.startRenterPage(loggedInRenter.getNickname());
        }else {
            view.showPop(view,"Invalid credentials");
        }
    }

    /**
     * set a new view
     * @param view the new view
     */
    public void setView(LoginView view){this.view = view;}

    /**
     * clear the view
     */
    public void clearView(){this.view = null;}

    /**
     * set the ownerDao
     * @param ownerDao the new ownerDao
     */
    public void setOwnerDao(OwnerDao ownerDao){this.ownerDao = ownerDao;}

    /**
     * set the renterDao
     * @param renterDao the new renterDao
     */
    public void setRenterDao(RenterDao renterDao){this.renterDao = renterDao;}

    /**
     * set the loginDao
     * @param loginDao the new loginDao
     */
    public void setLoginDao(LoginDao loginDao){this.loginDao = loginDao;}

    /**
     * gets the loginDao
     * @return the loginDao
     */
    public LoginDao getLoginDao(){return loginDao;}

    /**
     * checks if the credentials are valid
     * if they are not we show a pop
     * if yes we check if the user exists in the dao
     */
    public void validateCredentials(){
        String username = view.getUsername();
        String password = view.getPassword();
        if(username.length()<5||username.length()>20){
            view.showPop(view, "Username must be must be between 5 and 15 letters");
        }else if (password.length() < 5)
            view.showPop(view, "Password must be above 5 characters");
        else {
            checkInDao(username, password);
        }
    }







}
