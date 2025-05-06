/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestioncafeterias.acceso;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoEmpleado {

    public static List<String> consultarNombres() throws ClassNotFoundException, SQLException {
        List<String> nombres = new ArrayList<>();
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultados = null;
        try {
            conexion = DerbyUtil.abrirConexion();

            String sentenciaConsultar = String.format("SELECT nombre FROM empleado");
            sentencia = conexion.createStatement();
            resultados = sentencia.executeQuery(sentenciaConsultar);

            while (resultados.next()) {
                nombres.add(resultados.getString("nombre"));
            }

            resultados.close();
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
            if (sentencia != null) {
                sentencia.close();
            }
            if (resultados != null) {
                resultados.close();
            }
        }

        return nombres;
    }
}
