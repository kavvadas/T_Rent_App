package gr.aueb.sweng22.team11.view.User.OwnerRegister;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.time.LocalDate;
import java.util.Calendar;

import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.view.Owner.OwnerPage.OwnerPageActivity;
import gr.aueb.sweng22.team11.view.User.Login.LoginActivity;

public class OwnerRegisterActivity extends AppCompatActivity implements OwnerRegisterView,View.OnClickListener{


    private DatePickerDialog datePicker;
    private Button dateOfBirthButton;
    String ownerTitle;
    public static final String OWNER_TITLE = "owner_title";
    public static final String OWNER_TITLE_EXTRA = "owner_title_extra";
    OwnerRegisterViewModel viewModel;

    Button verification;

    /**
     * Creates the layout and initializes the activity
     * @param savedInstanceState the Instance state
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_register);


        initDatePicker();
        ownerTitle = this.getIntent().getStringExtra(OWNER_TITLE);
        if(ownerTitle != null){
            ActionBar actionBar = getSupportActionBar();
            if(actionBar != null)
                actionBar.setTitle("Owner Edit");

        }

        dateOfBirthButton = findViewById(R.id.datePickerButton);

        viewModel = new ViewModelProvider(this).get(OwnerRegisterViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().savedInfo(ownerTitle);


        verification = findViewById(R.id.verificationButton);
        verification.setOnClickListener(this);



    }

    /**
     * sets the birthdate of the owner
     * works as a dateSet button
     */
    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateOfBirthButton.setText(date);

            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePicker = new DatePickerDialog(this, style, dateSetListener, year, month, day);
    }

    /**
     * @param day day of birthdate
     * @param month month of birthdate
     * @param year year of birthdate
     * @return the birthdate as string
     */
    private String makeDateString(int day, int month, int year) {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    /**
     * @param month month chosen
     * @return the month in string
     */
    public String getMonthFormat(int month) {
        if (month == 1)
            return "JAN";
        if (month == 2)
            return "FEB";
        if (month == 3)
            return "MAR";
        if (month == 4)
            return "APR";
        if (month == 5)
            return "MAY";
        if (month == 6)
            return "JUN";
        if (month == 7)
            return "JUL";
        if (month == 8)
            return "AUG";
        if (month == 9)
            return "SEP";
        if (month == 10)
            return "OCT";
        if (month == 11)
            return "NOV";
        if (month == 12)
            return "DEC";

        return "JAN";

    }

   public void openBirthDatePicker(View view) {
        datePicker.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.verificationButton){
            viewModel.getPresenter().handleOwnerData();
        }
    }

    /**
     * get the content of textInputLayout
     * @return the username given
     */
    @Override
    public String getUsername() {
        TextInputLayout textInputLayout = findViewById(R.id.username);
        String USERNAME = textInputLayout.getEditText().getText().toString();
        return USERNAME;
    }

    /**
     * get the content of textInputLayout
     * @return the password given
     */
    @Override
    public String getPassword() {
        TextInputLayout textInputLayout = findViewById(R.id.password);
        String PASSWORD = textInputLayout.getEditText().getText().toString();
        return PASSWORD;
    }

    /**
     * get the content of textInputLayout
     * @return the password2 given
     */
    @Override
    public String getPassword2() {
        TextInputLayout textInputLayout = findViewById(R.id.passwordConfirm);
        String PASSWORDconf = textInputLayout.getEditText().getText().toString();
        return PASSWORDconf;
    }

    /**
     * get the content of textInputLayout
     * @return the name given
     */
    @Override
    public String getName() {
        TextInputLayout textInputLayout = findViewById(R.id.firstName);
        String FIRSTNAME = textInputLayout.getEditText().getText().toString();
        return FIRSTNAME;
    }

    /**
     * get the content of textInputLayout
     * @return the lastname given
     */
    @Override
    public String getLastname() {
        TextInputLayout textInputLayout = findViewById(R.id.lastName);
        String LASTNAME = textInputLayout.getEditText().getText().toString();
        return LASTNAME;
    }

    /**
     * get the content of textInputLayout
     * @return the phone given
     */
    @Override
    public String getPhone() {
        TextInputLayout textInputLayout = findViewById(R.id.phone);
        String PHONE = textInputLayout.getEditText().getText().toString();
        return PHONE;
    }

    /**
     * get the content of textInputLayout
     * @return the email given
     */
    @Override
    public String getEmail() {
        TextInputLayout textInputLayout = findViewById(R.id.email);
        String EMAIL = textInputLayout.getEditText().getText().toString();
        return EMAIL;
    }

    /**
     * get the content of datePicker
     * @return the birthdate given
     */
    @Override
    public String getBirthdate() {
        return datePicker.getDatePicker().toString();
    }

    /**
     * get the content of datepicker(year)
     * @return the year of the datepicker
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public int getYear(){
        int YEAR = datePicker.getDatePicker().getYear();
        return YEAR;
    }

    /**
     * get the content of textInputLayout
     * @return the title given
     */
    @Override
    public String getOwnerTitle() {
        TextInputLayout textInputLayout = findViewById(R.id.nickName);
        String TITLE = textInputLayout.getEditText().getText().toString();
        return TITLE;
    }


    /**
     * Method used
     * to set the username field of activity's layout
     * screen to the username of the owner that is logged in
     * @param username username of owner to be set
     */
    @Override
    public void setUsername(String username) {
        TextInputLayout USERNAME = findViewById(R.id.username);
        USERNAME.getEditText().setText(username);
    }

    /**
     * Method used
     * to set the username field of activity's layout
     * screen to the username of the owner that is logged in
     * @param password username of owner to be set
     */
    @Override
    public void setPassword(String password) {
        TextInputLayout PASSWORD = findViewById(R.id.password);
        PASSWORD.getEditText().setText(password);
    }

    /**
     * Method used
     * to set the name field of activity's layout
     * screen to the username of the owner that is logged in
     * @param name name of owner to be set
     */
    @Override
    public void setName(String name) {
        TextInputLayout NAME = findViewById(R.id.firstName);
        NAME.getEditText().setText(name);
    }

    /**
     * Method used
     * to set the lastname field of activity's layout
     * screen to the lastname of the owner that is logged in
     * @param lastname lastname of owner to be set
     */
    @Override
    public void setLastname(String lastname) {
        TextInputLayout LASTNAME = findViewById(R.id.lastName);
        LASTNAME.getEditText().setText(lastname);
    }

    /**
     * Method used
     * to set the birthdate field of the owner that is logged in
     * @param birthdate
     */
    @Override
    public void setBirthdate(String birthdate) {
        datePicker.getDatePicker().toString();
    }

    /**
     * Method used
     * to set the phone field of activity's layout
     * screen to the phone of the owner that is logged in
     * @param phone phone of owner to be set
     */
    @Override
    public void setPhone(String phone) {
        TextInputLayout PHONE = findViewById(R.id.phone);
        PHONE.getEditText().setText(phone);
    }

    /**
     * Method used
     * to set the email field of activity's layout
     * screen to the email of the owner that is logged in
     * @param email email of owner to be set
     */
    @Override
    public void setEmail(String email) {
        TextInputLayout EMAIL = findViewById(R.id.email);
        EMAIL.getEditText().setText(email);
    }

    /**
     * Method used
     * to set the title field of activity's layout
     * screen to the title of the owner that is logged in
     * @param title title of owner to be set
     */
    @Override
    public void setTitle(String title) {
        TextInputLayout TITLE = findViewById(R.id.nickName);
        TITLE.getEditText().setText(title);
    }
    /**
     * a pop shows on the screen
     * @param view the view of the pop
     * @param mess message of the pop
     */
    @Override
    public void showPop(OwnerRegisterView view, String mess) {
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        View customLayout = getLayoutInflater().inflate(R.layout.wrong_input_popup, null);
        builder.setView(customLayout);
        androidx.appcompat.app.AlertDialog dialog = builder.create();
        Button OK =  customLayout.findViewById(R.id.OK_popup);
        TextView errorMsg =  customLayout.findViewById(R.id.error_messsage);      // display message we want.
        errorMsg.setText(mess);
        OK.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    /**
     * starts the loginPage
     * when the create account button is pressed
     */
    @Override
    public void toLoginPage() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * starts the ownerPage
     * when the saved button is pressed in edit info
     */
    @Override
    public void startOwnerPage(String title) {
        Intent intent = new Intent(this,OwnerPageActivity.class);
        intent.putExtra(OWNER_TITLE_EXTRA,title);
        startActivity(intent);
    }

    /**
     * lock the dateofbirthbutton in editAccount
     */
    @Override
    public void lock() {
        dateOfBirthButton.setEnabled(false);
    }

}