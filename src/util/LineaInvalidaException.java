package util;

public class LineaInvalidaException extends RuntimeException {
    public LineaInvalidaException(String mensaje) {
        super(mensaje);
    }

    public LineaInvalidaException(String mensaje, String linea, int contadorLineas) {
        super(mensaje + "(Línea " + contadorLineas + ": " + linea + ")");
    }
}
