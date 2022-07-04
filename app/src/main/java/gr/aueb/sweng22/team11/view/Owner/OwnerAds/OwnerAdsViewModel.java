package gr.aueb.sweng22.team11.view.Owner.OwnerAds;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team11.memoryDao.adDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.ownerDaoMemory;

public class OwnerAdsViewModel extends ViewModel {
    OwnerAdsPresenter presenter;

    /**
     * Default constructor
     */
    public OwnerAdsViewModel(){
        presenter = new OwnerAdsPresenter();
        presenter.setOwnerDao(new ownerDaoMemory());
    }

    /** get the presenter
     * @return the PlayerPagePresenter instance
     */
    public OwnerAdsPresenter getPresenter(){return presenter;}

    /**
     * clear the view of the presenter
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }

}
