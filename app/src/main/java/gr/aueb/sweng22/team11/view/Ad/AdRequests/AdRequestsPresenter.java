package gr.aueb.sweng22.team11.view.Ad.AdRequests;

import android.util.Log;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.dao.AdDao;
import gr.aueb.sweng22.team11.dao.RequestDao;
import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.domain.Request;

public class AdRequestsPresenter {
    AdRequestsView view;
    private AdDao adDao;
    private RequestDao requestDao;
    private ArrayList<Request> requests = new ArrayList<>();

    /**
     * Default constructor
     */
    public AdRequestsPresenter(){}

    /**
     * finds the requests that has been sent to the current ad
     * and passes all the values to the array requests
     * @param title of the owner
     */
    public void findRequestsSent(String title){
        Ad ad = adDao.findByComment(title);
        if(ad == null)
            return;
        requests = requestDao.findByAd(ad);

    }

    /**
     * get the ad requests
     * @return the ArrayList of the requests
     */
    public ArrayList<Request> getRequests(){return requests;}

    /**
     * set a new view
     * @param view the new view
     */
    public void setView(AdRequestsView view){this.view = view;}

    /**
     * clear the view
     */
    public void clearView(){this.view = null;}

    /**
     * set the adDao
     * @param adDao the new adDao
     */
    public void setAdDao(AdDao adDao){this.adDao = adDao;}

    /**
     * set the requestDao
     * @param requestDao the new requestDao
     */
    public void setRequestDao(RequestDao requestDao){this.requestDao = requestDao;}
}
