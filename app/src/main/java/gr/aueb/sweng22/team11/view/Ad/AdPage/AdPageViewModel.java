package gr.aueb.sweng22.team11.view.Ad.AdPage;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team11.dao.AdDao;
import gr.aueb.sweng22.team11.memoryDao.adDaoMemory;

public class AdPageViewModel extends ViewModel {
    AdPagePresenter presenter;

    /**
     * Default constructor
     */
    public AdPageViewModel(){
        presenter = new AdPagePresenter();
        presenter.setAdDao(new adDaoMemory());
    }

    /** get the presenter
     * @return the PlayerPagePresenter instance
     */
    public AdPagePresenter getPresenter(){return presenter;}

    /**
     * clear the view of the presenter
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }
}
