package com.example.admin.autoshkolla.BlurryBackgrounds_Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.admin.autoshkolla.R;
import com.example.admin.autoshkolla.Testet.TestFormActivity;

public class TestUdhezime_Activity extends AppCompatActivity {

    Button startButton,closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_udhezime_);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.transparentBackground));
        }


        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String username = sharedPref.getString("activity", "");
        final int selectedIndex = getIntent().getIntExtra("selectExamIndex",0);

        if (!username.equals("1")) {
            setContentView(R.layout.activity_test_udhezime_);
        }
        else {
            Intent intent = new Intent(this, TestFormActivity.class);
            intent.putExtra("selectExamIndex", selectedIndex);
            startActivity(intent);
            finish();
        }

        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("activity", "0");
        editor.apply();

        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TestFormActivity.class);
                intent.putExtra("selectExamIndex", selectedIndex);
                startActivity(intent);
                finish();
            }
        });

        closeButton = (Button) findViewById(R.id.cancelButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestUdhezime_Activity.super.onBackPressed();
            }
        });

    }
}
