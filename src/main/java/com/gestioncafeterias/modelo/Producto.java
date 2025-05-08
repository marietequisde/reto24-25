/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestioncafeterias.modelo;

/**
 *
 * @author DAM1B22
 */
public class Producto {

    private int idProducto;
    private String nombre;
    private double precio;
    private String tipo;
    private String proveedor;

    public Producto(int idProducto, String nombre, double precio, String tipo, String proveedor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Producto{ id = " + idProducto + ", nombre = " + nombre + ", precio=" + precio + ", tipo=" + tipo + ", proveedor=" + proveedor + '}';
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

}
