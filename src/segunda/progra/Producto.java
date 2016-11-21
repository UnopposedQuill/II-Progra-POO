/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segunda.progra;

/**
 *
 * @author Esteban
 */
public class Producto implements Cloneable{

    private String codigo;
    private String nombre;
    private String descripcion;
    private int tamanhoPorcion;
    private int piezasPorcion;
    private int caloriasPorcion;
    private int caloriasPieza;
    private int precio;
    private boolean habilitado;
    
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

    public boolean isHabilitado() {
        return habilitado;
    }

    public boolean habilitar(){
        this.habilitado = !this.habilitado;
        return this.habilitado;
    }
    
    public Tipo getTipo(){
        return Tipo.ParseTipo(this.codigo);
    }
    
}