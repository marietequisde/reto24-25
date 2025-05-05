/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestioncafeterias.interfazGrafica;

import com.gestioncafeterias.acceso.AccesoCafeteria;
import com.gestioncafeterias.modelo.Cafeteria;
import java.sql.SQLException;
import java.util.List;
import lib.Teclado;

/**
 *
 * @author DAM1B11
 */
public class PruebaCafeterias {

    public static void main(String[] args) {
        int opcion = 0;
        do {
            escribirMenuOpciones();
            opcion = Teclado.leerEntero("Opci?n: ");
            System.out.println();
            try {
                switch (opcion) {
                    case 0:
                        break;
                    case 1:
                        insertarCafeteria();
                        break;
                    case 2:
                        consultarCafeterias();
                        break;
                    case 3:
                        consultarCafeteria();
                        break;
                    case 4:
                        actualizarCafeteria();
                        break;
                    case 5:
                        eliminarCafeteria();
                        break;
                    default:
                        System.out.println("La opci?n de men? debe estar comprendida entre 0 y 5.");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Error de BBDD: " + e.getMessage());
                e.printStackTrace();
            }
            System.out.println();
        } while (opcion != 0);
    }

    public static void insertarCafeteria() throws ClassNotFoundException, SQLException {
        String nombre = Teclado.leerCadena("Nombre: ");
        String ubicacion = Teclado.leerCadena("Ubicaci?n: ");

        //Cafeteria cafeteria = new Cafeteria(nombre, ubicacion);
        //AccesoCafeteria.insertar(cafeteria);
        System.out.println("Se ha insertado un cafeteria en la base de datos.");

    }

    public static void consultarCafeterias() throws ClassNotFoundException, SQLException {
        List<Cafeteria> cafeterias = AccesoCafeteria.consultarTodos();
        escribirListaCafeterias(cafeterias);
    }

    public static void consultarCafeteria() throws ClassNotFoundException, SQLException {
        int codigo = Teclado.leerEntero("C?digo: ");
        Cafeteria cafeteria = AccesoCafeteria.consultar(codigo);

        if (cafeteria != null) {
            System.out.println(cafeteria.toString());
        } else {
            System.out.println("No existe ning?n cafeteria con ese c?digo en la base de datos.");
        }
    }

    public static void actualizarCafeteria() throws ClassNotFoundException, SQLException {
        int codigo = Teclado.leerEntero("C?digo: ");
        String nombre = Teclado.leerCadena("Nombre: ");
        String ubicacion = Teclado.leerCadena("Ubicaci?n: ");
        /*
        if (AccesoCafeteria.actualizar(codigo, nombre, ubicacion)) {
            System.out.println("Se ha actualizado un cafeteria de la base de datos.");
        } else {
            System.out.println("No existe ning?n cafeteria con ese c?digo en la base de datos.");
        }
         */
    }

    public static void eliminarCafeteria() throws ClassNotFoundException, SQLException {
        int codigo = Teclado.leerEntero("C?digo: ");

        if (AccesoCafeteria.eliminar(codigo)) {
            System.out.println("Se ha eliminado un cafeteria de la base de datos.");
        } else {
            System.out.println("No existe ning?n cafeteria con ese c?digo en la base de datos.");
        }
    }

    private static void escribirListaCafeterias(List<Cafeteria> cafeterias) {
        if (!cafeterias.isEmpty()) {
            for (Cafeteria cafeteria : cafeterias) {
                System.out.println(cafeteria.toString());
            }
            System.out.printf("Se han consultado %d cafeterias de la base de datos.\n", cafeterias.size());
        } else {
            System.out.println("La base de datos no tiene ning?n cafeteria.");
        }
    }

    private static void escribirMenuOpciones() {
        System.out.println("0) Salir del programa.");
        System.out.println("1) Insertar un cafeteria en la base de datos.");
        System.out.println("2) Consultar todos los cafeterias de la base de datos.");
        System.out.println("3) Consultar un cafeteria, por c?digo, de la base de datos.");
        System.out.println("4) Actualizar un cafeteria, por c?digo, de la base de datos.");
        System.out.println("5) Eliminar un cafeteria, por c?digo, de la base de datos.\r\n");
    }
}
