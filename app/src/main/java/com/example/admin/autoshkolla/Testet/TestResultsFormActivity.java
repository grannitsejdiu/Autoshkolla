package com.example.admin.autoshkolla.Testet;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.admin.autoshkolla.R;

public class TestResultsFormActivity extends AppCompatActivity {

    Button closeButtonTestResultsForm;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_results_form);

        closeButtonTestResultsForm = (Button) findViewById(R.id.closeButtonTestResultsForm);
        closeButtonTestResultsForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestResultsFormActivity.super.onBackPressed();
            }
        });


        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        

//        if (progressBar.getProgress() > 50){
//            progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.circular_green_progressbar));
//            progressBar.setProgressDrawable();
//        }
//        else {
//            progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.circular_progress_bar));
//        }
    }

}
