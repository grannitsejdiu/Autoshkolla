package co.tenton.admin.autoshkolla.BlurryBackgrounds_Activities;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import co.tenton.admin.autoshkolla.Testet.TestFormActivity;

public class AlertWindow_Activity extends AppCompatActivity {

    Button vazhdoButton,anuloButton;
    LinearLayout alertWindowLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(co.tenton.admin.autoshkolla.R.layout.activity_alert_window_);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, co.tenton.admin.autoshkolla.R.color.transparentBackground));
        }

        anuloButton = (Button) findViewById(co.tenton.admin.autoshkolla.R.id.btnAnulo);
        anuloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestFormActivity.fa.finish();
                AlertWindow_Activity.super.onBackPressed();
            }
        });

        vazhdoButton = (Button) findViewById(co.tenton.admin.autoshkolla.R.id.btnVazhdo);
        vazhdoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertWindow_Activity.super.onBackPressed();
            }
        });

        alertWindowLinear = (LinearLayout) findViewById(co.tenton.admin.autoshkolla.R.id.activity_alert_window_);
        alertWindowLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertWindow_Activity.super.onBackPressed();
            }
        });
    }
}
