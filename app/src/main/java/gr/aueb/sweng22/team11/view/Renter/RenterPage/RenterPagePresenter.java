package gr.aueb.sweng22.team11.view.Renter.RenterPage;

import android.util.Log;

import gr.aueb.sweng22.team11.dao.LoginDao;
import gr.aueb.sweng22.team11.dao.RenterDao;
import gr.aueb.sweng22.team11.domain.RentAccount;
import gr.aueb.sweng22.team11.domain.User;

public class RenterPagePresenter {
    private RenterPageView view;
    private LoginDao loginDao;
    private RentAccount renter;
    private RenterDao renterDao;
    /**
     * Default constructor
     */
    public RenterPagePresenter(){}
    /**
     * finds the renter's info by nickname
     * @param nickname title of renter
     */
    public void findRenterInfo(String nickname){
        if(nickname == null)
            return;
        renter = renterDao.findByNickname(nickname);
    }
    /**
     * Get the renter's nickname
     * @return the renter nickname
     */
    public String getRenterNickname(){
        if(renter == null)
            return "";
        return renter.getNickname();
    }
    /**
     * Sets the renter to the user that is currently logged in
     * @param user to be set as an renter
     */
    public void setRenter(User user){
        if(user == null)
            return;
        if(!(user instanceof RentAccount))
            return;
        renter = (RentAccount) user;
    }

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
     * Starts RenterInfoActivity
     * when the account button is pressed
     */
    public void onRenterAccount(){view.toRenterAccount();}

    /**
     * Starts the searchAdsActivity
     * when the searchAds button is pressed
     */
    public void onRenterSearch(){view.toRenterSearch(renter.getNickname());}

    /**
     * Goes to the loginActivity
     */
    public void onRenterAppointments(){view.toRenterAppointments(renter.getNickname());}

    /**
     * when the user presses the log out button
     * and a confirmation pop up shows
     */
    public void onLogout(){view.logOutConfirmation();}
    /**
     * when the owner presses no in the AlertDialog
     * we dismiss the popup
     */
    public void onNoLogout(){view.noLogOut();}
    /**
     * user logs out
     */
    public void onYesLogout(){
        loginDao.clear();
        view.logout();
    }
    /**
     * set a new view
     * @param view the new view
     */
    public void setView(RenterPageView view){this.view = view;}

    /**
     * clear the view
     */
    public void clearView(){this.view = null;}

}
