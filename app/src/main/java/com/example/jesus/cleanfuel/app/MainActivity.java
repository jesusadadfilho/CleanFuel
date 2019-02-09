package com.example.jesus.cleanfuel.app;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.os.Bundle;

import com.example.jesus.cleanfuel.R;


import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.jesus.cleanfuel.app.model.Posto;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;
    private static final String TAG = MainActivity.class.getSimpleName();
    private Toolbar mTopToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mTopToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mTopToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_favorite) {
            Toast.makeText(MainActivity.this, "Meus postos favoritos", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnInfoWindowClickListener(this);
        mMap.setMinZoomPreference(12.0f);
        mMap.setMaxZoomPreference(18.0f);
        boolean success = googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                        this, R.raw.style_json));

        if (!success) {
            Log.e(TAG, "Estilo ok");
        }


        ArrayList<Posto> postos =  Posto.generate(20);
        System.out.println("Postos");
        System.out.println(postos);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(postos.get(0).getLocation()));

        for (Posto posto: postos) {
           Marker marker = mMap.addMarker(new MarkerOptions().position(posto.getLocation()).title(posto.getNome()));
            marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_posto));

        }
    }


    @Override
    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(this, "Visitar posto",
                Toast.LENGTH_SHORT).show();
    }
}