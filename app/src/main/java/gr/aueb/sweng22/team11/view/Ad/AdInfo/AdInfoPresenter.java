package gr.aueb.sweng22.team11.view.Ad.AdInfo;

import android.os.Build;
import android.util.Log;

import gr.aueb.sweng22.team11.dao.AdDao;
import gr.aueb.sweng22.team11.dao.AppointmentDao;
import gr.aueb.sweng22.team11.dao.RequestDao;
import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.domain.Appointment;
import gr.aueb.sweng22.team11.domain.OwnerAccount;
import gr.aueb.sweng22.team11.domain.Request;

public class AdInfoPresenter {
    private AdInfoView view;
    private Ad ad;
    private AdDao adDao;
    private RequestDao requestDao;
    private AppointmentDao appointmentDao;
    private OwnerAccount owner;

    /**
     * Default Constructor
     */
    public AdInfoPresenter(){}

    /**
     * Finds the ad's info to
     * set all text fields in the current layout
     */
    public void findAdInfo(String comment){
        ad = adDao.findByComment(comment);
        owner = ad.getOwner();
        view.setComment(ad.getComment());
        view.setStreet(ad.getHouse().getStreet());
        view.setRegion(ad.getHouse().getRegion());
        view.setPostcode(ad.getHouse().getPostcode());
        view.setRent(ad.getHouse().getRent());
    }

    /**
     * Starts the Create ad Actitity
     * so that the user can modify the ad
     */
    public void onEditAd(){view.startEditAd(ad.getComment());}

    /**
     * Deletes the ad of the owner
     * and goes back to the owner page
     */
    public void onDeleteAd(){
        for(Appointment appointment:appointmentDao.findByAd(ad)){
            appointmentDao.delete(appointment);
        }
        for(Request request:requestDao.findByAd(ad)){
            requestDao.delete(request);
        }
        adDao.delete(ad);
        owner.removeAd(ad);
        view.startDeleteAd(owner.getTitle());
    }

    /**
     * set the adDao
     * @param adDao the new adDao
     */
    public void setAdDao(AdDao adDao){this.adDao = adDao;}

    /**
     * set the appointmentDao
     * @param appointmentDao the new appointmentDao
     */
    public void setAppointmentDao(AppointmentDao appointmentDao){this.appointmentDao = appointmentDao;}

    /**
     * set the requestDao
     * @param requestDao the new requestDao
     */
    public void setRequestDao(RequestDao requestDao){this.requestDao = requestDao;}

    /**
     * Sets the view of the OwnerInfoPresenter
     * @param view OwnerInfoPresenter to be set
     */
    public void setView(AdInfoView view){this.view = view;}

    /**
     * Sets the view of the presenter to null
     */
    public void clearView(){this.view = null;}

}
