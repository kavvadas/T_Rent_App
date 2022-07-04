package gr.aueb.sweng22.team11.view.Renter.RenterAppointments;

import androidx.lifecycle.ViewModel;

import gr.aueb.sweng22.team11.memoryDao.appointmentDaoMemory;
import gr.aueb.sweng22.team11.memoryDao.renterDaoMemory;

public class RenterAppointmentsViewModel extends ViewModel {
    RenterAppointmentsPresenter presenter;

    /**
     * Default constructor
     */
    public RenterAppointmentsViewModel(){
        presenter = new RenterAppointmentsPresenter();
        presenter.setRenterDao(new renterDaoMemory());
        presenter.setAppointmentDao(new appointmentDaoMemory());
    }

    /** get the presenter
     * @return the PlayerPagePresenter instance
     */
    public RenterAppointmentsPresenter getPresenter(){return presenter;}

    /**
     * clear the view of the presenter
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        presenter.clearView();
    }



}
