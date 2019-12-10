package com.project.goartisan.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.project.goartisan.R;
import com.project.goartisan.models.Usuario;
import com.project.goartisan.services.ApiService;
import com.project.goartisan.services.ApiServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    final int REQUEST_CODE = 100;
    LinearLayout content;
    EditText txtcorreo,txtpassword;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtcorreo=findViewById(R.id.inputCorreoLogin);
        txtpassword=findViewById(R.id.inputPasswordLogin);
        loginButton=findViewById(R.id.btnIngresar);
        progressBar=findViewById(R.id.progressbarLoginUser);
        content=findViewById(R.id.content_login);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

        loadLoastUsername();
    }

    public void Registro(View view) {
        Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
        startActivityForResult(intent,REQUEST_CODE);
    }

    public void Login(){
        final String Gmail_u = txtcorreo.getText().toString();
        final String Password_u = txtpassword.getText().toString();

        if(Gmail_u.isEmpty() || Password_u.isEmpty()){
            txtpassword.setError("Ingrese sus datos");
            txtcorreo.requestFocus();
        }

        ApiService service = ApiServiceGenerator.createService(this, ApiService.class);
        service.login(Gmail_u,Password_u).enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                try {
                    if (response.isSuccessful()) {
                        Usuario usuario = response.body();

                        if (usuario != null){
                            Toast.makeText(LoginActivity.this,"Usuario "+ usuario.getGmail_u()+ " logeado",Toast.LENGTH_SHORT).show();



                            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                            sp.edit()
                                    .putString("correo_usu", usuario.getGmail_u())
                                    .putString("password_usu", usuario.getPassword_u())
                                    .putBoolean("islogged", true)
                                    .commit();

                            content.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.GONE);
                            setResult(RESULT_OK);

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            return;
                        }

                        Toast.makeText(LoginActivity.this,"Datos incorrectos",Toast.LENGTH_SHORT).show();



                    } else {
                        throw new Exception(ApiServiceGenerator.parseError(response).getMessage());
                    }

                } catch (Throwable t) {

                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });
    }

    private void loadLoastUsername(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String usu = sp.getString("correo",null);
        if(usu !=null){
            txtcorreo.setText(usu);
            txtpassword.requestFocus();
        }
    }
}
