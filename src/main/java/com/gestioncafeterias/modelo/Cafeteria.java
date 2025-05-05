/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestioncafeterias.modelo;

import java.util.Arrays;

/**
 *
 * @author DAM1B11
 */
public class Cafeteria {

    private int idCafeteria;
    private String horario;
    private String direccion;
    private int aforoLocal;
    private double precioAlquiler;
    private String gerente;

    public Cafeteria(String horario, String direccion, int aforoLocal, double precioAlquiler, String gerente) {
        this.horario = horario;
        this.direccion = direccion;
        this.aforoLocal = aforoLocal;
        this.precioAlquiler = precioAlquiler;
        this.gerente = gerente;
    }

    public Cafeteria(int idCafeteria, String horario, String direccion, int aforoLocal, double precioAlquiler, String gerente) {
        this.idCafeteria = idCafeteria;
        this.horario = horario;
        this.direccion = direccion;
        this.aforoLocal = aforoLocal;
        this.precioAlquiler = precioAlquiler;
        this.gerente = gerente;
    }

    public int getIdCafeteria() {
        return idCafeteria;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getAforoLocal() {
        return aforoLocal;
    }

    public void setAforoLocal(int aforoLocal) {
        this.aforoLocal = aforoLocal;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    @Override
    public String toString() {
        return "Cafeteria{" + "idCafeteria=" + idCafeteria + ", horario=" + horario + ", direccion=" + direccion + ", aforoLocal=" + aforoLocal + ", precioAlquiler=" + precioAlquiler + ", gerente=" + gerente + '}';
    }

    public String[] toDataArray() {
        String[] atributos = new String[6];
        atributos[0] = String.valueOf(idCafeteria);
        atributos[1] = horario;
        atributos[2] = direccion;
        atributos[3] = String.valueOf(aforoLocal);
        atributos[4] = String.valueOf(precioAlquiler);
        atributos[5] = gerente;
        return atributos;
    }

}
