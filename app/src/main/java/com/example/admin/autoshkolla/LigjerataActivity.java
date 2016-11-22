package com.example.admin.autoshkolla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

import com.example.admin.autoshkolla.Nocionet.Nocionet_Activity;
import com.example.admin.autoshkolla.ShenjatPolicit.Shenjat_Policit_Activity;
import com.example.admin.autoshkolla.SinjalizimiHorizontal.SinjalizimiHorizontalActivity;

public class LigjerataActivity extends AppCompatActivity {

    private Button backButtonLigjerata;
    CardView sinjalizimiHorizontal, shenjatPolicit, nocionet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ligjerata);

        sinjalizimiHorizontal = (CardView) findViewById(R.id.cardViewSinjaliziHorizontal);
        sinjalizimiHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LigjerataActivity.this, SinjalizimiHorizontalActivity.class);
                startActivity(intent);
            }
        });

        shenjatPolicit = (CardView) findViewById(R.id.cardViewShenjatePolicit);
        shenjatPolicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LigjerataActivity.this, Shenjat_Policit_Activity.class);
                startActivity(intent);
            }
        });

        backButtonLigjerata = (Button) findViewById(R.id.backbuttonLigjerata);
        backButtonLigjerata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LigjerataActivity.super.onBackPressed();
            }
        });

        nocionet = (CardView) findViewById(R.id.cardViewNocione);
        nocionet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LigjerataActivity.this, Nocionet_Activity.class);
                startActivity(intent);
            }
        });

    }
}
