package com.example.admin.autoshkolla.Testet;

import android.content.Intent;
import android.graphics.PointF;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.autoshkolla.R;
import com.example.admin.autoshkolla.RecyclerAdapter;

import java.util.concurrent.TimeUnit;

public class TestFormActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Button backButtonTestForm;
    TextView testFormTitle, testFormNextQuestion , testFormPreviousQuestion;
    TextView testFormExamTime;
    private static final String FORMAT = "%02d:%02d";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_form);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerViewTestForm);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new TestFormRecyclerAdapter();
        recyclerView.setAdapter(adapter);


        testFormTitle = (TextView) findViewById(R.id.testFormTitle);
        testFormTitle.setText("Pyetja 1/" + layoutManager.getItemCount());


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
                testFormTitle.setText("Pyetja " + (targetPosition+1) + "/" + layoutManager.getItemCount());
                if (targetPosition ==0){
                    testFormPreviousQuestion.setVisibility(View.INVISIBLE);
                }
                else{
                    testFormPreviousQuestion.setVisibility(View.VISIBLE);
                }
                return targetPosition;
            }
        };
        helper.attachToRecyclerView(recyclerView);


        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        final int width = displaymetrics.widthPixels;

        testFormNextQuestion = (TextView) findViewById(R.id.testFormNextQuestion);
        testFormNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.smoothScrollBy(width,0);

                View centerView = helper.findSnapView(layoutManager);

                int position = layoutManager.getPosition(centerView);
                int targetPosition = position + 1;

                final int firstItem = 0;
                final int lastItem = layoutManager.getItemCount() - 1;
                targetPosition = Math.min(lastItem, Math.max(targetPosition, firstItem));
                testFormTitle.setText("Pyetja " + (targetPosition +1) + "/" + layoutManager.getItemCount());

                if (targetPosition ==0){
                    testFormPreviousQuestion.setVisibility(View.INVISIBLE);
                }
                else if(position == layoutManager.getItemCount()-1){
                    Intent intent = new Intent(TestFormActivity.this, TestResultsFormActivity.class);
                    startActivity(intent);
                }
                else{
                    testFormPreviousQuestion.setVisibility(View.VISIBLE);
                }

            }
        });

        testFormPreviousQuestion = (TextView) findViewById(R.id.testFormPreviousQuestion);
        testFormPreviousQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.smoothScrollBy(-width,0);
                View centerView = helper.findSnapView(layoutManager);

                int position = layoutManager.getPosition(centerView);
                int targetPosition = position - 1;

                final int firstItem = 0;
                final int lastItem = layoutManager.getItemCount() - 1;
                targetPosition = Math.min(lastItem, Math.max(targetPosition, firstItem));
                testFormTitle.setText("Pyetja " + (targetPosition+1) + "/" + layoutManager.getItemCount());

                if (targetPosition ==0){
                    testFormPreviousQuestion.setVisibility(View.INVISIBLE);
                }
                else{
                    testFormPreviousQuestion.setVisibility(View.VISIBLE);
                }

            }
        });

        backButtonTestForm = (Button) findViewById(R.id.backbuttonTestForm);
        backButtonTestForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestFormActivity.super.onBackPressed();
            }
        });


        testFormExamTime = (TextView) findViewById(R.id.testFormExamTime);
        new CountDownTimer(2700000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {

                testFormExamTime.setText(""+String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                testFormExamTime.setText("done!");
            }
        }.start();


    }


}
