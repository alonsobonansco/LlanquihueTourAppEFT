package data;

import model.*;
import util.LineaInvalidaException;
import util.RutValidator;

import java.util.List;

public class EntidadesFactory {
    public static Registrable crearEntidad(String[] partes) {
        String tipo = partes[0];

        if (tipo.equals("Vehículo")) {
            if (partes.length != 4) {
                throw new LineaInvalidaException("Formato no válido para un vehículo. ");
            }

            String tipoVehiculo = partes[1];
            String tipoPatente = partes[2];
            int capacidadMaxima = Integer.parseInt(partes[3]);

            return new Vehiculo(tipoVehiculo, tipoPatente, capacidadMaxima);
        }

        String nombre = partes[1];
        int edad = Integer.parseInt(partes[2]);
        String rut = partes[3];

        RutValidator.validarRut(rut);

        String calle = partes[4];
        String sector = partes[5];
        String ciudad = partes[6];
        double sueldo = Double.parseDouble(partes[7]);

        return switch (tipo) {
            case "Guía" -> {
                if (partes.length != 9) {
                    throw new LineaInvalidaException("Formato no válido para guía. ");
                }
                List<String> idiomas = List.of(partes[8].split("\\|"));
                yield new GuiaTuristico(nombre, edad, rut, calle, sector, ciudad, sueldo, idiomas);
            }

            case "Chofer" -> {
                if (partes.length != 9) {
                    throw new LineaInvalidaException("Formato no válido para chofer. ");
                }
                String tipoLicencia = partes[8];
                yield new Chofer(nombre, edad, rut, calle, sector, ciudad, sueldo, tipoLicencia);
            }

            case "Hospedaje" -> {
                if (partes.length != 9) {
                    throw new LineaInvalidaException("Formato no válido para proveedor de hospedaje. ");
                }
                String tipoHospedaje = partes[8];
                yield new ProveedorHospedaje(nombre, edad, rut, calle, sector, ciudad, sueldo, tipoHospedaje);
            }

            default -> throw new LineaInvalidaException("Registro no válido. " +
                    "Verifique que esté escrito correctamente y sea una entidad válida.\n");
        };
    }
}
