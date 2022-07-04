package gr.aueb.sweng22.team11.view.Ad.AdRequests;


import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team11.memoryDao.adDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.requestDaoMemory;

public class AdRequestsViewModel extends ViewModel {
    AdRequestsPresenter presenter;

    /**
     * Default constructor
     */
    public AdRequestsViewModel(){
        presenter = new AdRequestsPresenter();
        presenter.setAdDao(new adDaoMemory());
        presenter.setRequestDao(new requestDaoMemory());
    }

    /** get the presenter
     * @return the PlayerPagePresenter instance
     */
    public AdRequestsPresenter getPresenter(){return presenter;}

    /**
     * clear the view of the presenter
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }
}
