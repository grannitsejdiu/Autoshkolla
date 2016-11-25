package com.example.admin.autoshkolla.Testet;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.admin.autoshkolla.Models.This;
import com.example.admin.autoshkolla.R;
import com.example.admin.autoshkolla.SinjalizimiHorizontal.SinjalizimiHorizontalRecyclerAdapter;

public class TestResultsFormActivity extends AppCompatActivity {

    Button closeButtonTestResultsForm;
    ProgressBar progressBar;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_results_form);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerViewTestFormResult);

        recyclerView.setHasFixedSize(true);
        GridLayoutManager glm=new GridLayoutManager(this,10);
        recyclerView.setLayoutManager(glm);
        adapter = new TestResultsForm_RecyclerAdapter();
        recyclerView.setAdapter(adapter);


        closeButtonTestResultsForm = (Button) findViewById(R.id.closeButtonTestResultsForm);
        closeButtonTestResultsForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestResultsFormActivity.super.onBackPressed();
            }
        });


        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        

        startAnimation();
//        if (progressBar.getProgress() > 50){
//            progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.circular_green_progressbar));
//            progressBar.setProgressDrawable();
//        }
//        else {
//            progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.circular_progress_bar));
//        }
    }

    private void startAnimation(){
        ProgressBar mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        TextView  progressBarPercentage = (TextView) findViewById(R.id.progressBarPercentage);

        int progressBarValue = 55;

        ObjectAnimator progressAnimator = ObjectAnimator.ofInt(mProgressBar, "progress", 0, progressBarValue);
        progressAnimator.setDuration(1000);

        if (progressBarValue >= 90){
            mProgressBar.setProgressDrawable(getResources().getDrawable(R.drawable.circular_green_progressbar));
            progressBarPercentage.setTextColor(Color.GREEN);
            progressBarPercentage.setText(progressBarValue + "%");

        }
        else{
            mProgressBar.setProgressDrawable(getResources().getDrawable(R.drawable.circular_progress_bar));
            progressBarPercentage.setTextColor(Color.RED);
            progressBarPercentage.setText(progressBarValue + "%");
        }

        progressAnimator.setInterpolator(new LinearInterpolator());
        progressAnimator.start();
    }

}
