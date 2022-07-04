package gr.aueb.sweng22.team11.View.Ad.Owner.OwnerPage;

import gr.aueb.sweng22.team11.dao.OwnerDao;
import gr.aueb.sweng22.team11.domain.Credentials;
import gr.aueb.sweng22.team11.domain.OwnerAccount;
import gr.aueb.sweng22.team11.domain.User;
import gr.aueb.sweng22.team11.memoryDao.initializerMemory;
import gr.aueb.sweng22.team11.memoryDao.loginDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.ownerDaoMemory;
import gr.aueb.sweng22.team11.view.Owner.OwnerPage.OwnerPagePresenter;
import gr.aueb.sweng22.team11.view.Owner.OwnerPage.OwnerPageView;
import gr.aueb.sweng22.team11.view.User.OwnerRegister.OwnerRegisterPresenter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class OwnerPagePresenterTest {

    private OwnerPageView view;
    private OwnerPagePresenter presenter;

    @Before
    public void setup(){
        new initializerMemory().prepare();

        presenter = new OwnerPagePresenter();
        view = new OwnerPageViewStub();



        presenter.setOwnerDao(new ownerDaoMemory());
        presenter.setLoginDao(new loginDaoMemory());

        presenter.setView(view);

        OwnerAccount owner = new OwnerAccount();

        owner.setTitle("Title");
        owner.setEmail("example@mail.gr");
        owner.setFirstName("name");
        owner.setLastName("lastname");
        owner.setCredentials(new Credentials("name","password"));
        owner.setDateOfBirth(LocalDate.now());
        owner.setPhoneNumber("69715623");

        presenter.setOwner(owner);

    }
    @Test
    public void UserCheck(){

        Assert.assertNotNull(presenter.getOwnerTitle());
        Assert.assertEquals(presenter.getOwnerTitle(),"Title");


    }



}
