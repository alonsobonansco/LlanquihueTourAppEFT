package data;

import model.*;
import util.LineaInvalidaException;
import util.RutInvalidoException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Clase que maneja el archivo solicitado.
 */
public class CargadorEntidades {
    /**
     * Lee el archivo txt, manda sus partes a EntidadesFactory, este devuelve un objeto
     * y aquí se agrega a una List y la devuelve.
     *
     * @param ruta Nombre del archivo.
     * @return Una List con objetos registrables.
     */
    public List<Registrable> cargarEntidades(String ruta) {
        List<Registrable> entidades = new ArrayList<>();

        try (InputStream is = CargadorEntidades.class.getResourceAsStream(ruta)) {
            if (is == null) {
                JOptionPane.showMessageDialog(
                        null, "Error. No se encontró el archivo " + ruta, "Error de Archivo", JOptionPane.ERROR_MESSAGE);
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
                        JOptionPane.showMessageDialog(
                                null, "Error en línea " + contadorLineas + " Formato no válido", "Error de Archivo", JOptionPane.ERROR_MESSAGE);
                    } catch (RutInvalidoException e) {
                        JOptionPane.showMessageDialog(
                                null, e.getMessage(), "RUT inválido", JOptionPane.ERROR_MESSAGE);
                    } catch (IllegalArgumentException e) {
                        String tipoError = e.getClass().getSimpleName();

                        JOptionPane.showMessageDialog(
                                null, "[" + tipoError + "] " + e.getMessage() +
                                        " (Línea " + contadorLineas + ": " + linea + ")", "Error de Archivo", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null, "Error al cargar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return entidades;
    }

    /**
     * Añade los datos ingresados por el usuario al archivo txt.
     *
     * @param partes Datos ingresados por el usuario.
     */
    public void escribirEntidades(String[] partes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/registros.txt", true))) {
            String linea = String.join(";", partes);

            writer.write(linea);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null, "Error al registrar en el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Escribe en el archivo txt la lista actualizada en modo append false, con el objetivo
     * de sobrescribir los datos.
     *
     * @param listaActualizada Lista después de eliminar un registro.
     */
    public void sobrescribirEntidades(List<Registrable> listaActualizada) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/registros.txt", false))) {
            for (Registrable r : listaActualizada) {
                String linea = "";
                String unirIdiomas;

                if (r instanceof Vehiculo v) {
                    linea = "Vehículo;" + v.getTipoVehiculo() + ";" + v.getPatente() + ";" + v.getCapacidadMaxima();
                } else if (r instanceof Chofer c) {
                    linea = "Chofer;" + c.getNombre() + ";" + c.getEdad() + ";" + c.getRut() +
                            ";" + c.getDireccion().getCalle() + ";" + c.getDireccion().getSector() + ";" + c.getDireccion().getCiudad() +
                            ";" + c.getSueldo() + ";" + c.getTipoLicencia();
                } else if (r instanceof GuiaTuristico g) {
                    unirIdiomas = String.join("|", g.getIdiomas());
                    linea = "Guía;" + g.getNombre() + ";" + g.getEdad() + ";" + g.getRut() +
                            ";" + g.getDireccion().getCalle() + ";" + g.getDireccion().getSector() + ";" + g.getDireccion().getCiudad() +
                            ";" + g.getSueldo() + ";" + unirIdiomas;
                } else if (r instanceof ProveedorHospedaje h) {
                    linea = "Hospedaje;" + h.getNombre() + ";" + h.getEdad() + ";" + h.getRut() +
                            ";" + h.getDireccion().getCalle() + ";" + h.getDireccion().getSector() + ";" + h.getDireccion().getCiudad() +
                            ";" + h.getSueldo() + ";" + h.getTipoHospedaje();
                }

                if (!linea.isBlank()) {
                    writer.write(linea);
                    writer.newLine();
                }
            }

            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null, "Error al sobrescribir el arhivo.", "RUT inválido", JOptionPane.ERROR_MESSAGE);
        }
    }
}
