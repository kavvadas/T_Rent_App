package gr.aueb.sweng22.team11.view.Renter.RenterMaps;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team11.memoryDao.adDaoMemory;

public class RenterMapsViewModel extends ViewModel {
    RenterMapsPresenter presenter;

    public RenterMapsViewModel(){
        presenter = new RenterMapsPresenter();
        presenter.setAdDao(new adDaoMemory());
    }

    public RenterMapsPresenter getPresenter(){return presenter;}

    @Override
    protected void onCleared(){
        super.onCleared();
        presenter.clearView();
    }
}
