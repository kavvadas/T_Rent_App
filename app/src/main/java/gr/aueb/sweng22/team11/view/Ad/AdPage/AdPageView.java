package gr.aueb.sweng22.team11.view.Ad.AdPage;

public interface AdPageView {
    /**
     * Starts the adInfoActivity
     * when the info button is pressed
     * @param comment comment of the ad
     * @param title title fot he owner
     */
    void toAdInfo(String comment,String title);

    /**
     * Starts the adRequestsActivity
     * when the myRequests button is pressed
     * @param comment title of the ad
     */
    void toAdRequests(String comment);

    /**
     * Starts the OwnerPageActivity
     * when the homepage button is pressed
     * @param title title of the owner
     */
    void toOwnerPage(String title);

    /**
     * starts the adAppointmentsActivity
     * when the myAppointments button is pressed
     * @param comment comment of the ad
     */
    void toAdAppointments(String comment);
}
