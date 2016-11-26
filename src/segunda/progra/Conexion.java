/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segunda.progra;

import java.net.*;

/**
 * Esta clase es la que va a registrar una solicitud del servidor
 * @author esteban
 */
public class Conexion {
    
    private final InetAddress direccionLocal;
    private final InetAddress direccionIP;
    private final TipoMensaje tipoConexion;

    /**
     * Crea un nuevo registro de conexion mediante la dirección local, global y el tipo de conexión que se hizo
     * @param direccionLocal La dirección local desde la que se detectó una solicitud
     * @param direccionIP La dirección global desde la que se detectó una solicitud
     * @param tipoConexion El tipo de solicitud enviada al servidor
     */
    public Conexion(InetAddress direccionLocal, InetAddress direccionIP, TipoMensaje tipoConexion) {
        this.direccionLocal = direccionLocal;
        this.direccionIP = direccionIP;
        this.tipoConexion = tipoConexion;
    }

    /**
     * Retorna la dirección local desde la que se envió la solicitud
     * @return Una InetAddress conteniendo la dirección local que envió la solicitud
     */
    public InetAddress getDireccionLocal() {
        return direccionLocal;
    }

    /**
     * Retorna la dirección global desde la que se envió la solicitud
     * @return Una InetAddress conteniendo la dirección global que envió la solicitud
     */
    public InetAddress getDireccionIP() {
        return direccionIP;
    }

    /**
     * Retorna el tipo de Mensaje que esta conexión solicitó al servidor
     * @return Un TipoMensaje que contiene el tipo de mensaje que se envió al servidor
     */
    public TipoMensaje getTipoConexion() {
        return tipoConexion;
    }
    
    
}
