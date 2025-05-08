/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gestioncafeterias.interfazGrafica.producto;

import com.gestioncafeterias.acceso.DerbyUtil;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andro
 */
public class MainMenu extends javax.swing.JFrame {

    DefaultTableModel modelTabla = new DefaultTableModel();

    /**
     * Creates new form MostrarProductos
     */
    public MainMenu() {
        initComponents();

        modelTabla.addColumn("ID");
        modelTabla.addColumn("Nombre");
        modelTabla.addColumn("Precio €");
        modelTabla.addColumn("Tipo");
        modelTabla.addColumn("Proveedor");
    }

    public void mostrar() throws SQLException, ClassNotFoundException {
        Connection conexion = null;
        conexion = DerbyUtil.abrirConexion();
        String sentenciaConsulta = String.format("SELECT * FROM producto");
        Statement sentencia = conexion.createStatement();
        ResultSet rs = sentencia.executeQuery(sentenciaConsulta);

        TablaConsultar.setModel(modelTabla);

        String[] datos = new String[5];

        while (rs.next()) {
            // Añadir filas (ajusta según tus columnas)

            datos[0] = rs.getString("id_producto");
            datos[1] = rs.getString("nombre");
            datos[2] = rs.getString("precio");
            datos[3] = rs.getString("tipo");
            datos[4] = rs.getString("proveedor");
            modelTabla.addRow(datos);

        }
        int filaSeleccionadaIn = TablaConsultar.getSelectedRow();
        String filaSeleccionadaStr = String.valueOf(filaSeleccionadaIn);
        LabelPrueba.setText(filaSeleccionadaStr);
        // Suponiendo que tu tabla se llama "miTabla" y el label "lblFilaSeleccionada"
    }

    public String getSelectedID() {
        int row = TablaConsultar.getSelectedRow();
        String value = TablaConsultar.getModel().getValueAt(row, 0).toString();
        LabelPrueba.setText("ID seleccionado: " + value);
        return value;
    }

    public void actualizarTabla() {
        try {
            DefaultTableModel model = (DefaultTableModel) TablaConsultar.getModel();
            model.setRowCount(0);
            mostrar();
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ExceptionDialog = new javax.swing.JDialog();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextErrEliminar = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaConsultar = new javax.swing.JTable();
        BtnConsultar = new javax.swing.JButton();
        BtnInsertar = new javax.swing.JButton();
        BtnActualizar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        LabelPrueba = new javax.swing.JLabel();
        UptTablaBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jVerify = new javax.swing.JLabel();

        ExceptionDialog.setTitle("Exception");
        ExceptionDialog.setSize(new java.awt.Dimension(379, 285));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\DAM1B22\\Pictures\\x-mark-64.png")); // NOI18N
        jLabel5.setText("Error de eliminacion. Descripcion del Error: ");

        TextErrEliminar.setColumns(20);
        TextErrEliminar.setRows(5);
        jScrollPane2.setViewportView(TextErrEliminar);

        javax.swing.GroupLayout ExceptionDialogLayout = new javax.swing.GroupLayout(ExceptionDialog.getContentPane());
        ExceptionDialog.getContentPane().setLayout(ExceptionDialogLayout);
        ExceptionDialogLayout.setHorizontalGroup(
            ExceptionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExceptionDialogLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(54, 54, 54))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExceptionDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        ExceptionDialogLayout.setVerticalGroup(
            ExceptionDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExceptionDialogLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UI Gestion de Productos");
        setForeground(new java.awt.Color(242, 242, 242));

        TablaConsultar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaConsultar.setGridColor(new java.awt.Color(0, 0, 204));
        jScrollPane1.setViewportView(TablaConsultar);

        BtnConsultar.setText("Consultar");
        BtnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConsultarActionPerformed(evt);
            }
        });

        BtnInsertar.setText("Insertar");
        BtnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInsertarActionPerformed(evt);
            }
        });

        BtnActualizar.setText("Actualizar");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        UptTablaBtn.setText("Actualizar tabla");
        UptTablaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UptTablaBtnActionPerformed(evt);
            }
        });

        jVerify.setIcon(new javax.swing.ImageIcon("C:\\Users\\DAM1B22\\Pictures\\greenCheck (1).png")); // NOI18N
        jVerify.setText("Eliminado!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BtnConsultar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnInsertar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(LabelPrueba)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UptTablaBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jVerify, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UptTablaBtn)
                .addGap(7, 7, 7)
                .addComponent(LabelPrueba)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jVerify)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnConsultar)
                    .addComponent(BtnInsertar)
                    .addComponent(BtnActualizar)
                    .addComponent(BtnEliminar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConsultarActionPerformed
        try {
            mostrar();
            /* new InsertarMenu().setVisible(true);*/
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnConsultarActionPerformed

    private void BtnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInsertarActionPerformed

        MenuInsertar ventana = new MenuInsertar();
        ventana.setVisible(true);

        ventana.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                TablaConsultar.clearSelection();
                actualizarTabla();
            }
        });
    }//GEN-LAST:event_BtnInsertarActionPerformed

    private void UptTablaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UptTablaBtnActionPerformed

        actualizarTabla();
    }//GEN-LAST:event_UptTablaBtnActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        
        MenuEliminar ventana = new MenuEliminar();
        ventana.setVisible(true);
        
        ventana.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {

                actualizarTabla();
            }
        });
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        MenuActualizar ventana = new MenuActualizar();
        ventana.setVisible(true);
        ventana.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                TablaConsultar.clearSelection();
                actualizarTabla();
            }
        });
    }//GEN-LAST:event_BtnActualizarActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnConsultar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnInsertar;
    private javax.swing.JDialog ExceptionDialog;
    private javax.swing.JLabel LabelPrueba;
    private javax.swing.JTable TablaConsultar;
    private javax.swing.JTextArea TextErrEliminar;
    private javax.swing.JButton UptTablaBtn;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jVerify;
    // End of variables declaration//GEN-END:variables
}
