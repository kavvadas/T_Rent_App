package gr.aueb.sweng22.team11.view.Renter.RenterSearchAds;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.dao.AdDao;
import gr.aueb.sweng22.team11.domain.Ad;

public class RenterSearchAdsPresenter {
    private RenterSearchAdsView view;
    private AdDao adDao;
    private ArrayList<Ad> ads = new ArrayList<>();
    /**
     * Default constructor
     */
    public RenterSearchAdsPresenter(){}

    /**
     * finds the ads via input
     * and passes all the values to the array ads
     */
    public void findAds(){
        String input = view.getInput();
        if(input.equals(""))
            ads = adDao.findAll();
        if(adDao.findByRegion(input).isEmpty()) {

        }else {
            if (input.equals(adDao.findByRegion(input).get(0).getHouse().getRegion()))
                ads = adDao.findByRegion(input);
        }
    }
    public void onStartMaps(){view.startMaps();}
    /**
     * get the owner ads
     * @return the ArrayList of the ads
     */
    public ArrayList<Ad> getAds(){return ads;}

    /**
     * set a new view
     * @param view the new view
     */
    public void setView(RenterSearchAdsView view){this.view = view;}


    /**
     * clear the view
     */
    public void clearView(){this.view = null;}

    /**
     * set the adDao
     * @param adDao thenew adDao
     */
    public void setAdDao(AdDao adDao){this.adDao = adDao;}
}
