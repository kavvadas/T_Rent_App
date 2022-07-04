package gr.aueb.sweng22.team11.domain;
import org.junit.Before;
import org.junit.Test;


import java.time.LocalDate;

import static org.junit.Assert.*;

public class TestNotification {


    Notification n1 = new Notification("User Kaminas sent you a request");
    Notification n2 = new Notification();
    Notification n3 = null;
    Notification n4 = new Notification();

    @Before
    public void setUp()
    {
        n2.setDateOfNotification(LocalDate.now().minusDays(2));
        n2.setContent("User Kaminas sent you a request");

    }

    @Test
    public void CheckNull()
    {
          assertNotNull(n4);
          assertNotNull(n1);
          assertNotNull(n2);
          assertNull(n3);

    }

    @Test
    public void testContent()
    {
        assertEquals(n1.getContent(), "User Kaminas sent you a request");
        assertEquals(n2.getContent(), "User Kaminas sent you a request");
        assertSame(n1.getContent(), n2.getContent());

    }

    @Test
    public void testDate()
    {
        assertEquals(n1.getDateOfNotification(), LocalDate.now());
        assertEquals(n2.getDateOfNotification(),LocalDate.now().minusDays(2));

    }



}

