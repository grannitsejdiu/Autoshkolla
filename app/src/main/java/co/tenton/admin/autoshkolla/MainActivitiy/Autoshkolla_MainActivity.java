package co.tenton.admin.autoshkolla.MainActivitiy;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
    Button shareApp,settingsBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autoshkolla__main);

        isStoragePermissionGranted();

        SharedPreferences sharedPreferences = getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        shareApp = (Button) findViewById(R.id.shareAutoshkolla);
        shareApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String appLink = "http://autoshkolla-ks.com/";
                String shareBody = "Aplikacioni Autoshkolla, për iOS dhe Android. : \n\n";
                 String shareSubject = "Autoshkolla : ";
                intent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                intent.putExtra(Intent.EXTRA_TEXT, shareBody + appLink);
                startActivity(Intent.createChooser(intent,"Share Autoshkolla with ... "));
            }
        });

        settingsBtn = (Button) findViewById(R.id.settingsBtn);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Autoshkolla_MainActivity.this, Preferencat_Activity.class);
                startActivity(intent);
            }
        });


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

        public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            }
            else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            return true;

        }
    }

}
