package co.tenton.admin.autoshkolla.MainActivitiy;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import co.tenton.admin.autoshkolla.R;

public class Preferencat_Activity extends AppCompatActivity {
    Button preferencatBackButton, autoshkolla_fb,autoshkolla_email;
    RelativeLayout editoPreferencat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencat_);

        preferencatBackButton = (Button) findViewById(R.id.preferencat_FormBackButton);
        preferencatBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Preferencat_Activity.super.onBackPressed();
            }
        });

        editoPreferencat = (RelativeLayout) findViewById(R.id.editoPreferencat);
        editoPreferencat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", getPackageName(), null);
                intent.setData(uri);
                startActivity(intent);
            }
        });

        autoshkolla_fb = (Button) findViewById(R.id.autoshkolla_fb);
        autoshkolla_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fbIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.autoshkolla-ks.com"));
                startActivity(fbIntent);
            }
        });

        autoshkolla_email = (Button) findViewById(R.id.autoshkolla_email);
        autoshkolla_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "info@autoshkolla-ks.com" });
//                intent.putExtra(Intent.EXTRA_SUBJECT, "Email");
//                intent.putExtra(Intent.EXTRA_TEXT, "Shkruani messazhin ketu");
                startActivity(Intent.createChooser(intent, ""));
            }
        });
    }
}
