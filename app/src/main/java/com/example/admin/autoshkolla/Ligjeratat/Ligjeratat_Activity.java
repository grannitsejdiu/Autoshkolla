package com.example.admin.autoshkolla.Ligjeratat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.admin.autoshkolla.R;

public class Ligjeratat_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private Button backButtonLigjeratat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ligjeratat);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerViewLigjeratat);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Ligjeratat_RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        backButtonLigjeratat = (Button) findViewById(R.id.ligjeratat_Backbutton);
        backButtonLigjeratat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ligjeratat_Activity.super.onBackPressed();
            }
        });
    }
}
