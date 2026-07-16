package model;

import java.util.ArrayList;
import java.util.List;

public class GuíaTurístico extends Empleado implements Registrable {
    private List<String> idiomas;

    public GuíaTurístico(String nombre, int edad, String rut, Direccion direccion, double sueldo) {
        super(nombre, edad, rut, direccion, sueldo);
        this.idiomas = idiomas;
    }

    @Override
    public String mostrarDatos() {
        System.out.println("DD;D;D;D;;D;D;");
    }

    public List<String> getIdiomas() {
        return this.idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = new ArrayList<>(idiomas);
    }

    @Override
    public String toString() {
        return "Heres goes the thing";
    }
}
