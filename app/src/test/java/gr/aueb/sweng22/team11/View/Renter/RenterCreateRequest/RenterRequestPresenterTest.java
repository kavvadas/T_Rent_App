package gr.aueb.sweng22.team11.View.Renter.RenterCreateRequest;

import gr.aueb.sweng22.team11.dao.Initializer;
import gr.aueb.sweng22.team11.dao.RenterDao;
import gr.aueb.sweng22.team11.domain.*;
import gr.aueb.sweng22.team11.memoryDao.initializerMemory;
import gr.aueb.sweng22.team11.memoryDao.loginDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.renterDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.requestDaoMemory;
import gr.aueb.sweng22.team11.view.Renter.RenterCreateRequest.RenterCreateRequestActivity;
import gr.aueb.sweng22.team11.view.Renter.RenterCreateRequest.RenterCreateRequestPresenter;
import gr.aueb.sweng22.team11.view.Renter.RenterCreateRequest.RenterCreateRequestView;
import gr.aueb.sweng22.team11.view.Renter.RenterPage.RenterPagePresenter;
import gr.aueb.sweng22.team11.view.User.RenterRegister.RenterRegisterPresenter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class RenterRequestPresenterTest {

    private RenterCreateRequestView view;
    private RenterCreateRequestPresenter presenter;

    @Before
    public void setup(){
       initializerMemory memory = new initializerMemory();
       memory.prepare();


        presenter = new RenterCreateRequestPresenter();
        view = new RenterRequestViewStub();

        presenter.setRenterDao(new renterDaoMemory());
        presenter.setRequestDao(new requestDaoMemory());
        presenter.setView(view);


        Request request = new Request();
        RentAccount rentAccount = new  RentAccount("nickname","Name","Lastname","6914253966","example@mail.gr", LocalDate.now(), new Credentials("name","password"));

        Appointment appointment = new Appointment();
        appointment.setDate(LocalDate.now());
        appointment.setTime(LocalTime.NOON);


        request.setAppointment(appointment);

        request.setRenter(rentAccount);

        memory.getRequestDao().save(request);


    }


    @Test
    public void RequestCreation(){

        Assert.assertTrue(new initializerMemory().getRequestDao().findAll().size() == 3);



    }

}
