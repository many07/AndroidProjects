package com.altice.manuel.altice4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MyAutoCompleteTextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_auto_complete_text_view);
        String[] data = {"Cat", "Dog", "Mouse"};
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.auto_ctv);
        autoCompleteTextView.setAdapter(new ArrayAdapter<>(this, android.R.layout.select_dialog_item, data));
        autoCompleteTextView.setThreshold(1);

        Intent recieveIntent = getIntent();
        String value = recieveIntent.getStringExtra("stringVal");
        Bundle bundle = recieveIntent.getBundleExtra("bundleVal");

        autoCompleteTextView.setHint(bundle.getString("name"));



    }
}
