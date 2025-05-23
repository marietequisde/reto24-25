/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion_cafeterias.interfaz_grafica;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mario Fernández
 * 
 * Esta clase extiende a AbstractTableModel para visualizar datos en una tabla.
 * Es muy aconsejable que la clase del modelo del dato que se quiere visualizar,
 * extienda a FilaTabla.
 */
public class ModeloTabla extends AbstractTableModel {
    
    private final String[] cabecera;
    private List<String[]> datos;
    
    public ModeloTabla(String[] cabecera) {
        this.cabecera = cabecera;
        this.datos = new ArrayList<>();
    }
    
    public void rellenar(FilaTabla[] datos) {
        limpiarDatos();
        for (FilaTabla fila : datos) {
            addRow(fila);
        }
    }
    
    public void mostrarElemento(FilaTabla dato) {
        limpiarDatos();
        addRow(dato);
    }
    
    public void addRow(FilaTabla fila) {
        String[] datosFila = fila.toVectorStrings();
        datos.add(datosFila);
        int filaModelo = datos.indexOf(datosFila);
        for (int columna = 0; columna < datosFila.length; columna++) {
            fireTableCellUpdated(filaModelo, columna);
        }
        fireTableRowsInserted(filaModelo, filaModelo);
    }
    
    public void limpiarDatos() {
        this.datos = new ArrayList<>();
        fireTableDataChanged();
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
    @Override
    public int getRowCount() {
        return datos.size();
    }
    
    @Override
    public int getColumnCount() {
        return cabecera.length;
    }
    
    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        return datos.get(rowIndex)[columnIndex];
    }
    
    @Override
    public String getColumnName(int col) {
        return cabecera[col];
    }
    
}
