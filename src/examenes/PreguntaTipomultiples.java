/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenes;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author aechavarria
 */
public class PreguntaTipomultiples extends Preguntas{
   
    
    public PreguntaTipomultiples(String texto, String respuesta,String ... opciones) {
        super(texto, respuesta,opciones);
        
    }
    
    public double calcularcalificacion(String rep) {
        String[] auxstring = respuesta.split("-");
        //agregamos la respuesta en una lista
        List<String> aux = Arrays.asList(auxstring);
        int auxint=0;
        // recorremos las repuesta si esta correcta y vamos sumando
        for (String string : rep.split("-")) {
            if(aux.contains(string)){
                auxint+=1;
            }else{
                auxint-=1;
            }
        }
        return (double) 1-abs(auxstring.length-auxint)/auxstring.length;
    }
    public PreguntaTipomultiples clone() throws CloneNotSupportedException 
    { 
        PreguntaTipomultiples aux = (PreguntaTipomultiples) super.clone();
        return aux; 
    } 
}
