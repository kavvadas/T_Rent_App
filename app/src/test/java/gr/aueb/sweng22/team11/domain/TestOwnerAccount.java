package gr.aueb.sweng22.team11.domain;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class TestOwnerAccount {

    OwnerAccount owner;
    OwnerAccount owner2;
    OwnerAccount owner3;
    OwnerAccount owner4;
    LocalDate DateOfBirth;
    LocalDate DateOfBirth2;
    Credentials credentials;
    Credentials credentials2;
    Ad ad = new Ad();
    Ad ad2 = new Ad();
    ArrayList<Appointment> appointments = new ArrayList<>();

    Pricing debt;


    /**
     *setup some initial variables before attempting each test
     */
    @Before
    public void setUp() throws Exception{

        DateOfBirth = LocalDate.of(1969,6,5);
        DateOfBirth2 = LocalDate.of(1978, 10, 23);
        credentials = new Credentials("jim","123456");
        credentials2 = new Credentials("marios","123456");

        owner = new OwnerAccount("JimmysAps", "Jimmy","Kavvadas","698832413","dimitris@gmail.com",DateOfBirth,credentials);
        owner2 = new OwnerAccount("paradiseHotel" ,"Jimmy","Kavvadas","698832413","dimitris@gmail.com",DateOfBirth,credentials);
        owner3 = new OwnerAccount("elabye", "Marios","Papagewrgiou","6934288314","marios@gmail.com",DateOfBirth2,credentials2);
        owner4 = new OwnerAccount();

        for(int i=1 ; i<=30;i++)
        {
            ad.addAppointment(new Appointment(LocalDate.of(2022, Month.MAY,i), LocalTime.NOON));

            if(i > 15)
            {
                ad2.addAppointment(new Appointment(LocalDate.of(2022, Month.JUNE,i), LocalTime.MIDNIGHT));
            }
        }

        House house1 = owner.createHouse("Filhs 32","13122","Athens","152");
        ad.setHouse(house1);
        owner.createAndSaveAd(ad);
        debt = new Pricing(154);
        ad.setPrice(debt);


        House house2 = owner.createHouse("Filou 23","22131","Mykonos","169.0");
        ad2.setHouse(house2);
        owner2.createAndSaveAd(ad2);


    }
    @Test
    public void testPaidDept(){
        ad.getPrice().setHasToBePaid();
        owner.payDebt(ad);
        assertTrue(ad.getPrice().getIsPaid());
    }


    @Test
    public void testAdCreation()
    {
        Ad adTest = new Ad();
        House house1 = owner.createHouse("Filhs 11","13333","Peiraias","175");
        adTest.setHouse(house1);
        owner.createAndSaveAd(ad);
    }


    @Test
    public void testPrint()
    {
        assertEquals(owner.toString(),owner2.toString());
    }

    @Test
    public void testCreateAd(){
        Ad adTest = null;

        owner.createAndSaveAd(adTest);
        owner.createAndSaveAd(ad);

        assertEquals(1,owner.getAds().size());
        assertEquals(ad,owner.getAds().get(0));
        assertTrue(owner.getAds().contains(ad));

    }

    @Test
    public void testDeleteAd(){
        Ad adTest = null;
        owner.removeAd(adTest);

        owner.removeAd(ad);

        owner.createAndSaveAd(ad);
        owner.removeAd(ad);

        assertEquals(0,owner.getAds().size());
        assertFalse(owner.getAds().contains(ad));
    }

    @Test
    public void equalsTest(){
        assertEquals(owner,owner);
    }
    @Test
    public void notequalsTest(){
        OwnerAccount testOwner = new OwnerAccount("elabye2", "Jimmy","Kavvadas","698832413","dimitris@gmail.com",DateOfBirth,credentials);
        assertNotEquals(testOwner,owner);
        assertNotEquals(owner,owner2);
        assertNotEquals(owner2,owner3);

    }



}
