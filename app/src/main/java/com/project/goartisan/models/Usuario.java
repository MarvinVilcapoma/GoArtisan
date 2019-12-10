package com.project.goartisan.models;

public class Usuario {
    private Long id_u;
    private String Nombre_u;
    private String Apellidos_u;
    private String DNI_u;
    private String Gmail_u;
    private String Direccion_u;
    private String Celular_u;
    private String Password_u;

    public Usuario(String Nombre_u, String Apellidos_u, String DNI_u, String Gmail_u, String Direccion_u, String Celular_u, String Password_u) {
        this.Nombre_u = Nombre_u;
        this.Apellidos_u = Apellidos_u;
        this.DNI_u = DNI_u;
        this.Gmail_u = Gmail_u;
        this.Direccion_u = Direccion_u;
        this.Celular_u = Celular_u;
        this.Password_u = Password_u;
    }

    public Long getId_u() {
        return id_u;
    }

    public void setId_u(Long id_u) {
        this.id_u = id_u;
    }

    public String getNombre_u() {
        return Nombre_u;
    }

    public void setNombre_u(String Nombre_u) {
        Nombre_u = Nombre_u;
    }

    public String getApellidos_u() {
        return Apellidos_u;
    }

    public void setApellidos_u(String Apellidos_u) {
        Apellidos_u = Apellidos_u;
    }

    public String getDNI_u() {
        return DNI_u;
    }

    public void setDNI_u(String DNI_u) {
        this.DNI_u = DNI_u;
    }

    public String getGmail_u() {
        return Gmail_u;
    }

    public void setGmail_u(String Gmail_u) {
        Gmail_u = Gmail_u;
    }

    public String getDireccion_u() {
        return Direccion_u;
    }

    public void setDireccion_u(String Direccion_u) {
        Direccion_u = Direccion_u;
    }

    public String getCelular_u() {
        return Celular_u;
    }

    public void setCelular_u(String Celular_u) {
        Celular_u = Celular_u;
    }

    public String getPassword_u() {
        return Password_u;
    }

    public void setPassword_u(String Password_u) {
        Password_u = Password_u;
    }
}