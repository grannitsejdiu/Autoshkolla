package com.example.admin.autoshkolla.Testet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin.autoshkolla.R;

public class TestQuestionResultActivity extends AppCompatActivity {

    Button pyetjaBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_question_result);

        pyetjaBackButton = (Button) findViewById(R.id.pyetja_Backbutton);
        pyetjaBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestQuestionResultActivity.super.onBackPressed();
            }
        });
    }

}
