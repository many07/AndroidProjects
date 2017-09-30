package com.altice.rssproject.rssproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    String urlPeriodico;
    String nombrePeriodico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerPeriodicos = (Spinner) findViewById(R.id.spinner_periodicos);
        Button botonSpinner = (Button) findViewById(R.id.boton_buscar_spinner);

        spinnerPeriodicos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        urlPeriodico = "https://www.diariolibre.com/rss/portada.xml";
                        nombrePeriodico = "Diario Libre";
                        break;
                    case 1:
                        urlPeriodico = "http://www.listindiario.com/rss/portada/";
                        nombrePeriodico = "Listin Diario";
                        break;
                    case 2:
                        urlPeriodico = "http://elnacional.com.do/feed";
                        nombrePeriodico = "El Nacional";
                        break;
                    case 3:
                        urlPeriodico = "http://hoy.com.do/feed";
                        nombrePeriodico = "Hoy";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                urlPeriodico = "";
                nombrePeriodico = "";
            }
        });

        botonSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RSSActivity.class);
                i.putExtra("url",urlPeriodico);
                i.putExtra("nombrePeriodico",nombrePeriodico);
                startActivity(i);
            }
        });



    }
}
