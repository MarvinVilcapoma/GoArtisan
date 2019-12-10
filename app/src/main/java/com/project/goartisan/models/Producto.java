package com.project.goartisan.models;

public class Producto {
    private Long id;
    private String nombre_p;
    private double precio_p;
    private String descripcion_p;
    private String imagen_p;

    public Producto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_p() {
        return nombre_p;
    }

    public void setNombre_p(String nombre_p) {
        this.nombre_p = nombre_p;
    }

    public double getPrecio_p() {
        return precio_p;
    }

    public void setPrecio_p(double precio_p) {
        this.precio_p = precio_p;
    }

    public String getDescripcion_p() {
        return descripcion_p;
    }

    public void setDescripcion_p(String descripcion_p) {
        this.descripcion_p = descripcion_p;
    }

    public String getImagen_p() {
        return imagen_p;
    }

    public void setImagen_p(String imagen_p) {
        this.imagen_p = imagen_p;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre_p='" + nombre_p + '\'' +
                ", precio_p=" + precio_p +
                ", descripcion_p='" + descripcion_p + '\'' +
                ", imagen_p='" + imagen_p + '\'' +
                '}';
    }
}
