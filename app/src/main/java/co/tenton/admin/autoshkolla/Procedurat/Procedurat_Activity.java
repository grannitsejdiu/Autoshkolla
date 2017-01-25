package co.tenton.admin.autoshkolla.Procedurat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import co.tenton.admin.autoshkolla.R;

public class Procedurat_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Button procedurat_backButton;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procedurat_);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("7F82521562046F0F8BD5A3F021FB707B")
                .build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                ImageView banner = (ImageView) findViewById(R.id.bannerimage);
                banner.setVisibility(View.GONE);
            }

            @Override
            public void onAdLeftApplication() {
                ImageView banner = (ImageView) findViewById(R.id.bannerimage);
                banner.setVisibility(View.VISIBLE);
            }
        });

        recyclerView= (RecyclerView) findViewById(R.id.proceduart_recyclerView);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Procedurat_RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        procedurat_backButton = (Button) findViewById(R.id.proceduart_FormBackButton);
        procedurat_backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Procedurat_Activity.super.onBackPressed();
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
