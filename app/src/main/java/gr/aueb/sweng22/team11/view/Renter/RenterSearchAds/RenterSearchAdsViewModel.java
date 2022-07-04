package gr.aueb.sweng22.team11.view.Renter.RenterSearchAds;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team11.memoryDao.adDaoMemory;

public class RenterSearchAdsViewModel extends ViewModel {
    RenterSearchAdsPresenter presenter;

    /**
     * Default constructor
     */
    public RenterSearchAdsViewModel(){
        presenter = new RenterSearchAdsPresenter();
        presenter.setAdDao(new adDaoMemory());
    }

    /** get the presenter
     * @return the PlayerPagePresenter instance
     */
    public RenterSearchAdsPresenter getPresenter(){return presenter;}

    /**
     * clear the view of the presenter
     */
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }

}
