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
public class Administrador {
    
    private Servidor servidor;
    private String nombreUsuario;

    /**
     * Este es el constructor que se usará siempre, este inicializa el administrador con un servidor dentro
     * @param server El servidor que se va a usar
     * @deprecated Desde que se implementó el login
     */
    public Administrador(Servidor server) {
        this.servidor = server;
    }

    /**
     * Este es el constructor que implementa un login, para cambiar el login, sólo se debe cambiar la validación de 
     * la constraseña
     * Este es el constructor que se usará de aquí en adelante
     * @param nombreUsuario El nombre del usuario del Administrador
     * @param constrasenha La contraseña del administrador
     */
    public Administrador(String nombreUsuario, String constrasenha) {
        if(validarContrasenha(nombreUsuario, constrasenha)){
            this.nombreUsuario = nombreUsuario;
            this.servidor = new Servidor();
            this.arrancarServidor();
        }
    }

    /**
     * Averigua cuál es el nombre del administrador en curso
     * @return Un String conteniendo el nombre del actual administrador
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    /**
     * Este es el método que valida la contraseña del nuevo administrador
     * @param nombreUsuario El nombre de usuario del supuesto administrador
     * @param constrasenha La contraseña del supuesto administrador
     * @return True si pertenece a algún administrador registrado, False en otro caso
     */
    private boolean validarContrasenha(String nombreUsuario, String constrasenha){
        return ((nombreUsuario.equals("Administrador")|| nombreUsuario.equals("Admin")) && constrasenha.equals("2646"));
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