package co.tenton.admin.autoshkolla.Testet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.squareup.picasso.Picasso;

import co.tenton.admin.autoshkolla.Models.Alternative;
import co.tenton.admin.autoshkolla.Models.Constants;
import co.tenton.admin.autoshkolla.Models.Question;
import co.tenton.admin.autoshkolla.Models.This;
import co.tenton.admin.autoshkolla.R;

public class TestQuestionResultActivity extends AppCompatActivity {

    Button pyetjaBackButton;
    ImageView pyetjaImage;
    TextView titulli, pyetjaText;
    public CheckBox pyetjaFirstAlternative,pyetjaSecondAlternative, pyetjaThirdAlternative;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(co.tenton.admin.autoshkolla.R.layout.activity_test_question_result);

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

        pyetjaImage = (ImageView) findViewById(R.id.pyetja_Image);
        titulli = (TextView) findViewById(R.id.pyetja_title);
        pyetjaText = (TextView) findViewById(R.id.pyetja_Text);

        pyetjaFirstAlternative = (CheckBox) findViewById(R.id.pyetja_FirstAlternative);
        pyetjaSecondAlternative = (CheckBox) findViewById(R.id.pyetja_SecondAlternative);
        pyetjaThirdAlternative = (CheckBox) findViewById(R.id.pyetja_ThirdAlternative);


        int examIndex = getIntent().getIntExtra("examIndex",0);
        int questionIndex = getIntent().getIntExtra("questionIndex",0);

        Question q = This.exams.get(examIndex).questions.get(questionIndex);

        titulli.setText("Pyetja " + String.valueOf(questionIndex + 1) + "/30");
        pyetjaText.setText(q.name);
        if (q.image != null && !q.image.link.equals("")) {
            Picasso.with(getApplicationContext()).load(q.image.getUrl()).into(pyetjaImage);
        }
        else{
            pyetjaImage.setImageResource(R.drawable.imageplaceholder);
        }

        pyetjaFirstAlternative.setText(q.alternatives.get(0).name);
        if (q.alternatives.get(0).userAnswer == true){
            pyetjaFirstAlternative.setChecked(true);
        }
        else{
            pyetjaFirstAlternative.setChecked(false);
        }

        pyetjaSecondAlternative.setText(q.alternatives.get(1).name);
        if (q.alternatives.get(1).userAnswer == true){
            pyetjaSecondAlternative.setChecked(true);
        }
        else{
            pyetjaSecondAlternative.setChecked(false);
        }


        if (q.alternatives.size() == 3) {
            pyetjaThirdAlternative.setText(q.alternatives.get(2).name);
            if (q.alternatives.get(2).userAnswer == true){
                pyetjaThirdAlternative.setChecked(true);
            }
            else{
                pyetjaThirdAlternative.setChecked(false);
            }
        }
        else{
            pyetjaThirdAlternative.setVisibility(View.GONE);
        }

        //validate alternative

        Alternative firstAlternative = q.alternatives.get(0);
        if (firstAlternative.correctAnswer) {
            pyetjaFirstAlternative.setTextColor(Constants.successColor);
        }else if (!firstAlternative.correctAnswer && firstAlternative.userAnswer){
            pyetjaFirstAlternative.setTextColor(Constants.failedColor);
        }

        Alternative secondAlternative = q.alternatives.get(1);
        if (secondAlternative.correctAnswer) {
            pyetjaSecondAlternative.setTextColor(Constants.successColor);
        }else if (!secondAlternative.correctAnswer && secondAlternative.userAnswer){
            pyetjaSecondAlternative.setTextColor(Constants.failedColor);
        }

        if (q.alternatives.size() == 3) {
            Alternative thirdAlternative = q.alternatives.get(2);
            if (thirdAlternative.correctAnswer) {
                pyetjaThirdAlternative.setTextColor(Constants.successColor);
            }else if (!thirdAlternative.correctAnswer && thirdAlternative.userAnswer){
                pyetjaThirdAlternative.setTextColor(Constants.failedColor);
            }
        }


        pyetjaBackButton = (Button) findViewById(co.tenton.admin.autoshkolla.R.id.pyetja_Backbutton);
        pyetjaBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestQuestionResultActivity.super.onBackPressed();
            }
        });
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
