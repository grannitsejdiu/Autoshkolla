package co.tenton.admin.autoshkolla.BlurryBackgrounds_Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import co.tenton.admin.autoshkolla.Models.Group;
import co.tenton.admin.autoshkolla.Models.Sign;
import co.tenton.admin.autoshkolla.Models.Subgroup;
import co.tenton.admin.autoshkolla.Models.This;
import co.tenton.admin.autoshkolla.R;

public class SinjalizimiVertikalGrid_Activity extends AppCompatActivity {

    Button backBtnSVertikalGrid;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinjalizimi_vertikal_grid_);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerViewSVertikal);
        title = (TextView) findViewById(R.id.sinjalizimitHorizontalGridFormTitle);

        recyclerView.setHasFixedSize(true);
        GridLayoutManager glm=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(glm);


        int index = getIntent().getIntExtra("index", 0);
        int groupIndex = getIntent().getIntExtra("groupIndex",0);

        if (groupIndex == 5) {
            Group g = This.groups.get(5);
            List<Sign> ss = g.signs;
            adapter = new SinjalizimiVertikalGrid_Adapter(ss, getApplicationContext(), index, 2);
            recyclerView.setAdapter(adapter);
            title.setText(g.name);
        }
        else {
            Subgroup s = This.groups.get(2).subgroups().get(index);
            adapter = new SinjalizimiVertikalGrid_Adapter(s.signs, getApplicationContext(), index, 2);
            recyclerView.setAdapter(adapter);
            title.setText(s.name);
        }


        backBtnSVertikalGrid = (Button) findViewById(R.id.sinjalizimitHorizontalGridFormBackButton);
        backBtnSVertikalGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SinjalizimiVertikalGrid_Activity.super.onBackPressed();
            }
        });

    }
}
