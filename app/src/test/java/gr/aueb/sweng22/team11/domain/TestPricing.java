package gr.aueb.sweng22.team11.domain;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestPricing {

    Pricing price1 = new Pricing(120);
    Pricing price2 = new Pricing(120);
    Pricing price3 = null;
    Pricing price4 = new Pricing();
    Pricing price5 = new Pricing();

    @Before
    public void setUp()
    {
        price4.setPrice(350);
        price4.setHasToBePaid();
        price4.setIsPaid();
        price2.setHasToBePaid();

    }
    @Test
    public void CompareValues()
    {
         assertNotEquals(price1.getPrice(), price4.getPrice());
         assertEquals(price1.getPrice(), price2.getPrice());

    }

    @Test
    public void CheckIsPaid()
    {
        assertEquals(price1.getIsPaid(), price2.getIsPaid());
        assertFalse(price1.getIsPaid());
        assertTrue(price4.getIsPaid());

    }

    @Test
    public void CheckHasToBePaid()
    {
        assertFalse(price5.getHasToBePaid());
        assertEquals(price2.getHasToBePaid(), price4.getHasToBePaid());

    }

    @Test
    public void CheckNull()
    {
         assertNull(price3);
        assertNotNull(price5);

    }



}

