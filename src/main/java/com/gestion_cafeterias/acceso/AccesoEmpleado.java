/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion_cafeterias.acceso;

import com.gestion_cafeterias.modelo.Empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class AccesoEmpleado {

    public static void insertar(Empleado empleado) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        try {
            String precioString = String.format("%.2f", empleado.getSalario()).replace(',', '.');
            conexion = DerbyUtil.abrirConexion();
            String sentenciaInsert = String.format("INSERT INTO empleado (nombre, salario, fecha_alta_empresa, dni)"
                    + "VALUES ('%s', %s, '%s', '%s')",
                    empleado.getNombre(), precioString,
                    empleado.getFechaAlta(), empleado.getDni());
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sentenciaInsert);
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
    }

    public static Empleado consultar(int codigo) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        Empleado empleado = null;
        try {
            conexion = DerbyUtil.abrirConexion();
            String sentenciaConsulta = String.format("SELECT id_empleado, nombre, salario, fecha_alta_empresa, dni "
                    + "FROM empleado "
                    + "WHERE id_empleado =" + codigo);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(sentenciaConsulta);
            if (resultado.next()) {
                empleado = new Empleado(
                        resultado.getInt("id_empleado"),
                        resultado.getString("nombre"),
                        resultado.getDouble("salario"),
                        resultado.getString("fecha_alta_empresa"),
                        resultado.getString("dni"));
            }
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
        return empleado;
    }

    public static List<Empleado> consultarTodos() throws ClassNotFoundException, SQLException {
        List<Empleado> listaEmpleados = new ArrayList<>();
        Connection conexion = null;
        try {
            conexion = DerbyUtil.abrirConexion();
            String sentenciaConsulta = String.format("SELECT * FROM empleado");
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(sentenciaConsulta);
            while (resultado.next()) {
                Empleado empleado = new Empleado(
                        resultado.getInt("id_empleado"),
                        resultado.getString("nombre"),
                        resultado.getDouble("salario"),
                        resultado.getString("fecha_alta_empresa"),
                        resultado.getString("dni"));
                listaEmpleados.add(empleado);
            }
            resultado.close();
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
        return listaEmpleados;
    }

    public static boolean actualizar(int codigo, String nombre, double salario,
            String fechaAlta, String dni) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        boolean modificado = false;
        try {
            String precioString = String.format("%.2f", salario).replace(',', '.');
            conexion = DerbyUtil.abrirConexion();
            String sentenciaActualizar = String.format("UPDATE empleado "
                    + "SET nombre = '%s', salario = %s, fecha_alta_empresa = '%s', dni = '%s'"
                    + "WHERE id_empleado = %d", nombre, precioString, fechaAlta, dni, codigo);
            Statement sentencia = conexion.createStatement();
            if (sentencia.executeUpdate(sentenciaActualizar) == 1) {
                modificado = true;
            }
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
        return modificado;
    }

    public static boolean eliminar(int codigo, int idNuevoGerente) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        boolean eliminado = false;
        try {
            conexion = DerbyUtil.abrirConexion();
            Statement sentencia = conexion.createStatement();
            Empleado empleado = consultar(idNuevoGerente);
            if (idNuevoGerente > 0 && empleado != null) {
                String sentenciaActualizarGerente = String.format("UPDATE cafeteria SET gerente = %d WHERE gerente = %d", idNuevoGerente, codigo);
                int filasActualizadas = sentencia.executeUpdate(sentenciaActualizarGerente);
                if (filasActualizadas > 0) {
                    String sentenciaEliminar = String.format("DELETE FROM empleado WHERE id_empleado = %d", codigo);
                    if (sentencia.executeUpdate(sentenciaEliminar) == 1) {
                        eliminado = true;
                    }
                }
            }
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
        return eliminado;
    }

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

    public static boolean esGerenteEliminar(int codigoEmpleado) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        boolean esGerente = false;
        boolean eliminado = false;
        try {
            conexion = DerbyUtil.abrirConexion();
            Statement sentencia = conexion.createStatement();
            String consultaVerificarGerente = String.format("SELECT COUNT(*) FROM cafeteria WHERE gerente = %d", codigoEmpleado);
            ResultSet resultadoGerente = sentencia.executeQuery(consultaVerificarGerente);
            resultadoGerente.next();
            if (resultadoGerente.getInt(1) > 0) {
                esGerente = true;
            } else {
                String sentenciaActualizar = String.format("DELETE FROM empleado "
                        + "WHERE id_empleado = %d", codigoEmpleado);
                if (sentencia.executeUpdate(sentenciaActualizar) == 1) {
                    eliminado = true;
                }
            }
            resultadoGerente.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
        return esGerente;
    }

}
