package gr.aueb.sweng22.team11.View.Ad.AdPage;

import gr.aueb.sweng22.team11.domain.*;
import gr.aueb.sweng22.team11.memoryDao.adDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.initializerMemory;
import gr.aueb.sweng22.team11.view.Ad.AdPage.AdPagePresenter;
import gr.aueb.sweng22.team11.view.Ad.AdPage.AdPageView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class AdPagePresenterTest {

    private AdPageView view;
    private AdPagePresenter presenter;

    @Before
    public void setup(){
     new initializerMemory().prepare();

     view = new AdPageViewStub();
     presenter = new AdPagePresenter();

     Pricing pricing = null;

     presenter.setAdDao(new adDaoMemory());
     presenter.setView(view);

        Ad ad  =new Ad();
        Request request = new Request();
        House house = new House();

        OwnerAccount owner = new OwnerAccount();


        Appointment appointment = new Appointment();

        appointment.setTime(LocalTime.NOON);
        appointment.setDate(LocalDate.now());


        ArrayList<String> Description = new ArrayList<>();

        ArrayList<Appointment> appointments = new  ArrayList<>();


        house.setDescription(Description);
        house.setRent("rent");
        house.setStreet("Papandreou 12");
        house.setRegion("Athens");
        house.setPostcode("18120");



        ad.setComment("comment");
        ad.setOwner(owner);
        ad.setHouse(house);
        ad.setAppointments(appointments);
        ad.setDateCreated(LocalDate.now());
        ad.setPrice(pricing);




    }

    @Test
    public void AdPageTest(){
        Assert.assertNotNull(new adDaoMemory().findAll());

    }



}
