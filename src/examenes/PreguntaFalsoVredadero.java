package examenes;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PreguntaFalsoVredadero extends Preguntas{
    
    
    public PreguntaFalsoVredadero(String texto, String respuesta,String ... opciones) {
        super(texto, respuesta,opciones);
    }
    
    public double calcularcalificacion(String rep) {
        if(rep.equals(respuesta)) return (double)1;
        return (double)0;
    }
    public PreguntaFalsoVredadero clone() throws CloneNotSupportedException 
    { 
        PreguntaFalsoVredadero aux = (PreguntaFalsoVredadero) super.clone();
        return aux; 
    } 
}
