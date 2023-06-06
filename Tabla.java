package mx.ipn.asanr;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Xavier Arce
 */

 public class Tabla {
    private final Map<Integer, Map<String, String>> tabla;

    public Tabla() {
        tabla = new HashMap<>();
        llenarTabla();
    }

    private void llenarTabla(){
        set(0, "select", "s2");     set(11, "from", "r6");
        set(0, "Q", "1");           set(12, "id", "s9");
        set(1, "", "acc");          set(12, "A", "19");
        set(2, "id", "s9");         set(12, "A2", "6");
        set(2, "distinct", "s7");   set(13, "from", "r2");
        set(2, "*", "s8");          set(14, "from", "r9");
        set(2, "D", "3");           set(14, ",", "r9");
        set(2, "P", "4");           set(15, "id", "s20");
        set(2, "A", "5");           set(16, "", "r1");
        set(2, "A2", "6");          set(17, ",", "s22");
        set(3, "from", "s10");      set(17, "T1", "21");
        set(4, "from", "r3");       set(18, "id", "s24");
        set(5, "from", "r5");       set(18, "T3", "23");
        set(6, ",", "s12");         set(19, "from", "r7");
        set(6, "A1", "11");         set(20, "from", "r10");
        set(6, "from", "r8");       set(9, "from", "r11");
        set(7, "id", "s9");         set(20, ",", "r10");
        set(7, "*", "s8");          set(21, "", "r12");
        set(7, "P", "13");          set(22, "id", "s18");
        set(7, "A", "5");           set(22, "T", "25");
        set(7, "A2", "6");          set(22, "T2", "17");
        set(8, "from", "r4");       set(23, "", "r15");
        set(9, ".", "s15");         set(23, ",", "r15");
        set(9, "A3", "14");         set(24, ",", "r16");
        set(10, "id", "s18");       set(24, "", "r16");
        set(10, "T", "16");         set(25, "", "r13");
        set(10, "T2", "17");        set(9, ",", "r11");    
        set(18, ",", "r17");        set(17, "", "r14");
        set(18, "", "r17");
    }

    public void set(int fila, String columna, String dato){
        if(!tabla.containsKey(fila)){
            tabla.put(fila, new HashMap<>());
        }
        
        Map<String, String> filaActual = tabla.get(fila);
        filaActual.put(columna, dato);
    }

    public String get(int fila, String columna){
        if(tabla.containsKey(fila)){
            Map<String, String> filaActual = tabla.get(fila);
            if (filaActual.containsKey(columna)) {
                return filaActual.get(columna);
            }
        }
        return null;
    }
}