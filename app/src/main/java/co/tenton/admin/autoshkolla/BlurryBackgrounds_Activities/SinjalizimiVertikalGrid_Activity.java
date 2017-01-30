package co.tenton.admin.autoshkolla.BlurryBackgrounds_Activities;

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

import co.tenton.admin.autoshkolla.Models.Group;
import co.tenton.admin.autoshkolla.Models.Sign;
import co.tenton.admin.autoshkolla.Models.Subgroup;
import co.tenton.admin.autoshkolla.Models.This;
import co.tenton.admin.autoshkolla.R;
import co.tenton.admin.autoshkolla.SinjalizimiVertikal.Sinjalizimi_Vertikal_Activity;

public class SinjalizimiVertikalGrid_Activity extends AppCompatActivity {

    Button backBtnSVertikalGrid;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    TextView title;
    Button info;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinjalizimi_vertikal_grid_);

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

        recyclerView= (RecyclerView) findViewById(R.id.recyclerViewSVertikal);
        title = (TextView) findViewById(R.id.sinjalizimitHorizontalGridFormTitle);

        recyclerView.setHasFixedSize(true);
        GridLayoutManager glm=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(glm);


        final int index = getIntent().getIntExtra("index", 0);
        final int groupIndex = getIntent().getIntExtra("groupIndex",0);

        if (groupIndex == 5) {
            Group g = This.shared.groups.get(5);
            List<Sign> ss = g.signs;
            adapter = new SinjalizimiVertikalGrid_Adapter(ss, getApplicationContext(), index, 2);
            recyclerView.setAdapter(adapter);
            title.setText(g.name);
        }
        else {
            Subgroup s = This.shared.groups.get(2).subgroups().get(index);
            adapter = new SinjalizimiVertikalGrid_Adapter(s.signs, getApplicationContext(), index, 2);
            recyclerView.setAdapter(adapter);
            title.setText(s.name);
        }


        backBtnSVertikalGrid = (Button) findViewById(R.id.sinjalizimitHorizontalGridFormBackButton);
        backBtnSVertikalGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SinjalizimiVertikalGrid_Activity.super.onBackPressed();
            }
        });

        info = (Button) findViewById(R.id.sinjalizimitVertikalGridFormInfo);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SinjalizimiVertikalGrid_Activity.this, Info_Activity.class);
                intent.putExtra("index",index);

                if (groupIndex == 5) {
                    Group g = This.shared.groups.get(5);
                    intent.putExtra("name", g.name);
                    intent.putExtra("description", g.description);
                }
                else {
                    Subgroup s = This.shared.groups.get(2).subgroups().get(index);
                    intent.putExtra("name", s.name);
                    intent.putExtra("description", s.description);
                }

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
