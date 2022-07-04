package gr.aueb.sweng22.team11.domain;
import java.time.LocalDate;
import java.util.ArrayList;

public class User {

    private String FirstName, LastName,phoneNumber,email;
    private LocalDate DateOfBirth;
    private Credentials credentials;
    private ArrayList<Notification> Notification;

    public User(){
        this.FirstName = "";
        this.LastName = "";
        this.phoneNumber = "";
        this.email = "";
        this.DateOfBirth = null;
        this.credentials = null;
    }

    public User(String first, String last, String phone, String email, LocalDate date, Credentials credentials){
        this.FirstName = first;
        this.LastName = last;
        this.phoneNumber = phone;
        this.email = email;
        this.DateOfBirth = date;
        this.credentials = credentials;
        this.Notification = new ArrayList<>();
    }

    public boolean login(String usernameInput, String passwordInput) { return (usernameInput.equals(this.getCredentials().getUsername()) && passwordInput.equals(this.getCredentials().getPassword())); }

    public void receiveNotification(Notification notification){this.getNotification().add(notification);}

    public ArrayList<Notification> getNotification(){return Notification;}

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.DateOfBirth = dateOfBirth;
    }

    @Override
    public String toString(){
        return "UserDetails:"+
                "name='" + FirstName + '\'' +
                ", lastname='" + LastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + DateOfBirth +
                ", credentials=" + credentials +
                '}';
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        boolean equal = false;
        if (other instanceof User) {
            User otherUser = (User) other;

            if ((FirstName.equals(otherUser.FirstName) && otherUser.FirstName != null)
                    && (LastName.equals(otherUser.LastName) && otherUser.LastName != null)
                    && (phoneNumber.equals(otherUser.phoneNumber) && otherUser.phoneNumber != null)
                    && (DateOfBirth.equals(otherUser.DateOfBirth) && otherUser.DateOfBirth != null)
                    && (credentials.equals(otherUser.credentials) && otherUser.credentials != null)
                    && (email.equals(otherUser.email) && otherUser.email != null)
                    && (Notification.equals(otherUser.Notification) && otherUser.Notification != null)
            )
                equal = true;
        }
        return equal;
    }
}
