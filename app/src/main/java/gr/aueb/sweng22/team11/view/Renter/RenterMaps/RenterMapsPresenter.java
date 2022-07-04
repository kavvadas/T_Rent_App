package gr.aueb.sweng22.team11.view.Renter.RenterMaps;

import gr.aueb.sweng22.team11.dao.AdDao;
import gr.aueb.sweng22.team11.domain.Ad;

public class RenterMapsPresenter {
    RenterMapsView view;
    AdDao adDao;

    public RenterMapsPresenter(){}


    public void onAddressMarker(){
        for(Ad ad:adDao.findAll()) {
            view.AddressMarker(ad.getComment(),ad.getHouse().getRegion(),ad.getHouse().getPostcode(),ad.getHouse().getStreet());
        }
    }

    public void setAdDao(AdDao adDao){this.adDao = adDao;}

    public void setView(RenterMapsView view){this.view = view;}

    public void clearView(){this.view = null;}
}
