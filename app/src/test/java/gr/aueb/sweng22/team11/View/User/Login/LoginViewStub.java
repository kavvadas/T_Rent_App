package gr.aueb.sweng22.team11.View.User.Login;

import gr.aueb.sweng22.team11.view.User.Login.LoginView;

public class LoginViewStub implements LoginView {

    String username = "Marios";
    String password = "password";



    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void showPop(LoginView view, String mess) {

    }

    @Override
    public void startOwnerPage(String title) {

    }

    @Override
    public void startRenterPage(String nickname) {

    }
}
