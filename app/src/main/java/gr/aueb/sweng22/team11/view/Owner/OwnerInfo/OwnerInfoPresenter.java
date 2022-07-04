package gr.aueb.sweng22.team11.view.Owner.OwnerInfo;

import android.util.Log;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.dao.AdDao;
import gr.aueb.sweng22.team11.dao.AppointmentDao;
import gr.aueb.sweng22.team11.dao.RequestDao;
import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.domain.Appointment;
import gr.aueb.sweng22.team11.domain.Request;
import gr.aueb.sweng22.team11.domain.User;
import gr.aueb.sweng22.team11.memoryDao.loginDaoMemory;

import gr.aueb.sweng22.team11.dao.OwnerDao;
import gr.aueb.sweng22.team11.domain.OwnerAccount;

public class OwnerInfoPresenter {
    private OwnerInfoView view;
    private OwnerAccount owner;
    private OwnerDao ownerDao;
    private AdDao adDao;
    private AppointmentDao appointmentDao;
    private RequestDao requestDao;

    /**
     * Default Constructor
     */
    public OwnerInfoPresenter(){}

    /**
     * Finds the owner's info to
     * set all text fields in the current layout
     */
    public void findOwnerInfo(){
        view.setUsername(owner.getCredentials().getUsername());
        view.setPassword(owner.getCredentials().getPassword());
        view.setName(owner.getFirstName());
        view.setLastname(owner.getLastName());
        view.setPhone(owner.getPhoneNumber());
        view.setBirthdate(owner.getDateOfBirth());
        view.setEmail(owner.getEmail());
        view.setTitle(owner.getTitle());
    }
    /**
     * Starts the Register Owner Actitity
     * so that the user can modify account
     */
    public void onEditOwner(){
        view.startEditOwner(owner.getTitle());
    }
    /**
     * Deletes the owner's account
     * and goes back to the login screen
     */
    public void onDeleteOwner(){
        for(Ad ad:adDao.findByOwner(owner)){
            for(Request request:requestDao.findByAd(ad)){
                requestDao.delete(request);
            }
            for(Appointment appointment:appointmentDao.findByAd(ad)){
                appointmentDao.delete(appointment);
            }
            adDao.delete(ad);
        }

        ownerDao.delete(owner);
        (new loginDaoMemory()).clear();
        view.startDeleteOwner();
    }
    /**
     * Sets the owner to the user that is currently logged in
     * @param user user to be set as an owner
     */
    public void setOwner(User user){
        if(user == null)
            return;
        if(!(user instanceof OwnerAccount))
            return;
        owner = (OwnerAccount) user;
    }

    /**
     * Sets the ownerDao
     * @param ownerDao ownerDao to be set
     */
    public void setOwnerDao(OwnerDao ownerDao){this.ownerDao = ownerDao;}

    /**
     * Sets the adDao
     * @param adDao adDao to be set
     */
    public void setAdDao(AdDao adDao){this.adDao = adDao;}

    /**
     * Sets the appointmentDao
     * @param appointmentDao appointmentDao to be set
     */
    public void setAppointmentDao(AppointmentDao appointmentDao){this.appointmentDao = appointmentDao;}

    /**
     * Sets the requestDao
     * @param requestDao requestDao to be set
     */
    public void setRequestDao(RequestDao requestDao){this.requestDao = requestDao;}

    /**
     * Sets the view of the OwnerInfoPresenter
     * @param view OwnerInfoPresenter to be set
     */
    public void setView(OwnerInfoView view){this.view = view;}

    /**
     * Sets the view of the presenter to null
     */
    public void clearView(){this.view = null;}
}
