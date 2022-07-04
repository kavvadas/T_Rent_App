package gr.aueb.sweng22.team11.view.Renter.RenterInfo;

import gr.aueb.sweng22.team11.dao.AppointmentDao;
import gr.aueb.sweng22.team11.dao.RequestDao;
import gr.aueb.sweng22.team11.domain.Appointment;
import gr.aueb.sweng22.team11.domain.Request;
import gr.aueb.sweng22.team11.domain.User;
import gr.aueb.sweng22.team11.memoryDao.loginDaoMemory;

import gr.aueb.sweng22.team11.dao.LoginDao;
import gr.aueb.sweng22.team11.dao.RenterDao;
import gr.aueb.sweng22.team11.domain.RentAccount;

public class

RenterInfoPresenter {
    private RenterInfoView view;
    private RentAccount renter;
    private RenterDao renterDao;
    private RequestDao requestDao;
    private AppointmentDao appointmentDao;
    /**
     * Default Constructor
     */
    public RenterInfoPresenter(){}

    /**
     * Finds the renter's info to
     * set all text fields in the current layout
     */
    public void findRenterInfo(){
        view.setUsername(renter.getCredentials().getUsername());
        view.setPassword(renter.getCredentials().getPassword());
        view.setName(renter.getFirstName());
        view.setLastname(renter.getLastName());
        view.setPhone(renter.getPhoneNumber());
        view.setBirthdate(renter.getDateOfBirth());
        view.setEmail(renter.getEmail());
        view.setNickname(renter.getNickname());
    }
    /**
     * Starts the Register Renter Activity
     * so that the user can modify account
     */
    public void onEditRenter(){
        view.startEditRenter(renter.getNickname());
    }
    /**
     * Deletes the renter's account
     * and goes back to the login screen
     */
    public void onDeleteRenter(){
        for(Appointment appointment:appointmentDao.findByRenter(renter)){
            appointmentDao.delete(appointment);
        }

        renterDao.delete(renter);
        (new loginDaoMemory()).clear();
        view.startDeleteRenter();
    }
    /**
     * Sets the renter to the user that is currently logged in
     * @param user user to be set as an renter
     */
    public void setRenter(User user){
        if(user == null)
            return;
        if(!(user instanceof RentAccount))
            return;
        renter = (RentAccount) user;
    }

    /**
     * set the renterDao
     * @param renterDao the new renterDao
     */
    public void setRenterDao(RenterDao renterDao){this.renterDao = renterDao;}
    /**
     * Sets the view of the OwnerInfoPresenter
     * @param view OwnerInfoPresenter to be set
     */
    public void setView(RenterInfoView view){this.view = view;}

    /**
     * Sets the view of the presenter to null
     */
    public void clearView(){this.view = null;}
}

