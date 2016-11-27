package com.example.admin.autoshkolla.BlurryBackgrounds_Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.admin.autoshkolla.R;

public class SinjalizimiVertikalGrid_Activity extends AppCompatActivity {

    Button backBtnSVertikalGrid;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinjalizimi_vertikal_grid_);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerViewSVertikal);

        recyclerView.setHasFixedSize(true);
        GridLayoutManager glm=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(glm);
        adapter = new SinjalizimiVertikalGrid_Adapter();
        recyclerView.setAdapter(adapter);

        backBtnSVertikalGrid = (Button) findViewById(R.id.sinjalizimitHorizontalGridFormBackButton);
        backBtnSVertikalGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SinjalizimiVertikalGrid_Activity.super.onBackPressed();
            }
        });

    }
}
