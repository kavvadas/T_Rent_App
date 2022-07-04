

package gr.aueb.sweng22.team11.View.Ad.AdInfo;

import gr.aueb.sweng22.team11.dao.Initializer;
import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.domain.House;
import gr.aueb.sweng22.team11.memoryDao.adDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.initializerMemory;
import gr.aueb.sweng22.team11.view.Ad.AdInfo.AdInfoPresenter;
import gr.aueb.sweng22.team11.view.Ad.AdInfo.AdInfoView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.MemoryHandler;

public class AdInfoPresenterTest {

    private AdInfoView view;
    private AdInfoPresenter presenter;
    private Ad ad;


    @Before
    public void setup() {

        new initializerMemory().prepare();
        new adDaoMemory().save(ad);


        view = new AdInfoViewStub();
        presenter = new AdInfoPresenter();

        presenter.setAdDao(new adDaoMemory());
        presenter.setView(view);

        //    ad = new adDaoMemory().findByStreet("papandreou 12");
    }

    @Test
    public void adInfoTestEditable() {

        Assert.assertNotNull(new adDaoMemory().findAll());


    }


  /*  @Test
    public void adInfoTestUneditable() {


        new initializerMemory().prepare();
        // new adDaoMemory().

        view = new AdInfoViewStub();
        presenter = new AdInfoPresenter();
        presenter.setAdDao(new adDaoMemory());
        presenter.setView(view);


        ad = new adDaoMemory().findByStreet("test_street");
        presenter.findAdInfo("test_comment");

        presenter.onEditAd();




    }

   */
}






