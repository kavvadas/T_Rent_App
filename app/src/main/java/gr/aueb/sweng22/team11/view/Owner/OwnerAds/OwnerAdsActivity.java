package gr.aueb.sweng22.team11.view.Owner.OwnerAds;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.domain.Request;
import gr.aueb.sweng22.team11.view.Ad.AdPage.AdPageActivity;
import gr.aueb.sweng22.team11.view.Owner.CreateAd.CreateAdActivity;
import gr.aueb.sweng22.team11.view.Owner.OwnerAds.fragment.AdListFragment;

public class OwnerAdsActivity extends AppCompatActivity implements OwnerAdsView, AdListFragment.OnListFragmentInteractionListener {

    public static final String AD_TITLE = "ad_title_extra";
    private static final String OWNER_TITLE_EXTRA = "owner_title_extra";

    OwnerAdsViewModel viewModel;

    FloatingActionButton createAdButton;


    /**
     * Creates the layout and initializes the activity
     * @param savedInstanceState the Instance state
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_ads);
        String ownerT =this.getIntent().getStringExtra(OWNER_TITLE_EXTRA);

        viewModel = new ViewModelProvider(this).get(OwnerAdsViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findAdsCreated(ownerT);

        createAdButton = findViewById(R.id.create_ad_button);
        createAdButton.setOnClickListener(v -> viewModel.getPresenter().onCreateAd());

        if(findViewById(R.id.fragment_container) != null){
            if(savedInstanceState != null)
                return;

            AdListFragment adListFragment = AdListFragment.newInstance(1);
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,adListFragment).commit();
        }
    }

    /**
     * When the + button is pushed we go
     * to the CreateAdActivity
     * @param title the title of the owner
     */
    @Override
    public void starCreateAd(String title) {
        Intent intent = new Intent(this, CreateAdActivity.class);
        intent.putExtra(OWNER_TITLE_EXTRA,title);
        startActivity(intent);
    }

    /**
     * what happens when the user presses on an ad
     * @param item the ad
     */
    @Override
    public void onListFragmentInteraction(Ad item) {
        Intent intent = new Intent(this, AdPageActivity.class);
        intent.putExtra(AD_TITLE,item.getComment());
        intent.putExtra(OWNER_TITLE_EXTRA,item.getOwner().getTitle());
        startActivity(intent);
    }
    /**
     * get the created ads of the owner
     * @return the ArrayList of ads
     */
    @Override
    public ArrayList<Ad> getListAd() {
        return viewModel.getPresenter().getAds();
    }
}
