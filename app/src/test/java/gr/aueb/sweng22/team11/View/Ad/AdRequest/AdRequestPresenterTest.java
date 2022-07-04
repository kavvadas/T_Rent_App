package gr.aueb.sweng22.team11.View.Ad.AdRequest;

import gr.aueb.sweng22.team11.domain.*;
import gr.aueb.sweng22.team11.memoryDao.adDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.initializerMemory;
import gr.aueb.sweng22.team11.memoryDao.requestDaoMemory;
import gr.aueb.sweng22.team11.view.Ad.AdRequests.AdRequestsPresenter;
import gr.aueb.sweng22.team11.view.Ad.AdRequests.AdRequestsView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.security.acl.Owner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class AdRequestPresenterTest {
    private AdRequestsView view;
    private AdRequestsPresenter presenter;




    @Before
    public void setup(){
    new initializerMemory().prepare();

    Pricing pricing = null;
    
    view = new AdRequestViewStub();
    presenter = new AdRequestsPresenter();


    presenter.setAdDao(new adDaoMemory());
    presenter.setRequestDao(new requestDaoMemory());
    presenter.setView(view);

        Ad ad  =new Ad();
        Request request = new Request();
        House house = new House();

        OwnerAccount owner = new OwnerAccount();

        
        Appointment appointment = new Appointment();
        
        appointment.setTime(LocalTime.NOON);
        appointment.setDate(LocalDate.now());


        ArrayList<String>Description = new ArrayList<>();
        
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
    public void Test(){

        Assert.assertNotNull(new adDaoMemory().findByRegion("Athens"));
    }
}
