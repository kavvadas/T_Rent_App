package gr.aueb.sweng22.team11.view.Renter.RenterCreateRequest;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.domain.Appointment;

public interface RenterCreateRequestView {

    /**
     * Method used
     * to set the title field of activity's layout
     * screen to the title of the ad
     * @param title title of ad to be set
     */
    void setTitle(String title);

    /**
     * Method used
     * to set the owner field of activity's layout
     * screen to the nickname of the owner
     * @param owner nickname of owner to be set
     */
    void setOwner(String owner);

    /**
     * Method used
     * to set the region field of activity's layout
     * screen to the region of the ad
     * @param region region of ad to be set
     */
    void setRegion(String region);

    /**
     * Method used
     * to set the street field of activity's layout
     * screen to the street of the ad
     * @param street street of ad to be set
     */
    void setStreet(String street);

    /**
     * Method used
     * to set the postcode field of activity's layout
     * screen to the postcode of the ad
     * @param postcode postcode of ad to be set
     */
    void setPostcode(String postcode);

    /**
     * Method used
     * to set the rent field of activity's layout
     * screen to the rent of the ad
     * @param rent rent of ad to be set
     */
    void setRent(String rent);

    /**
     * Method used
     * to set the appointments field of activity's layout
     * screen to the appointments of the ad that is already created
     * @param appointments appointments of ad to be set
     */
    void setAppointments(ArrayList<Appointment> appointments);

    /**
     * get the content of dates and hours been chosen by the owner
     * @return an array list of appointments
     */

    ArrayList<String> getChosenAppointment();

    /**
     * sends the request that the renter created
     * starts the RenterPageActivity and passes the nickname of the renter
     * @param nickname nickname of renter
     */
    void startRequest(String nickname);

}
