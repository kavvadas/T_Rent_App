package gr.aueb.sweng22.team11.domain;

import org.junit.Test;


import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestRentAccount {

    Ad ad1 = new Ad();
    Ad ad2 = new Ad();
    Credentials renter1_creds = new Credentials();

    Credentials renter2_creds = new Credentials();

    RentAccount renter1 = new RentAccount("egwww","Marios","Papageorge","12134","papamarios@aueb.gr",LocalDate.now(),renter1_creds);

    RentAccount renter2 = new RentAccount("elaaa","Zoe","TZ","54321","minaras@uni.gr",LocalDate.now().plusDays(1),renter2_creds);

    Appointment app1 = new Appointment();
    Appointment app2 = new Appointment();

    House house1 = new House();
    House house2 = new House();

    @Test
    public void TestUp(){

        house2.setStreet("Gkritzali");
        house2.setPostcode("12535");
        house2.setRegion("Mani");
        house2.setRent("350");

        house1.setStreet("LLoukoumakis");
        house1.setPostcode("6543");
        house1.setRegion("Sparti");
        house1.setRent("300");

        ad1.setComment("i am first");
        ad1.setHouse(house1);

        ad2.setComment("i am second");
        ad2.setHouse(house2);

        app1.setDate(LocalDate.now());
        app1.setTime(LocalTime.of(14,12,55));
        app1.setTaken();

        app2.setDate(LocalDate.now());
        app2.setTime(LocalTime.of(14,44,12));


        renter1.addFavorites(ad1);
        renter2.addFavorites(ad2);

        renter1.addAppointment(app1);
        renter2.addAppointment(app2);

        renter1.sendRequest(ad1,app1);
        renter2.sendRequest(ad2,app2);


        renter2.sendRequest(ad2,app2);

        //Test for favorites
        assertEquals((renter1.getFavorites().size()),(renter2.getFavorites().size()));

        renter2.removeFavorites(ad2);
        assertNotEquals((renter1.getFavorites().size()),(renter2.getFavorites().size()));
        // Test for appointments

        assertEquals((renter1.getAppointment().size()),(renter2.getAppointment().size()));



        //  Test for the Requets

        assertEquals(renter1.getAdsInterested().size(),renter2.getAdsInterested().size());



    }


















}
