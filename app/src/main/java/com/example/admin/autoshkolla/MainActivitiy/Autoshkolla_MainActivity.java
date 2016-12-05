package com.example.admin.autoshkolla.MainActivitiy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.autoshkolla.Ligjeratat.Ligjeratat_RecyclerAdapter;
import com.example.admin.autoshkolla.Models.Exam;
import com.example.admin.autoshkolla.Models.Group;
import com.example.admin.autoshkolla.Models.This;
import com.example.admin.autoshkolla.R;
import com.example.admin.autoshkolla.ServiceLayer.ExamsLayer;
import com.example.admin.autoshkolla.ServiceLayer.GroupsLayer;
import com.example.admin.autoshkolla.ServiceLayer.ResponseData;

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

        ExamsLayer.getAllExams(new ResponseData() {
            @Override
            public void onSuccess(Object data) {

                List<Exam> aa = (ArrayList<Exam>)data;
                This.exams = aa;
            }
        });

        GroupsLayer.getAllGroups(new ResponseData() {
            @Override
            public void onSuccess(Object data) {
                List<Group> gs = (ArrayList<Group>)data;
                This.groups = gs;
            }
        });

        recyclerView= (RecyclerView) findViewById(R.id.recyclerViewMain);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Autoshkolla_MainRecyclerAdapter();
        recyclerView.setAdapter(adapter);

    }
}
