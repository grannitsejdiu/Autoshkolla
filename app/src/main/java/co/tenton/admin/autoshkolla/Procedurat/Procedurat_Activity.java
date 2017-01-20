package co.tenton.admin.autoshkolla.Procedurat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import co.tenton.admin.autoshkolla.R;

public class Procedurat_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Button procedurat_backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procedurat_);

        recyclerView= (RecyclerView) findViewById(R.id.proceduart_recyclerView);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Procedurat_RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        procedurat_backButton = (Button) findViewById(R.id.proceduart_FormBackButton);
        procedurat_backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Procedurat_Activity.super.onBackPressed();
            }
        });

    }
}
