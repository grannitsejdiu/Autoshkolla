package co.tenton.admin.autoshkolla.SplashScreen_Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONObject;

import co.tenton.admin.autoshkolla.MainActivitiy.Autoshkolla_MainActivity;
import co.tenton.admin.autoshkolla.MainActivity;
import co.tenton.admin.autoshkolla.Models.ErrorResponse;
import co.tenton.admin.autoshkolla.Models.Parser;
import co.tenton.admin.autoshkolla.R;
import co.tenton.admin.autoshkolla.ServiceLayer.AllLayer;
import co.tenton.admin.autoshkolla.ServiceLayer.ResponseData;

public class Welcome_Activity extends AppCompatActivity {
    Button provoPerseriBtn,filloBtn;
    TextView teksti;
    ProgressBar progressBar;
    private static int SPLASH_SCREEN_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(co.tenton.admin.autoshkolla.R.layout.activity_welcome_);

        provoPerseriBtn = (Button) findViewById(R.id.provoPerseritBtn);
        filloBtn = (Button) findViewById(R.id.filloBtn);
        teksti = (TextView) findViewById(R.id.tekst);
        progressBar = (ProgressBar) findViewById(R.id.loaderGif);


        String sharedData = Parser.getFromShared(getApplicationContext());

        if (sharedData != ""){
            Intent intent = new Intent(getApplicationContext(), Autoshkolla_MainActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        downloadContent();

        filloBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Autoshkolla_MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        provoPerseriBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadContent();
            }
        });
    }

    protected void downloadContent(){
        showLoading();

        AllLayer.getAll(new ResponseData() {
            @Override
            public void onSuccess(JSONObject data) {
                Parser.saveToShared(getApplicationContext(), data.toString());
                Parser.createFromJSONObject(data);
                showSuccess();
            }

            @Override
            public void onFailure(ErrorResponse error) {
                showError();
            }

            @Override
            public void onNotModified() {
                showSuccess();
            }
        });
    }
    protected void showError(){
        teksti.setText("Duhet të keni qasje në internet!");
        progressBar.setVisibility(View.GONE);
        filloBtn.setVisibility(View.GONE);
        provoPerseriBtn.setVisibility(View.VISIBLE);
    }
    protected void showSuccess(){
        teksti.setText("Mirë se vini !");
        progressBar.setVisibility(View.GONE);
        filloBtn.setVisibility(View.VISIBLE);
        provoPerseriBtn.setVisibility(View.GONE);
    }

    protected void showLoading(){
        teksti.setText("Ju lutem, prisni ...");
        progressBar.setVisibility(View.VISIBLE);
        filloBtn.setVisibility(View.GONE);
        provoPerseriBtn.setVisibility(View.GONE);
    }
}
