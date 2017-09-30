package com.manuel.retrofit.locationmanagerproject;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements LocationListener {

    private static final int MY_APP_REQUEST_LOCATION_PERMISSION = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loadLocation();


    }

    private void loadLocation() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION},
                    MY_APP_REQUEST_LOCATION_PERMISSION);
            return;
        }
        Location lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (lastLocation != null){
            Log.d("MainActivity", "Last Loc " + lastLocation.getLongitude() + " , " + lastLocation.getLatitude());
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == MY_APP_REQUEST_LOCATION_PERMISSION){
            if (Manifest.permission.ACCESS_FINE_LOCATION.equals(permissions[0]) &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED
                    &&
                    Manifest.permission.ACCESS_COARSE_LOCATION.equals(permissions[1])
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED){

                loadLocation();


            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {



    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundale) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
