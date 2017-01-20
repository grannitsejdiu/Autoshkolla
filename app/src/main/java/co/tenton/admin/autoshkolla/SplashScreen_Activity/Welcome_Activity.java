package co.tenton.admin.autoshkolla.SplashScreen_Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.tenton.admin.autoshkolla.MainActivitiy.Autoshkolla_MainActivity;

public class Welcome_Activity extends AppCompatActivity {
    private static int SPLASH_SCREEN_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(co.tenton.admin.autoshkolla.R.layout.activity_welcome_);

        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                Intent homeIntent = new Intent(Welcome_Activity.this, Autoshkolla_MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPLASH_SCREEN_OUT );

    }
}
