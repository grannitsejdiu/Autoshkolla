package co.tenton.admin.autoshkolla.Shenjat_tabeles_Ilustrimeve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import co.tenton.admin.autoshkolla.BlurryBackgrounds_Activities.SinjalizimiVertikalGrid_Adapter;
import co.tenton.admin.autoshkolla.Models.Group;
import co.tenton.admin.autoshkolla.Models.Sign;
import co.tenton.admin.autoshkolla.Models.Subgroup;
import co.tenton.admin.autoshkolla.Models.This;
import co.tenton.admin.autoshkolla.R;

public class Shenjat_tbl_IlustrimeveActivity extends AppCompatActivity {

    Button shenjatIlustrimetBackButton;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shenjat_tbl__ilustrimeve);

        recyclerView= (RecyclerView) findViewById(R.id.shenjatIlustrimet_recyclerViewSVertikal);
        title = (TextView) findViewById(R.id.shenjatIlustrimet_GridFormTitle);

        recyclerView.setHasFixedSize(true);
        GridLayoutManager glm=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(glm);


        int index = getIntent().getIntExtra("index", 0);
        Group g = This.groups.get(index);
        List<Sign> s = g.signs;

        adapter = new SinjalizimiVertikalGrid_Adapter(s, getApplicationContext(), index, 5);
        recyclerView.setAdapter(adapter);

        title.setText(g.name);

        shenjatIlustrimetBackButton = (Button) findViewById(R.id.shenjatIlustrimet_GridFormBackButton);
        shenjatIlustrimetBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Shenjat_tbl_IlustrimeveActivity.super.onBackPressed();
            }
        });

    }
}
