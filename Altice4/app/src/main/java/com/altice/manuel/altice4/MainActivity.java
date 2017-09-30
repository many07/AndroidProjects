package com.altice.manuel.altice4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(this, CheckBoxActivity.class);
        startActivity(i);
        /*Intent i = new Intent(this, MyAutoCompleteTextViewActivity.class);
        i.putExtra("boolVal", false);
        i.putExtra("stringVAl", "este es el nuevo hint");

        Bundle b = new Bundle();
        b.putString("name","texto");
        b.putString("surname","Nombre");
        b.putString("hintReal","Este debería ser el hint");

        i.putExtra("bundleVal", b);
        startActivity(i);*/

    }
}
