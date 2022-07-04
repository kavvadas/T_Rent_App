package gr.aueb.sweng22.team11.view.Ad.HandleRequest;

public interface HandleRequestView {

    /**
     * Method used
     * to set the nickname field of activity's layout
     * screen to the nickname of the renter that sent the request
     * @param renter nickname of the renter
     */
    void setRenter(String renter);

    /**
     * Method used
     * to set the appointment field of activity's layout
     * screen to the appointment of the request
     * @param appointment appointment of the request
     */
    void setAppointment(String appointment);

    /**
     * Starts the AdPageActivity
     * when accept button is pressed
     * @param title title of the ad that is passed as an extra
     */
    void startAcceptRequest(String title);

    /**
     * Starts the adPageActivity
     * when decline button is pressed
     * @param title tile of the ad that is passed as an extra
     */
    void startDeclineRequest(String title);
}
