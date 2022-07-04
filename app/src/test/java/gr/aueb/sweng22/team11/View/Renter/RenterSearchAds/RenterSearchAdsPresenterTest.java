package gr.aueb.sweng22.team11.View.Renter.RenterSearchAds;

import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.memoryDao.adDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.initializerMemory;
import gr.aueb.sweng22.team11.view.Renter.RenterSearchAds.RenterSearchAdsPresenter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class RenterSearchAdsPresenterTest {
    private RenterSearchAdsPresenter presenter;
    private RenterSearchAdsViewStub view;


    @Before
    public void setup(){
      initializerMemory memory =  new initializerMemory();
        memory.prepare();
        presenter = new RenterSearchAdsPresenter();
        view = new RenterSearchAdsViewStub();

        presenter.setAdDao(new adDaoMemory());
        presenter.setView(view);



        ArrayList<Ad> adds = new ArrayList<>();



    }


    @Test
    public void AdsExist(){
        Assert.assertNotNull(new initializerMemory().getAdDao().findAll());

    }














}
