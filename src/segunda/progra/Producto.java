/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segunda.progra;

import java.io.Serializable;
import java.util.Objects;

/**
 * Esta es la clase de los productos
 * @author Esteban
 */
public class Producto implements Cloneable,Serializable{

    private String codigo;
    private String nombre;
    private String descripcion;
    private int tamanhoPorcion;
    private int piezasPorcion;
    private int caloriasPorcion;
    private int caloriasPieza;
    private int precio;
    private boolean habilitado;
    
    /**
     * Este constructor inicializa todos los valores con inicializaciones inútiles, sólo pide memoria
     */
    Producto(){
        this.codigo = null;
        this.nombre = null;
        this.descripcion = null;
        this.tamanhoPorcion = -1;
        this.piezasPorcion = -1;
        this.caloriasPorcion = -1;
        this.caloriasPieza = -1;
        this.precio = -1;
        this.habilitado = false;
    }

    /**
     * Este es el constructor que se va a usar por defecto, este inicializa todos los valores con valores útiles para el programa
     * @param codigo El código que tendrá el producto
     * @param nombre El nombre que tendrá el producto
     * @param descripcion La descripción del producto
     * @param tamanhoPorcion La cantidad de gramos que tiene cada porción
     * @param piezasPorcion La cantidad de piezas que tiene la porción
     * @param caloriasPorcion La cantidad de calorías que tiene cada porción del producto
     * @param caloriasPieza La cantidad de calorías que tiene cada pieza del producto
     * @param precio El precio que tiene el producto
     */
    public Producto(String codigo, String nombre, String descripcion, int tamanhoPorcion, int piezasPorcion, int caloriasPorcion, int caloriasPieza, int precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamanhoPorcion = tamanhoPorcion;
        this.piezasPorcion = piezasPorcion;
        this.caloriasPorcion = caloriasPorcion;
        this.caloriasPieza = caloriasPieza;
        this.precio = precio;
        this.habilitado = true;
    }
    
    public Producto(String codigo){
        this.codigo = codigo;
        this.nombre = null;
        this.descripcion = null;
        this.tamanhoPorcion = -1;
        this.piezasPorcion = -1;
        this.caloriasPorcion = -1;
        this.caloriasPieza = -1;
        this.precio = -1;
        this.habilitado = false;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTamanhoPorcion() {
        return tamanhoPorcion;
    }

    public void setTamanhoPorcion(int tamanhoPorcion) {
        this.tamanhoPorcion = tamanhoPorcion;
    }

    public int getPiezasPorcion() {
        return piezasPorcion;
    }

    public void setPiezasPorcion(int piezasPorcion) {
        this.piezasPorcion = piezasPorcion;
    }

    public int getCaloriasPorcion() {
        return caloriasPorcion;
    }

    public void setCaloriasPorcion(int caloriasPorcion) {
        this.caloriasPorcion = caloriasPorcion;
    }

    public int getCaloriasPieza() {
        return caloriasPieza;
    }

    public void setCaloriasPieza(int caloriasPieza) {
        this.caloriasPieza = caloriasPieza;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.codigo);
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
        final Producto other = (Producto) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    /**
     * Este método averiguar si el producto está habilitado para ser pedido por el sistema
     * @return True si el producto está habilitado, False en el otro caso
     */
    public boolean isHabilitado() {
        return habilitado;
    }

    /**
     * Este método invierte el estado actual del producto, haciendo que esté habilitado si no lo estaba previamente, y deshabilitado
     * si estaba habilitado previamente
     * @return True si el producto termina habilitado, False si queda deshabilitado
     */
    public boolean habilitar(){
        this.habilitado = !this.habilitado;
        return this.habilitado;
    }
    
    /**
     * Retorna el tipo de producto
     * @return Un enum del tipo Tipo que contiene el tipo
     */
    public Tipo getTipo(){
        return Tipo.ParseTipo(this.codigo);
    }

    @Override
    public String toString() {
        return "Producto: " + codigo + ", nombre: " + nombre + ", descripción: " + descripcion + ", tamaño de la porción: " + tamanhoPorcion + ", piezas de la porción: " + piezasPorcion + ", calorias por porción: " + caloriasPorcion + ", calorias por pieza: " + caloriasPieza + ", precio: " + precio + ", habilitado: " + habilitado;
    }
    
    
}