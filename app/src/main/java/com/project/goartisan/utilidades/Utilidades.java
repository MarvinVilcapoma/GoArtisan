package com.project.goartisan.utilidades;

public class Utilidades  {

    //Constantes de la tabla

    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_APELLIDOO="apellido";
    public static final String CAMPO_CORREO="correo";
    public static final String CAMPO_CELULAR="celular";
    public static final String CAMPO_CONTRASEÑA="contraseña";


    public static final String CREAR_TABLA_USUARIO="CREATE TABLE "+TABLA_USUARIO+"("+CAMPO_ID+" INTEGER,"+CAMPO_NOMBRE+" TEXT,"+CAMPO_APELLIDOO+" TEXT,"+CAMPO_CORREO+" TEXT,"+CAMPO_CELULAR+" TEXT,"+CAMPO_CONTRASEÑA+" TEXT)";
}
