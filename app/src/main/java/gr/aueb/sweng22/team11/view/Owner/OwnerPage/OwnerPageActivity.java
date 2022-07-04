package gr.aueb.sweng22.team11.view.Owner.OwnerPage;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.view.Owner.OwnerAds.OwnerAdsActivity;
import gr.aueb.sweng22.team11.view.Owner.OwnerInfo.OwnerInfoActivity;
import gr.aueb.sweng22.team11.view.User.Login.LoginActivity;


public class OwnerPageActivity extends AppCompatActivity implements OwnerPageView{
    private  OwnerPageViewModel viewModel;
    private static final String OWNER_TITLE_EXTRA = "owner_title_extra";
    private static AlertDialog POPUP;
    private String ownerUsername;
    private TextView txtOwnerName;
    private Button btnOwnerAccount;
    private Button btnOwnerAds;
    private Button btnLogOut;

    /**
     * Creates the layout and initializes the activity
     * @param savedInstanceState the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_page);


        ownerUsername = this.getIntent().getStringExtra(OWNER_TITLE_EXTRA);

        viewModel = new ViewModelProvider(this).get(OwnerPageViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findOwnerInfo(ownerUsername);


        txtOwnerName = findViewById(R.id.title_owner_name);
        btnOwnerAccount = findViewById(R.id.editAccountButton);
        btnOwnerAds = findViewById(R.id.myAdsButton);
        btnLogOut = findViewById(R.id.ExitButton);


        txtOwnerName.setText(viewModel.getPresenter().getOwnerTitle());
        btnOwnerAds.setOnClickListener(v -> viewModel.getPresenter().onOwnerAds());
        btnOwnerAccount.setOnClickListener(v -> viewModel.getPresenter().onOwnerAccount());
        btnLogOut.setOnClickListener(v -> viewModel.getPresenter().onLogout());
    }

    /**
     * Starts OwnerInfoActivity
     * when the account button is pressed
     */
    @Override
    public void toOwnerAccount() {
        Intent intent = new Intent(this, OwnerInfoActivity.class);
        startActivity(intent);
    }

    /**
     * Starts the ownerAdsActivity
     * when the myads button is pressed
     * @param title title of the owner put as extra
     */
    @Override
    public void toOwnerAds(String title) {
        Intent intent = new Intent(this, OwnerAdsActivity.class);
        intent.putExtra(OWNER_TITLE_EXTRA,title);
        startActivity(intent);
    }


    /**
     * Goes to the loginActivity
     * when the owner logs out
     */
    @Override
    public void logout() {
        Toast.makeText(this,
                "LOGGED OUT",
                Toast.LENGTH_SHORT)
                .show();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * @param layoutId layout of popup
     * @param msg message to bve shown in the layout
     * @param btn1 first button of pop
     * @param btn2 second button of pop
     * @return an AlertDialog to be shown
     */
    @Override
    public AlertDialog showPopUp(int layoutId, String msg, int btn1, int btn2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View customLayout = getLayoutInflater().inflate(layoutId, null);
        builder.setView(customLayout);
        AlertDialog dialog = builder.create();

        Button firstButton = customLayout.findViewById(btn1);
        Button secondButton = customLayout.findViewById(btn2);

        TextView textMsg = customLayout.findViewById(R.id.action_message);
        firstButton.setOnClickListener(v->viewModel.getPresenter().onNoLogout());
        secondButton.setOnClickListener(v->viewModel.getPresenter().onYesLogout());

        textMsg.setText(msg);

        return dialog;
    }

    /**
     * confirmation for logout
     * when the owner presses the logout button
     * shows the popup with the message and the 2 buttons
     */
    @Override
    public void logOutConfirmation() {
        POPUP = showPopUp(R.layout.popup, "Do you really want to log out?", R.id.no_delete, R.id.yes_delete);
        POPUP.show();
    }

    /**
     * when the owner presses no in the AlertDialog
     * we dismiss the popup
     */
    @Override
    public void noLogOut() {
        POPUP.dismiss();
    }

    /**
     * on back pressed owner wants to logout
     */
    @Override
    public void onBackPressed(){
        logOutConfirmation();
    }
}
