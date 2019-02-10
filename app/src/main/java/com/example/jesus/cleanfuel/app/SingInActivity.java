package com.example.jesus.cleanfuel.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jesus.cleanfuel.R;

public class SingInActivity extends AppCompatActivity {

    private TextView username;
    public SharedPreferences preferences;
    public SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
        preferences = getSharedPreferences("dados.file", Context.MODE_PRIVATE);
        editor = preferences.edit();
        username = findViewById(R.id.edit_username_sing);
    }


    public void confirm(View view) {
        if(!username.getText().toString().isEmpty()){
            editor.putString("userName", username.getText().toString());
            editor.apply();
            Toast.makeText(this, "Bem vindo : " + username.getText().toString() +"!" ,Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }else {
            Toast.makeText(this, "Usuario vazio!!" ,Toast.LENGTH_LONG).show();
        }
    }
}
