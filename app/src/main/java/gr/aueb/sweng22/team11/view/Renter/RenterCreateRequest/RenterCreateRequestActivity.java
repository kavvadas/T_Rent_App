package gr.aueb.sweng22.team11.view.Renter.RenterCreateRequest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.domain.Appointment;
import gr.aueb.sweng22.team11.view.Renter.RenterPage.RenterPageActivity;

public class RenterCreateRequestActivity extends AppCompatActivity implements RenterCreateRequestView {
    private RenterCreateRequestViewModel viewModel;
    public static final String AD_TITLE = "ad_title_extra";
    public static final String RENTER_NICKNAME_EXTRA = "renter_nickname_extra";



    String renterN;
    String adT;

    String chosenAp;
    Button button;


    /**
     * Creates the layout and initializes the activity
     * @param savedInstanceState the Instance state
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renter_create_request);

        renterN = getIntent().getStringExtra(RENTER_NICKNAME_EXTRA);
        adT = getIntent().getStringExtra(AD_TITLE);

        viewModel = new ViewModelProvider(this).get(RenterCreateRequestViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findAdInfo(adT);


        button = findViewById(R.id.saveRequest);
        button.setOnClickListener(v-> viewModel.getPresenter().onSaveRequest(renterN));
    }

    /**
     * Method used
     * to set the title field of activity's layout
     * screen to the title of the ad
     * @param title title of ad to be set
     */
    @Override
    public void setTitle(String title) {
        ((TextView)findViewById(R.id.ads_title)).setText(title);
    }

    /**
     * Method used
     * to set the owner field of activity's layout
     * screen to the nickname of the owner
     * @param owner nickname of owner to be set
     */
    @Override
    public void setOwner(String owner) {
        ((TextView)findViewById(R.id.ads_owner)).setText(owner);
    }

    /**
     * Method used
     * to set the region field of activity's layout
     * screen to the region of the ad
     * @param region region of ad to be set
     */
    @Override
    public void setRegion(String region) {
        ((TextView)findViewById(R.id.ads_region)).setText(region);
    }

    /**
     * Method used
     * to set the street field of activity's layout
     * screen to the street of the ad
     * @param street street of ad to be set
     */
    @Override
    public void setStreet(String street) {
        ((TextView)findViewById(R.id.ads_street)).setText(street);
    }

    /**
     * Method used
     * to set the postcode field of activity's layout
     * screen to the postcode of the ad
     * @param postcode postcode of ad to be set
     */
    @Override
    public void setPostcode(String postcode) {
        ((TextView)findViewById(R.id.ads_postcode)).setText(postcode);
    }

    /**
     * Method used
     * to set the rent field of activity's layout
     * screen to the rent of the ad
     * @param rent rent of ad to be set
     */
    @Override
    public void setRent(String rent) {
        ((TextView)findViewById(R.id.ads_rent)).setText(rent);
    }

    /**
     * Method used
     * to set the appointments field of activity's layout
     * screen to the appointments of the ad that is already created
     * @param appointments appointments of ad to be set
     */
    @Override
    public void setAppointments(ArrayList<Appointment> appointments) {
        ListView listView = findViewById(R.id.ad_dates);
        ArrayList<String> appointmentList = new ArrayList<>();
        ArrayAdapter<String> arrayAdapter;

        for(Appointment appointment:appointments){
            String appS = appointment.getDate().toString()+" "+appointment.getTime().toString();
            appointmentList.add(appS);
        }
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,appointmentList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                chosenAp = appointmentList.get(position);
                ((TextView)findViewById(R.id.chosen_appointment)).setText(appointmentList.get(position));
            }
        });
    }

    /**
     * get the content of dates and hours been chosen by the owner
     * @return an array list of appointments
     */

    @Override
    public ArrayList<String> getChosenAppointment() {
        String[] strings = chosenAp.split(" ");
        ArrayList<String> appointment = new ArrayList<>();
        for(String string:strings){
            appointment.add(string);
        }
        return appointment;
    }


    /**
     * sends the request that the renter created
     * starts the RenterPageActivity and passes the nickname of the renter
     * @param nickname nickname of renter
     */
    @Override
    public void startRequest(String nickname) {
        Intent intent = new Intent(this, RenterPageActivity.class);
        intent.putExtra(RENTER_NICKNAME_EXTRA,nickname);
        startActivity(intent);
    }


}