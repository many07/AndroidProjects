package com.manuel.retrofit.mygpsproject;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int MY_APP_REQUEST_LOCATION_PERMISSION = 0X1001;
    FusedLocationProviderClient locationProviderClient;
    private LocationCallback mLocarionCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadLocation();

        mLocarionCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                Location lastLocation = locationResult.getLastLocation();
                List<Location> locations = locationResult.getLocations();

                printLocation("Last Location: ", lastLocation);

                for (Location location : locations) {
                    printLocation("Current Location: ", location);
                }

            }
        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationProviderClient
                .getLastLocation()
                .addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        Location result = task.getResult();
                        printLocation("Last Location Only: ", result);
                    }
                });

        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(1000);

        locationProviderClient.requestLocationUpdates(locationRequest, mLocarionCallback, null);



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == MY_APP_REQUEST_LOCATION_PERMISSION){
            int i = 0;
            boolean locationEnabled = false;
            for (String permission: permissions){
                if (permission.equals(Manifest.permission.ACCESS_COARSE_LOCATION)||
                        permission.equals(Manifest.permission.ACCESS_COARSE_LOCATION)){
                    locationEnabled &= grantResults[i] == PackageManager.PERMISSION_GRANTED;

                }
                i++;
            }
            if (locationEnabled){
                loadLocation();
            }
        }
    }

    private void loadLocation() {
        locationProviderClient = LocationServices
                .getFusedLocationProviderClient(this);

        LocationRequest locationRequest = new LocationRequest();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},
                    MY_APP_REQUEST_LOCATION_PERMISSION);



            return;
        }
        locationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location result = task.getResult();
                if (result!=null)
                    printLocation("Resultado: ",result);
            }
        });
    }

    private void printLocation(String indix, Location result) {
        Log.d("MainActivity",indix+ result.getLatitude() + " , " + result.getLongitude());
    }
}
