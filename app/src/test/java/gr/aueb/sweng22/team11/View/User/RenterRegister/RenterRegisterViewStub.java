package gr.aueb.sweng22.team11.View.User.RenterRegister;

import gr.aueb.sweng22.team11.view.User.RenterRegister.RenterRegisterView;

public class RenterRegisterViewStub implements RenterRegisterView {
    String username = "username";
    String password = "password";
    String password2 = "password2";
    String name = "name";
    String lastname = "lastname";

    String phone = "6971624775";

    String mail = "example@test.gr";

    String birthdate = "4/2/98";

    String ownerTitle = "Title";

    String nickname = "nickname";

    @Override
    public String getNickname() {
        return nickname;
    }

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
    public void setNickname(String nickname) {

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
    public void setPhone(String phone) {

    }

    @Override
    public void setBirthdate(String birthdate) {

    }

    @Override
    public void setEmail(String email) {

    }

    @Override
    public void showPop(RenterRegisterView view, String mess) {

    }

    @Override
    public String getPassword2() {
        return password2;
    }

    @Override
    public void toLoginPage() {

    }

    @Override
    public void startRenterPage(String username) {

    }

    @Override
    public void lock() {

    }
}
