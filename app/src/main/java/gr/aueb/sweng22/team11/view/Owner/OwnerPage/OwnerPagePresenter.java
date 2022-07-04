package gr.aueb.sweng22.team11.view.Owner.OwnerPage;

import gr.aueb.sweng22.team11.dao.LoginDao;
import gr.aueb.sweng22.team11.dao.OwnerDao;
import gr.aueb.sweng22.team11.domain.OwnerAccount;
import gr.aueb.sweng22.team11.domain.User;

public class OwnerPagePresenter {
    private OwnerPageView view;
    private LoginDao loginDao;
    private OwnerAccount owner;
    private OwnerDao ownerDao;

    /**
     * Default constructor
     */
    public OwnerPagePresenter(){}

    /**
     * finds the owner's info by title
     * @param title title of owner
     */
    public void findOwnerInfo(String title){
        if(title == null)
            return;
        owner = ownerDao.findByTitle(title);
    }

    /**
     * Get the owner's title
     * @return the owner title
     */
    public String getOwnerTitle(){
        if(owner == null)
            return "";
        return owner.getTitle();
    }

    /**
     * Sets the owner to the user that is currently logged in
     * @param user to be set as an owner
     */
    public void setOwner(User user){
        if(user == null)
            return;
        if(!(user instanceof OwnerAccount))
            return;
        owner = (OwnerAccount) user;
    }

    /**
     * set the ownerDao
     * @param ownerDao the new ownerDao
     */
    public void setOwnerDao(OwnerDao ownerDao){this.ownerDao = ownerDao;}

    /**
     * set the logged in user
     * @param loginDao the logged in user
     */
    public void setLoginDao(LoginDao loginDao){this.loginDao = loginDao;}

    /**
     * Starts OwnerInfoActivity
     * when the account button is pressed
     */
    public void onOwnerAccount(){view.toOwnerAccount();}

    /**
     * Starts the ownerAdsActivity
     * when the myads button is pressed
     */
    public void onOwnerAds(){view.toOwnerAds(owner.getTitle());}

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
    public void setView(OwnerPageView view){this.view = view;}

    /**
     * clear the view
     */
    public void clearView(){this.view = null;}

}
