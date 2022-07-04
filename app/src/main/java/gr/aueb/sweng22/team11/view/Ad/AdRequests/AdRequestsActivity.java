package gr.aueb.sweng22.team11.view.Ad.AdRequests;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.domain.Request;
import gr.aueb.sweng22.team11.view.Ad.AdRequests.fragment.RequestListFragment;
import gr.aueb.sweng22.team11.view.Ad.HandleRequest.HandleRequestActivity;
import gr.aueb.sweng22.team11.view.Owner.OwnerAds.fragment.AdListFragment;

public class AdRequestsActivity extends AppCompatActivity implements AdRequestsView, RequestListFragment.OnListFragmentInteractionListener {

    public static final String AD_TITLE = "ad_title_extra";
    public static final String RENTER_NICKNAME_EXTRA = "renter_nickname_extra";
    public static final String APPOINTMENT_EXTRA = "appointment_extra";
    public static final String POSITION_EXTRA = "position_extra";
    String adTitle;
    AdRequestsViewModel viewModel;

    /**
     * Creates the layout and initializes the activity
     * @param savedInstanceState the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_requests);

        adTitle  = this.getIntent().getStringExtra(AD_TITLE);

        viewModel = new ViewModelProvider(this).get(AdRequestsViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findRequestsSent(adTitle);

        if(findViewById(R.id.fragment_container1) != null){
            if(savedInstanceState != null)
                return;
            RequestListFragment requestListFragment = RequestListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container1, requestListFragment).commit();
        }
    }

    /**
     * what happens when the user presses on a request
     * @param item the ad
     */
    @Override
    public void onListFragmentInteraction(Request item,int position) {
        Intent intent = new Intent(this, HandleRequestActivity.class);
        intent.putExtra(AD_TITLE,adTitle);
        intent.putExtra(RENTER_NICKNAME_EXTRA,item.getRenter().getNickname());
        String appointment = item.getAppointment().getDate().toString()+" "+item.getAppointment().getDate().toString();
        intent.putExtra(APPOINTMENT_EXTRA,appointment);
        intent.putExtra(POSITION_EXTRA,position);
        startActivity(intent);

    }
    /**
     * get the requests of the ad
     * @return the ArrayList of requests
     */
    @Override
    public ArrayList<Request> getListRequest() {
       return viewModel.getPresenter().getRequests();
    }
}