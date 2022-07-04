package gr.aueb.sweng22.team11.view.Ad.AdAppointments;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.dao.AdDao;
import gr.aueb.sweng22.team11.dao.AppointmentDao;
import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.domain.Appointment;

public class AdAppointmentsPresenter {
    AdAppointmentsView view;
    private AppointmentDao appointmentDao;
    private ArrayList<Appointment> appointments;
    private AdDao adDao;

    /**
     * Default constructor
     */
    public AdAppointmentsPresenter(){}

    /**
     * finds the appointments of an ad
     * and passes all the values to the array appointments
     * @param title of the ad
     */
    public void findAppointments(String title){
        Ad ad = adDao.findByComment(title);
        if(ad == null)
            return;
        appointments = appointmentDao.findByAd(ad);
    }

    /**
     * get the ad appointments
     * @return the ArrayList of the appointments
     */
    public ArrayList<Appointment> getAppointments(){return appointments;}

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
     * set a new view
     * @param view the new view
     */
    public void setView(AdAppointmentsView view){this.view = view;}

    /**
     * clear the view
     */
    public void clearView(){this.view = null;}
}
