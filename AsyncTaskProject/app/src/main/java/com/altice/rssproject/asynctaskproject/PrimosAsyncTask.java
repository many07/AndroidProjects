package com.altice.rssproject.asynctaskproject;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Manuel on 7/31/2017.
 */

public class PrimosAsyncTask extends AsyncTask<Integer, String, String> implements AsyncUpdates{


    @Override
    protected String doInBackground(Integer... n) {

        Integer num = n[0];
        String val = "";
        for (Integer i=1; i<=num ;i++) {
            if (isPrime(i))
                val = i + " Es primo";
            else {
                val = i + " No es primo";
            }
            publishProgress(val);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return val;
    }

    @Override
    protected void onPreExecute() {
        //super.onPreExecute();
        antesDeLaTarea();
    }

    @Override
    protected void onPostExecute(String aString) {
        //super.onPostExecute(aBoolean);
        desPuesDeLaTarea(aString);
    }

    @Override
    protected void onProgressUpdate(String... values) {
        duranteLaTarea(values);
    }

    private boolean isPrime(int n){
        if (n%2==0) return false;

        for (int i=3; i*i<=n; i+=2){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }

    @Override
    public void antesDeLaTarea() {

    }

    @Override
    public void duranteLaTarea(String... aString) {

    }

    @Override
    public void desPuesDeLaTarea(String values) {

    }


}
