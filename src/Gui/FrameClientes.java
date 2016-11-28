package Gui;

import java.awt.Component;
import java.awt.event.*;
import java.util.*;
import segunda.progra.*;
import javax.swing.*;
import javax.swing.table.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Esteban
 */
public class FrameClientes extends JFrame {

    private ArrayList <Producto> productos;
    private String huesped = "localhost";
    /**
     * Creates new form Clientes
     */
    public FrameClientes() {
        initComponents();
        inicializarTabla();
    }

    /**
     * Este método se usa para que la tabla se inicialice con los productos conseguidos desde el servidor
     */
    private void inicializarTabla(){
        this.LabelCalorias.setVisible(false);
        this.Correcto.setVisible(false);
        boolean offline = !this.conseguirProductos();
        this.OffLine.setVisible(offline);
        this.CambiarHuesped.setVisible(offline);
        if(!offline){
            this.llenarTabla();
            this.jTableProductos.setRowHeight(25);
            TableModel modeloTabla = this.jTableProductos.getModel();
            TableRowSorter <TableModel> ordenador = new TableRowSorter<>(modeloTabla);
            this.jTableProductos.setRowSorter(ordenador);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        hacerPedido = new javax.swing.JButton();
        textFieldTelefono = new javax.swing.JTextField();
        textFieldPersona = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        checkBoxExpress = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textFieldDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Error = new javax.swing.JLabel();
        OffLine = new javax.swing.JLabel();
        Cleaner = new javax.swing.JButton();
        LabelCalorias = new javax.swing.JLabel();
        CambiarHuesped = new javax.swing.JButton();
        LabelFiltro = new javax.swing.JLabel();
        ParametroFiltro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        SpinnerColumna = new javax.swing.JSpinner();
        CheckBoxRecoger = new javax.swing.JCheckBox();
        Correcto = new javax.swing.JLabel();
        RefrescarProductos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenido a nuestro servicio online!");

        hacerPedido.setText("Hacer pedido");
        hacerPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hacerPedidoActionPerformed(evt);
            }
        });

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Seleccionado", "Cantidad", "Nombre", "Descripción", "Tipo", "Tamaño Porción", "Piezas Porción", "Calorías por Pieza", "Calorías por porción", "Precio", "Codigo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, true, false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProductos.getTableHeader().setReorderingAllowed(false);
        jTableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductosMouseClicked(evt);
            }
        });
        jTableProductos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTableProductosPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProductos);
        if (jTableProductos.getColumnModel().getColumnCount() > 0) {
            jTableProductos.getColumnModel().getColumn(0).setResizable(false);
            jTableProductos.getColumnModel().getColumn(1).setResizable(false);
            jTableProductos.getColumnModel().getColumn(2).setResizable(false);
            jTableProductos.getColumnModel().getColumn(4).setResizable(false);
            jTableProductos.getColumnModel().getColumn(5).setResizable(false);
            jTableProductos.getColumnModel().getColumn(6).setResizable(false);
        }

        checkBoxExpress.setText("Pedido Express");
        checkBoxExpress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxExpressActionPerformed(evt);
            }
        });

        jLabel2.setText("Persona:");

        jLabel3.setText("Número de Teléfono: ");

        textFieldDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldDireccionActionPerformed(evt);
            }
        });

        jLabel4.setText("Dirección: ");

        Error.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Error.setText("Error al hacer la solicitud con el servidor");

        this.Error.setVisible(false);

        OffLine.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        OffLine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OffLine.setText("Servidor Fuera De Línea");

        Cleaner.setText("Limpiar Pedido");
        Cleaner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CleanerActionPerformed(evt);
            }
        });

        LabelCalorias.setText("Su pedido contiene: ");

        CambiarHuesped.setText("Cambiar Huesped");
        CambiarHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiarHuespedActionPerformed(evt);
            }
        });

        LabelFiltro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabelFiltro.setText("Buscar: ");

        ParametroFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ParametroFiltroKeyTyped(evt);
            }
        });

        jLabel5.setText("de la columna: ");

        SpinnerColumna.setModel(new javax.swing.SpinnerNumberModel(2, 2, 4, 1));
        SpinnerColumna.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpinnerColumnaStateChanged(evt);
            }
        });

        CheckBoxRecoger.setText("Pedido A Recoger");

        Correcto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Correcto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Correcto.setText("Pedido Realizado Correctamente");

        RefrescarProductos.setText("Refrescar Productos");
        RefrescarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefrescarProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1341, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textFieldPersona, javax.swing.GroupLayout.DEFAULT_SIZE, 1154, Short.MAX_VALUE)
                            .addComponent(textFieldTelefono)
                            .addComponent(textFieldDireccion)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(OffLine, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(Error, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CheckBoxRecoger, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxExpress, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hacerPedido))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CambiarHuesped))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelCalorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ParametroFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SpinnerColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Correcto, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Cleaner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RefrescarProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(CambiarHuesped, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCalorias, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cleaner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Correcto, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(RefrescarProductos))
                    .addComponent(SpinnerColumna, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(LabelFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ParametroFiltro)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldPersona)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hacerPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxExpress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OffLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CheckBoxRecoger))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hacerPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hacerPedidoActionPerformed
        // TODO add your handling code here
        this.ParametroFiltro.setText("");
        TableRowSorter filtro = new TableRowSorter(this.jTableProductos.getModel());
        jTableProductos.setRowSorter(filtro);
        filtro.setRowFilter(RowFilter.regexFilter("", (int)this.SpinnerColumna.getValue()));
        jTableProductos.repaint();
        boolean error = !this.enviarPedido();
        this.Error.setVisible(error);
        this.CambiarHuesped.setVisible(error);
        this.Correcto.setVisible(!error);
        this.Cleaner.doClick();
    }//GEN-LAST:event_hacerPedidoActionPerformed

    private void checkBoxExpressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxExpressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxExpressActionPerformed

    private void textFieldDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldDireccionActionPerformed

    private void CleanerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CleanerActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < productos.size(); i++) {
            this.jTableProductos.setValueAt(new JCheckBox(""), i, 0);
            this.jTableProductos.setValueAt(new JSpinner(new SpinnerNumberModel(1, 1, 32000, 1)),i,1);
        }
        this.textFieldPersona.setText("");
        this.textFieldTelefono.setText("");
        this.textFieldDireccion.setText("");
        this.LabelCalorias.setVisible(false);
    }//GEN-LAST:event_CleanerActionPerformed

    private void jTableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductosMouseClicked
        // TODO add your handling code here:
        this.actualizarCaloriasPrecioPantalla();
    }//GEN-LAST:event_jTableProductosMouseClicked

    private void jTableProductosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTableProductosPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableProductosPropertyChange

    private void CambiarHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiarHuespedActionPerformed
        // TODO add your handling code here:
        this.huesped = (String) JOptionPane.showInputDialog("Inserte el nuevo huésped");
        inicializarTabla();
    }//GEN-LAST:event_CambiarHuespedActionPerformed

    private void ParametroFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ParametroFiltroKeyTyped
        // TODO add your handling code here:
        TableRowSorter filtro = new TableRowSorter(this.jTableProductos.getModel());
        jTableProductos.setRowSorter(filtro);
        filtro.setRowFilter(RowFilter.regexFilter(this.ParametroFiltro.getText().concat(String.valueOf(evt.getKeyChar())).trim(), (int)this.SpinnerColumna.getValue()));
        jTableProductos.repaint();
    }//GEN-LAST:event_ParametroFiltroKeyTyped

    private void SpinnerColumnaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpinnerColumnaStateChanged
        // TODO add your handling code here:
        TableRowSorter filtro = new TableRowSorter(this.jTableProductos.getModel());
        jTableProductos.setRowSorter(filtro);
        filtro.setRowFilter(RowFilter.regexFilter(this.ParametroFiltro.getText(), (int)this.SpinnerColumna.getValue()));
        jTableProductos.repaint();
    }//GEN-LAST:event_SpinnerColumnaStateChanged

    private void RefrescarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefrescarProductosActionPerformed
        // TODO add your handling code here:
        this.inicializarTabla();
    }//GEN-LAST:event_RefrescarProductosActionPerformed

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
            java.util.logging.Logger.getLogger(FrameClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrameClientes ventana = new FrameClientes();
                ventana.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CambiarHuesped;
    private javax.swing.JCheckBox CheckBoxRecoger;
    private javax.swing.JButton Cleaner;
    private javax.swing.JLabel Correcto;
    private javax.swing.JLabel Error;
    private javax.swing.JLabel LabelCalorias;
    private javax.swing.JLabel LabelFiltro;
    private javax.swing.JLabel OffLine;
    private javax.swing.JTextField ParametroFiltro;
    private javax.swing.JButton RefrescarProductos;
    private javax.swing.JSpinner SpinnerColumna;
    private javax.swing.JCheckBox checkBoxExpress;
    private javax.swing.JButton hacerPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTextField textFieldDireccion;
    private javax.swing.JTextField textFieldPersona;
    private javax.swing.JTextField textFieldTelefono;
    // End of variables declaration//GEN-END:variables
    
    private void actualizarCaloriasPrecioPantalla(){
        try{
            this.LabelCalorias.setVisible(true);
            int cantidadCalorias = 0;
            int precio = 0;
            TableModel modeloTabla = this.jTableProductos.getModel();
            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                JCheckBox checkBoxSeleccionado = (JCheckBox)modeloTabla.getValueAt(i, 0);
                if(checkBoxSeleccionado.isSelected()){
                    JSpinner spinnerCantidad = (JSpinner) modeloTabla.getValueAt(i, 1);
                    precio += ((int)(spinnerCantidad.getModel().getValue())) * (int)modeloTabla.getValueAt(i, 9);
                    cantidadCalorias += ((int)(spinnerCantidad.getModel().getValue())) * (int)modeloTabla.getValueAt(i, 7);
                }
            }
            if(this.checkBoxExpress.isSelected()){
                Cliente cliente = new Cliente(this.huesped);
                double transporteActual = (double)cliente.conseguirTransporte();
                precio += precio*(transporteActual/100);
            }
            this.LabelCalorias.setText("Su pedido contiene: " + cantidadCalorias + " calorías, con un coste preliminar de: " + precio + " colones");
        }catch(NullPointerException exc){
            System.out.println("Sin productos");
        }
    }
    
    /**
     * Este es un método tipo hilo para asegurarse de que los productos siempre sean los más actualizados
     */
    private boolean conseguirProductos(){
        Cliente cliente = new Cliente(this.huesped);
        this.productos = cliente.conseguirListaDeProductos();
        return this.productos != null;
    }
    
    /**
     * Este método lo que hace es que envía el pedido con los productos seleccionados
     * @return Si se pudo enviar o no al servidor, True si lo logró, False en el otro caso
     */
    private boolean enviarPedido(){
        //return cliente.hacerPedido(new Pedido(this.conseguirProductosSeleccionados(),this.conseguirCantidadProductosSeleccionados()));
        //¿Pedido nulo?
        if(!this.conseguirProductosSeleccionados().isEmpty() && !this.textFieldTelefono.getText().equals("") && !this.textFieldPersona.getText().equals("")){
            //hacer pedido
            if(this.checkBoxExpress.isSelected() && this.textFieldDireccion.getText().equals("")){
                return false;
            }
            Cliente cliente = new Cliente(this.huesped);
            int transporteActual = cliente.conseguirTransporte();
            if(this.checkBoxExpress.isSelected()){
                return cliente.hacerPedido(new Pedido(this.conseguirProductosSeleccionados(), this.conseguirCantidadProductosSeleccionados(), this.textFieldPersona.getText(), this.textFieldTelefono.getText(), textFieldDireccion.getText(),transporteActual));
            }
            return cliente.hacerPedido(new Pedido(this.conseguirProductosSeleccionados(), this.conseguirCantidadProductosSeleccionados(), this.textFieldPersona.getText(), this.textFieldTelefono.getText(),transporteActual,this.CheckBoxRecoger.isSelected()));
        }
        return false;
    }
    
    /**
     * Este método lo que hace es actualizar la tabla de los productos según los productos que se tienen en el sistema
     */
    private void llenarTabla(){
        Object[][] datosProductos = new Object[this.productos.size()][11];
        
        for (int i = 0; i < productos.size(); i++) {
            Producto getProducto = productos.get(i);
            datosProductos[i][0] = new JCheckBox("");
            datosProductos[i][1] = new JSpinner(new SpinnerNumberModel(1, 1, 32000, 1));
            datosProductos[i][2] = getProducto.getNombre();
            datosProductos[i][3] = getProducto.getDescripcion();
            datosProductos[i][4] = Tipo.fakeToString(getProducto.getTipo());
            datosProductos[i][5] = getProducto.getTamanhoPorcion();
            datosProductos[i][6] = getProducto.getPiezasPorcion();
            datosProductos[i][7] = getProducto.getCaloriasPieza();
            datosProductos[i][8] = getProducto.getCaloriasPorcion();
            datosProductos[i][9] = getProducto.getPrecio();
            datosProductos[i][10] = getProducto.getCodigo();
        }
        
        String [] nombreCol = {"Seleccionado", "Cantidad", "Nombre", "Descripción", "Tipo", "Tamaño Porción", "Piezas Porción","Calorías Por Pieza","Calorías Por Porción","Precio","Código"};
        
        this.jTableProductos.setModel(new DefaultTableModel(datosProductos, nombreCol){
            //a partir de aquí me pongo a modificar algunos aspectos del modelo
            
            
            //con esto defino los tipos por fuerza que va a tener el modelo
            Class[] tipos = new Class[]{
            //los primeros 2 son un check box y un JSpinner, son los que más importan, los integers son sólo para el ordenamiento, los strings son para
            //el filtrado
                JCheckBox.class,
                JSpinner.class,
                
                String.class,
                String.class,
                String.class,
                
                Integer.class,
                Integer.class,
                Integer.class,
                Integer.class,
                Integer.class,

                String.class};
            
            //este override es para modificar lo que consigue al intentar la tabla
            @Override
            public Class getColumnClass(int columnIndex){
                //Este método es invocado por el CellRenderer para saber que dibujar en la celda,
                //observen que estamos retornando la clase que definimos de antemano.
                return tipos[columnIndex];
            }
            
            @Override
            public boolean isCellEditable(int row, int column){
                //Sobrescribo este método para evitar que la columna que contiene los botones sea editada
                return !(this.getColumnClass(column).equals(JCheckBox.class)|| this.getColumnClass(column).equals(JSpinner.class));
            }
        });
        
        this.jTableProductos.setDefaultRenderer(JSpinner.class, new TableCellRenderer(){
            /**
             * Este método sólo se encarga de una sóla y simple idiotez:
             * retornar lo que entra xD
             * El asunto es que a la hora de pintar la tabla dibuje el objeto tal
             * y como entra, en lugar de hacerlo asquerosamente de manera default 
             * Resumen: hace que aparezca un JSpinner cuando aparece un JSpinner dentro de los datos
             */
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        
        this.jTableProductos.setDefaultRenderer(JCheckBox.class, new TableCellRenderer(){
            /**
             * Este método sólo se encarga de una sóla y simple idiotez:
             * retornar lo que entra xD
             * El asunto es que a la hora de pintar la tabla dibuje el objeto tal
             * y como entra, en lugar de hacerlo asquerosamente de manera default 
             * Resumen: hace que aparezca un JCheckBox cuando aparece un JCheckBox dentro de los datos
             */
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        
        jTableProductos.addMouseListener(new MouseAdapter() {
            /*
            el mouse listener se coloca en la tabla y no en la ventana, así logro saber en qué celda se dio
            clic, en lugar de buscar por el frame al que pertenece
            el asunto es que tengo que capturar cuando el mouse clickea en el botón de mostrar el mapa
            */
            @Override
            public void mouseClicked(MouseEvent e){   
                
                int fila = jTableProductos.rowAtPoint(e.getPoint());
                int columna = jTableProductos.columnAtPoint(e.getPoint());
                
                /**
                 * Pregunto si hizo clic sobre la celda que contiene el JCheckBox de la fila
                 */
                if (jTableProductos.getModel().getColumnClass(columna).equals(JCheckBox.class)) {
                    JCheckBox checkBoxAModificar = (JCheckBox)jTableProductos.getValueAt(fila, columna);
                    checkBoxAModificar.doClick();
                    jTableProductos.setValueAt(checkBoxAModificar, fila, columna);
                    jTableProductosMouseClicked(e);
                }
                /**
                 * Pregunto si hizo clic sobre la celda que contiene el JSpinner de la fila
                 */
                if(jTableProductos.getModel().getColumnClass(columna).equals(JSpinner.class)){
                    JSpinner jSpinnerAModificar = (JSpinner)jTableProductos.getValueAt(fila, columna);
                    SpinnerModel modeloAModificar = jSpinnerAModificar.getModel();
                    modeloAModificar.setValue(modeloAModificar.getNextValue());
                    jSpinnerAModificar.setModel(modeloAModificar);
                    jTableProductos.setValueAt(jSpinnerAModificar, fila, columna);
                    jTableProductosMouseClicked(e);
                }
            }
        });
    }
    
    /**
     * Este método lo que hace es recorrer toda la tabla de productos en búsqueda de los productos que hayan sido seleccionados
     * y los agrega a la lista que retorna, siendo los Producto del ArrayList los productos seleccionados
     * @return Un ArrayList con los productos que hayan sido seleccionados dentro de la ventana, (algún día)
     */
    private ArrayList<Producto> conseguirProductosSeleccionados(){
        ArrayList <Producto> productosSeleccionados = new ArrayList<>();
        TableModel modeloTabla = this.jTableProductos.getModel();
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            //Consigo el checkbox de la primera columna, que dicta si el producto está seleccionado
            JCheckBox checkBoxSeleccionada = (JCheckBox)modeloTabla.getValueAt(i, 0);
            //¿Está seleccionado?
            if(checkBoxSeleccionada.isSelected()){
                productosSeleccionados.add(this.productos.get(this.productos.indexOf(new Producto((String)modeloTabla.getValueAt(i, 10)))));
            }
        }
        return productosSeleccionados;
    }
    
    /**
     * Este método lo que hace es que recorre toda la tabla de productos para conseguir la cantidad de los productos
     * seleccionados en la misma
     * @return Un arreglo que contiene la cantidad de los productos seleccionados
     */
    private int[] conseguirCantidadProductosSeleccionados(){
        int [] productosSeleccionados = new int[this.conseguirProductosSeleccionados().size()];        
        TableModel modeloTabla = this.jTableProductos.getModel();
        int posicionEscritura = 0;
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            //Consigo el checkbox de la primera columna, que dicta si el producto está seleccionado
            JCheckBox checkBoxSeleccionada = (JCheckBox)modeloTabla.getValueAt(i, 0);
            //¿Está seleccionado?
            if(checkBoxSeleccionada.isSelected()){
                JSpinner jSpinnerCantidadSeleccionados = (JSpinner)(modeloTabla.getValueAt(i, 1));
                productosSeleccionados[posicionEscritura] = (int)jSpinnerCantidadSeleccionados.getModel().getValue();
                posicionEscritura++;
            }
        }
        return productosSeleccionados;
    }
}
