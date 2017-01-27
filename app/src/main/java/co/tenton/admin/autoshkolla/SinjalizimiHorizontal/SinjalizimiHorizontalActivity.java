package co.tenton.admin.autoshkolla.SinjalizimiHorizontal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import co.tenton.admin.autoshkolla.BlurryBackgrounds_Activities.Info_Activity;
import co.tenton.admin.autoshkolla.Models.Group;
import co.tenton.admin.autoshkolla.Models.This;
import co.tenton.admin.autoshkolla.R;

public class SinjalizimiHorizontalActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Button sinjalizimiHorizontalBackButton, sinjalizimiInfo;
    ProgressBar progressBar;
    TextView progressBarText;
    TextView formTitle;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(co.tenton.admin.autoshkolla.R.layout.activity_sinjalizimi_horizontal);

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

        recyclerView= (RecyclerView) findViewById(co.tenton.admin.autoshkolla.R.id.recyclerViewTestForm);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);

        final int index = getIntent().getIntExtra("index",0);
        final Group g = This.groups.get(index);

        adapter = new SinjalizimiHorizontalRecyclerAdapter(g.signs, getApplicationContext());
        recyclerView.setAdapter(adapter);

        formTitle = (TextView) findViewById(co.tenton.admin.autoshkolla.R.id.sinjalizimitHorizontaFormTitle);
        formTitle.setText(g.name);

        progressBar = (ProgressBar) findViewById(co.tenton.admin.autoshkolla.R.id.sinjalizimitHorizontaProgressBar);
        progressBarText = (TextView) findViewById(co.tenton.admin.autoshkolla.R.id.progressBarText);
        progressBarText.setText("1/" + g.signs.size());
        progressBar.setMax(layoutManager.getItemCount());
        progressBar.setProgress(1);

        final LinearSnapHelper helper = new LinearSnapHelper(){
            @Override
            public int findTargetSnapPosition(final RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
                final View centerView = findSnapView(layoutManager);
                if (centerView == null) {
                    return RecyclerView.NO_POSITION;
                }

                final int position = layoutManager.getPosition(centerView);
                int targetPosition = -1;
                if (layoutManager.canScrollHorizontally()) {
                    if (velocityX < 0) {
                        targetPosition = position - 1;
                    } else {
                        targetPosition = position + 1;
                    }
                }
                final int firstItem = 0;
                final int lastItem = g.signs.size() - 1;
                targetPosition = Math.min(lastItem, Math.max(targetPosition, firstItem));

                progressBar.setProgress(targetPosition+1);
                progressBarText.setText((targetPosition +1) + "/" + g.signs.size());

                return targetPosition;

            }
        };
        helper.attachToRecyclerView(recyclerView);

        sinjalizimiHorizontalBackButton = (Button) findViewById(co.tenton.admin.autoshkolla.R.id.sinjalizimitHorizontaFormBackButton);
        sinjalizimiHorizontalBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SinjalizimiHorizontalActivity.super.onBackPressed();
            }
        });


        sinjalizimiInfo = (Button) findViewById(co.tenton.admin.autoshkolla.R.id.sinjalizimitHorizontaFormInfo);
        sinjalizimiInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Info_Activity.class);
                intent.putExtra("index", index);
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
