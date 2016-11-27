/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segunda.progra;

import java.io.Serializable;

/**
 *
 * @author Esteban
 */
public enum TipoMensaje implements Serializable{
    conseguirLista,nuevoPedido,conseguirTransporte;
    
    public String getRepString(){
        switch(this){
            case conseguirLista:{
                return "Conseguir Lista";
            }
            case nuevoPedido:{
                return "Nuevo Pedido";
            }
            case conseguirTransporte:{
                return "Conseguir Porcentaje Transporte";
            }
            default:{
                return "NULL";
            }
        }
    }
}
