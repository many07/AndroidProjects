package com.manuel.altice.fireapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button mSendData;
    private DatabaseReference databaseReference;
    private Integer counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase fbdb = FirebaseDatabase.getInstance();

        DatabaseReference myRef = fbdb.getReference("tabla");

        databaseReference = FirebaseDatabase.getInstance().getReference();

        mSendData = (Button) findViewById(R.id.send_data);

        mSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewUser(String.valueOf(counter), "Usuario "+counter, "correo"+counter+"@ejemplo.com");
                counter++;
            }
        });
    }

    private void createNewUser(String userId, String name, String email){
        User user = new User(name, email);

        databaseReference.child("users").child(userId).setValue(user);

        Log.d("MainActivity", "Valor Agregado: "+user);
    }

}
