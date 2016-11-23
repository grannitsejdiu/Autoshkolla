package com.example.admin.autoshkolla.SinjalizimiVertikal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.admin.autoshkolla.R;

import java.util.ArrayList;

public class Sinjalizimi_Vertikal_Activity extends AppCompatActivity {

    ArrayList<SectionDataModel> allSampleData;
    Button sinjalizimiVertikalBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinjalizimi__vertikal_);

        allSampleData = new ArrayList<SectionDataModel>();
        createDummyData();


        RecyclerView my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);
        my_recycler_view.setHasFixedSize(true);
        Sinjalizimi_Vertikal_RecyclerAdapter adapter = new Sinjalizimi_Vertikal_RecyclerAdapter(this, allSampleData);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(adapter);


        sinjalizimiVertikalBackButton = (Button) findViewById(R.id.sinjalizimitVertikalFormBackButton);
        sinjalizimiVertikalBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sinjalizimi_Vertikal_Activity.super.onBackPressed();
            }
        });


    }

    public void createDummyData() {
        for (int i = 1; i <= 5; i++) {
            SectionDataModel dm = new SectionDataModel();
            dm.setHeaderTitle("Section " + i);
            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j = 0; j <= 8; j++) {
                singleItem.add(new SingleItemModel("Item " + j, "URL " + j));
            }
            dm.setAllItemsInSection(singleItem);
            allSampleData.add(dm);

        }
    }


    }
