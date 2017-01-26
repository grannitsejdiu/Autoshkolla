package co.tenton.admin.autoshkolla.MainActivitiy;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import co.tenton.admin.autoshkolla.Models.ErrorResponse;
import co.tenton.admin.autoshkolla.R;
import co.tenton.admin.autoshkolla.ServiceLayer.ReportLayer;
import co.tenton.admin.autoshkolla.ServiceLayer.ResponseData;

public class Raporto_Activity extends AppCompatActivity {
    Button raportoBackBtn,raportoDergo;
    EditText raportoMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raporto_);

        raportoMessage = (EditText) findViewById(R.id.raportoMessage);
        raportoDergo = (Button) findViewById(R.id.raportoDergo);

        raportoBackBtn = (Button) findViewById(R.id.raportoBackBtn);
        raportoBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Raporto_Activity.super.onBackPressed();
            }
        });

        raportoDergo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (raportoMessage.getText().toString().equals("")){
                    Toast.makeText(Raporto_Activity.this,"Te lutem, shkruaj problemin apo sygjerimin qe deshironi te raportoni.",Toast.LENGTH_SHORT).show();
                    return;
                }

                final ProgressDialog pDialog = new ProgressDialog(Raporto_Activity.this);
                pDialog.setTitle("Ju lutem, prisni");
                pDialog.setMessage("Raportimi eshte duke u derguar.");
                pDialog.setCancelable(false);
                pDialog.show();
                ReportLayer.report(raportoMessage.getText().toString(), new ResponseData() {
                    @Override
                    public void onSuccess(JSONObject data) {
                        if (pDialog.isShowing()){
                            pDialog.dismiss();
                        }
                        Toast.makeText(Raporto_Activity.this,"Ju faleminderit për raportimin tuaj!",Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(ErrorResponse error) {
                        if (pDialog.isShowing()){
                            pDialog.dismiss();
                        }
                        Toast.makeText(Raporto_Activity.this,error.message,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNotModified() {

                    }
                });
            }
        });
    }
}
