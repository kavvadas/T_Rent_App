package gr.aueb.sweng22.team11.domain;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestAd{

    Ad ad = new Ad();
    Ad ad2 = new Ad();

    @Before
    public void setUp() throws Exception
    {

        OwnerAccount owner = new OwnerAccount();
        owner.setFirstName("Marios");
        owner.setLastName("Papageorge");
        Credentials c1 = new Credentials("UserMarios", "123456");
        owner.setCredentials(c1);
        owner.setDateOfBirth(LocalDate.of(2001, 8, 29));
        owner.setEmail("p3190156@aueb.gr");
        owner.setPhoneNumber("69xxxxxxxx");
        ArrayList<String> description = new ArrayList<>();
        description.add("2 Bathrooms");
        description.add("1 kitchen");
        description.add("2 bedrooms");
        House house1 = new House("Basileiou", "14323", "Argyroupoli", "150",description); //make one with constructor
        Pricing price1 = new Pricing();
        price1.setPrice(400);

        for(int i=1 ; i<=30;i++){
            ad.addAppointment(new Appointment(LocalDate.of(2022, Month.MAY,i), LocalTime.NOON));
        }
        ad.setOwner(owner);
        ad.setHouse(house1);
        ad.setComment("Wifi, bbq, pool");
        ad.setPrice(price1);
        ad.setDateCreated(LocalDate.now().plusDays(5));

        int k = 0;

        for(int i=1 ; i<=30;i++){

            Credentials c = new Credentials("User" + i, "password" + i);
            RentAccount r = new RentAccount("FirstName" + i, "LastName" + i, "69xxxxxxx" + i, "user" + i + "@gmail.com",LocalDate.now().minusMonths(i), c);
            Appointment a = new Appointment(LocalDate.of(2022, Month.MAY,i), LocalTime.NOON);

            ad.addRenterRequest(r, a);
            k = i;

        }
        for(int i=1 ; i<=30;i++){

            Credentials c = new Credentials("User" + k + i, "password" + k);
            RentAccount r = new RentAccount("FirstName" + k, "LastName" + k, "69xxxxx" + k+1, "user" + k + "@gmail.com",LocalDate.now().minusMonths(k), c);
            Appointment a = new Appointment(LocalDate.of(2022, Month.MAY,i), LocalTime.NOON);

            ad.addRenterRequest(r, a);

        }

        House house2 = new House("Georgiou", "12423", "Agia Paraskeyi", "350",description); //make one with constructor
        Pricing price2 = new Pricing();
        price2.setPrice(225);

        for(int i=1 ; i<=30;i++){
            ad.getAppointments().add(new Appointment(LocalDate.of(2022, Month.JUNE,i), LocalTime.MIDNIGHT));
        }

        ad2.setOwner(owner);
        ad2.setHouse(house2);
        ad2.setComment("Wifi, garden, pets not allowed");
        ad2.setPrice(price2);
        ad2.setDateCreated(LocalDate.now().plusDays(5));

        for(int i=1 ; i<=30;i++){

            Credentials c = new Credentials("User" + i, "password" + i);
            RentAccount r = new RentAccount("FirstName" + i, "LastName" + i, "6972xxxxx" + i, "resu" + i + "@hotmail.com",LocalDate.now().minusMonths(i + 1), c);
            Appointment a = new Appointment(LocalDate.of(2022, Month.JUNE,i), LocalTime.MIDNIGHT);

            ad2.addRenterRequest(r, a);

        }

        ad.checkForPricing();
        ad2.checkForPricing();

    }

    @Test
    public void testAds()
    {
       assertNotEquals(ad, ad2);
       assertEquals(ad.getOwner().getAds(), ad2.getOwner().getAds());

    }

    @Test
    public void testHouse()
    {
        assertNotEquals(ad.getHouse(), ad2.getHouse());
    }

    @Test
    public void testOwner()
    {
        assertEquals(ad.getOwner(), ad2.getOwner());
    }

    @Test
    public void testPrice()
    {
        assertFalse(ad2.getPrice().getHasToBePaid());
        assertTrue(ad.getPrice().getHasToBePaid());
    }

    @Test
    public void testAccept()
    {
        Request req = ad.getRequests().get(0);
        ad.acceptRequest(req,0);
        assertFalse(req.isPending());
        assertTrue(req.isAccepted());
    }

    @Test
    public void testReject()
    {
        Request req = ad.getRequests().get(30);
        ad.rejectRequest(req,30);
        assertFalse(req.isPending());
        assertFalse(req.isAccepted());
    }

    @Test
    public void testComment()
    {
        assertEquals(ad2.getComment(), "Wifi, garden, pets not allowed");
        assertNotEquals(ad.getComment(), "Wifi, garden, pets not allowed");

    }

    @Test
    public void testDates()
    {
        assertEquals(ad2.getDateCreated(), LocalDate.now().plusDays(5));

    }


}
