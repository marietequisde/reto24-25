/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gestion_cafeterias.interfaz_grafica.cafeteria;

import com.gestion_cafeterias.interfaz_grafica.ModeloTabla;
import com.gestion_cafeterias.acceso.AccesoCafeteria;
import com.gestion_cafeterias.interfaz_grafica.FilaTabla;
import com.gestion_cafeterias.modelo.Cafeteria;
import com.gestion_cafeterias.util.Constantes;
import com.gestion_cafeterias.util.PopUpError;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author Mario Fernández
 */
public class ConsultarCafeterias extends javax.swing.JFrame {

    public ConsultarCafeterias() {
        initComponents();
        inicializarComponentes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButtonRefrescar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jButtonInsertar = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCafeterias = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cafeterías");

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        jButtonRefrescar.setText("Volver al listado");
        jButtonRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefrescarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonRefrescar);

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonBuscar);

        jButtonInsertar.setText("Insertar");
        jButtonInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonInsertar);

        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonActualizar);

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonEliminar);

        jTableCafeterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableCafeterias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jTableCafeterias);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicializarComponentes() {
        inicializarBotones();
        inicializarTabla();
    }

    private void inicializarBotones() {
        jButtonEliminar.setEnabled(false);
        jButtonActualizar.setEnabled(false);
        jButtonRefrescar.setVisible(false);
    }

    private void inicializarTabla() {
        jTableCafeterias.setModel(new ModeloTabla(HEADER_CAFETERIAS));
        jTableCafeterias.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            jButtonEliminar.setEnabled(true);
            jButtonActualizar.setEnabled(true);
        });
        refrescarListado();
    }

    private void refrescarListado() {
        try {
            FilaTabla[] filas = AccesoCafeteria.consultarTodos().toArray(FilaTabla[]::new);
            obtenerModeloTabla().rellenar(filas);
        } catch (ClassNotFoundException | SQLException ex) {
            mostrarMensajeError(Constantes.ERROR_INTERNO);
            Logger.getLogger(ConsultarCafeterias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            mostrarMensajeError(Constantes.ERROR_INESPERADO);
            Logger.getLogger(ConsultarCafeterias.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void jButtonInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertarActionPerformed
        mostrarInsertarActualizar(null);
    }//GEN-LAST:event_jButtonInsertarActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        mostrarInsertarActualizar(obtenerIdSeleccion());
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void mostrarInsertarActualizar(Integer idCafeteria) {
        InsertarActualizarCafeteria ventana;
        if (idCafeteria == null) {
            ventana = new InsertarActualizarCafeteria(this, true);
        } else {
            ventana = new InsertarActualizarCafeteria(this, true, idCafeteria);
        }
        ventana.setLocationRelativeTo(jTableCafeterias);
        ventana.setVisible(true);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                refrescarListado();
                inicializarBotones();
            }
        });
    }

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(jTableCafeterias, "¿Eliminar cafetería?", "Eliminar", JOptionPane.YES_NO_OPTION);
        if (opcion == 0) {
            try {
                AccesoCafeteria.eliminar(obtenerIdSeleccion());
                refrescarListado();
                inicializarBotones();
            } catch (ClassNotFoundException | SQLException ex) {
                mostrarMensajeError(Constantes.ERROR_INTERNO);
                Logger.getLogger(ConsultarCafeterias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception e) {
                mostrarMensajeError(Constantes.ERROR_INESPERADO);
                Logger.getLogger(ConsultarCafeterias.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        try {
            String resultadoPopUp = JOptionPane.showInputDialog(jTableCafeterias, "Introduzca el id de la cafetería");
            if (resultadoPopUp != null && !resultadoPopUp.isEmpty()) {
                Cafeteria cafeteria = AccesoCafeteria.consultar(Integer.parseInt(resultadoPopUp));
                if (cafeteria != null) {
                    obtenerModeloTabla().mostrarElemento(cafeteria);
                    jButtonRefrescar.setVisible(true);
                } else {
                    mostrarMensajeError("No existe ninguna cafetería con id: " + resultadoPopUp);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            mostrarMensajeError(Constantes.ERROR_INTERNO);
            Logger.getLogger(ConsultarCafeterias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            mostrarMensajeError("El identificador debe ser numérico.");
            Logger.getLogger(ConsultarCafeterias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            mostrarMensajeError(Constantes.ERROR_INESPERADO);
            Logger.getLogger(ConsultarCafeterias.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefrescarActionPerformed
        refrescarListado();
        inicializarBotones();
    }//GEN-LAST:event_jButtonRefrescarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarCafeterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ConsultarCafeterias().setVisible(true);
        });
    }

    private int obtenerIdSeleccion() {
        int filaSeleccionada = jTableCafeterias.getSelectedRow();
        int filaModelo = jTableCafeterias.convertRowIndexToModel(filaSeleccionada);
        int idCafeteria = Integer.parseInt(obtenerModeloTabla().getValueAt(filaModelo, 0));
        return idCafeteria;
    }

    private ModeloTabla obtenerModeloTabla() {
        return (ModeloTabla) jTableCafeterias.getModel();
    }

    private void mostrarMensajeError(String mensaje) {
        PopUpError.mostrarError(jTableCafeterias, mensaje);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonInsertar;
    private javax.swing.JButton jButtonRefrescar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCafeterias;
    // End of variables declaration//GEN-END:variables
    private static final String[] HEADER_CAFETERIAS = new String[]{"id", "Horario", "Dirección", "Aforo", "Precio alquiler", "Gerente"};

}
