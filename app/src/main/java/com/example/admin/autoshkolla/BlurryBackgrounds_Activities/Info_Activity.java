package com.example.admin.autoshkolla.BlurryBackgrounds_Activities;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.autoshkolla.Models.Group;
import com.example.admin.autoshkolla.Models.This;
import com.example.admin.autoshkolla.R;
import com.github.mmin18.widget.RealtimeBlurView;

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


        final int index = getIntent().getIntExtra("index",0);
        //final int description = getIntent().getIntExtra("Description",0);
        final Group g = This.groups.get(index);
       // final Group gs = This.groups.get(description);

        titleText = (TextView) findViewById(R.id.infoFormTitle);
        descriptionText = (TextView) findViewById(R.id.infoFormDescription);
        titleText.setText(g.name);
        descriptionText.setText(g.description);
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
