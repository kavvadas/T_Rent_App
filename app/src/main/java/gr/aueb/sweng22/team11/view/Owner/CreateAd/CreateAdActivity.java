package gr.aueb.sweng22.team11.view.Owner.CreateAd;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;
import com.google.android.material.textfield.TextInputLayout;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.domain.Appointment;
import gr.aueb.sweng22.team11.view.Ad.AdPage.AdPageActivity;
import gr.aueb.sweng22.team11.view.Owner.OwnerAds.OwnerAdsActivity;
import gr.aueb.sweng22.team11.view.Owner.OwnerAds.OwnerAdsView;
import gr.aueb.sweng22.team11.view.Owner.OwnerPage.OwnerPageActivity;
import gr.aueb.sweng22.team11.view.User.OwnerRegister.OwnerRegisterView;

public class CreateAdActivity extends AppCompatActivity implements CreateAdView,View.OnClickListener, CalendarView.OnDateChangeListener {

    ArrayAdapter<String> hourAdapter;
    ArrayAdapter<String> chosen_hour_Adapter;
    ArrayAdapter<String> chosen_day_Adapter;

    ArrayList<String> hours = new ArrayList<>();

    CalendarView choose_days_calendar_view;
    ListView choose_hours_list_view;

    ListView chosen_days_list_view;
    ListView chosen_hours_list_view;

    ArrayList<String> chosen_days = new ArrayList<>();
    ArrayList<String> chosen_hours = new ArrayList<>();

    private static final String OWNER_TITLE_EXTRA = "owner_title_extra";
    private static final String AD_TITLE = "ad_title_extra";
    CreateAdViewModel viewModel;

    private ImageSwitcher imageIs;
    private Button previous;
    private Button next;
    private Button addImage;
    private Button buttonCreateAd;
    private String ownerT;
    private String adtitle;
    private ArrayList<Uri> imageUris;

    private static final int PICK_IMAGES_CODE = 0;

    int position = 0;

    /**
     * Creates the layout and initializes the activity
     * @param savedInstanceState the Instance state
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_ad);

        ownerT =this.getIntent().getStringExtra(OWNER_TITLE_EXTRA);
        adtitle = this.getIntent().getStringExtra(AD_TITLE);


        if(adtitle != null) {
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null)
                actionBar.setTitle("Ad Edit");
        }
        choose_days_calendar_view = findViewById(R.id.calendar_for_days);
        imageIs = findViewById(R.id.imageIs);
        previous = findViewById(R.id.previousImageButton);
        next = findViewById(R.id.nextImageButton);
        addImage = findViewById(R.id.AddImageButton);
        buttonCreateAd = findViewById(R.id.CreateNewAdButton);
        chosen_days_list_view =  findViewById(R.id.list_view_for_chosen_days);
        chosen_hours_list_view =  findViewById(R.id.list_view_for_chosen_hours);

        viewModel = new ViewModelProvider(this).get(CreateAdViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().savedInfo(adtitle);
        setDates();
        choosePhoto();

        choose_days_calendar_view.setOnDateChangeListener(this);
        buttonCreateAd.setOnClickListener( this);


    }

    /**
     * what happens when a button is pressed
     * @param view the current view
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.CreateNewAdButton){
            viewModel.getPresenter().handleAdData(ownerT);
        }
    }

    /**
     * set the picture's chosen
     */
    public void choosePhoto(){
        imageUris = new ArrayList<>();

        imageIs.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                return imageView;
            }
        });

        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickImagesIntent();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position > 0)
                {
                    position--;
                    imageIs.setImageURI(imageUris.get(position));
                }
                else
                {
                    Toast.makeText(CreateAdActivity.this, "No previous", Toast.LENGTH_SHORT).show();
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(position < imageUris.size() - 1)
                {
                    position++;
                    imageIs.setImageURI(imageUris.get(position));
                }
                else
                {
                    Toast.makeText(CreateAdActivity.this, "No next", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    /**
     * creates intent for picked image
     */
    private void pickImagesIntent()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Image(s)"), PICK_IMAGES_CODE);
    }

    /**
     * Parsing the data of the image chosen so it can show
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGES_CODE)
        {
            if(resultCode == Activity.RESULT_OK)
            {
                if(data.getClipData() != null)
                {
                    int count = data.getClipData().getItemCount();

                    for(int i = 0; i < count; i++)
                    {
                        Uri imageUri = data.getClipData().getItemAt(i).getUri();
                        imageUris.add(imageUri);
                    }

                    imageIs.setImageURI(imageUris.get(0));
                    position = 0;
                }
                else
                {
                    Uri imageUri = data.getData();
                    imageUris.add(imageUri);
                    imageIs.setImageURI(imageUris.get(0));
                    position = 0;

                }
            }
        }
    }
    /**
     * set the dates chosen from the owner
     */
    public void setDates(){
        choose_hours_list_view = (ListView) findViewById(R.id.list_view_for_hours);

        chosen_days_list_view = (ListView) findViewById(R.id.list_view_for_chosen_days);
        chosen_hours_list_view = (ListView) findViewById(R.id.list_view_for_chosen_hours);

        hours.add("09:00");
        hours.add("10:00");
        hours.add("11:00");
        hours.add("12:00");
        hours.add("13:00");
        hours.add("14:00");
        hours.add("15:00");
        hours.add("16:00");
        hours.add("17:00");
        hours.add("18:00");
        hours.add("19:00");
        hours.add("20:00");
        hours.add("21:00");

        hourAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, hours);
        choose_hours_list_view.setAdapter(hourAdapter);

        chosen_hour_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chosen_hours);
        chosen_hours_list_view.setAdapter(chosen_hour_Adapter);


        choose_hours_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(chosen_hours.contains(hours.get(position)))
                {
                    Toast.makeText(CreateAdActivity.this, hours.get(position) + " already in chosen hours", Toast.LENGTH_SHORT).show();
                }else {

                    Toast.makeText(CreateAdActivity.this, hours.get(position) + " added to chosen hours", Toast.LENGTH_SHORT).show();

                    chosen_hours.add(hours.get(position));
                    chosen_hour_Adapter.notifyDataSetChanged();
                }
            }
        });

        chosen_days_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(CreateAdActivity.this, chosen_days.get(position) + " removed", Toast.LENGTH_SHORT).show();
                chosen_days.remove(chosen_days.get(position));
                chosen_day_Adapter.notifyDataSetChanged();


            }
        });

        chosen_hours_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(CreateAdActivity.this, chosen_hours.get(position) + " removed", Toast.LENGTH_SHORT).show();
                chosen_hours.remove(chosen_hours.get(position));
                chosen_hour_Adapter.notifyDataSetChanged();

            }
        });

    }

    /**
     * get the content of textInputLayout
     * @return the street given
     */
    @Override
    public String getStreet() {
        TextInputLayout textInputLayout = findViewById(R.id.fill_street);
        String STREET = textInputLayout.getEditText().getText().toString();
        return STREET;
    }
    /**
     * get the content of textInputLayout
     * @return the postcode given
     */
    @Override
    public String getPostcode() {
        TextInputLayout textInputLayout = findViewById(R.id.postcode_fill);
        String POSTCODE = textInputLayout.getEditText().getText().toString();
        return POSTCODE;
    }
    /**
     * get the content of textInputLayout
     * @return the region given
     */
    @Override
    public String getRegion() {
        TextInputLayout textInputLayout = findViewById(R.id.region_fill);
        String REGION = textInputLayout.getEditText().getText().toString();
        return REGION;
    }
    /**
     * get the content of textInputLayout
     * @return the rent given
     */
    @Override
    public String getRent() {
        TextInputLayout textInputLayout = findViewById(R.id.rent_fill);
        String RENT = textInputLayout.getEditText().getText().toString();
        return RENT;
    }
    /**
     * get the content of textInputLayout
     * @return the comment given
     */
    @Override
    public String getComment() {
        TextInputLayout textInputLayout = findViewById(R.id.comment_fill);
        String COMMENT = textInputLayout.getEditText().getText().toString();
        return COMMENT;
    }

    /**
     * get the content of dates and hours been chosen by the owner
     * @return an array list of appointments
     */

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public ArrayList<Appointment> getAppointments() {
        ArrayList<Appointment> appointments = new ArrayList<>();
        for(String hours:chosen_hours){
            for(String days:chosen_days)
            {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate day = LocalDate.parse(days, dateTimeFormatter);
                LocalTime hour = LocalTime.parse(hours);
                Appointment appointment = new Appointment(day,hour);
                appointments.add(appointment);
            }
        }
        return appointments;
    }
    /**
     * get the content of arraylist string
     * @return the description given
     */
    @Override
    public ArrayList<String> getDescription() {
        return null;
    }
    /**
     * Method used
     * to set the street field of activity's layout
     * screen to the street of the ad that is already created
     * @param street street of ad to be set
     */
    @Override
    public void setStreet(String street) {
        TextInputLayout STREET = findViewById(R.id.fill_street);
        STREET.getEditText().setText(street);
    }
    /**
     * Method used
     * to set the postcode field of activity's layout
     * screen to the postcode of the ad that is already created
     * @param postcode postcode of ad to be set
     */
    @Override
    public void setPostcode(String postcode) {
        TextInputLayout POSTCODE = findViewById(R.id.postcode_fill);
        POSTCODE.getEditText().setText(postcode);
    }
    /**
     * Method used
     * to set the region field of activity's layout
     * screen to the region of the ad that is already created
     * @param region region of ad to be set
     */
    @Override
    public void setRegion(String region) {
        TextInputLayout REGION = findViewById(R.id.region_fill);
        REGION.getEditText().setText(region);
    }
    /**
     * Method used
     * to set the rent field of activity's layout
     * screen to the rent of the ad that is already created
     * @param rent rent of ad to be set
     */
    @Override
    public void setRent(String rent) {
        TextInputLayout RENT = findViewById(R.id.rent_fill);
        RENT.getEditText().setText(rent);
    }
    /**
     * Method used
     * to set the comment field of activity's layout
     * screen to the comment of the ad that is already created
     * @param comment comment of ad to be set
     */
    @Override
    public void setComment(String comment) {
        TextInputLayout COMMENT = findViewById(R.id.comment_fill);
        COMMENT.getEditText().setText(comment);
    }
    /**
     * Method used
     * to set the appointments field of activity's layout
     * screen to the appointments of the ad that is already created
     * @param appointments appointments of ad to be set
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void setAppointments(ArrayList<Appointment> appointments) {
        for(Appointment appointment:appointments){
            String format = appointment.getDate().getDayOfMonth()+"/"+appointment.getDate().getMonthValue()+"/"+appointment.getDate().getYear();
            chosen_days.add(format);
            if(!chosen_hours.contains(appointment.getTime().toString()))
                chosen_hours.add(appointment.getTime().toString());
        }
        chosen_day_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chosen_days);
        chosen_days_list_view.setAdapter(chosen_day_Adapter);

        chosen_hour_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chosen_hours);
        chosen_hours_list_view.setAdapter(chosen_hour_Adapter);
    }

    /**
     *show a popup on the screen
     * @param view the view of the popup
     * @param mess the message that will be shown
     */
    @Override
    public void showPop(CreateAdView view, String mess) {
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        View customLayout = getLayoutInflater().inflate(R.layout.wrong_input_popup, null);
        builder.setView(customLayout);
        androidx.appcompat.app.AlertDialog dialog = builder.create();
        Button OK = customLayout.findViewById(R.id.OK_popup);
        TextView errorMsg =  customLayout.findViewById(R.id.error_messsage);      // display message we want.
        errorMsg.setText(mess);
        OK.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }
    /**
     * Starts the owner page activity after the creation of ad
     * @param title title of owner to be passed as an extra
     */
    @Override
    public void toOwnerPage(String title) {
        Intent intent = new Intent(this, OwnerPageActivity.class);
        intent.putExtra(OWNER_TITLE_EXTRA,title);
        startActivity(intent);
    }

    /**
     * Starts the ad page activity after the modify of the ad
     * @param comment comment of ad to be passed as an extra
     * @param title title of owner to be passed as an extra
     */
    @Override
    public void toAdPage(String comment,String title) {
        Intent intent = new Intent(this, AdPageActivity.class);
        intent.putExtra(AD_TITLE,comment);
        intent.putExtra(OWNER_TITLE_EXTRA,title);
        startActivity(intent);
    }

    /**
     * Creates an appointment which we choose by the calendar
     * and we add it to the selected dates and in the adapter
     * @param view the current view
     * @param year the year of the appointment
     * @param month the month of the appointment
     * @param dayOfMonth the daymonth of the appointment
     */
    @Override
    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

        String  curDate = String.valueOf(dayOfMonth);
        String  Year = String.valueOf(year);
        String  Month = String.valueOf(month);

        String part1;
        String part2;

        if(dayOfMonth < 10)
        {
            part1 = "0" + curDate;
        }
        else
        {
            part1 = curDate;
        }

        if(month < 10)
        {
            part2 = "0" + Month;
        }
        else
        {
            part2 = Month;
        }


        String appointment = part1 + "/" + part2 + "/" + Year;



        chosen_day_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chosen_days);
        chosen_days_list_view.setAdapter(chosen_day_Adapter);

        if(chosen_days.contains(appointment))
        {
            Toast.makeText(CreateAdActivity.this, appointment + " already in chosen days", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(CreateAdActivity.this, appointment + " added to chosen days", Toast.LENGTH_SHORT).show();

            chosen_days.add(appointment);
            chosen_day_Adapter.notifyDataSetChanged();

        }

    }
}
