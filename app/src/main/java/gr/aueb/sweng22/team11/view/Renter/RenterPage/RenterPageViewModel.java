package gr.aueb.sweng22.team11.view.Renter.RenterPage;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team11.memoryDao.loginDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.renterDaoMemory;

public class RenterPageViewModel extends ViewModel {
    RenterPagePresenter presenter;

    /**
     * Default constructor
     */
    public RenterPageViewModel(){
        presenter = new RenterPagePresenter();
        presenter.setLoginDao(new loginDaoMemory());
        presenter.setRenterDao(new renterDaoMemory());
    }

    /** get the presenter
     * @return the PlayerPagePresenter instance
     */
    public RenterPagePresenter getPresenter(){return presenter;}

    /**
     * clear the view of the presenter
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }
}
