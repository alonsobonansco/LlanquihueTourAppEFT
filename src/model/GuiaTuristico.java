package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Subclase para representar un guía turístico. Atributo propio (List<>): idiomas
 */
public class GuiaTuristico extends Empleado implements Registrable {
    private List<String> idiomas;

    public GuiaTuristico(String nombre, int edad, String rut,
                         String calle, String sector, String ciudad,
                         double sueldo, List<String> idiomas) {
        super(nombre, edad, rut, calle, sector, ciudad, sueldo);
        setIdiomas(idiomas);
    }

    @Override
    public String mostrarDatos() {
        String listaIdiomas = String.join(", ", this.idiomas);

        return "Nombre: " + super.getNombre() +
                " | Edad: " + super.getEdad() +
                " | Rut: " + super.getRut() +
                " | Idiomas: " + listaIdiomas + "\n";
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        if (idiomas == null || idiomas.isEmpty()) {
            throw new IllegalArgumentException("El idioma del guía no puede estar vacío. ");
        }
        this.idiomas = new ArrayList<>(idiomas);
    }
}
