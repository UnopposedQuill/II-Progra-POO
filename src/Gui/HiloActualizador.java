/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import segunda.progra.*;

/**
 *
 * @author esteban
 */
public class HiloActualizador extends Thread{
    
    private final ArrayList arrayListLectura;
    private final JTable jTableLectura;

    /**
     * Este constructor crea un hilo que se especializará en mantener una jTable actualizada con los últimos contenidos
     * @param arrayListLectura La lista la cual 
     * @param jTableLectura 
     */
    public HiloActualizador(ArrayList arrayListLectura, JTable jTableLectura) {
        this.arrayListLectura = arrayListLectura;
        this.jTableLectura = jTableLectura;
    }
    
    @Override
    public void run(){
        while(true){
            System.out.println("Actualizando Tabla");
            //¿Está vacía? Si está vacía no hago nada
            if(!this.arrayListLectura.isEmpty()){
                //¿Es de conexiones?
                System.out.println("Tabla no vacía");
                if(this.arrayListLectura.get(0) instanceof Conexion){
                    System.out.println("Tabla de Conexiones");
                    //Es un arrayList de Conexiones
                    //Defino las columnas
                    String [] columnas = {"Dirección IP Global", "Dirección IP Local", "Tipo de Solicitud"};
                    //Defino el nuevo arreglo de datos
                    Object [][] datos = new Object[this.arrayListLectura.size()][3];
                    for (int i = 0; i < this.arrayListLectura.size(); i++) {
                        Conexion get = (Conexion)this.arrayListLectura.get(i);
                        datos[i][0] = get.getDireccionIP();
                        datos[i][1] = get.getDireccionLocal();
                        datos[i][2] = get.getTipoConexion().getRepString();
                    }
                    //actualizo el modelo
                    System.out.println("Actualizando Modelo de Conexiones");
                    this.jTableLectura.setModel(new DefaultTableModel(datos, columnas));
                }
                //¿Es de pedidos?
                if(this.arrayListLectura.get(0) instanceof Pedido){
                    System.out.println("Tabla de Conexiones");
                    //Es un arrayList de Pedidos
                    //Defino las columnas
                    String [] columnas = {"Persona", "Número de Teléfono", "Precio Total", "Dirección", "Cantidad De Productos", "Productos"};
                    //Defino el nuevo arreglo de datos
                    Object [][] datos = new Object[this.arrayListLectura.size()][6];
                    for (int i = 0; i < this.arrayListLectura.size(); i++) {
                        Pedido getPedido = (Pedido)this.arrayListLectura.get(i);
                        datos[i][0] = getPedido.getNombre();
                        datos[i][1] = getPedido.getNumTelefono();
                        //datos[i][2] = precio total (más abajo)
                        if(getPedido.getDireccion() != null)
                            datos[i][3] = getPedido.getDireccion();
                        else
                            datos[i][3] = "Nula";
                        datos[i][4] = Pedido.cantidadTotal(getPedido.getCantidadProductos());
                        datos[i][5] = toStringArrayList(getPedido.getProductosPedidos());
                        
                        int precio = 0;
                        //recorro todos los productos que se hayan pedido
                        for (int j = 0; j < getPedido.getProductosPedidos().size(); j++) {
                            Producto getProductoPedido = getPedido.getProductosPedidos().get(j);
                            //el precio va a ser igual a la cantidad específica del producto que se ordenó
                            //multiplicada por el precio individual
                            precio += getPedido.getCantidadProductos()[j]*getProductoPedido.getPrecio();
                        }
                        datos[i][2] = precio;
                    }
                    //actualizo el modelo
                    System.out.println("Actualizando el modelo de Pedidos");
                    this.jTableLectura.setModel(new DefaultTableModel(datos, columnas));
                }
            }
            try {
                sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloActualizador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static String toStringArrayList(ArrayList arrayL){
        String stringResultante = "";
        
        for (int i = 0; i < arrayL.size(); i++) {
            Object get = arrayL.get(i);
            stringResultante = stringResultante.concat(", " + get.toString());
        }
        if(stringResultante.startsWith(", "))
            stringResultante = stringResultante.substring(2);
        return stringResultante;
    }
}