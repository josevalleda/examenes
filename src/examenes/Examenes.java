
package examenes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Examenes {
    
    private int identificador;
    private EnunciadoExamenes enunciado;
    private Map<Preguntas, String > mapa;

    public Examenes(int identificador, EnunciadoExamenes enunciado) {
        this.identificador = identificador;
        this.enunciado = enunciado;
        mapa =  new  HashMap<Preguntas, String > ();
    }

    public int getIdentificador() {
        return identificador;
    }

    public EnunciadoExamenes getEnunciado() {
        return enunciado;
    }
    
    public boolean Responder(int i, String Repuesta){
        Preguntas aux = enunciado.obtenerpregunta(i);
        if(aux != null){
            if(mapa.containsKey(aux)){
                mapa.remove(aux);
            }
            mapa.put(aux, Repuesta);
            return true;
        }
        return false;
    }
    
    public double nota(){
        double scorrecta=0;
        //recorremos las preguntas
        for (Preguntas pregunta : enunciado.getListapreguntas()) {
            //verificamos que halla contestado
            if(mapa.containsKey(pregunta)){
                scorrecta += pregunta.calcularcalificacion(mapa.get(this));
            }
        }
        return 10* scorrecta/ enunciado.getCantidadpreguntas();
    }
 
    // la funcion main
    public static void main(String[] args) {
        Scanner teclado = new Scanner (System.in);
        String Respuesta ="" ;
        char c ='a';
        EnunciadoExamenes e1;
        double sumatoria = 0;
        e1 = new EnunciadoExamenes("primer examen");
        
        e1.insertapregunta(new Preguntatipotest("Cual es el valor decimal 0010?","b", "1","2","3"));
        e1.insertapregunta(new PreguntaTipomultiples("Cuales son protocolos de URL?","a-b", "http","ftp","coco"));
        e1.insertapregunta(new PreguntaFalsoVredadero("un Byte equivale a 15 bits?","falso", "verdadero","false"));
        Examenes a1 = new Examenes(1, e1);
        
        for (Preguntas pregunta : a1.enunciado.getListapreguntas()) {
             c ='a';
            System.out.println(""+pregunta.getTexto()+" \n selecion la o las repuesta correctas:");
            for (Object rep : pregunta.Opcionesrepuesta) {
                System.out.println(""+c+" "+rep);
                c = (char) (c+1);
            }
            Respuesta= teclado.nextLine();
            a1.mapa.put(pregunta, Respuesta);
        }
        for (Preguntas pregunta : a1.enunciado.getListapreguntas()) {
            if(a1.mapa.containsKey(pregunta)){
                Respuesta = a1.mapa.get(pregunta);
                sumatoria += pregunta.calcularcalificacion(Respuesta);
            }
        }
        System.out.println("\n Su nota es:"+10*(sumatoria/a1.enunciado.getCantidadpreguntas()));
    }
    
}
