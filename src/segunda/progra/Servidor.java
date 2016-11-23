/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segunda.progra;

import java.io.*;
import java.net.*;
import java.util.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Esteban
 */
public class Servidor {
    
    private boolean activo;
    private boolean pausado;
    private ArrayList <Producto> productos;
    private ArrayList <Pedido> pedidos;
    
    //Campos de las conexiones del servidor
    private ServerSocket serverSocket;
    private OutputStream conexionSalida;
    private ObjectOutputStream flujoDeSalida;
    private InputStream conexionEntrada;
    private ObjectInputStream flujoDeEntrada;
    
    /**
     * Crea un servidor nuevo a partir de una lista de productos ya definida
     * @param productos Los productos que tendrá el nuevo servidor
     */
    public Servidor(ArrayList<Producto> productos) {
        this.activo = true;
        this.pausado = true;
        this.productos = productos;
        this.pedidos = new ArrayList();
    }
    
    /**
     * Crea un servidor nuevo a partir del nombre de un archivo XML que se supone que tiene los nombre de los XML
     * @param XML El nombre 
     */
    public Servidor(String XML) {
        this.activo = true;
        this.pausado = true;
        this.productos = this.conseguirProductosXML(XML);
        this.pedidos = new ArrayList();
    }
    
    /**
     * Crea un servidor nuevo a partir del nombre de un archivo XML por defecto que está dentro de la carpeta del proyecto
     */
    public Servidor() {
        this.activo = true;
        this.pausado = true;
        this.productos = this.conseguirProductosXML("Productos.xml");
        this.pedidos = new ArrayList();
    }
    
    /**
     * Esto es para que el servidor se detenga, esté o no en ejecución
     * @return El estado en el que quedó el servidor
     */
    public boolean pararServidor(){
        this.activo = false;
        return this.activo;
    }
    
    /**
     * Esto habilita el servidor, pero NO lo pone en marcha
     * @return El estado final en el que quedó el servidor
     */
    public boolean activarServidor(){
        this.activo = true;
        return this.activo;
    }
    
    /**
     * Esto es para pausar el servidor, de modo que al remover la pausa el servidor pueda reanudar todo rápidamente
     * @return El estado final en el que quedó el servidor
     */
    public boolean pausarServidor(){
        this.pausado = true;
        return this.pausado;
    }
    
    /**
     * Para remover el estado de pausa del servidor
     * @return El estado final en el que quedó el servidor
     */
    public boolean desPausarServidor(){
        this.pausado = false;
        return this.pausado;
    }
    
    /**
     * Esto es para habilitar el servidor, y hacer que esté en ejecución en un sólo paso
     */
    public void correrServidor(){
        this.activarServidor();
        this.runServer();
    }

    /**
     * Para saber si el servidor está o no activado
     * @return True si el servidor está activado, false en el otro caso
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Para saber si el servidor está o no pausado
     * @return True si el servidor está pausado, false en el otro caso
     */
    public boolean isPausado() {
        return pausado;
    }

    /**
     * Para conseguir los productos con los que está el servidor trabajando actualmente
     * @return Los productos que tiene el servidor
     */
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    /**
     * Para conseguir todos los pedidos que tiene el servidor en la base de datos actualmente
     * @return Todos los pedidos que ha recibido el servidor
     */
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    
    /**
     * Esto es para agregar un nuevo producto a la base de datos del servidor, esta base de datos no admite ningún producto repetido
     * @param nuevoProducto El producto que se desea agregar a la base de datos del servidor
     * @return True si logró insertarlo correctamente, False en caso de que el producto ya estuviera en la base de datos o no haya podido insertarse correctamente
     */
    public boolean agregarProducto(Producto nuevoProducto){
        if(this.productos.contains(nuevoProducto)){
            return false;
        }
        return this.productos.add(nuevoProducto);
    }
    
    /**
     * Este método es el método que controla el servidor, lo que hace este método es que controla todas las nuevas conexiones
     * desde y hacia el servidor
     */
    private void runServer(){
        try{
            //nuevo servidor
            this.serverSocket = new ServerSocket(5000);
            //que esté corriendo mientras el servidor esté activo
            while(this.activo){
                System.out.println("Servidor en espera por una nueva conexión");
                Socket socketNuevo = serverSocket.accept();//consigo el nuevo socket que haya deseado conectarse
                //ahora las conexiones de entrada y de salida del servidor
                System.out.println("Haciendo nuevas conexiones");
                this.conexionSalida = socketNuevo.getOutputStream();
                this.flujoDeSalida = new ObjectOutputStream(conexionSalida);
                this.conexionEntrada = socketNuevo.getInputStream();
                this.flujoDeEntrada = new ObjectInputStream(conexionEntrada);
                System.out.println("Averiguando Mensaje");
                //ya tengo las conexiones hechas, ahora tengo que ver qué hago con lo que el cliente le envió al servidor
                try{
                    Mensaje mensajeRecibido = (Mensaje)flujoDeEntrada.readObject();//consigo el mensaje enviado (o intento hacerlo)
                    atenderPeticion(mensajeRecibido);//hago que el servidor atienda la petición
                }catch(ClassNotFoundException | ClassCastException excep){
                    System.out.println("Ocurrió un error a la hora de averiguar el mensaje enviado");
                }
                //Esto es en caso de que el administrador desee pausar el servidor
                while(this.pausado){
                    try{
                        System.out.println("Servidor en pausa");
                        Thread.sleep(1000);
                    }catch(InterruptedException except){
                        System.out.println("Hubo un error durante la espera");
                    }
                }
            }
        }catch(IOException exception){
            System.out.println("Hubo un problema al intentar conectar");
        }
    }
    
    /**
     * Este es el método que se encarga de averiguar qué exactamente traía el mensaje, así como de retornar una respuesta
     * @param mensajeAAtender El mensaje recibido que se desea atender
     */
    public void atenderPeticion(Mensaje mensajeAAtender){
        switch(mensajeAAtender.getTipoDelMensaje()){
            case conseguirLista:{//se desea conseguir la lista completa de los productos
                try{
                    mensajeAAtender.setDatoDeRespuesta(this.productos);
                    this.flujoDeSalida.writeObject(mensajeAAtender);
                }catch(IOException excep){
                    System.out.println("Hubo un error a la hora de enviar la respuesta");
                }
                break;
            }
            case nuevoPedido:{//se desea solicitar un nuevo pedido
                try{
                    try{
                        this.pedidos.add((Pedido) mensajeAAtender.getDatoDeSolicitud());
                        mensajeAAtender.setDatoDeRespuesta(true);
                    }catch(ClassCastException exc){
                        System.out.println("Hubo un error a la hora de introducir el nuevo pedido en el servidor");
                        mensajeAAtender.setDatoDeRespuesta(false);   
                    }
                    this.flujoDeSalida.writeObject(mensajeAAtender);
                }catch(IOException excep){
                    System.out.println("Hubo un error a la hora de enviar la respuesta");
                }
                break;
            }
            default:{
                try{
                    this.flujoDeSalida.writeObject(mensajeAAtender);
                }catch(IOException ex){
                    System.out.println("Hubo un error a la hora de devolver una solicitud no soportada");
                }
            }
        }
    }
    
    /**
     * Este método es para cargar los datos de un XML como los productos del servidor
     * @return Un ArrayList con los productos del servidor
     */
    private ArrayList<Producto> conseguirProductosXML(String XML){
        SAXBuilder saxBuilder = new SAXBuilder();
        File archivoXML = new File(XML);
        ArrayList <Producto> arrayLProductos = new ArrayList();
        try{
            Document documentoXML = (Document) saxBuilder.build(archivoXML);
            Element nodoRaiz = documentoXML.getRootElement();

            List <Element> listaProductos = nodoRaiz.getChildren();
            
            for (Element producto : listaProductos) {
                System.out.println(Servidor.eliminaUnderScores(producto.getName()));
                System.out.println("Elementos Producto: ");
                for (Element elementosProducto : producto.getChildren()) {
                    System.out.println(elementosProducto.getTextTrim());
                }
                
            }
            
        }catch(JDOMException | IOException exc){
            System.out.println("Error a la hora de agarrar el archivo XML especificado");
        }
        return new ArrayList<>();
    }
    
    /**
     * Este método se usa para cambiar los underscores ('_') de un string por un espacio en blanco
     * @param string El string del cual se van a cambiar los underscores
     * @return El string sin underscores
     */
    private static String eliminaUnderScores(String string){
        string = string.replaceAll("_", " ");
        return string;
    }
}