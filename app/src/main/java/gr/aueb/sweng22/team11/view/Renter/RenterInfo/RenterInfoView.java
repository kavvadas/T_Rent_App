package gr.aueb.sweng22.team11.view.Renter.RenterInfo;

import java.time.LocalDate;

public interface RenterInfoView {
    /**
     * Method used
     * to set the username field of activity's layout
     * screen to the username of the renter that is logged in
     * @param username username of renter to be set
     */
    void setUsername(String username);

    /**
     * Method used
     * to set the password field of activity's layout
     * screen to the password of the renter that is logged in
     * @param password password of renter to be set
     */
    void setPassword(String password);

    /**
     * Method used
     * to set the name field of activity's layout
     * screen to the name of the renter that is logged in
     * @param name name of renter to be set
     */
    void setName(String name);

    /**
     * Method used
     * to set the lastname field of activity's layout
     * screen to the lastname of the renter that is logged in
     * @param lastname lastname of renter to be set
     */
    void setLastname(String lastname);

    /**
     * Method used
     * to set the phone field of activity's layout
     * screen to the phone of the renter that is logged in
     * @param phone phone of renter to be set
     */
    void setPhone(String phone);

    /**
     * Method used
     * to set the email field of activity's layout
     * screen to the email of the renter that is logged in
     * @param email email of renter to be set
     */
    void setEmail(String email);

    /**
     * Method used
     * to set the birthdate field of activity's layout
     * screen to the birthdate of the renter that is logged in
     * @param date birthdate of renter to be set
     */
    void setBirthdate(LocalDate date);

    /**
     * Method used
     * to set the username field of activity's layout
     * screen to the username of the renter that is logged in
     * @param nickname username of renter to be set
     */
    void setNickname(String nickname);

    /**
     * Starts the register renter activity so that the user can modify account
     * @param username nickanem of renter to be passed as an extra
     */
    void startEditRenter(String username);

    /**
     * Deletes the renter's account
     * and goes back to the login screen
     */
    void startDeleteRenter();

}
