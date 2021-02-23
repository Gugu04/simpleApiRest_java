package com.api.rest.dto;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private Integer id_categoria;
    private String nombre;

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
