/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion_cafeterias.modelo;

import com.gestion_cafeterias.interfaz_grafica.FilaTabla;
import java.util.Arrays;

/**
 *
 * @author Mario Fernández
 */
public class Cafeteria implements FilaTabla {

    private Integer idCafeteria;
    private String horario;
    private String direccion;
    private Integer aforoLocal;
    private Double precioAlquiler;
    private String nombreGerente;

    public Cafeteria(String horario, String direccion, Integer aforoLocal, Double precioAlquiler, String nombreGerente) {
        this.horario = horario;
        this.direccion = direccion;
        this.aforoLocal = aforoLocal;
        this.precioAlquiler = precioAlquiler;
        this.nombreGerente = nombreGerente;
    }

    public Cafeteria(Integer idCafeteria, String horario, String direccion, Integer aforoLocal, Double precioAlquiler, String nombreGerente) {
        this.idCafeteria = idCafeteria;
        this.horario = horario;
        this.direccion = direccion;
        this.aforoLocal = aforoLocal;
        this.precioAlquiler = precioAlquiler;
        this.nombreGerente = nombreGerente;
    }

    public Integer getIdCafeteria() {
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

    public Integer getAforoLocal() {
        return aforoLocal;
    }

    public void setAforoLocal(Integer aforoLocal) {
        this.aforoLocal = aforoLocal;
    }

    public Double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(Double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public String getNombreGerente() {
        return nombreGerente;
    }

    public void setNombreGerente(String nombreGerente) {
        this.nombreGerente = nombreGerente;
    }

    @Override
    public String toString() {
        return "Cafeteria{" + "idCafeteria=" + idCafeteria + ", horario="
                + horario + ", direccion=" + direccion + ", aforoLocal="
                + aforoLocal + ", precioAlquiler=" + precioAlquiler
                + ", gerente=" + nombreGerente + '}';
    }

    @Override
    public String[] toVectorStrings() {
        String[] atributos = new String[6];
        atributos[0] = String.valueOf(idCafeteria);
        atributos[1] = horario;
        atributos[2] = direccion;
        if (aforoLocal != null) {
            atributos[3] = String.valueOf(aforoLocal);
        } else {
            atributos[3] = "";
        }
        
        if (precioAlquiler != null) {
            atributos[4] = String.valueOf(precioAlquiler);
        } else {
            atributos[4] = "";
        }
        atributos[5] = nombreGerente;
        return atributos;
    }

}
