package com.project.goartisan.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.project.goartisan.R;

public class SelectorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
    }

    public void Registro(View view) {
        startActivity(new Intent(SelectorActivity.this,RegistroActivity.class));
    }

    public void EntrarComoComprador(View view) {
        startActivity(new Intent(SelectorActivity.this,LoginActivity.class));
    }

    public void CrearTienda(View view) {
        startActivity(new Intent(SelectorActivity.this,LoginActivity.class));
    }
}
