package gr.aueb.sweng22.team11.domain;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2020-2021
 */

public class TestCredentials {
    private Credentials credentials;
    private Credentials credentials2;
    private Credentials credentials3;
    private Credentials credentials4;
    private Credentials credentials5;

    /**
     *setup some initial variables before attempting each test
     */
    @Test
    public void setUp() {
        credentials = new Credentials("Dimitris", "123456");
        credentials2 = new Credentials("Marios", "123456");
        credentials3 = new Credentials("Marios", "GioGio");
        credentials4 = new Credentials("Dimitris", "123456");
        credentials5 = new Credentials();
    }

    /**
     * test the equality between to instances
     */
    @Test
    public void testEquals() {

      //  Credentials credentials4 = new Credentials("Marios", "123456");
        assertEquals(credentials4, credentials);
        assertEquals(credentials, credentials);
    }

    /**
     * test the inequality between to instances
     */
    @Test
    public void testNotEquals() {
        setUp();
        assertNotEquals(credentials2, credentials);
        assertNotEquals(credentials3, credentials);
        assertNotEquals(credentials5, credentials);
        Credentials credTest = null;
        assertNotEquals(credTest, credentials);

    }

    /**
     * test the toString method
     */
    @Test
    public void testPrinting() {
        setUp();
        assertEquals(credentials4.toString(), credentials.toString());
    }

    /**
     * test the username getter
     */
    @Test
    public void getUsernameTest() {

        setUp();
        assertEquals("Marios", credentials2.getUsername());
    }

    /**
     * test the password getter
     */
    @Test
    public void getPasswordTest() {
        setUp();
        assertEquals("123456", credentials.getPassword());
    }


    /**
     * test the username setter
     */
    @Test
    public void testSetterGetterUsername() {
        setUp();

        String newName = "Dimitris";
        credentials.setUsername(newName);
        assertEquals(newName, credentials.getUsername());

    }


    /**
     * test the password setter
     */
    @Test
    public void testSetterGetterPassword() {
        setUp();
        String newPassword = "456789";
        credentials.setPassword(newPassword);
        assertEquals(newPassword, credentials.getPassword());

    }
}