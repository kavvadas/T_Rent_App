package gr.aueb.sweng22.team11.view.Ad.HandleRequest;

import android.util.Log;

import gr.aueb.sweng22.team11.dao.AdDao;
import gr.aueb.sweng22.team11.dao.AppointmentDao;
import gr.aueb.sweng22.team11.dao.RequestDao;
import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.domain.Appointment;
import gr.aueb.sweng22.team11.domain.Request;

public class HandleRequestPresenter {
    private HandleRequestView view;
    private Request request;
    private RequestDao requestDao;
    private AppointmentDao appointmentDao;
    private Ad ad;
    private AdDao adDao;

    /**
     * Default Constructor
     */
    public HandleRequestPresenter(){}

    /**
     * Finds the request's info to
     * set all text fields in the current layout
     * @param apppoint appointment of the request
     * @param nickname nickname of the renter
     * @param title title of the ad
     */
    public void findRequestInfo(String apppoint,String nickname,String title){

        request = requestDao.findByOwnerAppoint(apppoint,nickname);
        ad = adDao.findByComment(title);
        view.setRenter(request.getRenter().getNickname());
        view.setAppointment(request.getAppointment().getDate().toString()+" "+request.getAppointment().getTime().toString());

    }

    /**
     * creates an appointment and saves it to the dao, the adAppointmentsWithRenter, the renter
     * deletes the request from every possible arraylist (requestDao, adRequests)
     * @param position of the request so we can delete the request in adRequests
     */
    public void onAcceptRequest(int position){

        ad.addAppointmentsWithRenter(request.getAppointment());
        request.getRenter().addAppointment(request.getAppointment());
        appointmentDao.save(request.getAppointment());
        ad.getRequests().remove(position);
        requestDao.delete(request);

        view.startAcceptRequest(ad.getOwner().getTitle());
    }

    /**
     * creates an appointment and saves it to the the renter as declined so he can get notified
     * deletes the request from every possible arraylist (requestDao, adRequests)
     * @param position of the request so we can delete the request in adRequests
     */
    public void onDeclineRequest(int position){
        ad.getRequests().remove(position);
        requestDao.delete(request);
        request.getAppointment().setTaken();
        request.getRenter().addAppointment(request.getAppointment());
        view.startDeclineRequest(ad.getOwner().getTitle());
    }

    /**
     * Sets the requestDao
     * @param requestDao the new requestDao
     */
    public void setRequestDao(RequestDao requestDao){this.requestDao =requestDao;}

    /**
     * Sets the adDao
     * @param adDao the new adDao
     */
    public void setAdDao(AdDao adDao){this.adDao = adDao;}

    /**
     * Sets the appointmentDao
     * @param appointmentDao the new appointmentDao
     */
    public void setAppointmentDao(AppointmentDao appointmentDao){this.appointmentDao = appointmentDao;}

    /**
     * Sets the view of the OwnerInfoPresenter
     * @param view OwnerInfoPresenter to be set
     */
    public void setView(HandleRequestView view){this.view = view;}

    /**
     * Sets the view of the presenter to null
     */
    public void clearView(){this.view = null;}
}
