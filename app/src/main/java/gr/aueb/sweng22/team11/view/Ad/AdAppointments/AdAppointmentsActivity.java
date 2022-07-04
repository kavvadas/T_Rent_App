package gr.aueb.sweng22.team11.view.Ad.AdAppointments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.domain.Appointment;
import gr.aueb.sweng22.team11.view.fragment.AppointmentListFragment;

public class AdAppointmentsActivity extends AppCompatActivity implements AdAppointmentsView, AppointmentListFragment.OnListFragmentInteractionListener {
    AdAppointmentsViewModel viewModel;

    public static final String AD_TITLE = "ad_title_extra";
    String title;

    /**
     * Creates the layout and initializes the activity
     * @param savedInstanceState the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_appointments);
        title = getIntent().getStringExtra(AD_TITLE);

        viewModel = new ViewModelProvider(this).get(AdAppointmentsViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findAppointments(title);
        if(findViewById(R.id.fragment_container) != null){
            if(savedInstanceState != null)
                return;
            AppointmentListFragment appointmentListFragment = AppointmentListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, appointmentListFragment).commit();
        }
    }

    /**
     * get the created appointments of the ad
     * @return the ArrayList of appointments
     */
    @Override
    public ArrayList<Appointment> getListAppointment() {
        return viewModel.getPresenter().getAppointments();
    }
}