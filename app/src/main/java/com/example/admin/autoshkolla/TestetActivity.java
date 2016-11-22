package com.example.admin.autoshkolla;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class TestetActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private Button backButtonTeste, contentType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__teste);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        backButtonTeste = (Button) findViewById(R.id.backbuttonTeste);
        backButtonTeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestetActivity.super.onBackPressed();
            }
        });

        contentType = (Button) findViewById(R.id.btncontenType);
        contentType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutManager = new LinearLayoutManager(TestetActivity.this,LinearLayoutManager.HORIZONTAL,false);
                recyclerView.setLayoutManager(layoutManager);
                adapter = new RecyclerAdapter();
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
