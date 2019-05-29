
package examenes;

import java.util.ArrayList;


abstract class Preguntas implements Cloneable{
    protected  String texto;
    protected  String respuesta;
    protected  int dificultad;
     protected ArrayList<String> Opcionesrepuesta;
    public Preguntas(String texto, String respuesta,String[] opciones) {
        this.texto = texto;
        this.respuesta = respuesta;
        dificultad = 0;
        Opcionesrepuesta = new ArrayList<>();
        for (String opcione : opciones) {
            Opcionesrepuesta.add(opcione);
        }
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public String getTexto() {
        return texto;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public int getDificultad() {
        return dificultad;
    }
    
    abstract double calcularcalificacion(String rep);
    public Preguntas clone() throws CloneNotSupportedException 
    { 
        Preguntas aux = (Preguntas) super.clone();
        aux.dificultad = 0;
        return aux; 
    } 
    
}
