package gr.aueb.sweng22.team11.View.Ad.AdInfo.CreateAd;

import gr.aueb.sweng22.team11.memoryDao.adDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.initializerMemory;
import gr.aueb.sweng22.team11.memoryDao.ownerDaoMemory;
import gr.aueb.sweng22.team11.view.Owner.CreateAd.CreateAdPresenter;
import gr.aueb.sweng22.team11.view.Owner.CreateAd.CreateAdView;
import org.junit.Before;
import org.junit.Test;

public class CreateAdPresenterTest {

    private CreateAdView view;
    private CreateAdPresenter presenter;

    @Before
    public void setup(){
        new initializerMemory().prepare();

        presenter = new CreateAdPresenter();
        view = new CreateAdViewStub();



        presenter.setView(view);
        presenter.setAdDao(new adDaoMemory());
        presenter.setOwnerDao(new ownerDaoMemory());





    }


    @Test
    public void CreationCheck(){

    }




}
