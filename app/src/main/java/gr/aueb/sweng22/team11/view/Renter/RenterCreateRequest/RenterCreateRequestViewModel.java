package gr.aueb.sweng22.team11.view.Renter.RenterCreateRequest;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team11.memoryDao.adDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.renterDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.requestDaoMemory;

public class RenterCreateRequestViewModel extends ViewModel {
    RenterCreateRequestPresenter presenter;

    /**
     * Default constructor
     */
    public RenterCreateRequestViewModel(){
        presenter = new RenterCreateRequestPresenter();
        presenter.setRequestDao(new requestDaoMemory());
        presenter.setAdDao(new adDaoMemory());
        presenter.setRenterDao(new renterDaoMemory());
    }

    /** get the presenter
     * @return the PlayerPagePresenter instance
     */
    public RenterCreateRequestPresenter getPresenter(){return presenter;}

    /**
     * clear the view of the presenter
     */
    @Override
    protected void onCleared(){
        super.onCleared();
        presenter.clearView();
    }
}
