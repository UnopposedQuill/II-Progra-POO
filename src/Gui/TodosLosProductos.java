package Gui;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import segunda.progra.Producto;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import segunda.progra.Servidor;
import segunda.progra.Tipo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Esteban
 */
public class TodosLosProductos extends javax.swing.JFrame {

    /**
     * Crea una nueva ventana con una tabla mostrando todos los productos que le pasen
     * @param productos Los productos a mostrar
     * @param server El una referencia a un servidor, esto es para que la ventana llamada desde aquí sepa cuál servidor modificar
     */
    public TodosLosProductos(ArrayList <Producto> productos,Servidor server) {
        initComponents();
        Object[][] datosProductos = new Object[productos.size()][11];
        
        for (int i = 0; i < productos.size(); i++) {
            Producto getProducto = productos.get(i);
            
            
            datosProductos[i][0] = getProducto.getNombre();
            datosProductos[i][1] = getProducto.getDescripcion();
            datosProductos[i][2] = Tipo.fakeToString(getProducto.getTipo());
            datosProductos[i][3] = getProducto.getTamanhoPorcion();
            datosProductos[i][4] = getProducto.getPiezasPorcion();
            datosProductos[i][5] = getProducto.getCaloriasPieza();
            datosProductos[i][6] = getProducto.getCaloriasPorcion();
            datosProductos[i][7] = getProducto.getPrecio();
            datosProductos[i][8] = server.conseguirCantidadVecesPedido(getProducto);
            datosProductos[i][9] = getProducto.getCodigo();
            datosProductos[i][10] = new JButton("Modificar");
        }
        
        String [] nombreCol = {"Nombre", "Descripción", "Tipo", "Tamaño Porción", "Piezas Porción","Calorías Por Pieza","Calorías Por Porción","Precio","Cantidad Veces Pedido","Código","Modificar"};
        
        this.jTableProductos.setModel(new DefaultTableModel(datosProductos, nombreCol){
            //a partir de aquí me pongo a modificar algunos aspectos del modelo
            
            //con esto defino los tipos por fuerza que va a tener el modelo
            Class[] tipos = new Class[]{
            //los primeros 9 son objetos, el que me importa cambiar va a ser el último
            //el cual va a ser un botón
                String.class,
                String.class,
                String.class,
                Integer.class,
                
                Integer.class,
                Integer.class,            
                Integer.class,
                Integer.class,
                
                Integer.class,
                String.class,
                JButton.class
                };
            
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
                return !(this.getColumnClass(column).equals(JButton.class));
            }
            
        });
        
        this.jTableProductos.setDefaultRenderer(JButton.class, new TableCellRenderer(){
            /**
             * Este método sólo se encarga de una sóla y simple idiotez:
             * retornar lo que entra xD
             * El asunto es que a la hora de pintar la tabla dibuje el objeto tal
             * y como entra, en lugar de hacerlo asquerosamente de manera default 
             * Resumen: hace que aparezca un botón cuando aparece un botón
             */
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        
        this.jTableProductos.addMouseListener(new MouseAdapter() {
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
                 * Pregunto si hizo clic sobre la celda que contiene el botón de la fila
                 */
                if (jTableProductos.getModel().getColumnClass(columna).equals(JButton.class)) {
                    //significa que sí dio en el botón, por lo que hago que dibuje la ventana administradora de
                    //productos
                    AgenteProductos modificadorProductos = new AgenteProductos(server, productos.get(productos.indexOf(new Producto((String)jTableProductos.getValueAt(fila, 8)))));
                    modificadorProductos.setVisible(true);
                }
            }
        });
        
        this.setBounds(0, 0, 1366, 700);
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
        jTableProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Todos los Productos");

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Casado", "Plato Fuerte", "2000", "2500", "Sí"},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre Producto", "Tipo de Producto", "Costo", "Costo Express", "Habilitado"
            }
        ));
        jScrollPane1.setViewportView(jTableProductos);
        if (jTableProductos.getColumnModel().getColumnCount() > 0) {
            jTableProductos.getColumnModel().getColumn(0).setHeaderValue("Nombre Producto");
            jTableProductos.getColumnModel().getColumn(1).setHeaderValue("Tipo de Producto");
            jTableProductos.getColumnModel().getColumn(2).setHeaderValue("Costo");
            jTableProductos.getColumnModel().getColumn(3).setHeaderValue("Costo Express");
            jTableProductos.getColumnModel().getColumn(4).setHeaderValue("Habilitado");
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProductos;
    // End of variables declaration//GEN-END:variables
}
