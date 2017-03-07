package com.example.sbt_markin_aa.edu_service_task;

import android.app.IntentService;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;


public class EduTaskIntentService extends IntentService {


    public class LocalBinder extends Binder {
        EduTaskIntentService getService() {
            return EduTaskIntentService.this;
        }
    }

    public EduTaskIntentService() {
        super("EduIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("[SERVICE_LOG]","EXECUTE");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d("[SERVICE_LOG]","EXECUTED");
        Intent logMessage = new Intent();
        logMessage.putExtra(MainActivity.ServiceLogBroadcastReceiver.EXTRA_LOG_STRING,"EXECUTED");
        sendBroadcast(logMessage);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("[SERVICE_LOG]","OnCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d("[SERVICE_LOG]","OnStart");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("[SERVICE_LOG]","OnUnbind");
        return super.onUnbind(intent);
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
        return super.onBind(intent);

    }




}
