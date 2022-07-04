package gr.aueb.sweng22.team11.view.Ad.AdInfo;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team11.memoryDao.adDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.appointmentDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.requestDaoMemory;

public class AdInfoViewModel extends ViewModel {
    AdInfoPresenter presenter;

    /**
     * Default constructor
     */
    public AdInfoViewModel(){
        presenter = new AdInfoPresenter();
        presenter.setAppointmentDao(new appointmentDaoMemory());
        presenter.setRequestDao(new requestDaoMemory());
        presenter.setAdDao(new adDaoMemory());
    }

    /**
     * @return the presenter instance
     */
    public AdInfoPresenter getPresenter(){return presenter;}

    /**
     * clear the view of the presenter
     */
    @Override
    protected void onCleared(){
        super.onCleared();
        presenter.clearView();
    }
}
