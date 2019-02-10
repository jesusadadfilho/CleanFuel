package com.example.jesus.cleanfuel.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jesus.cleanfuel.R;

public class LoginActivity extends AppCompatActivity {

    private TextView singInText, username;
    public SharedPreferences preferences;
    public SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferences = getSharedPreferences("dados.file", Context.MODE_PRIVATE);
        editor = preferences.edit();
        setupViews();
        underlineText();
    }

    private void setupViews() {
        username = findViewById(R.id.edit_username);
        singInText = findViewById(R.id.sing_up_btn);
    }

    private void underlineText(){
        SpannableString content = new SpannableString(singInText.getText().toString());
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        singInText.setText(content);
    }

    public void singin(View view) {
        startActivity(new Intent(this, SingInActivity.class));
    }

    public void login(View view) {
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
