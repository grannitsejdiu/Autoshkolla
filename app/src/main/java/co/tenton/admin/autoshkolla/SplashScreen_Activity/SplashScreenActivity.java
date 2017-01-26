package co.tenton.admin.autoshkolla.SplashScreen_Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

import co.tenton.admin.autoshkolla.MainActivitiy.Autoshkolla_MainActivity;
import co.tenton.admin.autoshkolla.Models.Parser;
import co.tenton.admin.autoshkolla.R;

public class SplashScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash_screen);

        String sharedData = Parser.getFromShared(getApplicationContext());

        if (sharedData != ""){
            Intent intent = new Intent(getApplicationContext(), Autoshkolla_MainActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        else {
            Intent intent = new Intent(getApplicationContext(), Welcome_Activity.class);
            startActivity(intent);
            finish();
            return;
        }

    }
}
