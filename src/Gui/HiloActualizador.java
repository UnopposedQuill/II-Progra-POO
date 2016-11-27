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
import javax.swing.table.*;
import segunda.progra.*;

/**
 *
 * @author esteban
 */
public class HiloActualizador extends Thread{
    
    private final ArrayList arrayListLectura;
    private Object jTableLectura;

    /**
     * Este constructor crea un hilo que se especializará en mantener una jTable actualizada con los últimos contenidos
     * @param arrayListLectura La lista de la cuál leerá los datos a actualizar
     * @param objetolectura El objeto en el cual se actualizarán
     */
    public HiloActualizador(ArrayList arrayListLectura, Object objetolectura) {
        this.arrayListLectura = arrayListLectura;
        this.jTableLectura = objetolectura;
    }
    
    @Override
    public void run(){
        while(true){
            if(this.jTableLectura instanceof JTable){
                System.out.println("Actualizando Tabla");
                //¿Está vacía? Si está vacía no hago nada
                if(!this.arrayListLectura.isEmpty()){
                    //¿Es de conexiones?
                    JTable tabla = (JTable) this.jTableLectura;
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
                        tabla.setModel(new DefaultTableModel(datos, columnas));
                    }
                    //¿Es de pedidos?
                    if(this.arrayListLectura.get(0) instanceof Pedido){
                        System.out.println("Tabla de Conexiones");
                        //Es un arrayList de Pedidos
                        //Defino las columnas
                        String [] columnas = {"Persona", "Número de Teléfono", "Precio Total", "Dirección", "Cantidad De Productos", "Tipo de Pedido"};
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
                            if(getPedido.isExpress()){
                                datos[i][5] = "Express";
                            }
                            else{
                                if(getPedido.isaRecoger()){
                                    datos[i][5] = "A Recoger";
                                }
                                else{
                                    datos[i][5] = "En sitio";
                                }
                            }
                            
                            int precio = 0;
                            //recorro todos los productos que se hayan pedido
                            for (int j = 0; j < getPedido.getProductosPedidos().size(); j++) {
                                Producto getProductoPedido = getPedido.getProductosPedidos().get(j);
                                //el precio va a ser igual a la cantidad específica del producto que se ordenó
                                //multiplicada por el precio individual
                                precio += getPedido.getCantidadProductos()[j]*getProductoPedido.getPrecio();
                            }
                            if(getPedido.getDireccion() != null){
                                double transporteMomentoPedido = (double)getPedido.getExtraActualTransporte();
                                precio += precio*(transporteMomentoPedido/100);
                            }
                            datos[i][2] = precio;
                        }
                        //actualizo el modelo
                        System.out.println("Actualizando el modelo de Pedidos");
                        tabla.setModel(new DefaultTableModel(datos, columnas));
                    }
                }
                try {
                    sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HiloActualizador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                if(this.jTableLectura instanceof JLabel){
                    JLabel label = (JLabel) this.jTableLectura;
                    label.setText("Cantidad Total Actual de Pedidos: " + this.arrayListLectura.size());
                }
            }
        }
    }
    
    /**
     * Este es un método para imprimir con formato maś bonito un arrayList
     * @param arrayL El arrayList a ser imprimido con mejor formato
     * @return Un string con un formato más razonable
     */
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