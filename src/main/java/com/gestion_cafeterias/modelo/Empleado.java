/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion_cafeterias.modelo;

/**
 *
 * @author DAM1B07
 */
public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String fechaAlta;
    private double salario;
    private String dni;
    
    public Empleado(String nombre, double salario, String fechaAlta, String dni){
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
        this.salario = salario;
        this.dni = dni; 
    }
        public Empleado(int idEmpleado, String nombre, double salario, String fechaAlta, String dni){
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
        this.salario = salario;
        this.dni = dni; 
    }
           

    @Override
    public String toString() {

        return "Empleado [ Id_empleado =" + this.idEmpleado
                + ", Nombre = " + this.nombre
                + ", FechaAlta = " + this.fechaAlta
                + ", Salario = " + String.format("%.2f", this.salario)
                + ", DNI = " + this.dni
                + "]";
    }
    
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}
