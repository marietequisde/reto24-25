/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestioncafeterias.acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DAM1B07
 */
public class DerbyUtil {

    private static final String CONNECT_DERBY = "org.apache.derby.client.ClientAutoloadedDriver";
    private static final String URL_DERBY = "jdbc:derby://localhost:1527/Cafeterias";
    private static final String USUARIO = "root";
    private static final String CONTRASENYA = "root";

    public static Connection abrirConexion() throws SQLException, ClassNotFoundException {
        Class.forName(CONNECT_DERBY);
        Connection conexion = DriverManager.getConnection(URL_DERBY, USUARIO, CONTRASENYA);
        return conexion;
    }

    public static void cerrarConexion(Connection conexion) throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
}
