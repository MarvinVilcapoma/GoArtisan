package com.project.goartisan.services;

import com.project.goartisan.models.Usuario;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {
    String API_BASE_URL = "http://10.0.2.2:8085";



    @POST("/usuarios")
    Call<Usuario> createUsu(@Body Usuario user);

    @FormUrlEncoded
    @POST("/login")
    Call<Usuario> login(@Field("Gmail_u") String Gmail_u,
                        @Field("Password_u") String Password_u);

    @Multipart
    @POST("/usuarios")
    Call<Usuario> createUsuario(@Part("Nombre_u") RequestBody Nombre_u,
                                 @Part("Apellidos_u") RequestBody Apellidos_u,
                                 @Part("DNI_u") RequestBody DNI_u,
                                 @Part("Gmail_u") RequestBody Gmail_u,
                                 @Part("Direccion_u")RequestBody Direccion_u,
                                 @Part("Celular_u")RequestBody Celular_u,
                                 @Part("Password_u")RequestBody Password_u);

    @FormUrlEncoded
    @POST("/usuarios")
    Call<Usuario> createUsuario(@Field("Nombre_u") String Nombre_u,
                                 @Field("Apellidos_u") String Apellidos_u,
                                 @Field("DNI_u") String DNI_u,
                                 @Field("Gmail_u")String Gmail_u,
                                 @Field("Direccion_u")String Direccion_u,
                                 @Field("Celular_u") String Celular_u,
                                 @Field("Password_u") String Password_u

    );
    @POST("auth/usuarios")
    Call<Usuario> createUsuario(@Body Usuario user);
}
