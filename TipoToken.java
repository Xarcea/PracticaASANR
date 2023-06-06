package mx.ipn.asanr;

/**
 *
 * @author Xavier Arce
 */

 public enum TipoToken {
    IDENTIFICADOR,

    // Palabras reservadas
    SELECT, FROM, DISTINCT,

    // Caracteres
    COMA, PUNTO, ASTERISCO,

    // Final de cadena
    EOF
}