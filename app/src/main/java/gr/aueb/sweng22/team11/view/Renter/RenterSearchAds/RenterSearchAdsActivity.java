package gr.aueb.sweng22.team11.view.Renter.RenterSearchAds;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.view.Owner.OwnerAds.fragment.AdListFragment;
import gr.aueb.sweng22.team11.view.Renter.RenterCreateRequest.RenterCreateRequestActivity;
import gr.aueb.sweng22.team11.view.Renter.RenterMaps.RenterMapsActivity;

public class RenterSearchAdsActivity extends AppCompatActivity implements RenterSearchAdsView, AdListFragment.OnListFragmentInteractionListener{

    RenterSearchAdsViewModel viewModel;
    FloatingActionButton searchAdButton;
    public static final String AD_TITLE = "ad_title_extra";
    public static final String RENTER_NICKNAME_EXTRA = "renter_nickname_extra";
    String renterN;

    FrameLayout fragment_view;

    Button btnStartMaps;

    /**
     * Creates the layout and initializes the activity
     * @param savedInstanceState the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renter_search_ads);

        viewModel = new ViewModelProvider(this).get(RenterSearchAdsViewModel.class);
        viewModel.getPresenter().setView(this);

        renterN = getIntent().getStringExtra(RENTER_NICKNAME_EXTRA);

        fragment_view = findViewById(R.id.fragment_container);

        btnStartMaps = findViewById(R.id.openMaps);
        btnStartMaps.setOnClickListener(v -> viewModel.getPresenter().onStartMaps());

        searchAdButton = findViewById(R.id.searchAdsButton);
        searchAdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(fragment_view != null){

                    if(savedInstanceState != null)
                        return;

                    fragment_view.removeAllViews();

                    viewModel.getPresenter().findAds();

                    AdListFragment adListFragment = AdListFragment.newInstance(1);

                    getSupportFragmentManager().beginTransaction().add(fragment_view.getId(),adListFragment).commit();
                }
            }
        });

    }

    /**
     * what happens when the user presses on an ad
     * @param item the ad
     */
    @Override
    public void onListFragmentInteraction(Ad item) {
        Intent intent = new Intent(this, RenterCreateRequestActivity.class);
        intent.putExtra(AD_TITLE,item.getComment());
        intent.putExtra(RENTER_NICKNAME_EXTRA,renterN);
        startActivity(intent);
    }

    /**
     * get the ads
     * @return the ArrayList of ads
     */
    @Override
    public ArrayList<Ad> getListAd() {
        return viewModel.getPresenter().getAds();
    }

    /**
     * get the content of the textInputLayout
     * @return the input given
     */
    @Override
    public String getInput() {
        TextInputLayout textInputLayout = findViewById(R.id.searchAds);
        String INPUT = textInputLayout.getEditText().getText().toString();
        return INPUT;
    }

    @Override
    public void startMaps() {
        Intent intent = new Intent(this, RenterMapsActivity.class);
        intent.putExtra(RENTER_NICKNAME_EXTRA,renterN);
        startActivity(intent);
    }
}