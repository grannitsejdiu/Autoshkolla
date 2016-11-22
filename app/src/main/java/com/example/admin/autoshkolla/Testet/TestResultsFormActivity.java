package com.example.admin.autoshkolla.Testet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin.autoshkolla.R;

public class TestResultsFormActivity extends AppCompatActivity {

    Button closeButtonTestResultsForm;

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

    }
}
