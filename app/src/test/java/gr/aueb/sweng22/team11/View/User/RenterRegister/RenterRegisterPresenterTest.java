package gr.aueb.sweng22.team11.View.User.RenterRegister;

import gr.aueb.sweng22.team11.memoryDao.initializerMemory;
import gr.aueb.sweng22.team11.memoryDao.loginDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.ownerDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.renterDaoMemory;
import gr.aueb.sweng22.team11.view.User.RenterRegister.RenterRegisterPresenter;
import gr.aueb.sweng22.team11.view.User.RenterRegister.RenterRegisterView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RenterRegisterPresenterTest {


    private RenterRegisterView view;
    private  RenterRegisterPresenter presenter;


    @Before
    public void setup(){
        new initializerMemory().prepare();


        view = new RenterRegisterViewStub();
        presenter = new RenterRegisterPresenter();

        presenter.setRenterDao(new renterDaoMemory());
        presenter.setLoginDao(new loginDaoMemory());
        presenter.setOwnerDao(new ownerDaoMemory());

        presenter.setView(view);
    }


    @Test
    public void NoneRenter(){
        Assert.assertNull(new renterDaoMemory().findByNickname("nickname"));

    }

    @Test
    public void CorrectCheckers(){
        Assert.assertNull(new renterDaoMemory().findByNickname("nickname"));
        Assert.assertEquals(presenter.checkAge(1983),true);
        Assert.assertEquals(presenter.checkAge(2019),false);
        Assert.assertEquals(presenter.checkEmail("example@test.gr"),true);
    }






}
