package com.api.rest.dto;

import java.io.Serializable;
import java.util.Date;

public class LibroDTO implements Serializable {

    private Integer id_libro;
    private String titulo;
    private String descripcion;
    private Date fecha_publicado;
    private String nombre_autor;
    private String apellidos_autor;
    private Integer id_categoriafk;
    private String categoria_nombre;

    public Integer getId_libro() {
        return id_libro;
    }

    public void setId_libro(Integer id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_publicado() {
        return fecha_publicado;
    }

    public void setFecha_publicado(Date fecha_publicado) {
        this.fecha_publicado = fecha_publicado;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    public String getApellidos_autor() {
        return apellidos_autor;
    }

    public void setApellidos_autor(String apellidos_autor) {
        this.apellidos_autor = apellidos_autor;
    }

    public Integer getId_categoriafk() {
        return id_categoriafk;
    }

    public void setId_categoriafk(Integer id_categoriafk) {
        this.id_categoriafk = id_categoriafk;
    }

    public String getCategoria_nombre() {
        return categoria_nombre;
    }

    public void setCategoria_nombre(String categoria_nombre) {
        this.categoria_nombre = categoria_nombre;
    }
}
