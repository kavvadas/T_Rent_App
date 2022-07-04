package gr.aueb.sweng22.team11.view.Owner.OwnerAds;

import android.view.View;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.dao.AdDao;
import gr.aueb.sweng22.team11.dao.OwnerDao;
import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.domain.OwnerAccount;

public class OwnerAdsPresenter {
    private OwnerAdsView view;
    private String own_title;
    private OwnerDao ownerDao;
    private ArrayList<Ad> ads = new ArrayList<>();

    /**
     * Default constructor
     */
    public OwnerAdsPresenter(){}

    /**
     * finds the ads that owner has been created
     * and passes all the values to the array ads
     * @param title of the owner
     */
    public void findAdsCreated(String title){
        OwnerAccount owner = ownerDao.findByTitle(title);
        if(owner == null)
            return;
        own_title = owner.getTitle();
        ads.clear();
        ads.addAll(owner.getAds());
    }

    /**
     * get the owner ads
     * @return the ArrayList of the ads
     */
    public ArrayList<Ad> getAds(){
        return ads;
    }

    /**
     * When the + button is pushed we go
     * to the CreateAdActivity
     */
    public void onCreateAd(){view.starCreateAd(own_title);}

    /**
     * set a new view
     * @param view the new view
     */
    public void setView(OwnerAdsView view){this.view = view;}

    /**
     * clear the view
     */
    public void clearView(){this.view = null;}

    /**
     * set the ownerDao
     * @param ownerDao the new ownerDao
     */
    public void setOwnerDao(OwnerDao ownerDao){this.ownerDao = ownerDao;}


}
