package com.example.sbt_markin_aa.edu_service_task;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivityFragment extends Fragment {
    private Intent mIntent;
    private EduTaskIntentService myService;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myService = ((EduTaskIntentService.LocalBinder)service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myService=null;
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_fragment,container, false);

        Button buttonStartStarted = (Button) view.findViewById(R.id.start_started);
        Button buttonStopStarted = (Button) view.findViewById(R.id.stop_started);
        Button buttonBindBound = (Button) view.findViewById(R.id.bind_bound);
        Button buttonUnbindBound = (Button) view.findViewById(R.id.unbind_bound);
        Button buttonStartStartedBound = (Button) view.findViewById(R.id.start_started_bound);
        Button buttonStopStartedBound = (Button) view.findViewById(R.id.stop_started_bound);
        Button buttonBindStartedBound = (Button) view.findViewById(R.id.bind_started_bound);
        Button buttonUnbindStartedBound = (Button) view.findViewById(R.id.unbind_started_bound);

        mIntent =new Intent(getContext(), EduTaskService.class);

        buttonStartStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startService(mIntent);

            }
        });

        buttonStopStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().stopService(mIntent);
            }
        });

        buttonBindBound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().bindService(mIntent,mServiceConnection,Context.BIND_AUTO_CREATE);
            }
        });

        buttonUnbindBound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().unbindService(mServiceConnection);
            }
        });

        /*************************************************************************************/

        buttonStartStartedBound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startService(mIntent);
            }
        });

        buttonStopStartedBound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().stopService(mIntent);
            }
        });

        buttonBindStartedBound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().bindService(mIntent,mServiceConnection,Context.BIND_AUTO_CREATE);
            }
        });
        buttonUnbindStartedBound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().unbindService(mServiceConnection);
            }
        });


        return view;
    }
}
