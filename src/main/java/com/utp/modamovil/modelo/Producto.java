package com.utp.modamovil.modelo;

import java.util.Date;

public class Producto {
    private int id;
    private int categoriaId;
    private int proveedorId;
    private String nombre;
    private String descripcion;
    private Double precio;
    private int stock;
    private Date fechaIngreso;

    // Constructor vacío
    public Producto() {
    }

    // Constructor con todos los atributos
    public Producto(int id, int categoriaId, int proveedorId, String nombre, String descripcion, Double precio, int stock, Date fechaIngreso) {
        this.id = id;
        this.categoriaId = categoriaId;
        this.proveedorId = proveedorId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.fechaIngreso = fechaIngreso;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
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

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    // Método toString para imprimir el objeto
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", categoriaId=" + categoriaId +
                ", proveedorId=" + proveedorId +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", fechaIngreso=" + fechaIngreso +
                '}';
    }
}