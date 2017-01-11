package com.example.admin.autoshkolla.Rregullat_Komunikacionit_Siguria_MjetetMotorike;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.autoshkolla.R;

public class SiguriaDheMjetet_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siguria_dhe_mjetet_);

        recyclerView= (RecyclerView) findViewById(R.id.siguriadhemjetet_recyclerView);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SiguriaDheMjetet_RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }
}
