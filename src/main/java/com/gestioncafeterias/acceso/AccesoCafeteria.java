package com.gestioncafeterias.acceso;

import com.gestioncafeterias.modelo.Cafeteria;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class AccesoCafeteria {

    public static void insertar(Cafeteria cafeteria) throws ClassNotFoundException, SQLException {
        Connection conexion = null;

        try {
            conexion = DerbyUtil.abrirConexion();

            String stringPrecio = String.valueOf(cafeteria.getPrecioAlquiler()).replace(',', '.');
            String sentenciaInsert = String.format("INSERT INTO cafeteria (horario, direccion, aforo_local, precio_alquiler, gerente) "
                    + "VALUES ('%s', '%s', %d, %s, (SELECT id_empleado FROM empleado WHERE nombre = '%s'))",
                    cafeteria.getHorario(), cafeteria.getDireccion(),
                    cafeteria.getAforoLocal(), stringPrecio, cafeteria.getNombreGerente());
            System.out.println(sentenciaInsert);
            Statement sentencia = conexion.createStatement();

            sentencia.executeUpdate(sentenciaInsert);
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }
    }

    public static Cafeteria consultar(int codigo) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        Cafeteria cafeteria = null;

        try {
            conexion = DerbyUtil.abrirConexion();

            String sentenciaConsultar = String.format("SELECT id_cafeteria, horario, direccion, aforo_local, precio_alquiler, nombre "
                    + "FROM cafeteria "
                    + "LEFT JOIN empleado ON gerente = id_empleado "
                    + "WHERE id_cafeteria = %d", codigo);
            Statement sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery(sentenciaConsultar);
            if (resultado.next()) {
                cafeteria = new Cafeteria(resultado.getInt("id_cafeteria"),
                        resultado.getString("horario"),
                        resultado.getString("direccion"),
                        resultado.getInt("aforo_local"),
                        resultado.getDouble("precio_alquiler"),
                        resultado.getString("nombre"));
            }
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }

        return cafeteria;
    }

    public static List<Cafeteria> consultarTodos() throws ClassNotFoundException, SQLException {
        List<Cafeteria> cafeterias = new ArrayList<>();
        Connection conexion = null;

        try {
            conexion = DerbyUtil.abrirConexion();

            String sentenciaConsultar = String.format("SELECT id_cafeteria, horario, direccion, aforo_local, precio_alquiler, nombre "
                    + "FROM cafeteria "
                    + "LEFT JOIN empleado ON gerente = id_empleado");
            Statement sentencia = conexion.createStatement();
            ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);

            while (resultados.next()) {
                Cafeteria cafeteria = new Cafeteria(resultados.getInt("id_cafeteria"),
                        resultados.getString("horario"),
                        resultados.getString("direccion"),
                        resultados.getInt("aforo_local"),
                        resultados.getDouble("precio_alquiler"),
                        resultados.getString("nombre"));
                cafeterias.add(cafeteria);
            }

            resultados.close();
            sentencia.close();
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }

        return cafeterias;
    }

    public static boolean actualizar(int codigo, String horario, String direccion, int aforoLocal, double precioAlquiler, String nombreGerente) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        boolean modificado = false;

        try {
            conexion = DerbyUtil.abrirConexion();
            String precioString = String.format("%.2f", precioAlquiler).replace(',', '.');
            String sentenciaActualizar = String.format("UPDATE cafeteria "
                    + "SET horario = '%s', direccion = '%s', aforo_local = %d, precio_alquiler = %s , "
                    + "gerente = (SELECT id_empleado FROM empleado WHERE nombre = '%s') "
                    + "WHERE id_cafeteria = %d", horario, direccion, aforoLocal, precioString, nombreGerente, codigo);
            System.out.println(sentenciaActualizar);
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

            String sentenciaActualizar = String.format("DELETE FROM cafeteria "
                    + "WHERE id_cafeteria = %d", codigo);
            Statement sentencia = conexion.createStatement();
            if (sentencia.executeUpdate(sentenciaActualizar) == 1) {
                eliminado = true;
            }
        } finally {
            DerbyUtil.cerrarConexion(conexion);
        }

        return eliminado;
    }
}
