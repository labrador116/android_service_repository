package com.example.sbt_markin_aa.edu_service_task;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

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
}
