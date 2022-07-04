package gr.aueb.sweng22.team11.view.User.Login;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import gr.aueb.sweng22.team11.memoryDao.initializerMemory;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;
import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.view.Owner.OwnerPage.OwnerPageActivity;
import gr.aueb.sweng22.team11.view.Renter.RenterPage.RenterPageActivity;
import gr.aueb.sweng22.team11.view.User.OwnerRegister.OwnerRegisterActivity;
import gr.aueb.sweng22.team11.view.User.RenterRegister.RenterRegisterActivity;


public class LoginActivity extends AppCompatActivity implements LoginView,View.OnClickListener{
    LoginViewModel viewModel;
    Button button_for_login;
    private static String OWNER_TITLE_EXTRA = "owner_title_extra";
    private static String RENTER_NICKNAME_EXTRA = "renter_nickname_extra";
    private static boolean MEMORY = true;
    private CheckBox checkBox;

    /**
     * Creates the layout and initializes the activity
     * @param savedInstanceState the Instance state
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (MEMORY) {
            new initializerMemory().prepare();
            MEMORY = false;
        }


        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        viewModel.getPresenter().setView(this);
        button_for_login = findViewById(R.id.completeLogin);
        button_for_login.setOnClickListener(this);

        Button button_for_owner = findViewById(R.id.owner_register_button);
        Button button_for_renter =  findViewById(R.id.renter_register_button);

        checkBox = findViewById(R.id.termsCheckBox);

        button_for_owner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View ownerView) {

                Intent intent_for_owner = new Intent(LoginActivity.this, OwnerRegisterActivity.class);
                startActivity(intent_for_owner);

            }
        });

        button_for_renter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View renterView) {

                Intent intent_for_renter = new Intent(LoginActivity.this, RenterRegisterActivity.class);
                startActivity(intent_for_renter);

            }
        });

    }

    /**
     * starts the validatesCredentials if check box checked
     * if not shows a popup with the message
     * @param view current view
     */
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.completeLogin && checkBox.isChecked()){
                viewModel.getPresenter().validateCredentials();
        }else if(!checkBox.isChecked()){
            showPop(this,"You need to agree to the terms!");
        }
    }

    /**
     * get the content of the textInputLayout
     * @return the username given
     */
    @Override
    public String getUsername() {
        TextInputLayout textInputLayout = findViewById(R.id.name);
        String USERNAME = textInputLayout.getEditText().getText().toString();
        return USERNAME;

    }

    /**
     * get the content of the textInputLayout
     * @return the password given
     */
    @Override
    public String getPassword() {
        TextInputLayout textInputLayout = findViewById(R.id.password);
        String PASSWORD = textInputLayout.getEditText().getText().toString();
        return PASSWORD;

    }
    //Gia ta wrong inputs

    /**
     * a pop shows on the screen
     * @param view the view of the pop
     * @param mess message of the pop
     */
    @Override
    public void showPop(LoginView view, String mess) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View customLayout = getLayoutInflater().inflate(R.layout.wrong_input_popup, null);
        builder.setView(customLayout);
        AlertDialog dialog = builder.create();
        Button OK = (Button) customLayout.findViewById(R.id.OK_popup);
        TextView errorMsg = (TextView) customLayout.findViewById(R.id.error_messsage);      // display message we want.
        errorMsg.setText(mess);
        OK.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    /**
     * start the owner page activity
     * @param title the title of the owner is passed as an extra
     */
    @Override
    public void startOwnerPage(String title) {
        Toast.makeText(this,
                "LOGGED IN",
                Toast.LENGTH_SHORT)
                .show();
        Intent intent = new Intent(this, OwnerPageActivity.class);
        intent.putExtra(OWNER_TITLE_EXTRA,title);
        startActivity(intent);
    }

    /**
     * start the renter page activity
     * @param nickname the nickname of the renter is passed as an extra
     */
    @Override
    public void startRenterPage(String nickname) {
        Toast.makeText(this,
                "LOGGED IN",
                Toast.LENGTH_SHORT)
                .show();
        Intent intent = new Intent(this, RenterPageActivity.class);
        intent.putExtra(RENTER_NICKNAME_EXTRA,nickname);
        startActivity(intent);
    }

    /**
     * exit the app alertDialog
     * if yes is pressed the app terminates
     * if no is pressed we dismiss the dialog
     */
    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}