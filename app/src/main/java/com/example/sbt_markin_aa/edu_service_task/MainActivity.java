package com.example.sbt_markin_aa.edu_service_task;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.ServiceLogBroadcastReceiver broadcastReceiver = new MainActivity.ServiceLogBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        registerReceiver(broadcastReceiver,intentFilter);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.activity_main);

        if (fragment == null) {
            fragment= new MainActivityFragment();
        }
        fragmentManager.beginTransaction().add(R.id.activity_main, fragment).commit();


    }

    public class ServiceLogBroadcastReceiver extends BroadcastReceiver {
       public final static String EXTRA_LOG_STRING = "com.example.sbt_markin_aa.edu_service_task.ServiceLogBroadcastReceiver.string.log";

        @Override
        public void onReceive(Context context, Intent intent) {
            StringBuilder serviceLog = new StringBuilder();
            serviceLog.append(intent.getStringExtra(EXTRA_LOG_STRING)+"\n");

            EditText editText = (EditText) findViewById(R.id.editText);
            editText.setText(serviceLog);
        }

    }

}
