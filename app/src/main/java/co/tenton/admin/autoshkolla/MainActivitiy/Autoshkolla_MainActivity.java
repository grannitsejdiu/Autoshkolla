package co.tenton.admin.autoshkolla.MainActivitiy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import co.tenton.admin.autoshkolla.Models.ErrorResponse;
import co.tenton.admin.autoshkolla.Models.Parser;
import co.tenton.admin.autoshkolla.R;
import co.tenton.admin.autoshkolla.ServiceLayer.AllLayer;
import co.tenton.admin.autoshkolla.ServiceLayer.ResponseData;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.json.JSONException;
import org.json.JSONObject;

public class Autoshkolla_MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autoshkolla__main);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("7F82521562046F0F8BD5A3F021FB707B")
                .build();
        mAdView.loadAd(adRequest);


        // fill from local repository
        String response = Parser.getFromShared(getApplicationContext());
        if (!response.equals("")){
            try {
                JSONObject data = new JSONObject(response);
                Parser.createFromJSONObject(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        AllLayer.getAll(new ResponseData() {
            @Override
            public void onSuccess(JSONObject data) {
                Parser.saveToShared(getApplicationContext(), data.toString());
                Parser.createFromJSONObject(data);
            }

            @Override
            public void onNotModified() {
                Log.e("Not modified","Your updated");

            }

            @Override
            public void onFailure(ErrorResponse error) {

                Log.e("Failed", error.message);
            }
        });

        recyclerView= (RecyclerView) findViewById(R.id.recyclerViewMain);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Autoshkolla_MainRecyclerAdapter();
        recyclerView.setAdapter(adapter);

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
