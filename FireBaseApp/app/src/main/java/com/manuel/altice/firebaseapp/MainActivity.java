package com.manuel.altice.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private int counterObject = 0;
    FirebaseDatabase firebaseDataBase;
    DatabaseReference databaseReference;
    DatabaseReference databaseReference2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseDataBase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDataBase.getReference("message");
        databaseReference2 = firebaseDataBase.getReference("objects");

        String lastKey = databaseReference2.getKey();
        Log.d("MainActivity", lastKey);

        findViewById(R.id.add_data_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.setValue("Hello, World "+ counter);
                //Log.d("MainActivity","Hello, World agregado a la base de datos");
                counter++;
            }
        });

        findViewById(R.id.add_object_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeNewUser(String.valueOf(counterObject), "User: "+counterObject, "user"+counterObject+"@example.com");
                //Log.d("MainActivity","Un objeto ha sido agregado a la Base de Datos");
                counterObject++;
            }
        });

        findViewById(R.id.change_user_name_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userNameEditText = (EditText) findViewById(R.id.change_user_name_editText);
                String newUsername = userNameEditText.getText().toString();
                if (!"".equals(newUsername)){
                    writeNewUser(String.valueOf(counterObject), newUsername, "user1@example.com");
                    Log.d("MainActivityObjects","username del user 1 cambiado a: " + newUsername);
                }
            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String res = dataSnapshot.getValue(String.class);
                Log.d("MainActivityResponse", "Response: "+res);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("MainActivityResponse", "Hubo un error en el proceso");
                Log.d("MainActivityResponse",databaseError.toString());
            }

        });

        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                /*GenericTypeIndicator<HashMap<String,String>> t = new GenericTypeIndicator<HashMap<String, String>>() {};
                HashMap<String,String> res = dataSnapshot.child("objects").child("objects").getValue(t);*/
                GenericTypeIndicator<List<User>> t = new GenericTypeIndicator<List<User>>() {};
                Map<String,User> map = (Map<String, User>) dataSnapshot.getValue();
                ArrayList<User> list = new ArrayList<User>(map.values());
                Log.d("MainActivityObject", "Response: "+list.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("MainActivityResponse",databaseError.toString());
            }
        });

        findViewById(R.id.start_login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //ArrayList<User> usrs = databaseReference2.child("objects");

    }
    private void writeNewUser(String userId, String name, String email) {
        User user = new User("Username "+counterObject, email);
        //databaseReference2.child("objects").child(userId).setValue(user);
        databaseReference2.child("objects").push().setValue(user);
        Log.d("MainActivityObjects",""+user+" ha sido agregado a la base de datos");
    }

}
