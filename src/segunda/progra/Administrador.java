/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segunda.progra;

import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class Administrador {
    
    private Servidor servidor;

    public Administrador(Servidor server) {
        this.servidor = new Servidor(new ArrayList<>());
    }
    
    public boolean pararServidor(){
        return this.servidor.pararServidor();
    }
    
    public boolean pausarServidor(){
        return this.servidor.pausarServidor();
    }
    
    public boolean activarServidor(){
        return this.servidor.activarServidor();
    }
    
    public void arrancarServidor(){
        this.servidor.correrServidor();
    }
    
    public boolean despausarServidor(){
        return this.servidor.desPausarServidor();
    }

    public Servidor getServidor() {
        return servidor;
    }
}