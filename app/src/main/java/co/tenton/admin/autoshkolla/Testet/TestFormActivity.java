package co.tenton.admin.autoshkolla.Testet;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import co.tenton.admin.autoshkolla.BlurryBackgrounds_Activities.AlertWindow_Activity;
import co.tenton.admin.autoshkolla.Models.Exam;
import co.tenton.admin.autoshkolla.Models.GA;
import co.tenton.admin.autoshkolla.Models.This;
import co.tenton.admin.autoshkolla.R;

import java.util.concurrent.TimeUnit;

public class TestFormActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Button backButtonTestForm;
    TextView testFormTitle, testFormNextQuestion , testFormPreviousQuestion;
    TextView testFormExamTime,pasTextIcon, paraTextIcon,perfundo;
    TextView piket,testNr,questionPoints;
    private static final String FORMAT = "%02d:%02d";
    public static Activity fa;
    private AdView mAdView;

    Exam selectedExam = new Exam();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(co.tenton.admin.autoshkolla.R.layout.activity_test_form);

        GA.TrackScreen("Questions VC");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("7F82521562046F0F8BD5A3F021FB707B")
                .build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                ImageView banner = (ImageView) findViewById(R.id.bannerimage);
                banner.setVisibility(View.GONE);
            }

            @Override
            public void onAdLeftApplication() {
                ImageView banner = (ImageView) findViewById(R.id.bannerimage);
                banner.setVisibility(View.VISIBLE);
            }
        });

        fa = this;

        pasTextIcon = (TextView) findViewById(co.tenton.admin.autoshkolla.R.id.pasButton);
        paraTextIcon = (TextView) findViewById(co.tenton.admin.autoshkolla.R.id.paraButton);
        piket = (TextView) findViewById(co.tenton.admin.autoshkolla.R.id.piket);
        testNr = (TextView) findViewById(R.id.testNr);
        questionPoints = (TextView) findViewById(R.id.questionPoint);
        perfundo = (TextView) findViewById(R.id.perfundo);

        recyclerView= (RecyclerView) findViewById(co.tenton.admin.autoshkolla.R.id.recyclerViewTestForm);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);

        backButtonTestForm = (Button) findViewById(co.tenton.admin.autoshkolla.R.id.backbuttonTestForm);
        backButtonTestForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AlertWindow_Activity.class);
                startActivity(intent);
            }
        });


        //get select index

        final int selectedIndex = getIntent().getIntExtra("selectExamIndex",0);

        if (This.shared.exams.size() <= selectedIndex){
            finish();return;
        }

        selectedExam = This.shared.exams.get(selectedIndex);
        selectedExam.startNewExam();

        adapter = new TestFormRecyclerAdapter(selectedExam.questions, getApplicationContext());
        recyclerView.setAdapter(adapter);

        testFormTitle = (TextView) findViewById(co.tenton.admin.autoshkolla.R.id.testFormTitle);
        testFormTitle.setText("Pyetja 1/" + selectedExam.questions.size());

        GA.TrackAction("Questions VC","Exam Open",selectedExam.name);

        int testNumber = selectedIndex +1;
        testNr.setText(String.valueOf("Testi " + testNumber));
        questionPoints.setText(String.valueOf(selectedExam.questions.get(0).points));

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
                questionPoints.setText(String.valueOf(selectedExam.questions.get((targetPosition)).points));
                if (targetPosition ==0){
                    testFormPreviousQuestion.setVisibility(View.INVISIBLE);
                    pasTextIcon.setVisibility(View.INVISIBLE);
                }
                else{
                    testFormPreviousQuestion.setVisibility(View.VISIBLE);
                    pasTextIcon.setVisibility(View.VISIBLE);
                }

                if (targetPosition == layoutManager.getItemCount()-1){
                    perfundo.setVisibility(View.VISIBLE);
                    paraTextIcon.setVisibility(View.GONE);
                }
                else {
                    paraTextIcon.setVisibility(View.VISIBLE);
                    perfundo.setVisibility(View.GONE);
                }

                return targetPosition;
            }
        };
        helper.attachToRecyclerView(recyclerView);


        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        final int width = displaymetrics.widthPixels;

        //region testFormNextQuestion.setOnClickListener
        testFormNextQuestion = (TextView) findViewById(co.tenton.admin.autoshkolla.R.id.testFormNextQuestion);
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
                testFormTitle.setText("Pyetja " + (targetPosition +1) + "/" + selectedExam.questions.size());
                questionPoints.setText(String.valueOf(selectedExam.questions.get((targetPosition)).points));

                if (targetPosition ==0){
                    testFormPreviousQuestion.setVisibility(View.INVISIBLE);
                    pasTextIcon.setVisibility(View.INVISIBLE);
                }
                else if(position == layoutManager.getItemCount()-1){
                    Intent intent = new Intent(TestFormActivity.this, TestResultsFormActivity.class);
                    intent.putExtra("index", selectedIndex);
                    finish();
                    startActivity(intent);
                }
                else{
                    testFormPreviousQuestion.setVisibility(View.VISIBLE);
                    pasTextIcon.setVisibility(View.VISIBLE);
                }


                if ((position == layoutManager.getItemCount()-2) || (position==layoutManager.getItemCount()-1)){
                    perfundo.setVisibility(View.VISIBLE);
                    paraTextIcon.setVisibility(View.GONE);
                }
                else {
                    paraTextIcon.setVisibility(View.VISIBLE);
                    perfundo.setVisibility(View.GONE);
                }

            }
        });
        //endregion

        //region testFormPreviousQuestion.setOnClickListener
        testFormPreviousQuestion = (TextView) findViewById(co.tenton.admin.autoshkolla.R.id.testFormPreviousQuestion);
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
                testFormTitle.setText("Pyetja " + (targetPosition+1) + "/" + selectedExam.questions.size());
                questionPoints.setText(String.valueOf(selectedExam.questions.get((targetPosition)).points));

                if (targetPosition ==0){
                    testFormPreviousQuestion.setVisibility(View.INVISIBLE);
                    pasTextIcon.setVisibility(View.INVISIBLE);
                }
                else{
                    testFormPreviousQuestion.setVisibility(View.VISIBLE);
                    pasTextIcon.setVisibility(View.VISIBLE);
                }

                if (position == layoutManager.getItemCount()){
                    perfundo.setVisibility(View.VISIBLE);
                    paraTextIcon.setVisibility(View.GONE);
                }
                else {
                    paraTextIcon.setVisibility(View.VISIBLE);
                    perfundo.setVisibility(View.GONE);
                }

            }
        });
        //endregion

        //region  paraTextIcon.setOnClickListener
        paraTextIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.smoothScrollBy(width,0);

                View centerView = helper.findSnapView(layoutManager);

                int position = layoutManager.getPosition(centerView);
                int targetPosition = position + 1;

                final int firstItem = 0;
                final int lastItem = layoutManager.getItemCount() - 1;
                targetPosition = Math.min(lastItem, Math.max(targetPosition, firstItem));
                testFormTitle.setText("Pyetja " + (targetPosition +1) + "/" + selectedExam.questions.size());
                questionPoints.setText(String.valueOf(selectedExam.questions.get((targetPosition)).points));

                if (targetPosition ==0){
                    testFormPreviousQuestion.setVisibility(View.INVISIBLE);
                    pasTextIcon.setVisibility(View.INVISIBLE);
                }
                else if(position == layoutManager.getItemCount()-1){
                    Intent intent = new Intent(TestFormActivity.this, TestResultsFormActivity.class);
                    intent.putExtra("index", selectedIndex);
                    finish();
                    startActivity(intent);
                }
                else{
                    testFormPreviousQuestion.setVisibility(View.VISIBLE);
                    pasTextIcon.setVisibility(View.VISIBLE);
                }


                if ((position == layoutManager.getItemCount()-2) || (position==layoutManager.getItemCount()-1)){
                    perfundo.setVisibility(View.VISIBLE);
                    paraTextIcon.setVisibility(View.GONE);
                }
                else {
                    paraTextIcon.setVisibility(View.VISIBLE);
                    perfundo.setVisibility(View.GONE);
                }
            }
        });
        //endregion

        //region pasButton OnClickListener
        pasTextIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.smoothScrollBy(-width,0);
                View centerView = helper.findSnapView(layoutManager);

                int position = layoutManager.getPosition(centerView);
                int targetPosition = position - 1;

                final int firstItem = 0;
                final int lastItem = layoutManager.getItemCount() - 1;
                targetPosition = Math.min(lastItem, Math.max(targetPosition, firstItem));
                testFormTitle.setText("Pyetja " + (targetPosition+1) + "/" + selectedExam.questions.size());
                questionPoints.setText(String.valueOf(selectedExam.questions.get((targetPosition)).points));

                if (targetPosition ==0){
                    testFormPreviousQuestion.setVisibility(View.INVISIBLE);
                    pasTextIcon.setVisibility(View.INVISIBLE);
                }
                else{
                    testFormPreviousQuestion.setVisibility(View.VISIBLE);
                    pasTextIcon.setVisibility(View.VISIBLE);
                }

                if (position == layoutManager.getItemCount()){
                    perfundo.setVisibility(View.VISIBLE);
                    paraTextIcon.setVisibility(View.GONE);
                }
                else {
                    paraTextIcon.setVisibility(View.VISIBLE);
                    perfundo.setVisibility(View.GONE);
                }
            }
        });
        //endregion




        testFormExamTime = (TextView) findViewById(co.tenton.admin.autoshkolla.R.id.testFormExamTime);
        new CountDownTimer(2700000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {

                testFormExamTime.setText(""+String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
//                testFormExamTime.setText("done!");
                Intent intent = new Intent(getApplicationContext(), TestResultsFormActivity.class);
                intent.putExtra("index", selectedIndex);
                startActivity(intent);
            }
        }.start();

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), AlertWindow_Activity.class);
        startActivity(intent);
    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

}
