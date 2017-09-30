package com.altice.rssproject.serviceproject;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.IntDef;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class MyCounterService extends Service implements Runnable{

    private MyCounterBinder mBinder = new MyCounterBinder();
    private MyCounterListener listener;

    public static final String START_COUNTER = "START_COUNTER";
    public static final String STOP_COUNTER = "STOP_COUNTER";

    private Integer counter;
    private boolean running;

    Handler mHandler;

    public MyCounterService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mHandler = new Handler(Looper.myLooper());
        counter = 0;
    }

    private void publishNotification() {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Example")
                        .setContentText("My counter is " + counter);
        Intent targetIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent
                .getActivity(this, 0, targetIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(contentIntent);

        // ID Must be Greater than 0
        startForeground(1, mBuilder.build());
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return mBinder;

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(START_COUNTER.equals(intent.getAction())){
            mHandler.post(this);
            running = true;
        }else if(STOP_COUNTER.equals(intent.getAction())){
            mHandler.removeCallbacks(this);
            running = false;
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("CounterService","Service Destroyed");
    }

    @Override
    public void run() {
        counter++;
        mHandler.postDelayed(this,500);

        if (this.listener!=null){
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    listener.onCurrentValue(counter);
                    publishNotification();
                }
            });
        }


    }


    public class MyCounterBinder extends Binder{

        public MyCounterService getService(){
            return MyCounterService.this;
        }

    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public boolean isRunning() {
        return running;
    }

    public void setCounterListener(MyCounterListener listener){
        this.listener = listener;
    }

    public interface MyCounterListener{
        void onCurrentValue(Integer value);
    }
}
