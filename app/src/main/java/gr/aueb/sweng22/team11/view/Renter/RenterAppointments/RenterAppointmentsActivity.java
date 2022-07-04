package gr.aueb.sweng22.team11.view.Renter.RenterAppointments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.domain.Appointment;
import gr.aueb.sweng22.team11.view.Ad.AdRequests.fragment.RequestListFragment;
import gr.aueb.sweng22.team11.view.fragment.AppointmentListFragment;

public class RenterAppointmentsActivity extends AppCompatActivity implements RenterAppointmentsView, AppointmentListFragment.OnListFragmentInteractionListener {

    RenterAppointmentsViewModel viewModel;


    public static final String RENTER_NICKNAME_EXTRA = "renter_nickname_extra";
    String nickname;


    /**
     * Creates the layout and initializes the activity
     * @param savedInstanceState the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renter_appointments);

        nickname = getIntent().getStringExtra(RENTER_NICKNAME_EXTRA);

        viewModel = new ViewModelProvider(this).get(RenterAppointmentsViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findAppointments(nickname);



        if(findViewById(R.id.fragment_container) != null){
            if(savedInstanceState != null)
                return;
            AppointmentListFragment appointmentListFragment = AppointmentListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, appointmentListFragment).commit();
        }

    }


    /**
     * get the created appointments of the renter
     * @return the ArrayList of appointments
     */
    @Override
    public ArrayList<Appointment> getListAppointment() {
        return viewModel.getPresenter().getAppointments();
    }
}