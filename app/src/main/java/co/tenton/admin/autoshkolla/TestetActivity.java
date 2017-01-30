package co.tenton.admin.autoshkolla;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import co.tenton.admin.autoshkolla.Models.Exam;
import co.tenton.admin.autoshkolla.Models.This;

import java.util.List;

public class TestetActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private Button backButtonTeste, contentType;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__teste);
        
        List<Exam> es = This.shared.exams;

        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        backButtonTeste = (Button) findViewById(R.id.backbuttonTeste);
        backButtonTeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestetActivity.super.onBackPressed();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        List<Exam> es = This.shared.exams;
        adapter = new ExamsRecyclerAdapter(es, getApplicationContext());

        recyclerView.setAdapter(adapter);
    }
}
