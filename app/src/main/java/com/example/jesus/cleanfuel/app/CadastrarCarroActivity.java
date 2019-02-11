package com.example.jesus.cleanfuel.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jesus.cleanfuel.R;

public class CadastrarCarroActivity extends AppCompatActivity {

    private EditText marcaEdit, modeloEdit, placaEdit;
    public SharedPreferences preferences;
    public SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_carro);
        marcaEdit = findViewById(R.id.Marca_cadastro);
        modeloEdit = findViewById(R.id.modelo_cadastro);
        placaEdit = findViewById(R.id.placa_cadastro);
        preferences = getSharedPreferences("dados.file", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void salvar(View view) {
        if(marcaEdit.getText().toString().isEmpty() || modeloEdit.getText().toString().isEmpty() || placaEdit.getText().toString().isEmpty()) {
            editor.putString("marca", marcaEdit.getText().toString());
            editor.putString("modelo", modeloEdit.getText().toString());
            editor.putString("placa", placaEdit.getText().toString());
            editor.apply();
            startActivity(new Intent(this, CarroActivity.class));
        }else{
            Toast.makeText(this, "Preencha os campos", Toast.LENGTH_SHORT).show();
        }
    }
}
