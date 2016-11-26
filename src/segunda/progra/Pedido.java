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

    public Pedido(ArrayList<Producto> productosPedidos,int[] cantidadProductos) {
        this.fechaPedido = Calendar.getInstance();
        this.productosPedidos = productosPedidos;        
        this.cantidadesProductos = cantidadProductos;
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
}