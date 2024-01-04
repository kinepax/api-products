package com.tomtech.apiproducts.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class ProductDTO {
    private Integer     id;
    @Valid
    @NotEmpty(message = "Tiene que tener un nombre")
    private String     nombre;
    @Valid
    @NotEmpty(message = "Tiene que tener una descripcion")
    private String  descripcion;

    private Double  precio;

    @Min(1)

    private int     stock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
