package co.tenton.admin.autoshkolla.SinjalizimiVertikal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import co.tenton.admin.autoshkolla.BlurryBackgrounds_Activities.Info_Activity;
import co.tenton.admin.autoshkolla.Models.Group;
import co.tenton.admin.autoshkolla.Models.This;
import co.tenton.admin.autoshkolla.R;

public class Sinjalizimi_Vertikal_Activity extends AppCompatActivity {
    
    Button sinjalizimiVertikalBackButton, btnOpenInfoForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinjalizimi__vertikal_);

        final int index = getIntent().getIntExtra("index",0);
        Group group = This.groups.get(index);


        RecyclerView my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);
        my_recycler_view.setHasFixedSize(true);
        Sinjalizimi_Vertikal_RecyclerAdapter adapter = new Sinjalizimi_Vertikal_RecyclerAdapter(group.subgroups(), this);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(adapter);


        sinjalizimiVertikalBackButton = (Button) findViewById(R.id.sinjalizimitVertikalFormBackButton);
        sinjalizimiVertikalBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sinjalizimi_Vertikal_Activity.super.onBackPressed();
            }
        });

        btnOpenInfoForm = (Button) findViewById(R.id.sinjalizimiVertikalFormInfo);
        btnOpenInfoForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sinjalizimi_Vertikal_Activity.this, Info_Activity.class);
                intent.putExtra("index",index);
                startActivity(intent);
            }
        });

    }
}
