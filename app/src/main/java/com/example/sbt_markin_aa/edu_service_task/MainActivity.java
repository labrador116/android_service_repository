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

    MainActivity.ServiceLogBroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.activity_main);

        if (fragment == null) {
            fragment= new MainActivityFragment();
        }
        fragmentManager.beginTransaction().add(R.id.activity_main, fragment).commit();


    }

    @Override
    protected void onResume() {
        super.onResume();
        broadcastReceiver = new MainActivity.ServiceLogBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MainActivity.ServiceLogBroadcastReceiver.EXTRA_LOG_STRING);
        registerReceiver(broadcastReceiver,intentFilter);
    }

    public class ServiceLogBroadcastReceiver extends BroadcastReceiver {
       public final static String EXTRA_LOG_STRING = "com.example.sbt_markin_aa.edu_service_task.ServiceLogBroadcastReceiver.string.log";
        StringBuilder serviceLog = new StringBuilder();

        @Override
        public void onReceive(Context context, Intent intent) {
            serviceLog.append(intent.getStringExtra(EXTRA_LOG_STRING)+"\n");
            EditText editText = (EditText) findViewById(R.id.editText);
            editText.setText(serviceLog);
        }

    }

}
