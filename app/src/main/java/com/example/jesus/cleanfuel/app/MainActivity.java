package com.example.jesus.cleanfuel.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.os.Bundle;

import com.example.jesus.cleanfuel.R;


import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
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

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener, NavigationView.OnNavigationItemSelectedListener {

    private GoogleMap mMap;
    private static final String TAG = MainActivity.class.getSimpleName();
    private Toolbar mTopToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    private MenuItem item;
    private TextView userNameText;
    public SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mTopToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mTopToolbar);
        preferences = getSharedPreferences("dados.file", MODE_PRIVATE);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        userNameText = navigationView.getHeaderView(0).findViewById(R.id.username_perfil);
        setupDrawer();
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

        if(toggle.onOptionsItemSelected(item)){
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.sair){
            startActivity(new Intent(this, LoginActivity.class));
            Toast.makeText(this, "sair", Toast.LENGTH_SHORT).show();
            finish();
        }
        switch (id){
            case R.id.carro:
                startActivity(new Intent(this, CarroActivity.class));
                Toast.makeText(this, "carro", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    private void setupDrawer() {
        toggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
        userNameText.setText(preferences.getString("userName","invalido"));
    }

}