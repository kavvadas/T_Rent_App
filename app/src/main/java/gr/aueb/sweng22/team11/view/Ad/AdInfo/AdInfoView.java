package gr.aueb.sweng22.team11.view.Ad.AdInfo;

public interface AdInfoView {

    /**
     * Method used
     * to set the street field of activity's layout
     * screen to the street of the ad that is created
     * @param street street of ad to be set
     */
    void setStreet(String street);

    /**
     * Method used
     * to set the postcode field of activity's layout
     * screen to the postcode of the ad that is created
     * @param postcode postcode of ad to be set
     */
    void setPostcode(String postcode);

    /**
     * Method used
     * to set the region field of activity's layout
     * screen to the region of the ad that is created
     * @param region region of ad to be set
     */
    void setRegion(String region);

    /**
     * Method used
     * to set the rent field of activity's layout
     * screen to the rent of the ad that is created
     * @param rent rent of ad to be set
     */
    void setRent(String rent);

    /**
     * Method used
     * to set the comment field of activity's layout
     * screen to the comment of the ad that is created
     * @param comment comment of ad to be set
     */
    void setComment(String comment);

    /**
     * Starts the create ad activity so that the user can modify the ad info
     * @param comment title of ad to be passed as an extra
     */
    void startEditAd(String comment);

    /**
     * Deletes the ad of the owner
     * and goes back to the owner page
     * @param title title of the owner passed as and extra
     */
    void startDeleteAd(String title);
}
