package com.project.goartisan.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.project.goartisan.ConexionSQLiteHelper;
import com.project.goartisan.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



    }

    public void Registro(View view) {
        startActivity(new Intent(LoginActivity.this,RegistroActivity.class));
        finish();
    }

    public void GoMenu(View view) {
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
        finish();
    }
}
