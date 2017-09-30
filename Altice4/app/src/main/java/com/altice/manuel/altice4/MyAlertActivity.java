package com.altice.manuel.altice4;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyAlertActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_alert);

        Button button = (Button) findViewById(R.id.my_button);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick (View view){
        AlertDialog alert = new AlertDialog.Builder(this)
                .setTitle("Titulo")
                .setMessage("Mensaje")
                .setPositiveButton("YES", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        Toast.makeText(MyAlertActivity.this, "Positive Message", Toast.LENGTH_SHORT).show();;
                    }

                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        Toast.makeText(MyAlertActivity.this, "Negative Message", Toast.LENGTH_SHORT).show();;
                    }

                })
                .setNeutralButton("CANCEL", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        Toast.makeText(MyAlertActivity.this, "Negative Message", Toast.LENGTH_SHORT).show();;
                    }

                })
                .create();
        alert.show();
    }
}
