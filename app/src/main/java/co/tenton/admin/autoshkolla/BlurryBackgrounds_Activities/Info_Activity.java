package co.tenton.admin.autoshkolla.BlurryBackgrounds_Activities;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import co.tenton.admin.autoshkolla.Models.Group;
import co.tenton.admin.autoshkolla.Models.Sign;
import co.tenton.admin.autoshkolla.Models.This;
import co.tenton.admin.autoshkolla.R;

public class Info_Activity extends AppCompatActivity {

    Button backButtonInfo;
    TextView titleText, descriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.transparentBackground));
        }


        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");


        titleText = (TextView) findViewById(R.id.infoFormTitle);
        descriptionText = (TextView) findViewById(R.id.infoFormDescription);
        titleText.setText(name);
        descriptionText.setText(description);
        descriptionText.setMovementMethod(new ScrollingMovementMethod());


        backButtonInfo = (Button) findViewById(R.id.backButtonInfo);
        backButtonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Info_Activity.super.onBackPressed();
            }
        });

    }

}
