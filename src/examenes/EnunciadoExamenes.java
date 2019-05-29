
package examenes;

import java.util.ArrayList;


public class EnunciadoExamenes {
    private String Nombre;
    private ArrayList<Preguntas> listapreguntas;
    private int cantidadpreguntas;

    public EnunciadoExamenes(String Nombre) {
        this.Nombre = Nombre;
        listapreguntas = new ArrayList<>();
        cantidadpreguntas = listapreguntas.size();
    }

    public String getNombre() {
        return Nombre;
    }

    public ArrayList<Preguntas> getListapreguntas() {
        return listapreguntas;
    }

    public int getCantidadpreguntas() {
        return cantidadpreguntas;
    }
    
    public void insertapregunta(Preguntas pre){
        listapreguntas.add(pre);
        cantidadpreguntas = listapreguntas.size();
    }
    
    public Preguntas obtenerpregunta(int i){
        if(i<getCantidadpreguntas()) return listapreguntas.get(i-1);
        return null;
    }
    
    public boolean permutarpregunta(int i, int j){
        Preguntas aux, aux2;
        // verificamos que sea posible
        if(i>getCantidadpreguntas() || j>getCantidadpreguntas()){
            // tomamos las dos preguntas y hacemos la permutacion
            aux = listapreguntas.get(i);
            aux2 = listapreguntas.get(j);
            listapreguntas.set(i, aux2);
            listapreguntas.set(j, aux);
            return true;
        }
        return false;
    }
    
    public boolean borrarpregunta(int i){
        return listapreguntas.remove(listapreguntas.get(i));
    }
    public boolean borrarpregunta(Preguntas i){
        return listapreguntas.remove(i);
    }
    public boolean contienepregunta (Preguntas i){
        return listapreguntas.contains(i);
    }
}
