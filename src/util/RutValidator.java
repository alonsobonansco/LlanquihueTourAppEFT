package util;

public class RutValidator {
    public static void validarRut(String rut)
            throws RutInvalidoException {

        if (rut == null ||
                !rut.matches("^[0-9]{7,8}-[0-9kK]$")) {

            throw new RutInvalidoException(
                    "Formato de RUT inválido."
            );
        }

        if (!validarModulo11(rut)) {

            throw new RutInvalidoException(
                    "Dígito verificador incorrecto."
            );
        }
    }

    private static boolean validarModulo11(String rut) {

        String[] partes = rut.split("-");

        String numero = partes[0];
        String dvIngresado = partes[1].toUpperCase();

        int suma = 0;
        int multiplicador = 2;

        for (int i = numero.length() - 1; i >= 0; i--) {

            suma += Character.getNumericValue(
                    numero.charAt(i)
            ) * multiplicador;

            multiplicador++;

            if (multiplicador > 7) {
                multiplicador = 2;
            }
        }

        int resto = 11 - (suma % 11);

        String dvCalculado = switch (resto) {
            case 11 -> "0";
            case 10 -> "K";
            default -> String.valueOf(resto);
        };

        return dvCalculado.equals(dvIngresado);
    }
}
