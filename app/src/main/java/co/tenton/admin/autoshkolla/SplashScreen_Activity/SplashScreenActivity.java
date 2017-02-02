package co.tenton.admin.autoshkolla.SplashScreen_Activity;


import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Calendar;

import co.tenton.admin.autoshkolla.LocalNotification.AlarmReceiver;
import co.tenton.admin.autoshkolla.MainActivitiy.Autoshkolla_MainActivity;
import co.tenton.admin.autoshkolla.Models.Parser;
import co.tenton.admin.autoshkolla.R;

public class SplashScreenActivity extends AppCompatActivity {


    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        notificationManager.cancelAll();

        final String AlarmID = "AlarmID001";

        if (Build.VERSION.SDK_INT >= 19) {
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Intent notificationIntent = new Intent("android.media.action.DISPLAY_NOTIFICATION");
            notificationIntent.addCategory("android.intent.category.DEFAULT");

            PendingIntent broadcast = PendingIntent.getBroadcast(this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager.cancel(broadcast);

            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.HOUR, 120);
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);
        }

        String sharedData = Parser.getFromShared(getApplicationContext());

        if (!sharedData.equals("")){
            Intent intent = new Intent(getApplicationContext(), Autoshkolla_MainActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        else {
            Intent intent = new Intent(getApplicationContext(), Welcome_Activity.class);
            startActivity(intent);
            finish();
            return;
        }

    }

}
