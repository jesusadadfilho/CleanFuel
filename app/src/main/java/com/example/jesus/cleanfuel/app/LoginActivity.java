package com.example.jesus.cleanfuel.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

import com.example.jesus.cleanfuel.R;

public class LoginActivity extends AppCompatActivity {

    private TextView singInText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupViews();
        underlineText();
    }

    private void setupViews() {
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
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
