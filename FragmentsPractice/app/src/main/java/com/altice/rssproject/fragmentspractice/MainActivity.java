package com.altice.rssproject.fragmentspractice;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BlueFragment.OnFragmentInteractionListener,
        RedFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button redButton = (Button) findViewById(R.id.red_boton);
        Button blueButton = (Button) findViewById(R.id.blue_boton);

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.my_frame_layout, RedFragment.newInstance("1","2"))
                        .addToBackStack(null)
                        .commit();
            }
        });

        //Se le agrega un OnClickListener para cambiar el Fragment a
        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.my_frame_layout, BlueFragment.newInstance("3","4"))
                        .addToBackStack(null)
                        .commit();
            }
        });

    }

    @Override
    public void onBackPressed(){
        if (getSupportFragmentManager().getBackStackEntryCount() > 0){
            getSupportFragmentManager().popBackStack();
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onRedFragmentInteractionClicked() {
        Toast.makeText(this, "Red Button Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBlueFragmentButtonClicked() {
        Toast.makeText(this, "Blue Button Clicked", Toast.LENGTH_SHORT).show();
    }
}
