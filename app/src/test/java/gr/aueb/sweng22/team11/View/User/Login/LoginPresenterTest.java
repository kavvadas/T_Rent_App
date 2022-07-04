package gr.aueb.sweng22.team11.View.User.Login;

import gr.aueb.sweng22.team11.dao.Initializer;
import gr.aueb.sweng22.team11.domain.Credentials;
import gr.aueb.sweng22.team11.domain.OwnerAccount;
import gr.aueb.sweng22.team11.memoryDao.initializerMemory;
import gr.aueb.sweng22.team11.memoryDao.loginDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.ownerDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.renterDaoMemory;
import gr.aueb.sweng22.team11.view.User.Login.LoginPresenter;
import gr.aueb.sweng22.team11.view.User.Login.LoginView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginPresenterTest {
    private LoginView view;
    private LoginPresenter presenter;





    @Before
    public void setup(){
        new initializerMemory().prepare();
        view = new LoginViewStub();
        presenter = new LoginPresenter();
        presenter.setLoginDao(new loginDaoMemory());
        presenter.setOwnerDao(new ownerDaoMemory());
        presenter.setRenterDao(new renterDaoMemory());

        presenter.setView(view);




    }



    @Test
    public void loginSuccess(){
        presenter.validateCredentials();
        Assert.assertEquals(presenter.getLoginDao().getUser(), new ownerDaoMemory().findByCredentials(new Credentials("Marios","password")));
    }



    @Test
    public void loginFailed(){
       new ownerDaoMemory().delete(new ownerDaoMemory().findByCredentials(new Credentials("Marios","password")));
       presenter.validateCredentials();
       Assert.assertEquals(presenter.getLoginDao().getUser(),null);



    }

}
