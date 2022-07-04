package gr.aueb.sweng22.team11.view.Owner.CreateAd;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team11.memoryDao.adDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.ownerDaoMemory;

public class CreateAdViewModel extends ViewModel {
    CreateAdPresenter presenter;

    /**
     * Default constructor
     */
    public CreateAdViewModel(){
        presenter = new CreateAdPresenter();
        presenter.setAdDao(new adDaoMemory());
        presenter.setOwnerDao(new ownerDaoMemory());
    }

    /**
     * @return the presenter instance
     */
    public CreateAdPresenter getPresenter(){return presenter;}

    /**
     * clear the view of the presenter
     */
    @Override
    protected void onCleared(){
        super.onCleared();
        presenter.clearView();
    }

}
