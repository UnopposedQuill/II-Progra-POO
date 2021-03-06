package Gui;

import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import segunda.progra.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Esta será la ventana controlada por el administrador del servidor
 * @author Esteban
 */
public class FrameAdministrador extends javax.swing.JFrame {

    private Administrador administrador;
    private HiloActualizador hiloPedidos;
    private HiloActualizador hiloConexiones;
    private HiloActualizador hiloCantidadPedidos;
    
    /**
     * Creates new form Administrador
     */
    public FrameAdministrador() {
        initComponents();
        //creo el nuevo administrador desde 0
        this.administrador = null;
        /*
        this.administrador = new Administrador(new Servidor());
        //ahora defino los hilos que actualizarán las tablas de la ventana del administrador
        //por ahora irán aquí, luego de que implemente el login, irán luego del mismo
        this.hiloConexiones = new HiloActualizador(this.administrador.getServidor().getConexiones(), this.IP);
        this.hiloPedidos = new HiloActualizador(this.administrador.getServidor().getPedidos(), this.Pedidos);
        //arranco los 3 hilos que tiene la ventana: los pedidos, conexiones y el más importante, el servidor
        this.hiloConexiones.start();
        this.hiloPedidos.start();
        this.administrador.arrancarServidor();
        */
        //Esto es para que cuando se arranque la ventana, aparezca una sólo el login
        this.setVisibilidadSesion(false);
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
        IP = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Pedidos = new javax.swing.JTable();
        LabelBienvenido = new javax.swing.JLabel();
        LabelConexiones = new javax.swing.JLabel();
        LabelPedidos = new javax.swing.JLabel();
        IniciarSesión = new javax.swing.JButton();
        Administrador = new javax.swing.JTextField();
        LabelAdministrador = new javax.swing.JLabel();
        LabelContraseña = new javax.swing.JLabel();
        Contraseña = new javax.swing.JPasswordField();
        observarMejoresProductos = new javax.swing.JButton();
        observarPeoresProductos = new javax.swing.JButton();
        observarRelacionPorcentual = new javax.swing.JButton();
        agregarNuevoProducto = new javax.swing.JButton();
        observarTodosProductos = new javax.swing.JButton();
        PorcentajeExpress = new javax.swing.JTextField();
        LabelEmpaque = new javax.swing.JLabel();
        Error = new javax.swing.JLabel();
        CantidadTotalPedidos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador");

        IP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Dirección IP Global", "Dirección IP Local", "Tipo de Solicitud"
            }
        ));
        this.LabelConexiones.setVisible(false);
        this.LabelPedidos.setVisible(false);
        this.IP.setVisible(false);
        this.Pedidos.setVisible(false);
        jScrollPane1.setViewportView(IP);

        Pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Persona", "Número de Teléfono", "Precio Total", "Dirección", "Cantidad De Productos", "Tipo de Pedido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Pedidos);

        LabelBienvenido.setText("Bienvenido");

        LabelConexiones.setText("Conexiones");

        LabelPedidos.setText("Pedidos");

        IniciarSesión.setText("Iniciar Sesión");
        IniciarSesión.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarSesiónActionPerformed(evt);
            }
        });

        Administrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdministradorActionPerformed(evt);
            }
        });

        LabelAdministrador.setText("Administrador: ");

        LabelContraseña.setText("Contraseña:");

        Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraseñaActionPerformed(evt);
            }
        });

        observarMejoresProductos.setText("Observar Mejores Productos");
        observarMejoresProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                observarMejoresProductosActionPerformed(evt);
            }
        });

        observarPeoresProductos.setText("Observar Peores Productos");
        observarPeoresProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                observarPeoresProductosActionPerformed(evt);
            }
        });

        observarRelacionPorcentual.setText("Observar Relación Porcentual");
        observarRelacionPorcentual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                observarRelacionPorcentualActionPerformed(evt);
            }
        });

        agregarNuevoProducto.setText("Agregar Nuevo Producto");
        agregarNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarNuevoProductoActionPerformed(evt);
            }
        });

        observarTodosProductos.setText("Observar Todos Los Productos");
        observarTodosProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                observarTodosProductosActionPerformed(evt);
            }
        });

        PorcentajeExpress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PorcentajeExpress.setText("15");
        PorcentajeExpress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                PorcentajeExpressFocusLost(evt);
            }
        });
        PorcentajeExpress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PorcentajeExpressActionPerformed(evt);
            }
        });

        LabelEmpaque.setText("Porcentaje Empaque:");

        Error.setText("Error al Iniciar Sesión");

        CantidadTotalPedidos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        CantidadTotalPedidos.setText("Cantidad Total Actual de Pedidos: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelConexiones)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(LabelContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(LabelAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(IniciarSesión, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LabelEmpaque, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PorcentajeExpress, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(observarMejoresProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(observarTodosProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(observarPeoresProductos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(agregarNuevoProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96)
                        .addComponent(observarRelacionPorcentual))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CantidadTotalPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PorcentajeExpress, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelEmpaque, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LabelAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IniciarSesión))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelConexiones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CantidadTotalPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(observarRelacionPorcentual, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(observarPeoresProductos))
                    .addComponent(observarMejoresProductos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agregarNuevoProducto)
                    .addComponent(observarTodosProductos))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IniciarSesiónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarSesiónActionPerformed
        // TODO add your handling code here:
        //¿El administrador es nulo?
        if(this.administrador == null){
            //Debo iniciar sesión
            this.administrador = new Administrador(this.Administrador.getText(), String.valueOf(this.Contraseña.getPassword()));
            if(this.administrador.getNombreUsuario() == null){
                //el inicio de sesión no fue correcto
                this.Error.setVisible(true);
                this.administrador = null;
            }
            else{
                //inicio de sesión correcto, Bienvenido Administrador.
                //Preparo todos los hilos y sistemas correspondientes al administrador conectado
                this.Error.setVisible(false);
                //creo los hilos de actualizaciones
                this.hiloConexiones = new HiloActualizador(this.administrador.getServidor().getConexiones(), this.IP);
                this.hiloPedidos = new HiloActualizador(this.administrador.getServidor().getPedidos(), this.Pedidos);
                this.hiloCantidadPedidos = new HiloActualizador(this.administrador.getServidor().getPedidos(), this.CantidadTotalPedidos);
                //arranco los hilos que tiene la ventana: los pedidos y conexiones
                this.hiloConexiones.start();
                this.hiloPedidos.start();
                this.hiloCantidadPedidos.start();
                //ahora los labels
                this.setVisibilidadSesion(true);
            }
        }
        else{
            //se desea desconectar
            this.administrador.getServidor().pararServidor();
            this.administrador.getServidor().asesinarServidor();
            this.administrador = null;
            this.setVisibilidadSesion(false);
        }
    }//GEN-LAST:event_IniciarSesiónActionPerformed

    private void AdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdministradorActionPerformed

    private void ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContraseñaActionPerformed

    private void observarRelacionPorcentualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_observarRelacionPorcentualActionPerformed
        // TODO add your handling code here:
        Object [][] datos = new Object[1][3];
        int[]porcentajes = this.porcentaje(this.cantidadPedidosARecoger(), this.cantidadTotalPedidosEnSitio(), this.cantidadTotalPedidosExpress());
        
        datos[0][0] = String.valueOf(porcentajes[0]).concat("%");
        datos[0][1] = String.valueOf(porcentajes[1]).concat("%");
        datos[0][2] = String.valueOf(porcentajes[2]).concat("%");
        
        String[] columnas = {"Pedidos A Recoger", "Pedidos En Sitio", "Pedidos Express"};
        DefaultTableModel modeloTablaPorcentajes = new DefaultTableModel(datos, columnas);
        JTable tabla = new JTable(modeloTablaPorcentajes);
        JScrollPane scrollPane = new JScrollPane(tabla);
        JFrame frame = new JFrame("Tabla Con La Relación Porcentual de Pedidos");
        frame.setBounds(0, 0, 450, 250);
        frame.getContentPane().add(scrollPane);
        frame.setVisible(true);
    }//GEN-LAST:event_observarRelacionPorcentualActionPerformed

    private void PorcentajeExpressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PorcentajeExpressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PorcentajeExpressActionPerformed

    private void PorcentajeExpressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PorcentajeExpressFocusLost
        // TODO add your handling code here:
        this.administrador.getServidor().setAumentoEmpaque(Integer.parseInt(this.PorcentajeExpress.getText()));
    }//GEN-LAST:event_PorcentajeExpressFocusLost

    private void agregarNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarNuevoProductoActionPerformed
        // TODO add your handling code here:
        AgenteProductos modificadorBaseDatos = new AgenteProductos(this.administrador.getServidor());
        modificadorBaseDatos.setVisible(true);
    }//GEN-LAST:event_agregarNuevoProductoActionPerformed

    private void observarTodosProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_observarTodosProductosActionPerformed
        // TODO add your handling code here:
        //la clase todos los productos no necesariamente contiene todos los productos, pero en este caso sí le
        //estoy pasando todos
        TodosLosProductos tablaTodosProductos = new TodosLosProductos(this.administrador.getServidor().getProductos(), this.administrador.getServidor());
        tablaTodosProductos.setVisible(true);
    }//GEN-LAST:event_observarTodosProductosActionPerformed

    private void observarPeoresProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_observarPeoresProductosActionPerformed
        // TODO add your handling code here:
        ArrayList <Producto> peoresProductos = new ArrayList();
        ArrayList <Producto> listaProductos = this.administrador.getServidor().getProductos();
        int [] cantidadesProductos = this.conseguirCantidadesPedidos();
        for (int i = 0; i < cantidadesProductos.length; i++) {
            int cantidadesProducto = cantidadesProductos[i];
            if(cantidadesProducto == 0){
                peoresProductos.add(listaProductos.get(i));
            }
        }
        //este es un caso en el que "todos los productos" no contiene todos los productos, en lugar de eso, sólo
        //contiene una cantidad específica de elementos: los que no han sido pedidos
        TodosLosProductos tablaTodosProductos = new TodosLosProductos(peoresProductos, this.administrador.getServidor());
        tablaTodosProductos.setVisible(true);
    }//GEN-LAST:event_observarPeoresProductosActionPerformed

    private void observarMejoresProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_observarMejoresProductosActionPerformed
        // TODO add your handling code here:
        ArrayList <Producto> listaProductos = this.administrador.getServidor().getProductos();
        ArrayList <IdentificadoresOrden> listaOrdenada = new ArrayList<>();
        int [] cantidadesProductosPedidos = this.conseguirCantidadesPedidos();
        for (int i = 0; i < listaProductos.size(); i++) {
            Producto get = listaProductos.get(i);
            listaOrdenada.add(new IdentificadoresOrden(get.getCodigo(), cantidadesProductosPedidos[i]));
        }
        //El sorting
        Collections.sort(listaOrdenada, (IdentificadoresOrden o1, IdentificadoresOrden o2) 
                -> new Integer(o2.getCantidadPedido()).compareTo(o1.getCantidadPedido()));
        ArrayList <Producto> mejoresProductos = new ArrayList<>();
        for (int i = 0; i < listaOrdenada.size() && i < 10; i++) {
            IdentificadoresOrden get = listaOrdenada.get(i);
            mejoresProductos.add(listaProductos.get(listaProductos.indexOf(new Producto(get.getCodigo()))));
        }
        TodosLosProductos tablaTodosProductos = new TodosLosProductos(mejoresProductos, this.administrador.getServidor());
        tablaTodosProductos.setVisible(true);
    }//GEN-LAST:event_observarMejoresProductosActionPerformed

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
            java.util.logging.Logger.getLogger(FrameAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrameAdministrador ventana = new FrameAdministrador();
                ventana.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Administrador;
    private javax.swing.JLabel CantidadTotalPedidos;
    private javax.swing.JPasswordField Contraseña;
    private javax.swing.JLabel Error;
    private javax.swing.JTable IP;
    private javax.swing.JButton IniciarSesión;
    private javax.swing.JLabel LabelAdministrador;
    private javax.swing.JLabel LabelBienvenido;
    private javax.swing.JLabel LabelConexiones;
    private javax.swing.JLabel LabelContraseña;
    private javax.swing.JLabel LabelEmpaque;
    private javax.swing.JLabel LabelPedidos;
    private javax.swing.JTable Pedidos;
    private javax.swing.JTextField PorcentajeExpress;
    private javax.swing.JButton agregarNuevoProducto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton observarMejoresProductos;
    private javax.swing.JButton observarPeoresProductos;
    private javax.swing.JButton observarRelacionPorcentual;
    private javax.swing.JButton observarTodosProductos;
    // End of variables declaration//GEN-END:variables

    /**
     * Este método consigue un arreglo de la cantidad de veces que se han pedido todos los productos, estarán ordenados igual que en el arrayList
     * @return Un arreglo de enteros que contiene la cantidad de veces que se ha pedido cada producto
     */
    private int[] conseguirCantidadesPedidos(){
        //creo un par de referencias a los dos arrayLists que debo ir leyendo, los pedidos me dicen las cantidades, los productos me guían en donde debo
        //escribir la cantidad de productos
        ArrayList <Pedido> pedidosALeer = this.administrador.getServidor().getPedidos();
        ArrayList <Producto> referenciaProductos = this.administrador.getServidor().getProductos();
        //creo un arreglo que contendrá el resultado, será del tamaño de la lista de productos
        int[] cantidadProductos = new int[referenciaProductos.size()];
        for (int i = 0; i < cantidadProductos.length; i++) {cantidadProductos[i] = 0;}//limpio el nuevo arreglo
        
        //ahora toca llenar el nuevo arreglo
        for (int i = 0; i < pedidosALeer.size(); i++) {
            Pedido getPedido = pedidosALeer.get(i);//tomo el pedido, que me dirá cuánto se pidió
            for (int j = 0; j < getPedido.getProductosPedidos().size(); j++) {
                Producto getProductosPedido = getPedido.getProductosPedidos().get(j);//para cada uno de los productos que se pidieron
                //escriba en la posición "Conseguir posición del producto en el arrayList" |=| la cantidad que se pidió de ese producto
                cantidadProductos[referenciaProductos.indexOf(getProductosPedido)] = getPedido.getCantidadProductos()[j];
            }
        }
        //el arreglo debería estar listo
        return cantidadProductos;
    }
    
    /**
     * Este método averigua la cantidad total de productos pedidos
     * @return Un entero con la cantidad total de productos que se ordenaron
     */
    private int cantidadTotalProductosPedidos(){
        return Pedido.cantidadTotal(this.conseguirCantidadesPedidos());
    }
    
    /**
     * Este método va revisando todos los pedidos buscando cuáles son express
     * @return Un entero con la cantidad de pedidos que son express
     */
    private int cantidadTotalPedidosExpress(){
        int cantidadExpress = 0;
        for (int i = 0; i < this.administrador.getServidor().getPedidos().size(); i++) {
            Pedido get = this.administrador.getServidor().getPedidos().get(i);
            if(get.isExpress()){
                cantidadExpress++;
            }
        }
        return cantidadExpress;
    }
    
    /**
     * Este método va revisando todos los pedidos buscando cuáles no son express
     * @return Un entero con la cantidad de pedidos que no son express
     */
    private int cantidadTotalPedidosEnSitio(){
        int cantidadPedidos = 0;
        for (int i = 0; i < this.administrador.getServidor().getPedidos().size(); i++) {
            Pedido get = this.administrador.getServidor().getPedidos().get(i);
            if(!get.isARecoger() && !get.isExpress()){
                cantidadPedidos++;
            }
        }
        return cantidadPedidos;
    }
    
    private int cantidadPedidosARecoger(){
        int cantidadPedidos = 0;
        for (int i = 0; i < this.administrador.getServidor().getPedidos().size(); i++) {
            Pedido get = this.administrador.getServidor().getPedidos().get(i);
            if(get.isARecoger()){
                cantidadPedidos++;
            }
        }
        return cantidadPedidos;
    }
    
    /**
     * Este método retorna la cantidad total de pedidos 
     * @return Un entero con la cantidad total de pedidos del servidor
     */
    public int cantidadTotalPedidos(){
        return this.cantidadPedidosARecoger() + this.cantidadTotalPedidosEnSitio() + this.cantidadTotalPedidosExpress();
    }
    
    /**
     * Este método esconde los labels y demás componentes típicos de cuando está con sesión iniciada que cuando
     * está con sesión no iniciada
     * @param inicioODesconexion True si se desea que esté con la interfaz conectada, False para desconectada
     */
    private void setVisibilidadSesion(boolean inicioODesconexion){
        if(inicioODesconexion){
            this.Error.setVisible(false);
            this.Administrador.setVisible(false);
            this.Contraseña.setVisible(false);
            this.LabelAdministrador.setVisible(false);
            this.LabelContraseña.setVisible(false);
            this.LabelBienvenido.setText("Bienvenido, " + this.administrador.getNombreUsuario());
            this.LabelEmpaque.setVisible(true);
            this.PorcentajeExpress.setVisible(true);
            this.LabelPedidos.setVisible(true);
            this.LabelConexiones.setVisible(true);
            this.IniciarSesión.setText("Cerrar Sesión");
            this.IP.setVisible(true);
            this.Pedidos.setVisible(true);
            this.jScrollPane1.setVisible(true);
            this.jScrollPane2.setVisible(true);
            this.observarMejoresProductos.setVisible(true);
            this.observarPeoresProductos.setVisible(true);
            this.observarRelacionPorcentual.setVisible(true);
            this.agregarNuevoProducto.setVisible(true);
            this.observarTodosProductos.setVisible(true);
            this.CantidadTotalPedidos.setVisible(true);
        }
        else{
            this.Error.setVisible(false);
            this.Administrador.setVisible(true);
            this.Contraseña.setVisible(true);
            this.LabelAdministrador.setVisible(true);
            this.LabelContraseña.setVisible(true);
            this.LabelBienvenido.setText("Bienvenido");
            this.LabelEmpaque.setVisible(false);
            this.PorcentajeExpress.setVisible(false);
            this.LabelPedidos.setVisible(false);
            this.LabelConexiones.setVisible(false);
            this.IniciarSesión.setText("Iniciar Sesión");
            this.IP.setVisible(false);
            this.Pedidos.setVisible(false);
            this.jScrollPane1.setVisible(false);
            this.jScrollPane2.setVisible(false);
            this.observarMejoresProductos.setVisible(false);
            this.observarPeoresProductos.setVisible(false);
            this.observarRelacionPorcentual.setVisible(false);
            this.agregarNuevoProducto.setVisible(false);
            this.observarTodosProductos.setVisible(false);
            this.CantidadTotalPedidos.setVisible(false);
        }
    }
    
    /**
     * Este método saca el porcentaje que representan del valor del valorTotal 3 valores específicos
     * @param valor1 El valor pequeño, que se supone representa sólo una parte del valor total, el todo
     * @param valor2 Otro valor, que se supone también representa una parte del valor total, el todo
     * @param valor3 Otro valor, que se supone también representa una parte del valor total, el todo
     * @return Un arreglo de números naturales N* que representan cuánto vale cada uno de los valores como porcentaje, -1 si algo inválido entró como parámetro
     * Si el valor es mayor al valor total o si el valor o el valorTotal es menor o igual a 0
     */
    private int[] porcentaje(int valor1,int valor2,int valor3){
        int [] porcentajes = {-1,-1,-1};
        if(!(valor3 < 0 || valor2 < 0 || valor1 < 0)){
            int valorTotal = valor1 + valor2 + valor3;
            if(valorTotal == 0){
                for (int i = 0; i < 3; i++) {porcentajes[i] = 0;}
            }
            else{
                double resultado = valor1*100/valorTotal;
                System.out.println(resultado);
                porcentajes[0] = (int)resultado;
                resultado = valor2*100/valorTotal;
                System.out.println(resultado);
                porcentajes[1] = (int)resultado;
                porcentajes[2] = 100-(porcentajes[0]+porcentajes[1]);
                for (int i = 0; i < porcentajes.length; i++) {
                }
            }
        }
        return porcentajes;
    }
}
