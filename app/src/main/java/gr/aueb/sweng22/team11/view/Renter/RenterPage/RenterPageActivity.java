package gr.aueb.sweng22.team11.view.Renter.RenterPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.view.Renter.RenterAppointments.RenterAppointmentsActivity;
import gr.aueb.sweng22.team11.view.Renter.RenterInfo.RenterInfoActivity;
import gr.aueb.sweng22.team11.view.Renter.RenterSearchAds.RenterSearchAdsActivity;
import gr.aueb.sweng22.team11.view.Renter.RenterSearchAds.RenterSearchAdsView;
import gr.aueb.sweng22.team11.view.User.Login.LoginActivity;


public class RenterPageActivity extends AppCompatActivity implements RenterPageView {
    private RenterPageViewModel viewModel;
    private static final String RENTER_NICKNAME_EXTRA = "renter_nickname_extra";
    private static AlertDialog POPUP;
    private String renterUsername;
    private TextView txtRenterName;
    private Button btnRenterAccount;
    private Button btnRenterSearch;
    private Button btnRenterAppointments;
    private Button btnLogOut;
    /**
     * Creates the layout and initializes the activity
     * @param savedInstanceState the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renter_page);


        renterUsername = this.getIntent().getStringExtra(RENTER_NICKNAME_EXTRA);

        viewModel = new ViewModelProvider(this).get(RenterPageViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findRenterInfo(renterUsername);


        txtRenterName = findViewById(R.id.title_renter_name);
        btnRenterAccount =  findViewById(R.id.editAccountButton);
        btnRenterSearch = findViewById(R.id.RenterSearch);
        btnRenterAppointments = findViewById(R.id.renter_appointments);
        btnLogOut = findViewById(R.id.ExitButton);


        txtRenterName.setText(viewModel.getPresenter().getRenterNickname());
        btnRenterAccount.setOnClickListener(v -> viewModel.getPresenter().onRenterAccount());
        btnRenterSearch.setOnClickListener(v -> viewModel.getPresenter().onRenterSearch());
        btnRenterAppointments.setOnClickListener(v -> viewModel.getPresenter().onRenterAppointments());
        btnLogOut.setOnClickListener(v -> viewModel.getPresenter().onLogout());
    }
    /**
     * Starts RenterInfoActivity
     * when the account button is pressed
     */
    @Override
    public void toRenterAccount() {
        Intent intent = new Intent(this, RenterInfoActivity.class);
        startActivity(intent);
    }

    /**
     * Starts the searchAdsActivity
     * when the searchAds button is pressed
     * @param nickname nickname of the renter put as extra
     */
    @Override
    public void toRenterSearch(String nickname) {
        Intent intent = new Intent(this, RenterSearchAdsActivity.class);
        intent.putExtra(RENTER_NICKNAME_EXTRA,nickname);
        startActivity(intent);
    }

    /**
     * Starts the renterAppointmentsActivity
     * when the myAppointments button is pressed
     * @param nickname nickname of the renter put as extra
     */
    @Override
    public void toRenterAppointments(String nickname) {
        Intent intent = new Intent(this, RenterAppointmentsActivity.class);
        intent.putExtra(RENTER_NICKNAME_EXTRA,nickname);
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

        Button firstButton = (Button) customLayout.findViewById(btn1);
        Button secondButton = (Button) customLayout.findViewById(btn2);

        TextView textMsg = (TextView) customLayout.findViewById(R.id.action_message);
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
