package gr.aueb.sweng22.team11.domain;
import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class TestAppointment {

    //Create four appointments, one of which is null and the other is with default values
    Appointment appointment1 = new Appointment(LocalDate.of(2001,8,29), LocalTime.of(15,12,51));
    Appointment appointment2 = new Appointment();
    Appointment appointment3 = null;
    Appointment appointment4 = new Appointment();

    @Before
    public void setUp() {

        appointment1.setDate(LocalDate.of(2001,8,29));
        appointment1.setTime(LocalTime.of(15,12,51));
        appointment1.setTaken();

        appointment2.setDate(LocalDate.of(2001,12,3));
        appointment2.setTime(LocalTime.of(15,12,51));

    }
        @Test
        public void CompareValues()
        {
            assertNotEquals(appointment1.getDate(),appointment2.getDate());
            Assert.assertFalse(appointment1.getDate().equals(appointment2.getDate()));
            assertEquals(appointment1.getTime(),appointment2.getTime());
            Assert.assertTrue(appointment1.getTime().equals(appointment2.getTime()));
            assertNotEquals(appointment1.getAvailable(),appointment2.getAvailable());
            Assert.assertFalse(appointment1.getAvailable().equals(appointment2.getAvailable()));

        }

        @Test
        public void CheckAvailabilities()
        {
            assertTrue(appointment1.getAvailable());
            assertFalse(appointment2.getAvailable());
            assertFalse(appointment4.getAvailable());

        }

        @Test
        public void CheckNull()
        {
            assertNotNull(appointment1);
            assertNotNull(appointment2);
            assertNull(appointment3);
            assertNotNull(appointment4);

        }



}
