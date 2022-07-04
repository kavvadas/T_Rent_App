package gr.aueb.sweng22.team11.view.Owner.OwnerInfo;

import gr.aueb.sweng22.team11.memoryDao.adDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.appointmentDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.loginDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.ownerDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.requestDaoMemory;

import androidx.lifecycle.ViewModel;


public class OwnerInfoViewModel extends ViewModel {
    OwnerInfoPresenter presenter;

    /**
     * Default constructor
     */
    public OwnerInfoViewModel(){
        presenter = new OwnerInfoPresenter();
        presenter.setOwner(new loginDaoMemory().getUser());
        presenter.setAdDao(new adDaoMemory());
        presenter.setAppointmentDao(new appointmentDaoMemory());
        presenter.setRequestDao(new requestDaoMemory());
        presenter.setOwnerDao(new ownerDaoMemory());
    }

     /**
     * @return the presenter instance
     */
    public OwnerInfoPresenter getPresenter(){return presenter;}

    /**
     * clear the view of the presenter
     */
    @Override
    protected void onCleared(){
        super.onCleared();
        presenter.clearView();
    }
}
