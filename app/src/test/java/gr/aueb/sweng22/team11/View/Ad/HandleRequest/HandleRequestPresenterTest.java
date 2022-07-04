package gr.aueb.sweng22.team11.View.Ad.HandleRequest;

import gr.aueb.sweng22.team11.dao.RequestDao;
import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.domain.Appointment;
import gr.aueb.sweng22.team11.domain.Credentials;
import gr.aueb.sweng22.team11.domain.RentAccount;
import gr.aueb.sweng22.team11.domain.Request;
import gr.aueb.sweng22.team11.memoryDao.adDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.appointmentDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.initializerMemory;
import gr.aueb.sweng22.team11.memoryDao.requestDaoMemory;
import gr.aueb.sweng22.team11.view.Ad.HandleRequest.HandleRequestPresenter;
import gr.aueb.sweng22.team11.view.Ad.HandleRequest.HandleRequestView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class HandleRequestPresenterTest {
    private HandleRequestView view;
    private HandleRequestPresenter presenter;




    @Before
    public void setup(){
        initializerMemory memory = new  initializerMemory();
        memory.prepare();

        presenter = new HandleRequestPresenter();
        view = new HandleRequestViewStab();


        presenter.setRequestDao(new requestDaoMemory());
        presenter.setAppointmentDao(new appointmentDaoMemory());
        presenter.setAdDao(new adDaoMemory());
        presenter.setView(view);

        Ad ad = memory.getAdDao().findAll().get(0);
        Request request = ad.getRequests().get(0);
        RentAccount renter = request.getRenter();

        presenter.findRequestInfo(request.getAppointment().toString(),renter.getNickname(),ad.getComment());
        presenter.onAcceptRequest(0);

    }


    @Test
    public void HandleTest(){
        //Assert.assertTrue();

    }

}
