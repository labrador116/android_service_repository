package com.example.sbt_markin_aa.edu_service_task;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
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
        Intent logMessage = new Intent();
        logMessage.setAction(MainActivity.ServiceLogBroadcastReceiver.EXTRA_LOG_STRING);
        logMessage.putExtra(MainActivity.ServiceLogBroadcastReceiver.EXTRA_LOG_STRING,"OnCreate");
        sendOrderedBroadcast(logMessage,null);
        serviceThread.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("[SERVICE_LOG]","OnStartCommand");
        Intent logMessage = new Intent();
        logMessage.setAction(MainActivity.ServiceLogBroadcastReceiver.EXTRA_LOG_STRING);
        logMessage.putExtra(MainActivity.ServiceLogBroadcastReceiver.EXTRA_LOG_STRING,"OnStartCommand");
        sendOrderedBroadcast(logMessage,null);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("[SERVICE_LOG]","OnDestroy");
        Intent logMessage = new Intent();
        logMessage.setAction(MainActivity.ServiceLogBroadcastReceiver.EXTRA_LOG_STRING);
        logMessage.putExtra(MainActivity.ServiceLogBroadcastReceiver.EXTRA_LOG_STRING,"OnDestroy");
        sendOrderedBroadcast(logMessage,null);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("[SERVICE_LOG]","OnBind");
        Intent logMessage = new Intent();
        logMessage.setAction(MainActivity.ServiceLogBroadcastReceiver.EXTRA_LOG_STRING);
        logMessage.putExtra(MainActivity.ServiceLogBroadcastReceiver.EXTRA_LOG_STRING,"OnBind");
        sendOrderedBroadcast(logMessage,null);
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("[SERVICE_LOG]","OnUnbind");
        Intent logMessage = new Intent();
        logMessage.setAction(MainActivity.ServiceLogBroadcastReceiver.EXTRA_LOG_STRING);
        logMessage.putExtra(MainActivity.ServiceLogBroadcastReceiver.EXTRA_LOG_STRING,"OnUnbind");
        sendOrderedBroadcast(logMessage,null);
        return super.onUnbind(intent);
    }
}
