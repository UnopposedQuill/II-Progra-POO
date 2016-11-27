/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.util.Objects;

/**
 * Esta clase la uso para ordenar un arrayList, lo que importa es el comparable que le definí
 * @author esteban
 */
public class IdentificadoresOrden implements Comparable<IdentificadoresOrden>{

    private String codigo;
    private int cantidadPedido;

    /**
     * Este constructor inicializa el Identificador con lo que se necesita para poder ordenarlo
     * @param codigo El codigo del producto que este objeto representa
     * @param cantidadPedido La cantidad de veces en las que fue pedido, este será usado en una "competencia", para ver cuáles quedan de primeros
     */
    public IdentificadoresOrden(String codigo, int cantidadPedido) {
        this.codigo = codigo;
        this.cantidadPedido = cantidadPedido;
    }

    /**
     * Retorna el código que representa
     * @return Un string con el código del producto que representa en la lista
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Retorna la cantidad de veces que fue pedido
     * @return Un entero con la cantidad de veces que fue pedido
     */
    public int getCantidadPedido() {
        return cantidadPedido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.codigo);
        hash = 83 * hash + this.cantidadPedido;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IdentificadoresOrden other = (IdentificadoresOrden) obj;
        if (this.cantidadPedido != other.cantidadPedido) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    
    
    /**
     * Averigua retorna como entero la diferencia de pedidos entre los dos representantes de productos
     * @param o El objeto con el cual será comparado
     * @return Un entero representando la diferencia entre ambos productos
     */
    @Override
    public int compareTo(IdentificadoresOrden o) {
        return this.cantidadPedido - o.getCantidadPedido();
    }
}
