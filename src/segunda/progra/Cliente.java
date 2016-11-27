/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segunda.progra;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class Cliente {
    
    private Socket socket;
    private OutputStream conexionSalida;
    private ObjectOutputStream flujoDeSalida;
    private InputStream conexionEntrada;
    private ObjectInputStream flujoDeEntrada;
    private int puerto = 5000;
    private String huesped = "localhost";
    //private String huesped = "192.168.100.3"; ip -h -f inet address
    
    public Cliente(){
        this.puerto = 5000;
    }
    
    public Cliente(int port, String host){
        this.puerto = port;
        this.huesped = host;
    }
    
    public Mensaje realizarPeticion(Mensaje aEnviar){
        for (int i = 0; i < 3; i++) {
            try{
                System.out.println("Conectándose al servidor especificado");
                this.socket = new Socket(this.huesped, this.puerto);
                System.out.println("Estableciendo conexiones con el servidor");
                this.conexionEntrada = this.socket.getInputStream();
                this.flujoDeEntrada = new ObjectInputStream(this.conexionEntrada);
                this.conexionSalida = this.socket.getOutputStream();
                this.flujoDeSalida = new ObjectOutputStream(this.conexionSalida);
                System.out.println("Enviando mensaje");
                this.flujoDeSalida.writeObject(aEnviar);
                try{
                    System.out.println("Mensaje recibido con éxito");
                    return (Mensaje) this.flujoDeEntrada.readObject();
                }catch(ClassNotFoundException | ClassCastException exc){
                    System.out.println("Ocurrió un error a la hora de averiguar el mensaje retornado");
                    return null;
                }
            }catch(IOException exc){
                System.out.println("Algo salió mal al intentar conectarse al servidor: " + this.huesped + " " + this.puerto);
            }
        }
        System.out.println("Se rindió al no poder conectarse al servidor");
        return null;
    }
    
    /**
     * Este es el método para pedirle al cliente que consiga la lista de productos actual del servidor
     * @return Un arrayList que contiene todos los productos actuales del servidor
     */
    public ArrayList<Producto> conseguirListaDeProductos(){
        Mensaje mensajePeticion = this.realizarPeticion(new Mensaje(TipoMensaje.conseguirLista, null));
        if(mensajePeticion != null){
            try{
                return (ArrayList <Producto>) mensajePeticion.getDatoDeRespuesta();
            }catch(ClassCastException exc){
                System.out.println("El servidor retornó algo raro");
            }
        }
        return null;
    }
    
    /**
     * Este es el método para pedirle al cliente que envíe una solicitud de agregado de pedido al servidor
     * @param pedidoASolicitar El pedido que se desea enviar
     * @return True si fue atendida correctamente la petición, False en el otro caso
     */
    public boolean hacerPedido(Pedido pedidoASolicitar){
        Mensaje mensajePeticion = this.realizarPeticion(new Mensaje(TipoMensaje.nuevoPedido, pedidoASolicitar));
        if(mensajePeticion != null){
            try{
                return (boolean) mensajePeticion.getDatoDeRespuesta();
            }catch(ClassCastException exc){
                System.out.println("El servidor retornó algo raro");
            }
        }
        return false;
    }
    
    /**
     * Este es el método para pedirle al cliente que consiga el coste extra actual por el transporte del producto
     * @return Un entero que representa el porcentaje extra por transporte
     */
    public int conseguirTransporte(){
        Mensaje mensajePeticion = this.realizarPeticion(new Mensaje(TipoMensaje.conseguirTransporte, null));
        if(mensajePeticion != null){
            try{
                return (int) mensajePeticion.getDatoDeRespuesta();
            }catch(ClassCastException exc){
                System.out.println("El servidor retornó algo raro");
            }
        }
        return -1;
    }
}
