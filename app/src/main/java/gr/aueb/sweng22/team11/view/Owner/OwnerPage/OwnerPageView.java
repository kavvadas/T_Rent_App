package gr.aueb.sweng22.team11.view.Owner.OwnerPage;

import androidx.appcompat.app.AlertDialog;

public interface OwnerPageView {
    /**
     * Starts OwnerInfoActivity
     * when the account button is pressed
     */
    void toOwnerAccount();

    /**
     * Starts the ownerAdsActivity
     * when the myads button is pressed
     * @param title title of the owner put as extra
     */
    void toOwnerAds(String title);

    /**
     * Goes to the loginActivity
     * when the owner logs out
     */
    void logout();

    /**
     * @param layoutId layout of popup
     * @param msg message to bve shown in the layout
     * @param btn1 first button of pop
     * @param btn2 second button of pop
     * @return an AlertDialog to be shown
     */
    AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2);

    /**
     * confirmation for logout
     * when the owner presses the logout button
     * shows the popup with the message and the 2 buttons
     */
    void logOutConfirmation();

    /**
     * when the owner presses no in the AlertDialog
     * we dismiss the popup
     */
    void noLogOut();

}
