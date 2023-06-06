package mx.ipn.asanr;

import java.util.List;
import java.util.Stack;

/**
 *
 * @author Xavier Arce
 */

public class Parser {
    private final List<Token> tokens;
    private String a;
    private final Token identificador = new Token(TipoToken.IDENTIFICADOR, "");
    private boolean hayErrores = false;
    private static Stack<Integer> pila = new Stack<>();
    private int i = 0;
    private Token preanalisis;
    private Tabla tabla = new Tabla();
    private Gramatica g = new Gramatica();

    public Parser(List<Token> tokens){
        this.tokens = tokens;
    }

    public void analizar(){
        pila.push(0);
        preanalisis = tokens.get(i); //hacer que a sea el primer símbolo de w$

        while(true){
            //hacer que s sea el estado en la parte superior de la pila
            int s = pila.peek();
            if(preanalisis.equals(identificador))
                a = "id";
            else
                a = preanalisis.lexema;
            String accion = tabla.get(s, a);
            if(accion==null){
                hayErrores = true;
                break;
            } else if(accion.startsWith("s")){
                //meter t en la pila;
                int t = Integer.parseInt(accion.substring(1));
                pila.push(t);
                //hacer que a sea el siguiente símbolo de entrada
                preanalisis = tokens.get(++i);
            } else if(accion.startsWith("r")){
                //sacar |β| símbolos de la pila
                int A = Integer.parseInt(accion.substring(1));
                for(int j=0; j<g.getBodySize(A); j++){
                    pila.pop();
                }
                //hacer que el estado t ahora esté en la parte superior de la pila
                s = pila.peek();
                //meter ir_A[t, A] en la pila
                accion = tabla.get(s, g.getHeader(A));
                pila.push(Integer.parseInt(accion));
            } else if(accion.equals("acc")) break; /* terminó el análisis sintáctico */
        }

        if(hayErrores)
            Principal.error("Error en la posición " + preanalisis.posicion + ". No se esperaba el token " + preanalisis.tipo);
        else
            System.out.println("Consulta válida");
    }
}