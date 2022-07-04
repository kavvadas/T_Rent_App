package gr.aueb.sweng22.team11.view.Owner.OwnerPage;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team11.memoryDao.loginDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.ownerDaoMemory;

public class OwnerPageViewModel extends ViewModel {
    OwnerPagePresenter presenter;

    /**
     * Default constructor
     */
    public OwnerPageViewModel(){
        presenter = new OwnerPagePresenter();
        presenter.setLoginDao(new loginDaoMemory());
        presenter.setOwnerDao(new ownerDaoMemory());
    }

    /** get the presenter
     * @return the PlayerPagePresenter instance
     */
    public OwnerPagePresenter getPresenter(){return presenter;}

    /**
     * clear the view of the presenter
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }
}
