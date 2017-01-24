package co.tenton.admin.autoshkolla.SinjalizimiVertikal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import co.tenton.admin.autoshkolla.BlurryBackgrounds_Activities.Info_Activity;
import co.tenton.admin.autoshkolla.Models.Group;
import co.tenton.admin.autoshkolla.Models.This;
import co.tenton.admin.autoshkolla.R;

public class Sinjalizimi_Vertikal_Activity extends AppCompatActivity {
    
    Button sinjalizimiVertikalBackButton, btnOpenInfoForm;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinjalizimi__vertikal_);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("7F82521562046F0F8BD5A3F021FB707B")
                .build();
        mAdView.loadAd(adRequest);

        final int index = getIntent().getIntExtra("index",0);
        Group group = This.groups.get(index);


        RecyclerView my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);
        my_recycler_view.setHasFixedSize(true);
        Sinjalizimi_Vertikal_RecyclerAdapter adapter = new Sinjalizimi_Vertikal_RecyclerAdapter(group.subgroups(), this);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(adapter);


        sinjalizimiVertikalBackButton = (Button) findViewById(R.id.sinjalizimitVertikalFormBackButton);
        sinjalizimiVertikalBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sinjalizimi_Vertikal_Activity.super.onBackPressed();
            }
        });

        btnOpenInfoForm = (Button) findViewById(R.id.sinjalizimiVertikalFormInfo);
        btnOpenInfoForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sinjalizimi_Vertikal_Activity.this, Info_Activity.class);
                intent.putExtra("index",index);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}
