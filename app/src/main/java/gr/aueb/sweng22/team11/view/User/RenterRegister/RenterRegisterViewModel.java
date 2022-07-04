package gr.aueb.sweng22.team11.view.User.RenterRegister;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team11.dao.RenterDao;
import gr.aueb.sweng22.team11.memoryDao.loginDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.ownerDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.renterDaoMemory;

public class RenterRegisterViewModel extends ViewModel {
    RenterRegisterPresenter presenter;

    /**
     * Default constructor
     */
    public RenterRegisterViewModel(){
        presenter = new RenterRegisterPresenter();
        presenter.setLoginDao(new loginDaoMemory());
        presenter.setOwnerDao(new ownerDaoMemory());
        presenter.setRenterDao(new renterDaoMemory());
    }

    /**
     * @return the presenter instance
     */
    public RenterRegisterPresenter getPresenter(){return presenter;}

    /**
     * clear the view of the presenter
     */
    @Override
    protected void onCleared(){
        super.onCleared();
        presenter.clearView();
    }
}
