package com.example.sbt_markin_aa.edu_service_task;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class EduTaskService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();

        Thread serviceThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("[SERVICE_LOG]","OnCreate");
            }
        });
        serviceThread.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("[SERVICE_LOG]","OnStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("[SERVICE_LOG]","OnDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("[SERVICE_LOG]","OnBind");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("[SERVICE_LOG]","OnUnbind");
        return super.onUnbind(intent);
    }
}
