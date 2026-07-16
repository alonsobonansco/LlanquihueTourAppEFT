package model;

public class Chofer extends Empleado implements Registrable {
    private String tipoLicencia;

    public Chofer(String nombre, int edad, String rut, Direccion direccion, double sueldo) {
        super(nombre, edad, rut, direccion, sueldo);
        this.tipoLicencia = tipoLicencia;
    }

    @Override
    public String mostrarDatos() {
        return "Nombre: " + super.getNombre() +
                " | Edad: " + super.getEdad() +
                " | Tipo Licencia: " + tipoLicencia + "\n";
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    @Override
    public String toString() {
        return super.toString() + "Además es chofer";
    }
}
