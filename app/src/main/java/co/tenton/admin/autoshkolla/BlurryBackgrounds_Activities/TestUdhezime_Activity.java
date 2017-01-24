package co.tenton.admin.autoshkolla.BlurryBackgrounds_Activities;

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

import co.tenton.admin.autoshkolla.R;
import co.tenton.admin.autoshkolla.Testet.TestFormActivity;

public class TestUdhezime_Activity extends AppCompatActivity {

    Button startButton,closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_udhezime_);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        final String vlera = sharedPreferences.getString("vlera", "");
        final int selectedIndex = getIntent().getIntExtra("selectExamIndex",0);

        if(vlera.equals(""))
        {
            setContentView(R.layout.activity_test_udhezime_);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("vlera", "0");
            editor.apply();
        }
        else{
            Intent intent = new Intent(getApplicationContext(), TestFormActivity.class);
            intent.putExtra("selectExamIndex", selectedIndex);
            startActivity(intent);
            finish();
        }

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.transparentBackground));
        }

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
