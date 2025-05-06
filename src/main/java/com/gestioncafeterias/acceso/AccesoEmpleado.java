/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestioncafeterias.acceso;

import com.gestioncafeterias.modelo.Cafeteria;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAM1B11
 */
public class AccesoEmpleado {
    
        public static List<String> consultarNombres() throws ClassNotFoundException, SQLException {
        List<String> nombres = new ArrayList<>();
        Connection conexion = null;

        try {
            conexion = DerbyUtil.abrirConexion();

            String sentenciaConsultar = String.format("SELECT nombre FROM empleado");
            Statement sentencia = conexion.createStatement();
            ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);

            while (resultados.next()) {
                nombres.add(resultados.getString("nombre"));
            }

            resultados.close();
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }

        return nombres;
    }
}
