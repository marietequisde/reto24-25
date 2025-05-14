/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion_cafeterias.util;

import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario Fernández
 */
public class PopUpError {
    
    private static final String TITULO_VENTANA = "Error";

    public static void mostrarErrores(Component parentComponent, List<String> errores) {
        String stringErrores = "";
        for (String error : errores) {
            stringErrores += error + "\n";
        }
        mostrarError(parentComponent, stringErrores);
    }

    public static void mostrarError(Component parentComponent, String error) {
        JOptionPane.showMessageDialog(parentComponent, error, TITULO_VENTANA, JOptionPane.ERROR_MESSAGE);
    }
}
