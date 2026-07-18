package data;

import model.Registrable;
import util.LineaInvalidaException;
import util.RutInvalidoException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CargadorEntidades {
    public List<Registrable> cargarEntidades(String ruta) {
        List<Registrable> entidades = new ArrayList<>();

        try (InputStream is = CargadorEntidades.class.getResourceAsStream(ruta)) {
            if (is == null) {
                System.err.println("Error. No se encontró " + ruta);
                return entidades;
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                String linea;
                int contadorLineas = 0;

                while ((linea = reader.readLine()) != null) {
                    contadorLineas++;

                    if (linea.isBlank()) continue;

                    try {
                        String[] partes = linea.split(";");

                        Registrable nuevaEntidad = EntidadesFactory.crearEntidad(partes);
                        entidades.add(nuevaEntidad);

                    } catch (LineaInvalidaException e) {
                        System.out.println("Errorísimo");
                    } catch (RutInvalidoException e) {
                        System.out.println("Rut malo");
                    } catch (IllegalArgumentException e) {
                        String tipoError = e.getClass().getSimpleName();

                        System.err.println("[" + tipoError + "] " + e.getMessage() +
                                " (Línea " + contadorLineas + ": " + linea + ")");
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error al cargar el archivo");
        }

        return entidades;
    }

    public void escribirEntidades(String[] partes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/registros.txt", true))) {
            String linea = String.join(";", partes);

            writer.write(linea);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
