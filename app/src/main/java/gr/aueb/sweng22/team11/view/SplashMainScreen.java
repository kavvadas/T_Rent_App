package gr.aueb.sweng22.team11.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.view.User.Login.LoginActivity;

public class SplashMainScreen extends AppCompatActivity {

    /**
     * Start splash screen for just 2 seconds
     * Creates the layout and initializes the activity
     * @param savedInstanceState the Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_main_screen);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashMainScreen.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}