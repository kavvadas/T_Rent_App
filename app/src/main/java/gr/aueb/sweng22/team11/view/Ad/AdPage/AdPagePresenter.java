package gr.aueb.sweng22.team11.view.Ad.AdPage;

import gr.aueb.sweng22.team11.dao.AdDao;
import gr.aueb.sweng22.team11.domain.Ad;


public class AdPagePresenter {
    private AdPageView view;
    private AdDao adDao;
    private Ad ad;

    /**
     * Default constructor
     */
    public AdPagePresenter(){}

    /**
     * finds the ad info by comment
     * @param comment the comment of the ad
     */
    public void findAdInfo(String comment){
        if(comment == null)
            return;
        ad = adDao.findByComment(comment);

        /**
         * get the ad's comment
         * @return ad of the comment
         */
    }
    public String getAdComment(){
        if(ad == null)
            return "";
        return ad.getComment();
    }

    /**
     * set the adDao
     * @param adDao the new adDao
     */
    public void setAdDao(AdDao adDao){this.adDao = adDao;}

    /**
     * Starts the adInfoActivity
     * when the info button is pressed
     */
    public void onAdInfo(){view.toAdInfo(ad.getComment(),ad.getOwner().getTitle());}

    /**
     * Starts the adRequestsActivity
     * when the myRequests button is pressed
     */
    public void onAdRequests(){view.toAdRequests(ad.getComment());}

    /**
     * Starts the OwnerPageActivity
     * when the homepage button is pressed
     */
    public void onOwnerPage(){view.toOwnerPage(ad.getOwner().getTitle());}

    /**
     * starts the adAppointmentsActivity
     * when the myAppointments button is pressed
     */
    public void onAdAppointments(){view.toAdAppointments(ad.getComment());}

    /**
     * set a new view
     * @param view the new view
     */
    public void setView(AdPageView view){this.view = view;}

    /**
     * clear the view
     */
    public void clearView(){this.view = null;}

}
