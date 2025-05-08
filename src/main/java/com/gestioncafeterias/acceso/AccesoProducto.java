/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestioncafeterias.acceso;

import com.gestioncafeterias.modelo.Producto;
import java.sql.Connection;
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
    
    public static void insertarProducto(Producto producto) throws SQLException, ClassNotFoundException{
        Connection conexion = null;
        
        try{
            conexion = DerbyUtil.abrirConexion();
            String sentenciaInsercion = String.format("INSERT INTO producto (nombre, precio,tipo,proveedor)"
                    + "VALUES (%s, %f, %s, %s)", 
                    producto.getNombre(), 
                    producto.getPrecio(), 
                    producto.getTipo(),
                    producto.getProveedor());
            Statement sentencia = conexion.createStatement();
            sentencia.close();
        }
        finally{
            DerbyUtil.cerrarConexion(conexion);
        }
    }
    public static List<Producto> consultarTodos() throws SQLException, ClassNotFoundException{
        List<Producto> productos = new ArrayList<>();
        Connection conexion = null;
        
        try{
            conexion = DerbyUtil.abrirConexion();
            String sentenciaConsulta = String.format("SELECT * FROM producto");
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(sentenciaConsulta);
            
            while(resultado.next()){
                Producto producto = new Producto(
                    resultado.getString("nombre"),
                    resultado.getDouble("precio"),
                    resultado.getString("tipo"),
                    resultado.getString("proveedor"));
                productos.add(producto);
            }
            resultado.close();
            sentencia.close();
        }
        finally{
            DerbyUtil.cerrarConexion(conexion);
        }
        return productos;
    }
    
    public static boolean actualizar(int id, String nombre, Double precio, String tipo, String proveedor) throws SQLException, ClassNotFoundException{
        Connection conexion = null;
        boolean actualizado = false;
        
        try{
            conexion = DerbyUtil.abrirConexion();
            String sentenciaUpt = String.format("UPDATE producto SET nombre = %s"
            + ", precio = %f, tipo = %s, proveedor = %s"
            +"WHERE id_producto = %d",nombre, precio, tipo, proveedor,id);
            Statement sentencia = conexion.createStatement();
            if(sentencia.executeUpdate(sentenciaUpt) == 1){
                actualizado = true;
            }
        }finally{
            DerbyUtil.cerrarConexion(conexion);
        }
        return actualizado;
    }
    
    public static boolean eliminar(int id) throws SQLException, ClassNotFoundException{
        Connection conexion = null;
        boolean eliminado = false;
        
        try{
            conexion = DerbyUtil.abrirConexion();
            String sentenciaEliminar = String.format("DELETE FROM productos WHERE id_producto = " + id);
            Statement sentencia = conexion.createStatement();
            if(sentencia.executeUpdate(sentenciaEliminar) == 1){
                eliminado = true;
            }
        }finally{
            DerbyUtil.cerrarConexion(conexion);
        }
        return eliminado;
    } 
}
