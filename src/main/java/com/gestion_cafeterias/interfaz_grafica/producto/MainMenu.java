/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gestion_cafeterias.interfaz_grafica.producto;

import com.gestion_cafeterias.acceso.AccesoProducto;
import com.gestion_cafeterias.modelo.Producto;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moha
 */
public class MainMenu extends javax.swing.JFrame {

    DefaultTableModel modelTabla = new DefaultTableModel();

    public MainMenu() {
        initComponents();
        LabelIdNoExist.setVisible(false);
        modelTabla.addColumn("ID");
        modelTabla.addColumn("Nombre");
        modelTabla.addColumn("Precio €");
        modelTabla.addColumn("Tipo");
        modelTabla.addColumn("Proveedor");
        if (TablaConsultar.isVisible()) {
            mostrar();
        }
    }

    private void mostrar() {

        try {
            List<Producto> productos = AccesoProducto.consultarTodos();

            TablaConsultar.setModel(modelTabla);

            String[] datos = new String[5];

            for (Producto producto : productos) {

                datos[0] = String.valueOf(producto.getIdProducto());
                datos[1] = producto.getNombre();
                datos[2] = String.valueOf(producto.getPrecio());
                datos[3] = producto.getTipo();
                datos[4] = producto.getProveedor();
                modelTabla.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            ExceptionDialog.setVisible(true);
            ErrTextArea.setText(e.getLocalizedMessage());
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void actualizarTabla() {
        DefaultTableModel model = (DefaultTableModel) TablaConsultar.getModel();
        model.setRowCount(0);
        mostrar();

    }

    public void limpiarTabla() {
        DefaultTableModel model = (DefaultTableModel) TablaConsultar.getModel();
        model.setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ExceptionDialog = new javax.swing.JDialog();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ErrTextArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaConsultar = new javax.swing.JTable();
        BtnVolver = new javax.swing.JButton();
        BtnInsertar = new javax.swing.JButton();
        BtnActualizar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnConsultaPorID = new javax.swing.JButton();
        LabelIdNoExist = new javax.swing.JLabel();
        AreaInputId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        ExceptionDialog.setTitle("Exception");
        ExceptionDialog.setSize(new java.awt.Dimension(379, 285));

        jLabel5.setText("Error de eliminacion. Descripcion del Error: ");

        ErrTextArea.setColumns(20);
        ErrTextArea.setRows(5);
        jScrollPane2.setViewportView(ErrTextArea);

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
        setIconImage((new javax.swing.ImageIcon("iconos/cafe.png")).getImage());

        TablaConsultar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Precio €", "Tipo", "Proveedor"
            }
        ));
        TablaConsultar.setGridColor(new java.awt.Color(0, 0, 204));
        jScrollPane1.setViewportView(TablaConsultar);

        BtnVolver.setText("Volver al listado");
        BtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVolverActionPerformed(evt);
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

        BtnConsultaPorID.setText("Consultar por ID");
        BtnConsultaPorID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConsultaPorIDActionPerformed(evt);
            }
        });

        LabelIdNoExist.setBackground(new java.awt.Color(204, 204, 204));
        LabelIdNoExist.setFont(new java.awt.Font("Sitka Subheading", 3, 12)); // NOI18N
        LabelIdNoExist.setForeground(new java.awt.Color(255, 0, 0));
        LabelIdNoExist.setIcon(new javax.swing.ImageIcon("iconos\\warning2.png"));

        AreaInputId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AreaInputIdActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AreaInputId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LabelIdNoExist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(BtnVolver)
                                .addGap(15, 15, 15)
                                .addComponent(BtnConsultaPorID)
                                .addGap(18, 18, 18)
                                .addComponent(BtnActualizar)))
                        .addGap(18, 18, 18)
                        .addComponent(BtnInsertar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                        .addComponent(BtnEliminar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AreaInputId)
                        .addComponent(jLabel1))
                    .addComponent(LabelIdNoExist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnVolver)
                    .addComponent(BtnInsertar)
                    .addComponent(BtnActualizar)
                    .addComponent(BtnConsultaPorID)
                    .addComponent(BtnEliminar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVolverActionPerformed
        LabelIdNoExist.setVisible(false);
        AreaInputId.setText("");
        limpiarTabla();
        mostrar();
        /* new InsertarMenu().setVisible(true);*/

    }//GEN-LAST:event_BtnVolverActionPerformed

    private void BtnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInsertarActionPerformed

        MenuInsertar ventana = new MenuInsertar();
        ventana.setVisible(true);

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                TablaConsultar.clearSelection();
                actualizarTabla();
            }
        });
    }//GEN-LAST:event_BtnInsertarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed

        MenuEliminar ventana = new MenuEliminar();
        ventana.setVisible(true);

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                TablaConsultar.clearSelection();
                actualizarTabla();
            }
        });
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        MenuActualizar ventana = new MenuActualizar();
        ventana.setVisible(true);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                TablaConsultar.clearSelection();
                actualizarTabla();
            }
        });

    }//GEN-LAST:event_BtnActualizarActionPerformed

    private void BtnConsultaPorIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConsultaPorIDActionPerformed

        try {

            int id = Integer.parseInt(AreaInputId.getText());

            List<Producto> productos = AccesoProducto.consultarPorID(id);

            TablaConsultar.setModel(modelTabla);

            String[] datos = new String[5];

            if (AccesoProducto.siExiste(id) == false) {
                LabelIdNoExist.setVisible(true);
                LabelIdNoExist.setText("¡ID no existe!");
            } else {
                LabelIdNoExist.setVisible(false);
                limpiarTabla();
                for (Producto producto : productos) {

                    datos[0] = String.valueOf(producto.getIdProducto());
                    datos[1] = producto.getNombre();
                    datos[2] = String.valueOf(producto.getPrecio());
                    datos[3] = producto.getTipo();
                    datos[4] = producto.getProveedor();
                    modelTabla.addRow(datos);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException nfe) {
            LabelIdNoExist.setVisible(true);
            LabelIdNoExist.setText("¡ID invalido!");
        } catch (Exception e) {
            ExceptionDialog.setVisible(true);
            ErrTextArea.setText(e.getLocalizedMessage());
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_BtnConsultaPorIDActionPerformed

    private void AreaInputIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AreaInputIdActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_AreaInputIdActionPerformed

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
            @Override
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AreaInputId;
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnConsultaPorID;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnInsertar;
    private javax.swing.JButton BtnVolver;
    private javax.swing.JTextArea ErrTextArea;
    private javax.swing.JDialog ExceptionDialog;
    private javax.swing.JLabel LabelIdNoExist;
    private javax.swing.JTable TablaConsultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
