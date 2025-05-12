/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion_cafeterias.acceso;

import com.gestion_cafeterias.acceso.DerbyUtil;
import com.gestion_cafeterias.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAM1B22
 */
public class AccesoProducto {

    public static boolean insertarProducto(String nombre, Double precio, String tipo, String proveedor) throws SQLException, ClassNotFoundException {
        boolean insertado = false;
        Connection conexion = null;

        try {
            conexion = DerbyUtil.abrirConexion();
            String sentenciaInsercion = "INSERT INTO producto (nombre, precio, tipo, proveedor) VALUES (?, ?, ?, ?)";

            PreparedStatement sentencia = conexion.prepareStatement(sentenciaInsercion);
            sentencia.setString(1, nombre);
            sentencia.setDouble(2, precio);
            sentencia.setString(3, tipo);
            sentencia.setString(4, proveedor);

            if (sentencia.executeUpdate() == 1) {
                insertado = true;
            }
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
        return insertado;
    }

    public static List<Producto> consultarTodos() throws SQLException, ClassNotFoundException {
        List<Producto> productos = new ArrayList<>();
        Connection conexion = null;

        try {
            conexion = DerbyUtil.abrirConexion();
            String sentenciaConsulta = String.format("SELECT * FROM producto");
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(sentenciaConsulta);

            while (resultado.next()) {
                Producto producto = new Producto(
                        resultado.getInt("id_producto"),
                        resultado.getString("nombre"),
                        resultado.getDouble("precio"),
                        resultado.getString("tipo"),
                        resultado.getString("proveedor"));
                productos.add(producto);
            }
            resultado.close();
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
        return productos;
    }

    public static List<Producto> consultarPorID(int id) throws SQLException, ClassNotFoundException {
        List<Producto> productos = new ArrayList<>();
        Connection conexion = null;

        try {
            conexion = DerbyUtil.abrirConexion();
            String sentenciaConsulta = String.format("SELECT * FROM producto "
                    + "WHERE id_producto = " + id);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(sentenciaConsulta);

            while (resultado.next()) {
                Producto producto = new Producto(
                        resultado.getInt("id_producto"),
                        resultado.getString("nombre"),
                        resultado.getDouble("precio"),
                        resultado.getString("tipo"),
                        resultado.getString("proveedor"));
                productos.add(producto);
            }
            resultado.close();
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
        return productos;
    }

    /*public static boolean actualizar(int id, String nombre, Double precio, String tipo, String proveedor) throws SQLException, ClassNotFoundException {
        Connection conexion = null;
        boolean actualizado = false;

        try {
            conexion = DerbyUtil.abrirConexion();
            String sentenciaUpt = String.format("UPDATE producto SET nombre = '%s'"
                    + ", precio = %f, tipo = '%s', proveedor = '%s'"
                    + " WHERE id_producto = %d", nombre, precio, tipo, proveedor, id);
            Statement sentencia = conexion.createStatement();
            if (sentencia.executeUpdate(sentenciaUpt) == 1) {
                actualizado = true;
            }
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
        return actualizado;
    }*/
    public static boolean actualizar(int id, String nombre, Double precio, String tipo, String proveedor) throws SQLException, ClassNotFoundException {
        Connection conexion = null;
        boolean actualizado = false;

        try {
            conexion = DerbyUtil.abrirConexion();
            String sentenciaUpt = "UPDATE producto SET nombre = ?, precio = ?, tipo = ?, proveedor = ? WHERE id_producto = ?";
            PreparedStatement pstmt = conexion.prepareStatement(sentenciaUpt);

            pstmt.setString(1, nombre);
            pstmt.setDouble(2, precio);
            pstmt.setString(3, tipo);
            pstmt.setString(4, proveedor);
            pstmt.setInt(5, id);

            if (pstmt.executeUpdate() == 1) {
                actualizado = true;
            }
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
        return actualizado;
    }

    public static boolean eliminar(int id) throws SQLException, ClassNotFoundException {
        Connection conexion = null;
        boolean eliminado = false;

        try {
            conexion = DerbyUtil.abrirConexion();
            String sentenciaEliminar = String.format("DELETE FROM producto WHERE id_producto = " + id);
            Statement sentencia = conexion.createStatement();
            if (sentencia.executeUpdate(sentenciaEliminar) == 1) {
                eliminado = true;
            }
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
        return eliminado;
    }

    public static boolean siExiste(int id) throws SQLException, ClassNotFoundException {
        Connection conexion = null;
        conexion = DerbyUtil.abrirConexion();
        boolean exists = false;
        try {
            String sentenciaConsulta = String.format("SELECT * FROM producto "
                    + "WHERE id_producto = " + id);
            Statement sentencia = conexion.createStatement();
            ResultSet rs = sentencia.executeQuery(sentenciaConsulta);

            exists = rs.next() == true;
            return exists;
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
    }
}
