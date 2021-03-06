/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cod_mvc2;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author estudios
 */
public class Vista extends javax.swing.JFrame {
    DefaultTableModel modelo= new DefaultTableModel();
    Controlador control= new Controlador();
    /**
     * Creates new form Vista
     */
    public Vista() {
        initComponents();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        this.tabka.setModel(modelo);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabka = new javax.swing.JTable();
        bConn = new javax.swing.JButton();
        bMostrar = new javax.swing.JButton();
        bInsert = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabka.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabka);

        bConn.setText("Conectarse");
        bConn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConnActionPerformed(evt);
            }
        });

        bMostrar.setText("Mostrar");
        bMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMostrarActionPerformed(evt);
            }
        });

        bInsert.setText("Insert");
        bInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInsertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bConn)
                        .addGap(94, 94, 94)
                        .addComponent(bMostrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bInsert))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bConn)
                    .addComponent(bMostrar)
                    .addComponent(bInsert))
                .addGap(0, 59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Accion del boton conn que se encarga de conectarse a la base y muestra un mensaje si se conecto o un error si no.
     * @param evt 
     */
    private void bConnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConnActionPerformed
        if(control.crearBase())
            JOptionPane.showMessageDialog(null, "Conectado");
        else
            JOptionPane.showMessageDialog(null, "Error de conexion");
    }//GEN-LAST:event_bConnActionPerformed
    /**
     * Accion del boton del insert que se encarga de pedir los datos de la tabla para enviarselos al controlador.
     * Si se realizo correctamente se muestra un mensaje u otro si no se realizo correctamente
     * @param evt 
     */
    private void bInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInsertActionPerformed
       int id=Integer.parseInt(JOptionPane.showInputDialog("ID"));
       String nombre=JOptionPane.showInputDialog("Nombre");
       if(control.insert(id, nombre))
           JOptionPane.showMessageDialog(null, "Se ha añadido una fila");
       else
           JOptionPane.showMessageDialog(null, "Error en el proceso");
    }//GEN-LAST:event_bInsertActionPerformed
    /**
     * Boton mostrar que se encarga de actualizar el modelo  que recibe del controlador.
     * @param evt 
     */
    private void bMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMostrarActionPerformed
        DefaultTableModel tm=control.mostrar();
        this.tabka.setModel(tm);
    }//GEN-LAST:event_bMostrarActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bConn;
    public javax.swing.JButton bInsert;
    public javax.swing.JButton bMostrar;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tabka;
    // End of variables declaration//GEN-END:variables
}
