package gr.aueb.sweng22.team11.View.Ad.AdAppointments;

import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.memoryDao.adDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.appointmentDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.initializerMemory;
import gr.aueb.sweng22.team11.view.Ad.AdAppointments.AdAppointmentsPresenter;
import gr.aueb.sweng22.team11.view.Ad.AdAppointments.AdAppointmentsView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdAppointmentsPresenterTest {

    private AdAppointmentsView view;
    private AdAppointmentsPresenter presenter;

    @Before
    public void setup(){
        new initializerMemory().prepare();


        presenter = new AdAppointmentsPresenter();
        view = new AdAppointmentsViewStub();

        presenter.setView(view);
        presenter.setAppointmentDao(new appointmentDaoMemory());
        presenter.setAdDao(new adDaoMemory());



        Ad ad = new  Ad();

        new adDaoMemory().save(ad);



    }

    @Test
    public void AppointmetsTest(){
        Assert.assertNotNull(new adDaoMemory().findAll());
    }

}
