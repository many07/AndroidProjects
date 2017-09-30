package com.altice.manuel.rssreader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonDiarioLibre = (Button) findViewById(R.id.boton_diario_libre);
        Button botonListinDiario = (Button) findViewById(R.id.boton_listin_diario);
        Button botonElNacional = (Button) findViewById(R.id.boton_el_nacional);
        Button botonHoy = (Button) findViewById(R.id.boton_hoy);

        botonDiarioLibre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TitulosRSSActivity.class);
                i.putExtra("url", "https://www.diariolibre.com/rss/portada.xml");
                startActivity(i);

            }
        });

        botonListinDiario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TitulosRSSActivity.class);
                i.putExtra("url", "http://www.listindiario.com/rss/portada/");
                startActivity(i);
            }
        });
        botonElNacional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TitulosRSSActivity.class);
                i.putExtra("url", "http://elnacional.com.do/feed");
                startActivity(i);
            }
        });

        botonHoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TitulosRSSActivity.class);
                i.putExtra("url", "http://hoy.com.do/feed");
                startActivity(i);

            }
        });

    }
}
