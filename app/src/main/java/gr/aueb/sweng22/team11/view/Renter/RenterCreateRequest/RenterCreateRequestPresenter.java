package gr.aueb.sweng22.team11.view.Renter.RenterCreateRequest;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.LocalTime;

import gr.aueb.sweng22.team11.dao.AdDao;
import gr.aueb.sweng22.team11.dao.RenterDao;
import gr.aueb.sweng22.team11.dao.RequestDao;
import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.domain.Appointment;
import gr.aueb.sweng22.team11.domain.RentAccount;
import gr.aueb.sweng22.team11.domain.Request;


public class RenterCreateRequestPresenter {
    private RenterCreateRequestView view;
    private RenterDao renterDao;
    private RentAccount renter;
    private RequestDao requestDao;
    private Request request;
    private AdDao adDao;
    private Ad ad;

    /**
     * Default constructor
     */
    public RenterCreateRequestPresenter(){}
    /**
     * sets the info of an already created ad in dao
     * @param title comment of the ad
     */
    public void findAdInfo(String title){
        ad = adDao.findByComment(title);
        view.setAppointments(ad.getAppointments());
        view.setOwner(ad.getOwner().getTitle());
        view.setPostcode(ad.getHouse().getPostcode());
        view.setRent(ad.getHouse().getRent());
        view.setRegion(ad.getHouse().getRegion());
        view.setStreet(ad.getHouse().getStreet());
        view.setTitle(ad.getComment());
    }

    /**
     * sends the request that the renter created
     * starts the RenterPageActivity and passes the nickname of the renter
     * @param nickname nickname of renter
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onSaveRequest(String nickname){
        LocalDate date = LocalDate.parse(view.getChosenAppointment().get(0));
        LocalTime time = LocalTime.parse(view.getChosenAppointment().get(1));
        renter = renterDao.findByNickname(nickname);

        request = new Request(renter, new Appointment(date,time));

        requestDao.save(request);
        ad.addRenterRequest(renter,new Appointment(date,time));
        view.startRequest(nickname);

    }

    /**
     * set the requestDao
     * @param requestDao the new requestDao
     */
    public void setRequestDao(RequestDao requestDao){this.requestDao = requestDao;}

    /**
     * set the adDao
     * @param adDao the new adDao
     */
    public void setAdDao(AdDao adDao){this.adDao = adDao;}

    /**
     * set the renterDao
     * @param renterDao the new renterDao
     */
    public void setRenterDao(RenterDao renterDao){this.renterDao = renterDao;}

    /**
     * set a new view
     * @param view the new view
     */
    public void setView(RenterCreateRequestView view){this.view = view;}

    /**
     * clear the view
     */
    public void clearView(){this.view = null;}
}
