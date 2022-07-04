package gr.aueb.sweng22.team11.view.Owner.CreateAd;

import android.view.View;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.domain.Appointment;
import gr.aueb.sweng22.team11.view.User.OwnerRegister.OwnerRegisterView;

public interface CreateAdView {
    /**
     * get the content of textInputLayout
     * @return the street given
     */
    String getStreet();
    /**
     * get the content of textInputLayout
     * @return the postcode given
     */
    String getPostcode();
    /**
     * get the content of textInputLayout
     * @return the region given
     */
    String getRegion();
    /**
     * get the content of textInputLayout
     * @return the rent given
     */
    String getRent();
    /**
     * get the content of textInputLayout
     * @return the comment given
     */
    String getComment();
    /**
     * get the content of dates and hours been chosen by the owner
     * @return an array list of appointments
     */

    ArrayList<Appointment> getAppointments();
    /**
     * get the content of arraylist string
     * @return the description given
     */
    ArrayList<String> getDescription();
    /**
     * Method used
     * to set the street field of activity's layout
     * screen to the street of the ad that is already created
     * @param street street of ad to be set
     */
    void setStreet(String street);
    /**
     * Method used
     * to set the postcode field of activity's layout
     * screen to the postcode of the ad that is already created
     * @param postcode postcode of ad to be set
     */
    void setPostcode(String postcode);
    /**
     * Method used
     * to set the region field of activity's layout
     * screen to the region of the ad that is already created
     * @param region region of ad to be set
     */
    void setRegion(String region);
    /**
     * Method used
     * to set the rent field of activity's layout
     * screen to the rent of the ad that is already created
     * @param rent rent of ad to be set
     */
    void setRent(String rent);
    /**
     * Method used
     * to set the comment field of activity's layout
     * screen to the comment of the ad that is already created
     * @param comment comment of ad to be set
     */
    void setComment(String comment);
    /**
     * Method used
     * to set the appointments field of activity's layout
     * screen to the appointments of the ad that is already created
     * @param appointments appointments of ad to be set
     */
    void setAppointments(ArrayList<Appointment> appointments);
    /**
     *show a popup on the screen
     * @param view the view of the popup
     * @param mess the message that will be shown
     */
    void showPop(CreateAdView view,String mess);
    /**
     * Starts the owner page activity after the creation of ad
     * @param title title of owner to be passed as an extra
     */
    void toOwnerPage(String title);
    /**
     * Starts the ad page activity after the modify of the ad
     * @param comment comment of ad to be passed as an extra
     * @param title title of owner to be passed as an extra
     */
    void toAdPage(String comment,String title);


}
