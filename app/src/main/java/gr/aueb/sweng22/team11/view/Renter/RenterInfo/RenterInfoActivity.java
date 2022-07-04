package gr.aueb.sweng22.team11.view.Renter.RenterInfo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import java.time.LocalDate;

import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.view.User.Login.LoginActivity;
import gr.aueb.sweng22.team11.view.User.RenterRegister.RenterRegisterActivity;

public class RenterInfoActivity extends AppCompatActivity implements RenterInfoView{
    private RenterInfoViewModel viewModel;
    public static final String RENTER_NICKNAME = "renter_nickname";
    Button buttonEdit;
    Button buttonDelete;
    /**
     * Creates the layout and initializes the activity
     * @param savedInstanceState the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renter_info);

        viewModel = new ViewModelProvider(this).get(RenterInfoViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findRenterInfo();

        buttonEdit = findViewById(R.id.edit_renter);
        buttonDelete = findViewById(R.id.delete_renter);

        buttonEdit.setOnClickListener(v ->viewModel.getPresenter().onEditRenter());
        buttonDelete.setOnClickListener(v -> viewModel.getPresenter().onDeleteRenter());
    }

    /**
     * Method used
     * to set the username field of activity's layout
     * screen to the username of the renter that is logged in
     * @param username username of renter to be set
     */
    @Override
    public void setUsername(String username) {
        ((TextView)findViewById(R.id.text_username)).setText(username);
    }

    /**
     * Method used
     * to set the password field of activity's layout
     * screen to the password of the renter that is logged in
     * @param password password of renter to be set
     */
    @Override
    public void setPassword(String password) {
        ((TextView)findViewById(R.id.text_password)).setText(password);
    }

    /**
     * Method used
     * to set the name field of activity's layout
     * screen to the name of the renter that is logged in
     * @param name name of renter to be set
     */
    @Override
    public void setName(String name) {
        ((TextView)findViewById(R.id.text_name)).setText(name);
    }

    /**
     * Method used
     * to set the lastname field of activity's layout
     * screen to the lastname of the renter that is logged in
     * @param lastname lastname of renter to be set
     */
    @Override
    public void setLastname(String lastname) {
        ((TextView)findViewById(R.id.text_lastname)).setText(lastname);
    }

    /**
     * Method used
     * to set the phone field of activity's layout
     * screen to the phone of the renter that is logged in
     * @param phone phone of renter to be set
     */
    @Override
    public void setPhone(String phone) {
        ((TextView)findViewById(R.id.text_phone)).setText(phone);
    }

    /**
     * Method used
     * to set the email field of activity's layout
     * screen to the email of the renter that is logged in
     * @param email email of renter to be set
     */
    @Override
    public void setEmail(String email) {
        ((TextView)findViewById(R.id.text_email)).setText(email);
    }

    /**
     * Method used
     * to set the birthdate field of activity's layout
     * screen to the birthdate of the renter that is logged in
     * @param date birthdate of renter to be set
     */
    @Override
    public void setBirthdate(LocalDate date) {
        ((TextView)findViewById(R.id.text_birth_date)).setText(date.toString());
    }

    /**
     * Method used
     * to set the username field of activity's layout
     * screen to the username of the renter that is logged in
     * @param nickname username of renter to be set
     */
    @Override
    public void setNickname(String nickname) {
        ((TextView)findViewById(R.id.text_nickname)).setText(nickname);
    }

    /**
     * Starts the register renter activity so that the user can modify account
     * @param username nickanem of renter to be passed as an extra
     */
    @Override
    public void startEditRenter(String username) {
        Intent intent = new Intent(this, RenterRegisterActivity.class);
        intent.putExtra(RENTER_NICKNAME,username);
        startActivity(intent);
    }

    /**
     * Deletes the renter's account
     * and goes back to the login screen
     */
    @Override
    public void startDeleteRenter() {
        Intent intent = new Intent(this, LoginActivity.class);
        Toast.makeText(this,
                        "ACCOUNT DELETED",
                        Toast.LENGTH_SHORT)
                .show();
        startActivity(intent);

    }
}
