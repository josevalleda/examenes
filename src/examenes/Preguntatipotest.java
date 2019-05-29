package examenes;

import java.util.ArrayList;

public class Preguntatipotest extends Preguntas {

   

    public Preguntatipotest(String texto, String respuesta, String... opciones) {
        super(texto, respuesta,opciones);
    }

    
    public double calcularcalificacion(String rep) {
        if (rep.equals(respuesta)) {
            return  1;
        }
        return (double) -1/Opcionesrepuesta.size();
    }
    public Preguntatipotest clone() throws CloneNotSupportedException 
    { 
        Preguntatipotest aux = (Preguntatipotest) super.clone();
        return aux; 
    } 

      
}
