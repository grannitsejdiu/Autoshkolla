package com.example.admin.autoshkolla.Ilustrimet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.admin.autoshkolla.MainActivitiy.Autoshkolla_MainRecyclerAdapter;
import com.example.admin.autoshkolla.Models.This;
import com.example.admin.autoshkolla.R;

public class Ilustrimet_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    Button backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilustrimet_);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerView_Ilustrimet);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Ilustrimet_RecyclerAdapter(This.illustraions, getApplicationContext());
        recyclerView.setAdapter(adapter);

        backbutton = (Button) findViewById(R.id.ilustrimet_FormBackButton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ilustrimet_Activity.super.onBackPressed();
            }
        });
    }
}
