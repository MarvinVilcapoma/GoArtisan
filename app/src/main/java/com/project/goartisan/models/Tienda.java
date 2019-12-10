package com.project.goartisan.models;

public class Tienda {
    private Long id_ti;
    private Long id_usuariot;
    private String factura;
    private String imagen_ti;
    private String descripcion_ti;
    private String ruc_ti;
    private String nombre_ti;
    private String fechaini_ti;
    private String categoria_ti;

    public Tienda(Long id_ti, String factura, String imagen_ti, String descripcion_ti, String ruc_ti, String nombre_ti, String fechaini_ti, String categoria_ti) {
        this.id_ti = id_ti;
        this.factura = factura;
        this.imagen_ti = imagen_ti;
        this.descripcion_ti = descripcion_ti;
        this.ruc_ti = ruc_ti;
        this.nombre_ti = nombre_ti;
        this.fechaini_ti = fechaini_ti;
        this.categoria_ti = categoria_ti;
    }

    public Long getId_ti() {
        return id_ti;
    }

    public void setId_ti(Long id_ti) {
        this.id_ti = id_ti;
    }

    public Long getId_usuariot() {
        return id_usuariot;
    }

    public void setId_usuariot(Long id_usuariot) {
        this.id_usuariot = id_usuariot;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getImagen_ti() {
        return imagen_ti;
    }

    public void setImagen_ti(String imagen_ti) {
        this.imagen_ti = imagen_ti;
    }

    public String getDescripcion_ti() {
        return descripcion_ti;
    }

    public void setDescripcion_ti(String descripcion_ti) {
        this.descripcion_ti = descripcion_ti;
    }

    public String getRuc_ti() {
        return ruc_ti;
    }

    public void setRuc_ti(String ruc_ti) {
        this.ruc_ti = ruc_ti;
    }

    public String getNombre_ti() {
        return nombre_ti;
    }

    public void setNombre_ti(String nombre_ti) {
        this.nombre_ti = nombre_ti;
    }

    public String getFechaini_ti() {
        return fechaini_ti;
    }

    public void setFechaini_ti(String fechaini_ti) {
        this.fechaini_ti = fechaini_ti;
    }

    public String getCategoria_ti() {
        return categoria_ti;
    }

    public void setCategoria_ti(String categoria_ti) {
        this.categoria_ti = categoria_ti;
    }
}
