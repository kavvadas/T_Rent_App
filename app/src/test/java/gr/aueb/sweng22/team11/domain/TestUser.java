package gr.aueb.sweng22.team11.domain;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class TestUser {

    private User user;
    private User user2;
    private User user3;
    private LocalDate date;
    private LocalDate date2;
    private Credentials credentials;
    private Credentials credentials2;

    Notification n1 = new Notification("notification1");
    Notification n2 = new Notification("notification2");
    Notification n3 = new Notification("notification3");
    Notification n4 = new Notification("notification4");
    Notification n5 = new Notification("notification5");

    /**
     *setup some initial variables before attempting each test
     */
    @Before
    public void setUp() throws Exception {
        date = LocalDate.parse("1994-05-03");
        date2 = LocalDate.parse("2000-01-04");
        credentials = new Credentials("jimms", "123456");
        credentials2 = new Credentials("mariouuus", "123456");
        user = new User("Dimitris", "Kavvadas", "69341223", "dimitris@gmail.com", date, credentials);
        user2 = new User("Marios", "Papagewrgiou", "692352135", "marios@gmail.com", date2, credentials2);
        user3 = new User();

    }

    /**
     * test the equality between to instances
     */
    @Test
    public void testEquals() {

        User userTest = new User("Dimitris", "Kavvadas", "69341223", "dimitris@gmail.com", date, credentials);
        assertEquals(userTest, user);
        assertEquals(user, user);

    }

    /**
     * test the inequality between to instances
     */
    @Test
    public void testNotEquals() {

        assertNotEquals(user2, user);
        assertNotEquals(user3, user);
        assertNotEquals(user2, user3);

    }

    /**
     * test the equality between to instances
     */
    @Test
    public void testPrinting() {

        User userTest = new User("Dimitris", "Kavvadas", "69341223", "dimitris@gmail.com", date, credentials);
        assertEquals(userTest.toString(), user.toString());

    }

    /**
     * test the name getter
     */
    @Test
    public void getNameTest() {

        assertEquals("Dimitris", user.getFirstName());
    }

    /**
     * test the surname getter
     */
    @Test
    public void getSurnameTest() {
        assertEquals("Papagewrgiou", user2.getLastName());
    }

    /**
     * test the phone number
     */
    @Test
    public void getPhoneNumber() {
        String phone = "69341223";
       assertEquals(phone, user.getPhoneNumber());
    }

    /**
     * test the birth date getter
     */
    @Test
    public void getBirthdayTest() {
        LocalDate dateTest = LocalDate.parse("2000-01-04");
        assertEquals(dateTest, user2.getDateOfBirth());
    }

    /**
     * test the email getter
     */
    @Test
    public void getEmailTest() {
        String emailTest = "dimitris@gmail.com";
        assertEquals(emailTest, user.getEmail());
    }

    /**
     * test the credentials getter
     */
    @Test
    public void getCredentialsTest() {
        Credentials credentialsTest = new Credentials("jimms", "123456");
       assertEquals(credentialsTest, user.getCredentials());
    }

    /**
     * test name getters and setters
     */
    @Test
    public void testSetterGetterName() {

        String newName = "Iaswnas";
        user.setFirstName(newName);
        assertEquals(newName, user.getFirstName());
    }

    /**
     * test the surname getters and setters
     */
    @Test
    public void testSetterGetterSurname() {

        String newSurname = "";
        user2.setLastName(newSurname);
        assertEquals(newSurname, user2.getLastName());

    }

    /**
     * test the phone number getters and setters
     */
    @Test
    public void testSetterGetterPhoneNumber() {

        String phoneNumber = "697xxxxxxx";
        user2.setPhoneNumber(phoneNumber);
        assertEquals(phoneNumber, user2.getPhoneNumber());

    }

    /**
     * test the email getters and setters
     */
    @Test
    public void testSetterGetterEmail() {

        String email = "iaswn@yahoo.gr";
        user3.setEmail(email);
       assertEquals(email, user3.getEmail());

    }

    /**
     * test the birth date getters and setters
     */
    @Test
    public void testSetterGetterBirthdate() {

        LocalDate birthDate = LocalDate.parse("1999-03-04");
        user.setDateOfBirth(birthDate);
        assertEquals(birthDate, user.getDateOfBirth());

    }

    /**
     * test the credentials getters and setters
     */
    @Test
    public void testSetterGetterCredentials() {

        Credentials cred = new Credentials("iaswwn!", "123789");
        user2.setCredentials(cred);
        assertEquals(cred, user2.getCredentials());

    }

    @Test
    public void testLogin() {

        Credentials cred = new Credentials("iaswwn!", "123789");
        user2.setCredentials(cred);
        assertTrue(user2.login("iaswwn!", "123789"));

    }

    @Test
    public void testNotification() {

        user.receiveNotification(n1);
        user.receiveNotification(n2);
        user.receiveNotification(n3);
        user.receiveNotification(n4);
        user.receiveNotification(n5);

        user2.receiveNotification(n1);
        user2.receiveNotification(n2);
        user2.receiveNotification(n3);
        user2.receiveNotification(n4);
        user2.receiveNotification(n5);

        assertEquals(user.getNotification(), user2.getNotification());
        assertNotNull(user.getNotification());
        assertNotNull(user2.getNotification());
        assertNull(user3.getNotification());


    }

}
