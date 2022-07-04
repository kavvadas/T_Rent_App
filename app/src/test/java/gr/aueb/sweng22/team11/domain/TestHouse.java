package gr.aueb.sweng22.team11.domain;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class TestHouse {
    ArrayList<String> description = new ArrayList<>();


    House house1 = new House("Basileiou", "14323", "Argyroupoli", "250000",description); //make one with constructor
    House house2 = new House(); //make one with setters
    House house3 = null; //make one null
    House house4 = new House(); //make one with some values null

    @Before
    public void setUp()
    {
        house2.setStreet("Gkritzali");
        house2.setPostcode("12535");
        house2.setRegion("Mani");
        house2.setRent("150");
        house2.getDescription().add("adsfsdaf");

        house4.setStreet("Gkritzali");

    }
    @Test
    public void CompareValues()
    {
        assertTrue(house1.getRent().equals(house2.getRent()));
        assertNotEquals(house2, house4);
        assertTrue(house4.getRent().equalsIgnoreCase("0"));
        assertEquals(house2.getStreet(), (house4.getStreet()));

    }

    @Test
    public void CheckNull()
    {
        assertNull(house3);
        assertNotNull(house4.getRent());
        assertNotNull(house4.getPostcode());
        assertNotNull(house4.getRegion());
        assertNotNull(house1);
        assertNotNull(house2);
        assertNotNull(house4);


    }

    @Test
    public void testStreet()
    {

        assertEquals(house2.getStreet(), "Gkritzali");

    }

    @Test
    public void testRent()
    {

        assertTrue(house1.getRent().equalsIgnoreCase("250000"));
        assertEquals(house2.getRent(), house1.getRent());

    }

    @Test
    public void testPostcode()
    {
        assertEquals(house1.getPostcode(),"14323");
        assertEquals(house2.getPostcode(),"12535");
        assertEquals(house4.getPostcode(),"");


    }


    @Test
    public void testRegion()
    {

        assertEquals(house1.getRegion(),"Argyroupoli");
        assertEquals(house2.getRegion(),"Mani");
        assertEquals(house4.getRegion(),"");

    }



}

