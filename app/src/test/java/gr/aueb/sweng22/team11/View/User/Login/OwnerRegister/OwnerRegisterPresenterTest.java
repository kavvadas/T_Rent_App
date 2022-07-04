package gr.aueb.sweng22.team11.View.User.Login.OwnerRegister;

import gr.aueb.sweng22.team11.dao.RenterDao;
import gr.aueb.sweng22.team11.memoryDao.initializerMemory;
import gr.aueb.sweng22.team11.memoryDao.loginDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.ownerDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.renterDaoMemory;
import gr.aueb.sweng22.team11.view.User.OwnerRegister.OwnerRegisterPresenter;
import gr.aueb.sweng22.team11.view.User.OwnerRegister.OwnerRegisterView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OwnerRegisterPresenterTest {
    private OwnerRegisterView view;
    private OwnerRegisterPresenter presenter;

    @Before
    public void setup(){
        new initializerMemory().prepare();
        view = new OwnerRegisterViewStub();

        presenter =  new  OwnerRegisterPresenter();

        presenter.setRenterDao(new renterDaoMemory());
        presenter.setOwnerDao(new ownerDaoMemory());
        presenter.setLoginDao(new loginDaoMemory());

        presenter.setView(view);



    }

    @Test
    public void NoneUser(){
        Assert.assertNull(new ownerDaoMemory().findByTitle("Title"));
    }

    @Test
    public void CorrectChecks(){

        Assert.assertEquals(presenter.titleAlreadyUsed("Title",new ownerDaoMemory().findByTitle("Title")),false);
        Assert.assertEquals(presenter.checkAge(1983),true);
        Assert.assertEquals(presenter.checkAge(2019),false);
        Assert.assertEquals(presenter.checkEmail("example@test.gr"),true);

    }



}
