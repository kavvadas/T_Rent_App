package gr.aueb.sweng22.team11.view.Ad.AdPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.view.Ad.AdAppointments.AdAppointmentsActivity;
import gr.aueb.sweng22.team11.view.Ad.AdInfo.AdInfoActivity;
import gr.aueb.sweng22.team11.view.Ad.AdRequests.AdRequestsActivity;
import gr.aueb.sweng22.team11.view.Owner.OwnerPage.OwnerPageActivity;


public class AdPageActivity extends AppCompatActivity implements AdPageView{
    private AdPageViewModel viewModel;
    public static final String AD_TITLE = "ad_title_extra";
    public static final String OWNER_TITLE_EXTRA = "owner_title_extra";

    private String adComment;
    private String ownerT;
    private TextView txtAdComment;
    private Button btnAdInfo;
    private Button btnAdRequests;
    private Button btnOwnerPage;
    private Button btnAdAppointments;

    /**
     * Creates the layout and initializes the activity
     * @param savedInstanceState the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_page);

        adComment = this.getIntent().getStringExtra(AD_TITLE);
        ownerT = this.getIntent().getStringExtra(OWNER_TITLE_EXTRA);

        viewModel = new ViewModelProvider(this).get(AdPageViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findAdInfo(adComment);

        txtAdComment = findViewById(R.id.title_ad);

        btnAdInfo = findViewById(R.id.editAdButton);
        btnAdRequests = findViewById(R.id.myRequestsButton);
        btnOwnerPage = findViewById(R.id.OwnerHomePage);
        btnAdAppointments = findViewById(R.id.adAppointments);

        txtAdComment.setText(viewModel.getPresenter().getAdComment());
        btnAdInfo.setOnClickListener(v -> viewModel.getPresenter().onAdInfo());
        btnAdRequests.setOnClickListener(v -> viewModel.getPresenter().onAdRequests());
        btnOwnerPage.setOnClickListener(v -> viewModel.getPresenter().onOwnerPage());
        btnAdAppointments.setOnClickListener(v -> viewModel.getPresenter().onAdAppointments());
    }

    /**
     * Starts the adInfoActivity
     * when the info button is pressed
     * @param comment comment of the ad
     * @param title title fot he owner
     */
    @Override
    public void toAdInfo(String comment,String title) {
        Intent intent = new Intent(this, AdInfoActivity.class);
        intent.putExtra(AD_TITLE,comment);
        intent.putExtra(OWNER_TITLE_EXTRA,title);
        startActivity(intent);
    }

    /**
     * Starts the adRequestsActivity
     * when the myRequests button is pressed
     * @param comment title of the ad
     */
    @Override
    public void toAdRequests(String comment) {
        Intent intent = new Intent(this, AdRequestsActivity.class);
        intent.putExtra(AD_TITLE,comment);
        startActivity(intent);
    }

    /**
     * Starts the OwnerPageActivity
     * when the homepage button is pressed
     * @param title title of the owner
     */
    @Override
    public void toOwnerPage(String title) {
        Intent intent = new Intent(this, OwnerPageActivity.class);
        intent.putExtra(OWNER_TITLE_EXTRA,title);
        startActivity(intent);
    }

    /**
     * starts the adAppointmentsActivity
     * when the myAppointments button is pressed
     * @param comment comment of the ad
     */
    @Override
    public void toAdAppointments(String comment) {
        Intent intent = new Intent(this, AdAppointmentsActivity.class);
        intent.putExtra(AD_TITLE,comment);
        startActivity(intent);
    }

    /**
     * Starts the OwnerPageActivity
     * when we press back
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, OwnerPageActivity.class);
        intent.putExtra(OWNER_TITLE_EXTRA,ownerT);
        startActivity(intent);
    }
}