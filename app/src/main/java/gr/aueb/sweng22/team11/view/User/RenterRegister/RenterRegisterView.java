package gr.aueb.sweng22.team11.view.User.RenterRegister;

public interface RenterRegisterView {

    /**
     * get the content of textInputLayout
     * @return the nickname given
     */
    String getNickname();

    /**
     * get the content of textInputLayout
     * @return the username given
     */
    String getUsername();

    /**
     * get the content of textInputLayout
     * @return the password given
     */
    String getPassword();

    /**
     * get the content of textInputLayout
     * @return the password2 given
     */
    String getPassword2();

    /**
     * get the content of textInputLayout
     * @return the name given
     */
    String getName();

    /**
     * get the content of textInputLayout
     * @return the lastname given
     */
    String getLastname();


     /**
     * get the content of textInputLayout
     * @return the phone given
     */
    String getPhone();

    /**
     * get the content of textInputLayout
     * @return the email given
     */
    String getEmail();

    /**
     * get the content of datePicker
     * @return the birthdate given
     */
    String getBirthdate();

    /**
     * get the content of datepicker(year)
     * @return the year of the datepicker
     */
    int getYear();

    /**
     * Method used
     * to set the nickname field of activity's layout
     * screen to the nickname of the renter that is logged in
     * @param nickname nickname of renter to be set
     */
    void setNickname(String nickname);

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
     * to set the birthdate field of activity's layout
     * screen to the birthdate of the renter that is logged in
     * @param birthdate birthdate of renter to be set
     */
    void setBirthdate(String birthdate);

    /**
     * Method used
     * to set the email field of activity's layout
     * screen to the email of the renter that is logged in
     * @param email email of renter to be set
     */
    void setEmail(String email);

    /**
     * a pop shows on the screen
     * @param view the view of the pop
     * @param mess message of the pop
     */
    void showPop(RenterRegisterView view,String mess);

    /**
     * starts the loginPage
     * when the create account button is pressed
     */
    void toLoginPage();

    /**
     * starts the renterPage
     * when the saved button is pressed in edit info
     */
    void startRenterPage(String username);

    /**
     * lock the dateofbirthbutton in editAccount
     */
    void lock();
}

