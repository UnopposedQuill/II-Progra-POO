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
    private ArrayList <Producto[]> productosPedidos;

    public Pedido(ArrayList<Producto[]> productosPedidos) {
        this.fechaPedido = Calendar.getInstance();
        this.productosPedidos = productosPedidos;        
    }

    public Calendar getFechaPedido() {
        return fechaPedido;
    }

    public ArrayList<Producto[]> getProductosPedidos() {
        return productosPedidos;
    }
}