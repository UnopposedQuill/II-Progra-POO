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
}
