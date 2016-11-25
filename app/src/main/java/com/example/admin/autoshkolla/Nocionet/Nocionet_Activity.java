package com.example.admin.autoshkolla.Nocionet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.admin.autoshkolla.Models.Group;
import com.example.admin.autoshkolla.Models.This;
import com.example.admin.autoshkolla.R;

public class Nocionet_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Button nocionet_BackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nocionet_);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerView_Nocionet);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);


        int index = getIntent().getIntExtra("index", 0);
        Group selectedGroup = This.groups.get(index);

        adapter = new Nocionet_RecyclerAdapter(selectedGroup.signs, getApplicationContext());
        recyclerView.setAdapter(adapter);

//        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
//        linearSnapHelper.attachToRecyclerView(recyclerView);

        nocionet_BackButton = (Button) findViewById(R.id.nocionet_FormBackButton);
        nocionet_BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nocionet_Activity.super.onBackPressed();
            }
        });


    }
}
