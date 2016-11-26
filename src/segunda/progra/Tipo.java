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
public enum Tipo {
    ENT,PRN,PTR,BEB;
    
    public static Tipo ParseTipo(String str){
        if(str.startsWith("ENT")){
            return ENT;
        }
        else{
            if(str.startsWith("PRN")){
                return PRN;
            }
            else{
                if(str.startsWith("PTR")){
                    return PTR;
                }
                else{
                    if(str.startsWith("BEB")){
                        return BEB;
                    }
                    return null;
                }
            }
        }
    }
    
    public static String fakeToString(Tipo tipo){
        switch(tipo){
            case ENT:{
                return "Entrada";
            }
            case PTR:{
                return "Postre";
            }
            case BEB:{
                return "Bebida";
            }
            default:{
                return "Principal";
            }
        }
    }
}
