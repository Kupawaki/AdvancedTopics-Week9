package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mainBTN = findViewById(R.id.mainBTN);

        mainBTN.setOnClickListener(view ->
        {
            Intent ini = new Intent(MainActivity.this, NotifiActivity.class);
            ini.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            ini.putExtra("message", "You've Done It Now!");

            NotificationChannel mChannel = new NotificationChannel("MyChannel", "MyChannel", NotificationManager.IMPORTANCE_DEFAULT);
            mChannel.setDescription("My Channel");
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            mChannel.setShowBadge(false);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "MyChannel")
                    .setSmallIcon(R.drawable.ic_android)
                    .setContentTitle("You should not have done that")
                    .setContentText("This is very bad")
                    .setAutoCancel(true);

            PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, ini, PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pendingIntent);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, builder.build());

            notificationManager.createNotificationChannel(mChannel);
        });
    }
}