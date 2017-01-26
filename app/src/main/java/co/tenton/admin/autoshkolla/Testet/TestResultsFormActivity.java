package co.tenton.admin.autoshkolla.Testet;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.io.File;
import java.io.FileOutputStream;

import co.tenton.admin.autoshkolla.Models.Constants;
import co.tenton.admin.autoshkolla.Models.Exam;
import co.tenton.admin.autoshkolla.Models.This;
import co.tenton.admin.autoshkolla.R;

public class TestResultsFormActivity extends AppCompatActivity {

    private String TAG = TestResultsFormActivity.class.getSimpleName();
    InterstitialAd mInterstitialAd;

    Button closeButtonTestResultsForm;
    ProgressBar progressBar;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Button shareTestResults;
    private AdView mAdView;
    TextView testResultFormTitle;

    Exam selectedExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_results_form);

        mAdView = (AdView) findViewById(R.id.adView);
        mInterstitialAd = new InterstitialAd(this);
        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
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

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest);
        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });



        int examId = getIntent().getIntExtra("index",0);
        selectedExam = This.exams.get(examId);

        selectedExam.saveResults(getApplicationContext()); //save exam results

        recyclerView= (RecyclerView) findViewById(R.id.recyclerViewTestFormResult);

        recyclerView.setHasFixedSize(true);
        GridLayoutManager glm=new GridLayoutManager(this,10);
        recyclerView.setLayoutManager(glm);
        adapter = new TestResultsForm_RecyclerAdapter(selectedExam.questions, examId);
        recyclerView.setAdapter(adapter);

        checkResults();

        closeButtonTestResultsForm = (Button) findViewById(R.id.closeButtonTestResultsForm);
        closeButtonTestResultsForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestResultsFormActivity.super.onBackPressed();
            }
        });

        shareTestResults = (Button) findViewById(R.id.shareTestResults);
        shareTestResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bitmap bm = screenShot(view.getRootView());
                File file = saveBitmap(bm, "rezultatet.png");
                Log.i("chase", "filepath: "+file.getAbsolutePath());
                Uri uri = Uri.fromFile(new File(file.getAbsolutePath()));
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Rezultatet!");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Gjatë testimit tim për patent shofer në aplikacionin Autoshkolla, " +
                        "në " + selectedExam.name + ", kam arritur rezultat prej " + selectedExam.pointsResults() +
                " pikëve nga 100. \n\nAplikacionin mund ta shkarkoni në linkun: www.autoshkolla.com");
                shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                shareIntent.setType("image/*");
                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(Intent.createChooser(shareIntent, "Shperndaji rezultet me :"));
            }
        });

        testResultFormTitle = (TextView) findViewById(R.id.testFormResultTitle);
        int testTitle = examId + 1;
        testResultFormTitle.setText(String.valueOf("Rezultati për Testin " + testTitle));


        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        startAnimation();
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }


    private Bitmap screenShot(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(),view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }

    private static File saveBitmap(Bitmap bm, String fileName){
        final String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Screenshots";
        File dir = new File(path);
        if(!dir.exists())
            dir.mkdirs();
        File file = new File(dir, fileName);
        try {
            FileOutputStream fOut = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.PNG, 90, fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }


    private void checkResults() {

    }

    private void startAnimation(){
        ProgressBar mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        TextView  progressBarPercentage = (TextView) findViewById(R.id.progressBarPercentage);

        int progressBarValue = selectedExam.pointsResults();

        ObjectAnimator progressAnimator = ObjectAnimator.ofInt(mProgressBar, "progress", 0, progressBarValue);
        progressAnimator.setDuration(1000);

        if (progressBarValue >= 90){
            mProgressBar.setProgressDrawable(getResources().getDrawable(R.drawable.circular_green_progressbar));
            progressBarPercentage.setTextColor(Constants.successColor);
            progressBarPercentage.setText(progressBarValue + "%");

        }
        else{
            mProgressBar.setProgressDrawable(getResources().getDrawable(R.drawable.circular_progress_bar));
            progressBarPercentage.setTextColor(Constants.failedColor);
            progressBarPercentage.setText(progressBarValue + "%");
        }

        progressAnimator.setInterpolator(new LinearInterpolator());
        progressAnimator.start();
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
