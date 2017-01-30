package co.tenton.admin.autoshkolla.Shenjat_tabeles_Ilustrimeve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;

import co.tenton.admin.autoshkolla.BlurryBackgrounds_Activities.Info_Activity;
import co.tenton.admin.autoshkolla.BlurryBackgrounds_Activities.SinjalizimiVertikalGrid_Adapter;
import co.tenton.admin.autoshkolla.Models.Group;
import co.tenton.admin.autoshkolla.Models.Sign;
import co.tenton.admin.autoshkolla.Models.Subgroup;
import co.tenton.admin.autoshkolla.Models.This;
import co.tenton.admin.autoshkolla.R;

public class Shenjat_tbl_IlustrimeveActivity extends AppCompatActivity {

    Button shenjatIlustrimetBackButton, infoBtn;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    TextView title;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shenjat_tbl__ilustrimeve);

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

        recyclerView= (RecyclerView) findViewById(R.id.shenjatIlustrimet_recyclerViewSVertikal);
        title = (TextView) findViewById(R.id.shenjatIlustrimet_GridFormTitle);

        recyclerView.setHasFixedSize(true);
        GridLayoutManager glm=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(glm);


        int index = getIntent().getIntExtra("index", 0);
        final Group g = This.shared.groups.get(index);
        List<Sign> s = g.signs;

        adapter = new SinjalizimiVertikalGrid_Adapter(s, getApplicationContext(), index, 5);
        recyclerView.setAdapter(adapter);

        title.setText(g.name);

        shenjatIlustrimetBackButton = (Button) findViewById(R.id.shenjatIlustrimet_GridFormBackButton);
        shenjatIlustrimetBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Shenjat_tbl_IlustrimeveActivity.super.onBackPressed();
            }
        });

        infoBtn = (Button) findViewById(R.id.tblInfo);
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Info_Activity.class);
                intent.putExtra("index", 0);
                intent.putExtra("name", g.name);
                intent.putExtra("description", g.description);
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
