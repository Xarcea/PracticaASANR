package mx.ipn.asanr;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xavier Arce
 */

public class Gramatica {
    private final List<String> producciones;

    public Gramatica(){
        producciones = new ArrayList<>();
        llenarGramatica();
    }

    private void llenarGramatica(){
        agregarProduccion("Q -> select D from T");
        agregarProduccion("D -> distinct P");
        agregarProduccion("D -> P");
        agregarProduccion("P -> *");
        agregarProduccion("P -> A");
        agregarProduccion("A -> A2 A1");
        agregarProduccion("A1 -> , A");
        agregarProduccion("A1 -> empty");
        agregarProduccion("A2 -> id A3");
        agregarProduccion("A3 -> . id");
        agregarProduccion("A3 -> empty");
        agregarProduccion("T -> T2 T1");
        agregarProduccion("T1 -> , T");
        agregarProduccion("T1 -> empty");
        agregarProduccion("T2 -> id T3");
        agregarProduccion("T3 -> id");
        agregarProduccion("T3 -> empty");
    }

    private void agregarProduccion(String produccion){
        producciones.add(produccion);
    }

    public int getBodySize(int indice){
        if(indice >= 1 && indice <= producciones.size()){
            String produccion = producciones.get(indice - 1);
            String cuerpo = produccion.split("->")[1].trim();
            if(cuerpo.equals("empty"))
                return 0;
            else
                return cuerpo.split(" ").length;
        }
        return -1;
    }

    public String getHeader(int indice){
        if(indice >= 1 && indice <= producciones.size()){
            String produccion = producciones.get(indice - 1);
            return produccion.split("->")[0].trim();
        }
        return null;
    }

    public String toString(int indice){
        if(indice >= 1 && indice <= producciones.size())
            return producciones.get(indice - 1);
        return null;
    }
}