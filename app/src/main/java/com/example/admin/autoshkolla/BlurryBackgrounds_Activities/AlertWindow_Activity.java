package com.example.admin.autoshkolla.BlurryBackgrounds_Activities;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.admin.autoshkolla.R;
import com.example.admin.autoshkolla.Testet.TestFormActivity;

public class AlertWindow_Activity extends AppCompatActivity {

    Button vazhdoButton,anuloButton;
    LinearLayout alertWindowLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_window_);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.transparentBackground));
        }

        anuloButton = (Button) findViewById(R.id.btnAnulo);
        anuloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestFormActivity.fa.finish();
                AlertWindow_Activity.super.onBackPressed();
            }
        });

        vazhdoButton = (Button) findViewById(R.id.btnVazhdo);
        vazhdoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertWindow_Activity.super.onBackPressed();
            }
        });

        alertWindowLinear = (LinearLayout) findViewById(R.id.activity_alert_window_);
        alertWindowLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertWindow_Activity.super.onBackPressed();
            }
        });
    }
}
