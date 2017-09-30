package com.altice.rssproject.serviceproject;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyCounterService.MyCounterListener{

    MyCounterService myCounterService;

    boolean running = false;
    TextView mTextView;
    Button botonStartStop;
    Button stopServiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonStartStop = (Button) findViewById(R.id.my_button);
        mTextView = (TextView) findViewById(R.id.my_text_view);
        stopServiceButton = (Button) findViewById(R.id.button_stop_service);

        Intent intent = new Intent(this, MyCounterService.class);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);

        botonStartStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myCounterService!=null && myCounterService.isRunning()){
                    stopService();
                }else{
                    Intent intent = new Intent(MainActivity.this, MyCounterService.class);
                    intent.setAction(myCounterService.START_COUNTER);
                    //bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
                    startService(intent);
                    botonStartStop.setText("STOP");
                    //mTextView.setText("Counter is: " + myCounterService.getCounter());
                    running = true;
                }
            }
        });

        stopServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService();
                myCounterService.setCounter(0);
                mTextView.setText("Current Value: "+ 0);
            }
        });

    }

    private void stopService(){
        Intent intent = new Intent(MainActivity.this, MyCounterService.class);
        intent.setAction(myCounterService.STOP_COUNTER);
        startService(intent);
        //bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
        botonStartStop.setText("START");
        mTextView.setText("Counter is: " + myCounterService.getCounter());
        running = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder instanceof MyCounterService.MyCounterBinder){
                myCounterService = ((MyCounterService.MyCounterBinder) iBinder).getService();

                myCounterService.setCounterListener(MainActivity.this);

                mTextView.setText("Current Counter: "+myCounterService.getCounter());
                if (myCounterService!=null && myCounterService.isRunning()){
                    botonStartStop.setText("STOP");
                }else{
                    botonStartStop.setText("START");
                }


            }
            Log.d("MainActivity", "Service Connected");

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("MainActivity", "Service DisConnected");
        }
    };

    @Override
    public void onCurrentValue(Integer value) {

        mTextView.setText("Current Value: "+value);
    }
}
