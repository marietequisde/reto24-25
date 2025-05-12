/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestioncafeterias.interfazGrafica.cafeteria;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DAM1B11
 */
public class ModeloTabla extends AbstractTableModel {

    private final String[] cabecera;
    private List<String[]> datos;

    public ModeloTabla(String[] cabecera) {
        this.cabecera = cabecera;
        this.datos = new ArrayList<>();
    }

    public void addRow(String[] fila) {
        datos.add(fila);
        int row = datos.indexOf(fila);
        for (int column = 0; column < fila.length; column++) {
            fireTableCellUpdated(row, column);
        }
        fireTableRowsInserted(row, row);
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
