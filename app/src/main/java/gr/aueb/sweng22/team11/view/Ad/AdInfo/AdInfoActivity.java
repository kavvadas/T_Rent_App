package gr.aueb.sweng22.team11.view.Ad.AdInfo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.view.Owner.CreateAd.CreateAdActivity;

import gr.aueb.sweng22.team11.view.Owner.OwnerPage.OwnerPageActivity;

public class AdInfoActivity extends AppCompatActivity implements AdInfoView{
    private AdInfoViewModel viewModel;
    public static final String AD_TITLE = "ad_title_extra";
    public static final String OWNER_TITLE_EXTRA = "owner_title_extra";

    String adComm;
    String ownerT;

    Button buttonEdit;
    Button buttonDelete;

    /**
     * Creates the layout and initializes the activity
     * @param savedInstanceState the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_info);

        adComm = this.getIntent().getStringExtra(AD_TITLE);
        ownerT = this.getIntent().getStringExtra(OWNER_TITLE_EXTRA);

        viewModel = new ViewModelProvider(this).get(AdInfoViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findAdInfo(adComm);

        buttonEdit = findViewById(R.id.edit_ad);
        buttonDelete = findViewById(R.id.delete_ad);

        buttonEdit.setOnClickListener(v -> viewModel.getPresenter().onEditAd());
        buttonDelete.setOnClickListener(v -> viewModel.getPresenter().onDeleteAd());
    }

    /**
     * Method used
     * to set the street field of activity's layout
     * screen to the street of the ad that is created
     * @param street street of ad to be set
     */
    @Override
    public void setStreet(String street) {
        ((TextView) findViewById(R.id.text_street)).setText(street);
    }

    /**
     * Method used
     * to set the postcode field of activity's layout
     * screen to the postcode of the ad that is created
     * @param postcode postcode of ad to be set
     */
    @Override
    public void setPostcode(String postcode) {
        ((TextView) findViewById(R.id.text_postcode)).setText(postcode);
    }

    /**
     * Method used
     * to set the region field of activity's layout
     * screen to the region of the ad that is created
     * @param region region of ad to be set
     */
    @Override
    public void setRegion(String region) {
        ((TextView) findViewById(R.id.text_region)).setText(region);
    }

    /**
     * Method used
     * to set the rent field of activity's layout
     * screen to the rent of the ad that is created
     * @param rent rent of ad to be set
     */
    @Override
    public void setRent(String rent) {
        ((TextView) findViewById(R.id.text_rent)).setText(rent);
    }

    /**
     * Method used
     * to set the comment field of activity's layout
     * screen to the comment of the ad that is created
     * @param comment comment of ad to be set
     */
    @Override
    public void setComment(String comment) {
        ((TextView) findViewById(R.id.text_comment)).setText(comment);
    }

    /**
     * Starts the create ad activity so that the user can modify the ad info
     * @param comment title of ad to be passed as an extra
     */
    @Override
    public void startEditAd(String comment) {
        Intent intent = new Intent(this, CreateAdActivity.class);
        intent.putExtra(AD_TITLE,comment);
        startActivity(intent);
    }

    /**
     * Deletes the ad of the owner
     * and goes back to the owner page
     * @param title title of the owner passed as and extra
     */
    @Override
    public void startDeleteAd(String title) {
        Intent intent = new Intent(this, OwnerPageActivity.class);
        intent.putExtra(OWNER_TITLE_EXTRA,title);
        startActivity(intent);

    }
}