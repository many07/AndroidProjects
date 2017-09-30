package com.altice.manuel.altice4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TimePicker;

public class TimePickerActivity extends AppCompatActivity implements View.OnClickListener{


    private TimePicker mTimePicker;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

        getSupportActionBar().setTitle(getIntent().getStringExtra(Intent.EXTRA_TITLE));

        mTimePicker = (TimePicker) findViewById(R.id.my_time_picker);
        findViewById(R.id.my_button).setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        StringBuilder sb = new StringBuilder();
    }
}
