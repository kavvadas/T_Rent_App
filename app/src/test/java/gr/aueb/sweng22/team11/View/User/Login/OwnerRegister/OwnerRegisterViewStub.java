package gr.aueb.sweng22.team11.View.User.Login.OwnerRegister;

import gr.aueb.sweng22.team11.view.User.OwnerRegister.OwnerRegisterView;

public class OwnerRegisterViewStub implements OwnerRegisterView {
    String username = "username";
    String password = "password";
    String password2 = "password2";
    String name = "name";
    String lastname = "lastname";

    String phone = "6971624775";

    String mail = "example@test.gr";

    String birthdate = "4/2/98";

    String ownerTitle = "Title";

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLastname() {
        return lastname;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public String getEmail() {
        return mail;
    }

    @Override
    public String getBirthdate() {
        return birthdate;
    }

    @Override
    public int getYear() {
        return 0;
    }

    @Override
    public String getOwnerTitle() {
        return ownerTitle;
    }

    @Override
    public void setUsername(String username) {

    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void setLastname(String lastname) {

    }

    @Override
    public void setBirthdate(String birthdate) {

    }

    @Override
    public void setPhone(String phone) {

    }

    @Override
    public void setEmail(String email) {

    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void showPop(OwnerRegisterView view, String mess) {

    }

    @Override
    public String getPassword2() {
        return password2;
    }

    @Override
    public void toLoginPage() {

    }

    @Override
    public void startOwnerPage(String title) {

    }

    @Override
    public void lock() {

    }
}
