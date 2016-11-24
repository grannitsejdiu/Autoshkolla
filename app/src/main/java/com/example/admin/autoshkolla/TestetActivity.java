package com.example.admin.autoshkolla;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.admin.autoshkolla.Models.Exam;
import com.example.admin.autoshkolla.Models.This;
import com.example.admin.autoshkolla.ServiceLayer.ExamsLayer;
import com.example.admin.autoshkolla.ServiceLayer.ResponseData;

import java.util.ArrayList;
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

        pDialog = new ProgressDialog(TestetActivity.this);
        pDialog.setTitle("Duke marrur testet!");
        pDialog.setMessage("Ju lutem prisni ... ");
        pDialog.setCancelable(false);
        pDialog.show();

        List<Exam> es = new ArrayList<Exam>();

        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ExamsRecyclerAdapter(es);

        ExamsLayer.getAllExams(new ResponseData() {
            @Override
            public void onSuccess(Object data) {

                List<Exam> aa = (ArrayList<Exam>)data;
                This.exams = aa;

                recyclerView.setAdapter(new ExamsRecyclerAdapter(aa));

                if (pDialog.isShowing()){
                    pDialog.dismiss();
                }
            }
        });
        recyclerView.setAdapter(adapter);


        backButtonTeste = (Button) findViewById(R.id.backbuttonTeste);
        backButtonTeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestetActivity.super.onBackPressed();
            }
        });


    }
}
