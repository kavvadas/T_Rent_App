package gr.aueb.sweng22.team11.view.Ad.AdAppointments;


import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team11.memoryDao.adDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.appointmentDaoMemory;

public class AdAppointmentsViewModel extends ViewModel {
    AdAppointmentsPresenter presenter;

    /**
     * Default constructor
     */
    public AdAppointmentsViewModel(){
        presenter = new AdAppointmentsPresenter();
        presenter.setAppointmentDao(new appointmentDaoMemory());
        presenter.setAdDao(new adDaoMemory());
    }

    /** get the presenter
     * @return the PlayerPagePresenter instance
     */
    public AdAppointmentsPresenter getPresenter(){return presenter;}

    /**
     * clear the view of the presenter
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }

}
