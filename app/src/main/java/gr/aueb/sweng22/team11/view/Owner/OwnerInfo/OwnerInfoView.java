package gr.aueb.sweng22.team11.view.Owner.OwnerInfo;

import java.time.LocalDate;

public interface OwnerInfoView {
        /**
         * Method used
         * to set the username field of activity's layout
         * screen to the username of the owner that is logged in
         * @param username username of owner
         */
        void setUsername(String username);

        /**
         * Method used
         * to set the password field of activity's layout
         * screen to the password of the owner that is logged in
         * @param password password of owner
         */
        void setPassword(String password);

        /**
         * Method used
         * to set the name field of activity's layout
         * screen to the name of the owner that is logged in
         * @param name name of owner
         */
        void setName(String name);

        /**
         * Method used
         * to set the lastname field of activity's layout
         * screen to the lastname of the owner that is logged in
         * @param lastname lastname of owner
         */
        void setLastname(String lastname);

        /**
         * Method used
         * to set the phone field of activity's layout
         * screen to the phone of the owner that is logged in
         * @param phone phone of owner
         */
        void setPhone(String phone);

        /**
         * Method used
         * to set the email field of activity's layout
         * screen to the email of the owner that is logged in
         * @param email email of owner
         */
        void setEmail(String email);

        /**
         * Method used
         * to set the date field of activity's layout
         * screen to the date of the owner that is logged in
         * @param date date of owner
         */
        void setBirthdate(LocalDate date);

        /**
         * Method used
         * to set the title field of activity's layout
         * screen to the title of the owner that is logged in
         * @param title title of owner
         */
        void setTitle(String title);

        /**
         * Starts the register owner activity so that the user can modify account
         * @param title title of owner to be passed as an extra
         */
        void startEditOwner(String title);

        /**
         * Deletes the owner's account
         * and goes back to the login screen
         */
        void startDeleteOwner();

}
