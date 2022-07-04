package gr.aueb.sweng22.team11.view.User.Login;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team11.memoryDao.loginDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.ownerDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.renterDaoMemory;

public class LoginViewModel extends ViewModel {
    LoginPresenter presenter;

    /**
     * Default constructor
     */
    public LoginViewModel(){
        presenter = new LoginPresenter();
        presenter.setOwnerDao(new ownerDaoMemory());
        presenter.setRenterDao(new renterDaoMemory());
        presenter.setLoginDao(new loginDaoMemory());
    }

    /**
     * @return the presenter instance
     */
    public LoginPresenter getPresenter() {
        return presenter;
    }

    /**
     * clear the view of the presenter
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }
}
