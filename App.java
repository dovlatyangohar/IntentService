package com.example.intentservice;

import android.app.Application;
import android.os.Build;
import android.app.NotificationChannel;
import android.app.NotificationManager;

import androidx.core.app.NotificationManagerCompat;


public class App extends Application {
    public static final String CHANNEL_ID = "exampleServiceChanel";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Example service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT

            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
        }
    }
}
