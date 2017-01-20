package co.tenton.admin.autoshkolla.Ligjeratat;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import co.tenton.admin.autoshkolla.Models.Group;
import co.tenton.admin.autoshkolla.Models.This;

import java.util.List;

public class Ligjeratat_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private Button backButtonLigjeratat;
    private ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(co.tenton.admin.autoshkolla.R.layout.activity_ligjeratat);

        List<Group> groups = This.groups;

        recyclerView= (RecyclerView) findViewById(co.tenton.admin.autoshkolla.R.id.recyclerViewLigjeratat);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Ligjeratat_RecyclerAdapter(groups);




        recyclerView.setAdapter(adapter);

        backButtonLigjeratat = (Button) findViewById(co.tenton.admin.autoshkolla.R.id.ligjeratat_Backbutton);
        backButtonLigjeratat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ligjeratat_Activity.super.onBackPressed();
            }
        });
    }
}
