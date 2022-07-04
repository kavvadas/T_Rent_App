package gr.aueb.sweng22.team11.View.Renter.RenterPage;

import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.domain.Credentials;
import gr.aueb.sweng22.team11.domain.OwnerAccount;
import gr.aueb.sweng22.team11.domain.RentAccount;
import gr.aueb.sweng22.team11.memoryDao.initializerMemory;
import gr.aueb.sweng22.team11.memoryDao.loginDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.renterDaoMemory;
import gr.aueb.sweng22.team11.view.Renter.RenterPage.RenterPagePresenter;
import gr.aueb.sweng22.team11.view.Renter.RenterPage.RenterPageView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class RenterPagePresenterTest {
    private RenterPageView view;
    private RenterPagePresenter presenter;



    @Before
    public void setup(){
        new initializerMemory().prepare();

        presenter = new RenterPagePresenter();
        view = new RenterPageViewStub();

        presenter.setRenterDao(new renterDaoMemory());
        presenter.setLoginDao(new loginDaoMemory());

        presenter.setView(view);

        RentAccount renter = new RentAccount("nickname","name","lastname","6975624966","example@mail.gr",LocalDate.now(), new Credentials("name","password"));


       // renter.setTitle("Title");
        renter.setEmail("example@mail.gr");
        renter.setNickname("nickname");
        renter.setFirstName("name");
        renter.setLastName("lastname");
        renter.setCredentials(new Credentials("name","password"));
        renter.setDateOfBirth(LocalDate.now());
        renter.setPhoneNumber("69715623");

        presenter.setRenter(renter);


    }

    @Test
    public void RenterCheck(){

        Assert.assertEquals(presenter.getRenterNickname(),"nickname");


    }

}

