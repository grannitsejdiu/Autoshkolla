package com.example.admin.autoshkolla.BlurryBackgrounds_Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.autoshkolla.Models.Group;
import com.example.admin.autoshkolla.Models.This;
import com.example.admin.autoshkolla.R;

public class Info_Activity extends AppCompatActivity {

    Button backButtonInfo;
    TextView titleText, descriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_);

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
