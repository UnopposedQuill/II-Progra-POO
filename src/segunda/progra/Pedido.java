/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segunda.progra;

import java.util.*;
import java.io.Serializable;

/**
 *
 * @author Esteban
 */
public class Pedido implements Serializable{
    private Calendar fechaPedido;
    private ArrayList <Producto> productosPedidos;
    private int [] cantidadesProductos;
    private String nombre;
    private String numTelefono;
    private String direccion;
    private int extraActualTransporte;
    private int ID;

    /**
     * Este es el constructor para los pedidos express, este recibe todos los parámetros completos
     * @param productosPedidos Un ArrayList con los productos que se desean
     * @param cantidadesProductos Un arreglo de enteros con la cantidad de productos que se desean
     * @param nombre El nombre de la persona responsable por el pedido
     * @param numTelefono El número de teléfono de la persona responsable por el pedido
     * @param direccion La dirección de la persona responsable por el pedido
     * @param extraActualTransporte Este va a ser el porcentaje del momento por transporte
     */
    public Pedido(ArrayList<Producto> productosPedidos, int[] cantidadesProductos, String nombre, String numTelefono, String direccion,int extraActualTransporte) {
        this.fechaPedido = Calendar.getInstance();
        this.productosPedidos = productosPedidos;
        this.cantidadesProductos = cantidadesProductos;
        this.nombre = nombre;
        this.numTelefono = numTelefono;
        this.direccion = direccion;
        this.ID = -1;
        this.extraActualTransporte = extraActualTransporte;
    }

    /**
     * Este es el constructor para los pedidos normales, este recibe todos los parámetros menos la dirección
     * @param productosPedidos Un ArrayList con los productos que se desean
     * @param cantidadesProductos Un arreglo de enteros con la cantidad de productos que se desean
     * @param nombre El nombre de la persona responsable por el pedido
     * @param numTelefono El número de teléfono de la persona responsable por el pedido
     * @param extraActualTransporte Este va a ser el porcentaje del momento por transporte
     */
    public Pedido(ArrayList<Producto> productosPedidos, int[] cantidadesProductos, String nombre, String numTelefono,int extraActualTransporte) {
        this.fechaPedido = Calendar.getInstance();
        this.productosPedidos = productosPedidos;
        this.cantidadesProductos = cantidadesProductos;
        this.nombre = nombre;
        this.numTelefono = numTelefono;
        this.direccion = null;
        this.ID = -1;
        this.extraActualTransporte = extraActualTransporte;
    }

    /**
     * Este es el constructor para los pedidos de prueba, este no toma los datos personales, por eso no se puede usar
     * @param productosPedidos Un ArrayList con los productos que se desean
     * @param cantidadProductos Un arreglo de enteros con la cantidad de productos que se desean
     * @deprecated Luego de mejorar el servidor
     */
    public Pedido(ArrayList<Producto> productosPedidos,int[] cantidadProductos) {
        this.fechaPedido = Calendar.getInstance();
        this.productosPedidos = productosPedidos;        
        this.cantidadesProductos = cantidadProductos;
        this.nombre = null;
        this.numTelefono = null;
        this.direccion = null;
        this.ID = -1;
    }

    public Calendar getFechaPedido() {
        return fechaPedido;
    }

    public ArrayList<Producto> getProductosPedidos() {
        return productosPedidos;
    }

    public int[] getCantidadProductos() {
        return cantidadesProductos;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public String getDireccion() {
        return direccion;
    }
    
    
    
    /**
     * Este método averigua si el pedido es nulo, puesto que la cantidad de productos seleccionados podría ser 0
     * @return True si los productos están vacíos y/o las cantidades están vacías, False si es posible utilizarlo
     */
    public boolean isNull(){
        if(this.productosPedidos.isEmpty()){
            return true;
        }
        if(this.cantidadesProductos.length == 0){
            return true;
        }
        for (int i = 0; i < this.cantidadesProductos.length; i++) {
            if(cantidadesProductos[i] == 0){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Este método averigua si el pedido es express
     * @return True si el pedido es express, False en el otro caso
     */
    public boolean isExpress(){
        return this.direccion != null;
    }

    @Override
    public String toString(){
        return "Pedido el: " + fechaPedido + ", productos pedidos: " + productosPedidos + ", cantidad de productos pedidos: " + cantidadTotal(cantidadesProductos) + ", nombre: " + nombre + ", número de teléfono: " + numTelefono + ", dirección: " + direccion + ", identificador del pedido: " + ID;
    }
    
    /**
     * Este método se enfoca en sumar todas los números en cada posición del arreglo recibido, para averiguar cuantos
     * eran en total
     * @param arreglo El arreglo del cuál se desea saber el número total
     * @return Un entero que contiene la cantidad de unidades en todas las posiciones
     */
    public static int cantidadTotal(int []arreglo){
        int contador = 0;
        for (int i = 0; i < arreglo.length; i++) {
            int j = arreglo[i];
            contador += j;
        }
        return contador;
    }
}