package com.project.goartisan.activities;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.project.goartisan.ConexionSQLiteHelper;
import com.project.goartisan.R;
import com.project.goartisan.utilidades.Utilidades;

public class RegistroActivity extends AppCompatActivity {

    EditText nombre,apellido,correo,celular,contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        nombre=findViewById(R.id.et_nombres);
        apellido=findViewById(R.id.et_apellidos);
        correo=findViewById(R.id.et_correo);
        celular=findViewById(R.id.et_celular);
        contraseña=findViewById(R.id.et_celular);

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
    }

    public void Iniciar(View view) {
        startActivity(new Intent(RegistroActivity.this,LoginActivity.class));
        registrarUsuarios();



    }

    private void registrarUsuarios(){

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,nombre.getText().toString());
        values.put(Utilidades.CAMPO_APELLIDOO,apellido.getText().toString());
        values.put(Utilidades.CAMPO_CORREO,correo.getText().toString());
        values.put(Utilidades.CAMPO_CELULAR,celular.getText().toString());
        values.put(Utilidades.CAMPO_CONTRASEÑA,contraseña.getText().toString());

        Long nombreResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_NOMBRE,values);

        Toast.makeText(getApplicationContext(),"Nombre del registro: "+nombreResultante,Toast.LENGTH_SHORT).show();

        db.close();


    }
}
