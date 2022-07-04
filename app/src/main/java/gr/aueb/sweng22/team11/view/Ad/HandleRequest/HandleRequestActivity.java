package gr.aueb.sweng22.team11.view.Ad.HandleRequest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.view.Ad.AdPage.AdPageActivity;

public class HandleRequestActivity extends AppCompatActivity implements HandleRequestView{
    HandleRequestViewModel viewModel;


    public static final String AD_TITLE = "ad_title_extra";
    public static final String OWNER_TITLE_EXTRA = "owner_title_extra";
    public static final String RENTER_NICKNAME_EXTRA = "renter_nickname_extra";
    public static final String APPOINTMENT_EXTRA = "appointment_extra";
    public static final String POSITION_EXTRA = "position_extra";

    String adT;
    String appoint;
    String nickname;
    int position;

    Button buttonAccept;
    Button buttonDecline;

    /**
     * Creates the layout and initializes the activity
     * @param savedInstanceState the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_request);
        adT = getIntent().getStringExtra(AD_TITLE);
        nickname = getIntent().getStringExtra(RENTER_NICKNAME_EXTRA);
        appoint = getIntent().getStringExtra(APPOINTMENT_EXTRA);
        position = getIntent().getIntExtra(POSITION_EXTRA,0);

        viewModel = new ViewModelProvider(this).get(HandleRequestViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findRequestInfo(appoint,nickname,adT);

        buttonAccept = findViewById(R.id.accept_request);
        buttonDecline = findViewById(R.id.decline_request);

        buttonAccept.setOnClickListener(v -> viewModel.getPresenter().onAcceptRequest(position));
        buttonDecline.setOnClickListener(v -> viewModel.getPresenter().onDeclineRequest(position));


    }

    /**
     * Method used
     * to set the nickname field of activity's layout
     * screen to the nickname of the renter that sent the request
     * @param renter nickname of the renter
     */
    @Override
    public void setRenter(String renter) {
        ((TextView)findViewById(R.id.renter_sent_request_title)).setText(renter);
    }

    /**
     * Method used
     * to set the appointment field of activity's layout
     * screen to the appointment of the request
     * @param appointment appointment of the request
     */
    @Override
    public void setAppointment(String appointment) {
        ((TextView)findViewById(R.id.appointment_sent)).setText(appointment);
    }

    /**
     * Starts the AdPageActivity
     * when accept button is pressed
     * @param title title of the ad that is passed as an extra
     */
    @Override
    public void startAcceptRequest(String title) {
        Intent intent = new Intent(this, AdPageActivity.class);
        intent.putExtra(AD_TITLE,adT);
        intent.putExtra(OWNER_TITLE_EXTRA,title);
        startActivity(intent);

    }

    /**
     * Starts the adPageActivity
     * when decline button is pressed
     * @param title tile of the ad that is passed as an extra
     */
    @Override
    public void startDeclineRequest(String title) {
        Intent intent = new Intent(this, AdPageActivity.class);
        intent.putExtra(AD_TITLE,adT);
        intent.putExtra(OWNER_TITLE_EXTRA,title);
        startActivity(intent);
    }
}