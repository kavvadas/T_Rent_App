package gr.aueb.sweng22.team11.view.User.OwnerRegister;

public interface OwnerRegisterView {

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
     * get the content of textInputLayout
     * @return the title given
     */
    String getOwnerTitle();

    /**
     * Method used
     * to set the username field of activity's layout
     * screen to the username of the owner that is logged in
     * @param username username of owner to be set
     */
    void setUsername(String username);

    /**
     * Method used
     * to set the username field of activity's layout
     * screen to the username of the owner that is logged in
     * @param password username of owner to be set
     */
    void setPassword(String password);

    /**
     * Method used
     * to set the name field of activity's layout
     * screen to the username of the owner that is logged in
     * @param name name of owner to be set
     */
    void setName(String name);

    /**
     * Method used
     * to set the lastname field of activity's layout
     * screen to the lastname of the owner that is logged in
     * @param lastname lastname of owner to be set
     */
    void setLastname(String lastname);

    /**
     * Method used
     * to set the birthdate field of the owner that is logged in
     * @param birthdate
     */
    void setBirthdate(String birthdate);

    /**
     * Method used
     * to set the phone field of activity's layout
     * screen to the phone of the owner that is logged in
     * @param phone phone of owner to be set
     */
    void setPhone(String phone);

    /**
     * Method used
     * to set the email field of activity's layout
     * screen to the email of the owner that is logged in
     * @param email email of owner to be set
     */
    void setEmail(String email);

    /**
     * Method used
     * to set the title field of activity's layout
     * screen to the title of the owner that is logged in
     * @param title title of owner to be set
     */
    void setTitle(String title);

    /**
     * a pop shows on the screen
     * @param view the view of the pop
     * @param mess message of the pop
     */
    void showPop(OwnerRegisterView view,String mess);

    /**
     * starts the loginPage
     * when the create account button is pressed
     */
    void toLoginPage();

    /**
     * starts the ownerPage
     * when the saved button is pressed in edit info
     */
    void startOwnerPage(String title);

    /**
     * lock the dateofbirthbutton in editAccount
     */
    void lock();
}
