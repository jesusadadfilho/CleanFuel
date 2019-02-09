package com.example.jesus.cleanfuel.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jesus.cleanfuel.R;

public class SingInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
    }


    public void confirm(View view) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
