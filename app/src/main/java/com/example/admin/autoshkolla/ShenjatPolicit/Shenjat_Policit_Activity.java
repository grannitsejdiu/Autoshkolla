package com.example.admin.autoshkolla.ShenjatPolicit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.admin.autoshkolla.BlurryBackgrounds_Activities.Info_Activity;
import com.example.admin.autoshkolla.R;
import com.example.admin.autoshkolla.SinjalizimiHorizontal.SinjalizimiHorizontalRecyclerAdapter;

public class Shenjat_Policit_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Button shenjat_Policit_BackButton;
    ProgressBar progressBar;
    TextView progressBarText;
    Button btnOpenInfoForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shenjat__policit_);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerViewShenjat_Policit);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Shenjat_Policit_RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        progressBar = (ProgressBar) findViewById(R.id.progressBar_ShenjatPolicit);
        progressBarText = (TextView) findViewById(R.id.progressBarText_Shenjat_Policit);
        progressBarText.setText("1/" + layoutManager.getItemCount());
        progressBar.setMax(layoutManager.getItemCount());
        progressBar.setProgress(1);

        final LinearSnapHelper helper = new LinearSnapHelper(){
            @Override
            public int findTargetSnapPosition(final RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
                final View centerView = findSnapView(layoutManager);
                if (centerView == null) {
                    return RecyclerView.NO_POSITION;
                }

                final int position = layoutManager.getPosition(centerView);
                int targetPosition = -1;
                if (layoutManager.canScrollHorizontally()) {
                    if (velocityX < 0) {
                        targetPosition = position - 1;
                    } else {
                        targetPosition = position + 1;
                    }
                }
                final int firstItem = 0;
                final int lastItem = layoutManager.getItemCount() - 1;
                targetPosition = Math.min(lastItem, Math.max(targetPosition, firstItem));

                progressBar.setProgress(targetPosition+1);
                progressBarText.setText((targetPosition +1) + "/" + layoutManager.getItemCount());

                return targetPosition;

            }
        };
        helper.attachToRecyclerView(recyclerView);

        shenjat_Policit_BackButton = (Button) findViewById(R.id.shenjat_Policit_FormBackButton);
        shenjat_Policit_BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Shenjat_Policit_Activity.super.onBackPressed();
            }
        });

        btnOpenInfoForm = (Button) findViewById(R.id.shenjat_Policit_FormInfo);
        btnOpenInfoForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Info_Activity.class);
                startActivity(intent);
            }
        });
    }
}
