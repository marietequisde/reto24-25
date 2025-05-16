package com.gestion_cafeterias.acceso;

import com.gestion_cafeterias.modelo.Cafeteria;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Mario Fernández
 */
public class AccesoCafeteria {
    
    private static final String SQL_INSERTAR_CON_GERENTE
            = "INSERT INTO cafeteria (horario, "
            + "direccion, aforo_local, precio_alquiler, gerente) "
            + "VALUES (%s, %s, %s, %s, "
            + "(SELECT id_empleado FROM empleado WHERE nombre = %s))";
    
    private static final String SQL_INSERTAR_SIN_GERENTE
            = "INSERT INTO cafeteria (horario, "
            + "direccion, aforo_local, precio_alquiler) "
            + "VALUES (%s, %s, %s, %s)";
    
    private static final String SQL_CONSULTAR_UNO
            = "SELECT id_cafeteria, horario, direccion, aforo_local, precio_alquiler, nombre "
            + "FROM cafeteria "
            + "LEFT JOIN empleado ON gerente = id_empleado "
            + "WHERE id_cafeteria = %d";
    
    private static final String SQL_CONSULTAR_TODOS
            = "SELECT id_cafeteria, horario, direccion, aforo_local, precio_alquiler, nombre "
            + "FROM cafeteria "
            + "LEFT JOIN empleado ON gerente = id_empleado";
    
    private static final String SQL_ACTUALIZAR_UNO_CON_GERENTE
            = "UPDATE cafeteria "
            + "SET horario = %s, direccion = %s, aforo_local = %s, precio_alquiler = %s , "
            + "gerente = (SELECT id_empleado FROM empleado WHERE nombre = %s) "
            + "WHERE id_cafeteria = %s";
    
    private static final String SQL_ACTUALIZAR_UNO_SIN_GERENTE
            = "UPDATE cafeteria "
            + "SET horario = %s, direccion = %s, aforo_local = %s, precio_alquiler = %s, gerente = null "
            + "WHERE id_cafeteria = %s";
    
    private static final String SQL_ELIMINAR_UNO
            = "DELETE FROM cafeteria WHERE id_cafeteria = %d";
    
    private static final String SQL_NULL = "NULL";
    
    public static void insertar(Cafeteria cafeteria) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        Statement sentencia = null;
        try {
            conexion = DerbyUtil.abrirConexion();
            String sentenciaInsert;
            if (!toSQLString(cafeteria.getNombreGerente()).equals(SQL_NULL)) {
                sentenciaInsert = String.format(SQL_INSERTAR_CON_GERENTE,
                        toSQLString(cafeteria.getHorario()),
                        toSQLString(cafeteria.getDireccion()),
                        toSQLString(cafeteria.getAforoLocal()),
                        toSQLString(cafeteria.getPrecioAlquiler()),
                        toSQLString(cafeteria.getNombreGerente()));
            } else {
                sentenciaInsert = String.format(SQL_INSERTAR_SIN_GERENTE,
                        toSQLString(cafeteria.getHorario()),
                        toSQLString(cafeteria.getDireccion()),
                        toSQLString(cafeteria.getAforoLocal()),
                        toSQLString(cafeteria.getPrecioAlquiler()));
            }
            
            sentencia = conexion.createStatement();
            
            sentencia.executeUpdate(sentenciaInsert);
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
            if (sentencia != null) {
                sentencia.close();
            }
        }
    }
    
    public static Cafeteria consultar(int codigo) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        Cafeteria cafeteria = null;
        Statement sentencia = null;
        try {
            conexion = DerbyUtil.abrirConexion();
            
            String sentenciaConsultar = String.format(SQL_CONSULTAR_UNO, codigo);
            sentencia = conexion.createStatement();
            
            ResultSet resultado = sentencia.executeQuery(sentenciaConsultar);
            if (resultado.next()) {
                cafeteria = nuevaCafeteria(resultado);
            }
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
            if (sentencia != null) {
                sentencia.close();
            }
        }
        
        return cafeteria;
    }
    
    private static Integer toInteger(String cadena) {
        if (cadena != null) {
            return Integer.valueOf(cadena);
        }
        return null;
    }
    
    private static Double toDouble(String cadena) {
        if (cadena != null) {
            return Double.valueOf(cadena);
        }
        return null;
    }
    
    public static List<Cafeteria> consultarTodos() throws ClassNotFoundException, SQLException {
        List<Cafeteria> cafeterias = new ArrayList<>();
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultados = null;
        try {
            conexion = DerbyUtil.abrirConexion();
            
            String sentenciaConsultar = String.format(SQL_CONSULTAR_TODOS);
            sentencia = conexion.createStatement();
            resultados = sentencia.executeQuery(sentenciaConsultar);
            
            while (resultados.next()) {
                cafeterias.add(nuevaCafeteria(resultados));
            }
            
        } finally {
            DerbyUtil.cerrarConexion(conexion);
            if (resultados != null) {
                resultados.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
        }
        
        return cafeterias;
    }
    
    public static boolean actualizar(Cafeteria cafeteria) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        boolean modificado = false;
        try {
            conexion = DerbyUtil.abrirConexion();
            String sentenciaActualizar;
            if (!toSQLString(cafeteria.getNombreGerente()).equals(SQL_NULL)) {
                sentenciaActualizar = String.format(SQL_ACTUALIZAR_UNO_CON_GERENTE,
                        toSQLString(cafeteria.getHorario()),
                        toSQLString(cafeteria.getDireccion()),
                        toSQLString(cafeteria.getAforoLocal()),
                        toSQLString(cafeteria.getPrecioAlquiler()),
                        toSQLString(cafeteria.getNombreGerente()),
                        toSQLString(cafeteria.getIdCafeteria()));
            } else {
                sentenciaActualizar = String.format(SQL_ACTUALIZAR_UNO_SIN_GERENTE,
                        toSQLString(cafeteria.getHorario()),
                        toSQLString(cafeteria.getDireccion()),
                        toSQLString(cafeteria.getAforoLocal()),
                        toSQLString(cafeteria.getPrecioAlquiler()),
                        toSQLString(cafeteria.getIdCafeteria()));
            }
            
            Statement sentencia = conexion.createStatement();
            if (sentencia.executeUpdate(sentenciaActualizar) == 1) {
                modificado = true;
            }
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
        
        return modificado;
    }
    
    public static boolean eliminar(int codigo) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        boolean eliminado = false;
        
        try {
            conexion = DerbyUtil.abrirConexion();
            
            String sentenciaActualizar = String.format(SQL_ELIMINAR_UNO, codigo);
            Statement sentencia = conexion.createStatement();
            if (sentencia.executeUpdate(sentenciaActualizar) == 1) {
                eliminado = true;
            }
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
        
        return eliminado;
    }
    
    private static Cafeteria nuevaCafeteria(ResultSet resultado) throws SQLException {
        return new Cafeteria(resultado.getInt("id_cafeteria"),
                resultado.getString("horario"),
                resultado.getString("direccion"),
                toInteger(resultado.getString("aforo_local")),
                toDouble(resultado.getString("precio_alquiler")),
                resultado.getString("nombre"));
    }
    
    private static String toSQLString(String cadena) {
        if (cadena == null || cadena.isBlank()) {
            return SQL_NULL;
        }
        return "'" + cadena + "'";
    }
    
    private static String toSQLString(Integer entero) {
        if (entero == null) {
            return SQL_NULL;
        }
        return entero.toString();
    }
    
    private static String toSQLString(Double decimal) {
        if (decimal == null) {
            return SQL_NULL;
        }
        return decimal.toString().replace(',', '.');
    }
}
