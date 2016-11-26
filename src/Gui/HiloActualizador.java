/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author esteban
 */
public class HiloActualizador extends Thread{
    
    private final ArrayList arrayListLectura;
    private final JTable jTableLectura;

    /**
     * Este constructor crea un hilo que se especializará en mantener una jTable actualizada con los últimos contenidos
     * @param arrayListLectura La lista la cual 
     * @param jTableLectura 
     */
    public HiloActualizador(ArrayList arrayListLectura, JTable jTableLectura) {
        this.arrayListLectura = arrayListLectura;
        this.jTableLectura = jTableLectura;
    }
    
    @Override
    public void run(){
        
    }
}