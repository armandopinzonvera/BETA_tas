package com.tracking.beta_tas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class Act2mapa extends AppCompatActivity {

    public static final int DEFAUL_UPDATE_INTERVAL = 30;
    public static final int FAST_UPDATE_INTERVAL = 50;
    private static final int PERMISSIONS_FINE_LOCATION = 99;
    TextView tv_lat, tv_lon, tv_alt, tv_acc, tv_sped, tv_adre, tv_sensor;
    Switch sw_locationUpdate, sw_gps;
    LocationRequest locationRequest;
    FusedLocationProviderClient fusedLocationProviderClient;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2mapa);

       locationRequest = new LocationRequest();

        tv_lat = (TextView) findViewById(R.id.tv_latitud2);
        tv_lon =  (TextView)findViewById(R.id.tv_longitud);
        tv_alt =  (TextView)findViewById(R.id.tv_altura);
        tv_acc =  (TextView)findViewById(R.id.tv_accuracy);
        tv_sped = (TextView) findViewById(R.id.tv_speed);
        tv_adre =  (TextView)findViewById(R.id.tv_address);
        tv_sensor=  (TextView)findViewById(R.id.tv_sensor);
        sw_locationUpdate= findViewById(R.id.sw_locationUpdate);
        sw_gps= findViewById(R.id.sw_gps);


        locationRequest.setInterval(1000*DEFAUL_UPDATE_INTERVAL);
        locationRequest.setFastestInterval(1000* FAST_UPDATE_INTERVAL);

        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        sw_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sw_gps.isChecked()){
                    locationRequest.setPriority(locationRequest.PRIORITY_HIGH_ACCURACY);
                    tv_sensor.setText("Usando el GPS");
                }else{
                    locationRequest.setPriority(locationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
                    tv_sensor.setText("Usando Torres + WiiFii");
                }
            }
        });
        updateGPS();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
       // if (requestCode == PERMISSIONS_FINE_LOCATION){
      switch(requestCode){
        case PERMISSIONS_FINE_LOCATION:
                if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    updateGPS();
                }else{
                    Toast.makeText(this, "Esta aplicacion requiere permisos", Toast.LENGTH_LONG).show();
                    finish();
                }break;
        }


    }

    private void updateGPS(){
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(Act2mapa.this);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)== PackageManager.PERMISSION_GRANTED){
                fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this,
                        new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                      updateUIValues(location);
                    }
                });
            }else{
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,}, PERMISSIONS_FINE_LOCATION);
                }
            }
        }

    private void updateUIValues(Location location) {
        tv_lat.setText(String.valueOf(location.getLatitude()));
        tv_lon.setText(String.valueOf(location.getLongitude()));
        tv_acc.setText(String.valueOf(location.getAccuracy()));


          if (location.hasAltitude()){
            tv_alt.setText(String.valueOf(location.getAltitude()));
         }else{
           tv_alt.setText("No Disponible");
             }
           if (location.hasSpeed()){
            tv_sped.setText(String.valueOf(location.getSpeed()));
        }else{
            tv_sped.setText("No Disponible");
        }




    }


}
