package gr.aueb.sweng22.team11.view.Ad.HandleRequest;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team11.memoryDao.adDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.appointmentDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.requestDaoMemory;

public class HandleRequestViewModel extends ViewModel {
    HandleRequestPresenter presenter;

    /**
     * Default constructor
     */
    public HandleRequestViewModel(){
        presenter = new HandleRequestPresenter();
        presenter.setAdDao(new adDaoMemory());
        presenter.setRequestDao(new requestDaoMemory());
        presenter.setAppointmentDao(new appointmentDaoMemory());
    }

    /** get the presenter
     * @return the PlayerPagePresenter instance
     */
    public HandleRequestPresenter getPresenter(){return presenter;}

    /**
     * clear the view of the presenter
     */
    @Override
    protected void onCleared(){
        super.onCleared();
        presenter.clearView();
    }

}
