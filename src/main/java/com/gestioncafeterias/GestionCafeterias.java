/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.gestioncafeterias;

import com.gestioncafeterias.acceso.AccesoEmpleado;
import com.gestioncafeterias.modelo.Empleado;
import consola.Teclado;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DAM1B07+
 */
public class GestionCafeterias {
 private static void menu() {
		System.out.println("(0) Salir.\n" 
				+"(1) Insertar un empleado en la base de datos..\n"
				+ "(2)Consultar todos los empleados de la base de datos..\n"
				+ "(3) Consultar un empleado, por codigo de la base de datos.\n" 
				+ "(4) Actualizar un empleado, por codigo, de la base de datos.\n"
				+ "(5) Eliminar un empleado, por codigo , de la base de datos..\n");
			System.out.println();
	}
	
    private static void escribirListaEmpleados(List<Empleado> empleados) {
        if (!empleados.isEmpty()) {
            for (Empleado empleado : empleados) {
                System.out.println(empleado.toString());
            }
            System.out.printf("Se han consultado" + empleados.size() + "empleados de la base de datos.\n");
        } else {
            System.out.println("La base de datos no tiene ning?n empleado.");
        }
    }

	public static void main(String[] args) {
		int opcion,codigo,total;
                double salario;
		Empleado empleado;
		String nombre, fechaAlta, dni;
		List<Empleado> listaEmpleados;
		try {
			do {
				menu();
				opcion=Teclado.leerEntero("Opcion?: ");

				switch(opcion) {
				case 0:
					//Salir del programa.
					break;
				case 1:
					//Insertar un empleado en la base de datos
					nombre = Teclado.leerCadena("Nombre?: ");
					fechaAlta = Teclado.leerCadena("fecha de alta?: ");
                                        salario = Teclado.leerReal("Salario?");
					dni = Teclado.leerCadena("dni?");
                                        empleado = new Empleado(nombre, salario, fechaAlta, dni);
					AccesoEmpleado.insertar(empleado);
					System.out.println("Se ha insertado un empleado en la base de datos.");
					System.out.println();
					break;
				case 2:
                                    listaEmpleados = AccesoEmpleado.consultarTodos();
                                    escribirListaEmpleados(listaEmpleados);
                                    System.out.println();
                                    break;
				case 3:
                                    codigo = Teclado.leerNatural("Codigo?");
                                    empleado = AccesoEmpleado.consultar(codigo);
                                    if(empleado == null) {
                                            System.out.println("No existe empleado con ese id");
                                    }
                                    else {
                                            System.out.println(empleado.toString());
                                    }
                                    break;
				case 4:
                                    //Actualizar un departamento, por OID, de la base de datos.
                                    codigo=Teclado.leerEntero("Codigo/OID?: ");
                                    empleado = AccesoEmpleado.consultar(codigo);
                                                    if(empleado == null) {
                                                            System.out.println("No existe empleado con ese oid");
                                                    }
                                                    else {
                                                        nombre = Teclado.leerCadena("Nombre?: ");
                                                        fechaAlta = Teclado.leerCadena("fecha de alta?: ");
                                                        salario = Teclado.leerReal("Salario?");
                                                        dni = Teclado.leerCadena("dni?");
                                            if(AccesoEmpleado.actualizar(codigo, nombre, salario, fechaAlta, dni)) {
                                                    System.out.println("Se ha actualizado un empleado de la base de datos");
                                            }
                                            else {
                                                    System.out.println("No existe ningún empleado con ese ID en la base de datos.");
                                            }
                                                    }
                                    break;
				case 5:
					//Eliminar un departamento, por codigo, de la base de datos.
					codigo=Teclado.leerEntero("Codigo?: ");
					 if(AccesoEmpleado.eliminar(codigo)) {
						System.out.println("Se ha eliminado un empleado de la base de datos.");
                                            }
						else {
							System.out.println("No existe ningún empleado con ese OID en la base de datos.");
						}
                                        System.out.println();
					break;
				default:
					System.out.println("La opción de menú debe estar comprendida entre 0 y 5.");
					break;
				}
			}
			while(opcion!=0);
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("No existe ningún departamento con ese OID en la base de datos.");
		}
                catch(SQLException sqle){
                    System.out.println(sqle.getMessage());
                    sqle.getErrorCode();
                    sqle.toString();
                }
	}
}
