package com.altice.rssproject.asynctaskproject;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /*En esta practica hay que hacer el AsyncTask en una clase diferente*/

    EditText editTextPrimo;
    Button botonPrimo;
    TextView textViewPrimo;
    TextView primoTotal;
    AsyncTask<Integer, String, String> asyncTask;
    AsyncTaskPrimos primosAsyncTask;

    class AsyncTaskPrimos extends AsyncTask<Integer, String, String>{

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
            Log.d("MainActivity","Starting...");
        }

        @Override
        protected void onPostExecute(String s) {
            primoTotal.setText(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            for (String v: values){
                textViewPrimo.setText(v);
            }
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

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPrimo = (EditText) findViewById(R.id.edit_text_primo);
        botonPrimo = (Button) findViewById(R.id.boton_primo);
        textViewPrimo = (TextView) findViewById(R.id.x_es_primo);
        primoTotal = (TextView) findViewById(R.id.n_es_primo);

        botonPrimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(editTextPrimo.getText().toString());
                primosAsyncTask = new AsyncTaskPrimos();
                primosAsyncTask.execute(n);
            }
        });

    }

}
