package co.tenton.admin.autoshkolla.MainActivitiy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import co.tenton.admin.autoshkolla.R;

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
                Toast.makeText(Raporto_Activity.this,"Dergo Button Clicked!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
