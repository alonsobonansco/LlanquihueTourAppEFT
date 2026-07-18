package data;

import model.*;
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
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sobrescribirEntidades(List<Registrable> listaActualizada) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/registros.txt", false))) {
            for (Registrable r : listaActualizada) {
                String linea = "";
                String unirIdiomas = "";

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
            System.out.println("Error al escribir en el archivo.");
        }
    }
}
