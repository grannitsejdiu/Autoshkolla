package com.example.admin.autoshkolla.LaunchActivities;

import android.support.v4.content.ParallelExecutorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.autoshkolla.Models.ErrorResponse;
import com.example.admin.autoshkolla.Models.Parser;
import com.example.admin.autoshkolla.R;
import com.example.admin.autoshkolla.ServiceLayer.AllLayer;
import com.example.admin.autoshkolla.ServiceLayer.ResponseData;

import org.json.JSONObject;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        //download the content from server

        //set a download bar and status
        downloadContent();
    }

    void downloadContent(){
        AllLayer.getAll(new ResponseData() {
            @Override
            public void onSuccess(JSONObject data) {

                Parser.saveToShared(getApplicationContext(), data.toString());
                Parser.createFromJSONObject(data);

                //show button Fillo to go to main activity

            }

            @Override
            public void onFailure(ErrorResponse error) {

                //tell user that internet connection is needed to download content
                //show retry button


            }

            @Override
            public void onNotModified() {
                //nuk besoj qe hin najhere :P
            }
        });
    }
}
