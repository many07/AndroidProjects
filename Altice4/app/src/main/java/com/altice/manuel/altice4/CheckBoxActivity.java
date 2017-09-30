package com.altice.manuel.altice4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class CheckBoxActivity extends AppCompatActivity implements View.OnClickListener{

    private CheckBox mMyCheckBox;
    private ToggleButton mToggleButton;
    private RadioGroup mRadioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        mMyCheckBox = (CheckBox) findViewById(R.id.my_checkbox);
        findViewById(R.id.my_checkbox_status_button).setOnClickListener(this);

        mToggleButton = (ToggleButton) findViewById(R.id.my_toggle_button);
        findViewById(R.id.my_toggle_button_status_button).setOnClickListener(this);

        mRadioGroup = (RadioGroup) findViewById(R.id.my_radio_group);
        findViewById(R.id.my_radio_group_status_button);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.my_checkbox_status_button){
            Toast.makeText(this, mMyCheckBox.isChecked() ? "Checked" : "Not Checked", Toast.LENGTH_SHORT).show();
        }else if(v.getId()==R.id.my_toggle_button_status_button){
            Toast.makeText(this, mToggleButton.isChecked() ? mToggleButton.getTextOn().toString() : mToggleButton.getTextOff().toString(), Toast.LENGTH_SHORT).show();
        }else if(v.getId()==R.id.my_radio_group_status_button){
            RadioButton selected = (RadioButton) findViewById(mRadioGroup.getCheckedRadioButtonId());
            if(selected!=null){
                Toast.makeText(this,"Selected: "+selected.getText(), Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Please Select an animal",Toast.LENGTH_SHORT).show();
            }
        }

    }
}
