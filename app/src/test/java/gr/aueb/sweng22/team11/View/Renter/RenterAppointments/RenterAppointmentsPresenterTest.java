package gr.aueb.sweng22.team11.View.Renter.RenterAppointments;

import gr.aueb.sweng22.team11.domain.Appointment;
import gr.aueb.sweng22.team11.memoryDao.appointmentDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.initializerMemory;
import gr.aueb.sweng22.team11.memoryDao.renterDaoMemory;
import gr.aueb.sweng22.team11.view.Renter.RenterAppointments.RenterAppointmentsPresenter;
import gr.aueb.sweng22.team11.view.Renter.RenterAppointments.RenterAppointmentsView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class RenterAppointmentsPresenterTest {


    private RenterAppointmentsView view;
    private RenterAppointmentsPresenter presenter;




    @Before
    public void setup(){
       new initializerMemory().prepare();


       presenter = new RenterAppointmentsPresenter();
       view = new RenterAppointmentsViewStub();

       presenter.setRenterDao(new renterDaoMemory());
       presenter.setAppointmentDao(new appointmentDaoMemory());
       presenter.setView(view);

        Appointment appointment = new Appointment();
        appointment.setDate(LocalDate.now());
        appointment.setTime(LocalTime.NOON);

       new appointmentDaoMemory().save(appointment);




    }

    @Test
    public void TestAppointmets(){
        Assert.assertNotNull(new renterDaoMemory().findAll());


    }


}
