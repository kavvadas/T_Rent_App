package gr.aueb.sweng22.team11.view.User.OwnerRegister;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team11.dao.RenterDao;
import gr.aueb.sweng22.team11.memoryDao.loginDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.ownerDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.renterDaoMemory;

public class OwnerRegisterViewModel extends ViewModel {
    OwnerRegisterPresenter presenter;

    /**
     * Default constructor
     */
    public OwnerRegisterViewModel(){
        presenter = new OwnerRegisterPresenter();
        presenter.setLoginDao(new loginDaoMemory());
        presenter.setOwnerDao(new ownerDaoMemory());
        presenter.setRenterDao(new renterDaoMemory());
    }

    /**
     * @return the presenter instance
     */
    public OwnerRegisterPresenter getPresenter(){return presenter;}

    /**
     * clear the view of the presenter
     */
    @Override
    protected void onCleared(){
        super.onCleared();
        presenter.clearView();
    }
}
