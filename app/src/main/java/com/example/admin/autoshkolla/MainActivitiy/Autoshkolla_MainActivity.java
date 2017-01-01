package com.example.admin.autoshkolla.MainActivitiy;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.admin.autoshkolla.Ligjeratat.Ligjeratat_RecyclerAdapter;
import com.example.admin.autoshkolla.Models.ErrorResponse;
import com.example.admin.autoshkolla.Models.Exam;
import com.example.admin.autoshkolla.Models.Group;
import com.example.admin.autoshkolla.Models.Parser;
import com.example.admin.autoshkolla.Models.Sign;
import com.example.admin.autoshkolla.Models.Subgroup;
import com.example.admin.autoshkolla.Models.This;
import com.example.admin.autoshkolla.R;
import com.example.admin.autoshkolla.ServiceLayer.AllLayer;
import com.example.admin.autoshkolla.ServiceLayer.ExamsLayer;
import com.example.admin.autoshkolla.ServiceLayer.GroupsLayer;
import com.example.admin.autoshkolla.ServiceLayer.ResponseData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Autoshkolla_MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autoshkolla__main);

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
}
