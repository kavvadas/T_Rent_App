package gr.aueb.sweng22.team11.view.User.Login;

public interface LoginView {

    /**
     * get the content of the textInputLayout
     * @return the username given
     */
    String getUsername();

    /**
     * get the content of the textInputLayout
     * @return the password given
     */
    String getPassword();

    /**
     * a pop shows on the screen
     * @param view the view of the pop
     * @param mess message of the pop
     */
    void showPop(LoginView view, String mess);

    /**
     * start the owner page activity
     * @param title the title of the owner is passed as an extra
     */
    void startOwnerPage(String title);

    /**
     * start the renter page activity
     * @param nickname the nickname of the renter is passed as an extra
     */
    void startRenterPage(String nickname);
}
