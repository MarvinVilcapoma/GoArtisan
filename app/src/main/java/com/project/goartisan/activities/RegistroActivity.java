package com.project.goartisan.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.project.goartisan.R;
import com.project.goartisan.models.Usuario;
import com.project.goartisan.services.ApiService;
import com.project.goartisan.services.ApiServiceGenerator;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegistroActivity extends AppCompatActivity {

    private static final String TAG = RegistroActivity.class.getSimpleName();

    EditText etnombre,etapellido,etdni,etcorreo,etdireccion,etcelular,etpassword;
    LinearLayout content;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        etnombre=findViewById(R.id.inputNombreRegister);
        etapellido=findViewById(R.id.inputApellidoRegister);
        etdni=findViewById(R.id.inputDNIRegister);
        etcorreo=findViewById(R.id.inputCorreoRegister);
        etdireccion=findViewById(R.id.inputDireccionRegister);
        etcelular=findViewById(R.id.inputCelularRegister);
        etpassword=findViewById(R.id.inputContraseñaRegister);
        content=findViewById(R.id.contentRegisterUser);
        progressBar=findViewById(R.id.progressbarRegisterUser);



    }

    private void irlogin() {
        startActivity(new Intent(RegistroActivity.this,LoginActivity.class));
        finish();
    }


    public void callRegister(View view) {
        RegisterUser();
    }
    private Bitmap bitmap;
    private void RegisterUser() {
        progressBar.setVisibility(View.VISIBLE);
        content.setVisibility(View.GONE);

        String Nombre_u=etnombre.getText().toString();
        String Apellidos_u=etapellido.getText().toString();
        String DNI_u=etdni.getText().toString();
        String Gmail_u=etcorreo.getText().toString();
        String Direccion_u=etdireccion.getText().toString();
        String Celular_u= etcelular.getText().toString();
        String Password_u=etpassword.getText().toString();

        if (Nombre_u.isEmpty()){
            etnombre.setError("Es necesario escribir su nombre");
            etnombre.requestFocus();
            return;
        }

        if (Apellidos_u.isEmpty()){
            etapellido.setError("Es necesario escribir su Apellido");
            etapellido.requestFocus();
            return;
        }

        if (DNI_u.isEmpty()){
            etdni.setError("Es necesario ingresar su DNI");
            etdni.requestFocus();
            return;
        }

        if (Gmail_u.isEmpty()){
            etdni.setError("Es necesario ingresar su correo eléctronico");
            etdni.requestFocus();
            return;
        }
        if (Direccion_u.isEmpty()){
            etdni.setError("Es necesario colocar su ubicación (dirección)");
            etdni.requestFocus();
            return;
        }
        if (Celular_u.isEmpty()){
            etdni.setError("Es necesario colocar su número celular");
            etdni.requestFocus();
            return;
        }

        if (Password_u.isEmpty()){
            etdni.setError("Es necesario colocar una contraseña");
            etdni.requestFocus();
            return;
        }

        if (Password_u.length() < 6){
            etpassword.setError("La contraseñna debe tener 6 caracteres como mínimo");
            etpassword.requestFocus();
            return;
        }

        ApiService service = ApiServiceGenerator.createService(this, ApiService.class);
        Call<Usuario> call;



        if(bitmap == null){
            call = service.createUsuario(Nombre_u,Apellidos_u,DNI_u,Gmail_u,Direccion_u,Celular_u,Password_u);
        } else {

            RequestBody nombrePart = RequestBody.create(MultipartBody.FORM, Nombre_u);
            RequestBody apellidoPart = RequestBody.create(MultipartBody.FORM, Apellidos_u);
            RequestBody dniPart = RequestBody.create(MultipartBody.FORM, DNI_u);
            RequestBody correoPart = RequestBody.create(MultipartBody.FORM, Gmail_u);
            RequestBody direccionPart = RequestBody.create(MultipartBody.FORM, Direccion_u);
            RequestBody celularPart = RequestBody.create(MultipartBody.FORM, Celular_u);
            RequestBody passPart = RequestBody.create(MultipartBody.FORM, Password_u);

            call = service.createUsuario(nombrePart,apellidoPart,dniPart, correoPart,direccionPart,celularPart, passPart);
        }

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {

                try{

                    if(response.isSuccessful()){

                        Usuario usuarios = response.body();
                        Log.d(TAG , "Usuario: " + usuarios);

                        Toast.makeText(RegistroActivity.this, "Registro Realizado Correctamente", Toast.LENGTH_SHORT).show();
                        content.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                        setResult(RESULT_OK);

                        finish();
                    }else{
                        throw new Exception(ApiServiceGenerator.parseError(response).getMessage());
                    }


                }catch(Throwable t){
                    Log.e(TAG, "onThrowable: " + t.getMessage(), t);
                    Toast.makeText(RegistroActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage(), t);
                Toast.makeText(RegistroActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    public void irLogin(View view) {
        startActivity(new Intent(RegistroActivity.this,LoginActivity.class));
        finish();
    }
}
