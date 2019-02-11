package com.example.jesus.cleanfuel.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jesus.cleanfuel.R;

import java.util.Random;

public class CarroActivity extends AppCompatActivity {

    private TextView modeloText, marcaText, qualidadeText, nivelText, detritosText, alcoolText, placaText;
    private Random gerador;
    public SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carro);
        preferences = getSharedPreferences("dados.file", MODE_PRIVATE);
        setupViews();
        setValues();
    }

    private void setValues() {
        //qualidadeText.setText(String.format("%s%d", getString(R.string.quali), gerador.nextInt(100)));
        //nivelText.setText(String.format("Nivel da gasolina: %d", gerador.nextInt(100)));
        //detritosText.setText(String.format("Detritos: %d", gerador.nextInt(15)));
        //alcoolText.setText(String.format("Alcool: %d", gerador.nextInt(16)));
        placaText.setText(String.format("Placa: %s", preferences.getString("placa", "AAA-0000")));
        marcaText.setText(String.format("Marca: %s", preferences.getString("marca", "Fiat")));
        modeloText.setText(String.format("Modelo: %s", preferences.getString("modelo", "Palio")));
    }

    private void setupViews() {
        modeloText = findViewById(R.id.modelo_text);
        marcaText = findViewById(R.id.marca_text);
        qualidadeText = findViewById(R.id.qualidade_text);
        nivelText = findViewById(R.id.nivel_text);
        detritosText = findViewById(R.id.detritos_text);
        alcoolText = findViewById(R.id.alcool_text);
        placaText = findViewById(R.id.placa_text);
    }


    public void addCarro(View view) {


    }
}
