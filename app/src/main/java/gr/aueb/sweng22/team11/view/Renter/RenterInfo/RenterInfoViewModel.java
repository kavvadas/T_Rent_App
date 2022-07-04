package gr.aueb.sweng22.team11.view.Renter.RenterInfo;

import gr.aueb.sweng22.team11.memoryDao.loginDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.renterDaoMemory;
import androidx.lifecycle.ViewModel;


public class RenterInfoViewModel extends ViewModel {
    RenterInfoPresenter presenter;

    /**
     * Default constructor
     */
    public RenterInfoViewModel(){
        presenter = new RenterInfoPresenter();
        presenter.setRenter(new loginDaoMemory().getUser());
        presenter.setRenterDao(new renterDaoMemory());
    }

    /**
     * @return the presenter instance
     */
    public RenterInfoPresenter getPresenter(){return presenter;}

    /**
     * clear the view of the presenter
     */
    @Override
    protected void onCleared(){
        super.onCleared();
        presenter.clearView();
    }
}
