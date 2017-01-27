package co.tenton.admin.autoshkolla.MainActivitiy;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import co.tenton.admin.autoshkolla.Models.ErrorResponse;
import co.tenton.admin.autoshkolla.Models.GA;
import co.tenton.admin.autoshkolla.Models.Parser;
import co.tenton.admin.autoshkolla.R;
import co.tenton.admin.autoshkolla.ServiceLayer.AllLayer;
import co.tenton.admin.autoshkolla.ServiceLayer.ResponseData;
import co.tenton.admin.autoshkolla.TestetActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.json.JSONException;
import org.json.JSONObject;

public class Autoshkolla_MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Button shareApp;
    Button menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autoshkolla__main);

        GA.TrackScreen("Main VC");

        SharedPreferences sharedPreferences = getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        shareApp = (Button) findViewById(R.id.shareAutoshkolla);
        shareApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GA.TrackAction("Main VC","Hit Share Button","");

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String appLink = "http://autoshkolla-ks.com/";
                String shareBody = "Aplikacioni Autoshkolla, për iOS dhe Android. : \n\n";
                 String shareSubject = "Autoshkolla : ";
                intent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                intent.putExtra(Intent.EXTRA_TEXT, shareBody + appLink);
                startActivity(Intent.createChooser(intent,"Shpërndaje Autoshkolla me ... "));
            }
        });


        menu = (Button) findViewById(R.id.main_menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                PopupMenu popupMenu = new PopupMenu(Autoshkolla_MainActivity.this,menu);
                popupMenu.getMenuInflater().inflate(R.menu.main_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.menu_preferencat:
                                Intent intent1 = new Intent(Autoshkolla_MainActivity.this, Preferencat_Activity.class);
                                startActivity(intent1);
                                break;
                            case R.id.menu_raporto:
                                Intent intent = new Intent(view.getContext().getApplicationContext(), Raporto_Activity.class);
                                view.getContext().startActivity(intent);
                                break;
                            case R.id.menu_vlereso:
                                final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                                try {
                                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                                } catch (android.content.ActivityNotFoundException anfe) {
                                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                                }

                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });


        // fill from local repository
        String response = Parser.getFromShared(getApplicationContext());
        if (!response.equals("")){
            try {
                JSONObject data = new JSONObject(response);
                Parser.createFromJSONObject(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        AllLayer.getAll(new ResponseData() {
            @Override
            public void onSuccess(JSONObject data) {
                Parser.saveToShared(getApplicationContext(), data.toString());
                Parser.createFromJSONObject(data);
            }

            @Override
            public void onNotModified() {
                Log.e("Not modified","Your updated");

            }

            @Override
            public void onFailure(ErrorResponse error) {

                Log.e("Failed", error.message);
            }
        });

        recyclerView= (RecyclerView) findViewById(R.id.recyclerViewMain);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Autoshkolla_MainRecyclerAdapter();
        recyclerView.setAdapter(adapter);

    }


}
