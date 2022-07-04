package gr.aueb.sweng22.team11.view.Owner.OwnerInfo;

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
import gr.aueb.sweng22.team11.view.User.OwnerRegister.OwnerRegisterActivity;

public class OwnerInfoActivity extends AppCompatActivity implements OwnerInfoView{
    private OwnerInfoViewModel viewModel;
    public static final String OWNER_TITLE = "owner_title";
    Button buttonEdit;
    Button buttonDelete;

    /**
     * Creates the layout and initializes the activity
     * @param savedInstanceState the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_info);

        viewModel = new ViewModelProvider(this).get(OwnerInfoViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findOwnerInfo();


        buttonEdit = findViewById(R.id.edit_owner);
        buttonDelete = findViewById(R.id.delete_owner);

        buttonEdit.setOnClickListener(v ->viewModel.getPresenter().onEditOwner());
        buttonDelete.setOnClickListener(v -> viewModel.getPresenter().onDeleteOwner());
    }
    /**
     * Method used
     * to set the username field of activity's layout
     * screen to the username of the owner that is logged in
     * @param username username of owner to be set
     */
    @Override
    public void setUsername(String username) {
        ((TextView)findViewById(R.id.text_username)).setText(username);
    }
    /**
     * Method used
     * to set the username field of activity's layout
     * screen to the username of the owner that is logged in
     * @param password username of owner to be set
     */
    @Override
    public void setPassword(String password) {
        ((TextView)findViewById(R.id.text_password)).setText(password);
    }

    /**
     * Method used
     * to set the name field of activity's layout
     * screen to the username of the owner that is logged in
     * @param name name of owner to be set
     */
    @Override
    public void setName(String name) {
        ((TextView)findViewById(R.id.text_name)).setText(name);
    }

    /**
     * Method used
     * to set the lastname field of activity's layout
     * screen to the lastname of the owner that is logged in
     * @param lastname lastname of owner to be set
     */
    @Override
    public void setLastname(String lastname) {
        ((TextView)findViewById(R.id.text_lastname)).setText(lastname);
    }
    /**
     * Method used
     * to set the phone field of activity's layout
     * screen to the phone of the owner that is logged in
     * @param phone phone of owner to be set
     */
    @Override
    public void setPhone(String phone) {
        ((TextView)findViewById(R.id.text_phone)).setText(phone);
    }
    /**
     * Method used
     * to set the email field of activity's layout
     * screen to the email of the owner that is logged in
     * @param email email of owner to be set
     */
    @Override
    public void setEmail(String email) {
        ((TextView)findViewById(R.id.text_email)).setText(email);
    }
    /**
     * Method used
     * to set the birthdate field of activity's layout
     * screen to the birthdate of the owner that is logged in
     * @param date birthdate of owner to be set
     */
    @Override
    public void setBirthdate(LocalDate date) {
        ((TextView)findViewById(R.id.text_birth_date)).setText(date.toString());
    }
    /**
     * Method used
     * to set the title field of activity's layout
     * screen to the title of the owner that is logged in
     * @param title title of owner to be set
     */
    @Override
    public void setTitle(String title) {
        ((TextView)findViewById(R.id.text_title)).setText(title);
    }

    /**
     * Starts the register owner activity so that the user can modify account
     * @param title title of owner to be passed as an extra
     */
    @Override
    public void startEditOwner(String title) {
        Intent intent = new Intent(this, OwnerRegisterActivity.class);
        intent.putExtra(OWNER_TITLE,title);
        startActivity(intent);
    }
    /**
     * Deletes the owner's account
     * and goes back to the login screen
     */
    @Override
    public void startDeleteOwner() {
        Intent intent = new Intent(this, LoginActivity.class);
        Toast.makeText(this,
                        "ACCOUNT DELETED",
                        Toast.LENGTH_SHORT)
                .show();
        startActivity(intent);

    }
}
