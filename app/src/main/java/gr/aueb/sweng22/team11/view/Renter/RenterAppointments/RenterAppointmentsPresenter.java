package gr.aueb.sweng22.team11.view.Renter.RenterAppointments;

import android.util.Log;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.dao.AppointmentDao;
import gr.aueb.sweng22.team11.dao.RenterDao;
import gr.aueb.sweng22.team11.domain.Appointment;
import gr.aueb.sweng22.team11.domain.RentAccount;

public class RenterAppointmentsPresenter {
    RenterAppointmentsView view;
    private AppointmentDao appointmentDao;
    private ArrayList<Appointment> appointments;
    private RenterDao renterDao;

    /**
     * Default constructor
     */
    public RenterAppointmentsPresenter(){}

    /**
     * finds the appointments of th renter with an ad
     * and passes all the values to the array appointments
     * @param title nickname of the renter
     */
    public void findAppointments(String title){
        RentAccount renter = renterDao.findByNickname(title);
        if(renter == null) {
            return;
        }
        appointments = appointmentDao.findByRenter(renter);
    }

    /**
     * get the renter appointments
     * @return the ArrayList of the appointments
     */
    public ArrayList<Appointment> getAppointments(){return appointments;}

    /**
     * set the renterDao
     * @param renterDao the new renterDao
     */
    public void setRenterDao(RenterDao renterDao){this.renterDao = renterDao;}

    /**
     * set the appointmentDao
     * @param appointmentDao the new appointmentDao
     */
    public void setAppointmentDao(AppointmentDao appointmentDao){this.appointmentDao = appointmentDao;}

    /**
     * set a new view
     * @param view the new view
     */
    public void setView(RenterAppointmentsView view){this.view = view;}

    /**
     * clear the view
     */
    public void clearView(){this.view = null;}

}
