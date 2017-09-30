package com.altice.manuel.altice4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MySpinnerActivity extends AppCompatActivity {


    private Spinner mSpinner;
    private String[] data = {"Dog", "Cat", "Mouse"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_spinner);

        getSupportActionBar().setTitle(getIntent().getStringExtra(Intent.EXTRA_TITLE));
        //mSpinner = (Spinner) findViewById(R.id.my_spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //mSpinner = (Spinner) findViewById(R.id.my_button);


    }
}
