package gr.aueb.sweng22.team11.domain;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class TestRequest {

    Credentials c1 = new Credentials("User1", "1234");
    Credentials c2 = new Credentials("User2", "5678");

    Appointment a1 = new Appointment(LocalDate.now().plusMonths(1), LocalTime.now());
    Appointment a2 = new Appointment(LocalDate.now().plusMonths(2), LocalTime.now());

    RentAccount r1 = new RentAccount("Mike", "Pipi", "0901654333", "hotboyz@hotmail.gr", LocalDate.now(), c1);
    RentAccount r2 = new RentAccount("Tina", "Tsakis", "666", "vanillaboys65@quickmail.er", LocalDate.now(), c2);

    Request req1 = new Request(r1,a1);
    Request req2 = new Request();
    Request req3 = null;
    Request req4 = new Request();

    @Before
    public void setUp()
    {

        r2.setCredentials(c2);
        req2.setAccepted(true);
        req2.setAppointment(a2);
        req2.setRenter(r2);

    }
    @Test
    public void CompareValues()
    {
         assertNotEquals(req1, req2);
         assertNotEquals(req3, req4);
         assertTrue(req1.isAccepted() == req2.isAccepted());

    }

    @Test
    public void testPending()
    {

        assertNotEquals(req1.isPending(), req2.isPending());

    }

    @Test
    public void testAccepted()
    {

        assertEquals(req1.isAccepted(), req2.isAccepted());

    }

    @Test
    public void CheckNull()
    {
        assertNull(req3);
        assertNotNull(req4);
        assertNotNull(req2);
        assertNotNull(req1);
    }

    @Test
    public void testDate(){
        assertEquals(req1.getDateSent(),LocalDate.now());
    }




}

