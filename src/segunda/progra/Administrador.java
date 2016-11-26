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

    /**
     * Este es el constructor que se usará siempre, este inicializa el administrador con un servidor dentro
     * @param server El servidor que se va a usar
     */
    public Administrador(Servidor server) {
        this.servidor = server;
    }
    
    /**
     * Este método es para parar el servidor por completo
     * @return El estado final del servidor
     */
    public boolean pararServidor(){
        return this.servidor.pararServidor();
    }
    
    /**
     * Este método es para parar el servidor por momentáneamente y luego reanudar las operaciones
     * @return El estado final del servidor
     */
    public boolean pausarServidor(){
        return this.servidor.pausarServidor();
    }
    
    /**
     * Este método es para reanudar las operaciones del servidor justo donde se dejaron
     * @return El estado final del servidor
     */
    public boolean despausarServidor(){
        return this.servidor.desPausarServidor();
    }
    
    /**
     * Este método es para activar el servidor, pero no lo pone en marcha
     * @return El estado final del servidor
     */
    public boolean activarServidor(){
        return this.servidor.activarServidor();
    }
    
    /**
     * Este método es para activar el servidor, y lo pone en marcha
     */
    public void arrancarServidor(){
        this.servidor.correrServidor();
    }

    public Servidor getServidor() {
        return servidor;
    }
}