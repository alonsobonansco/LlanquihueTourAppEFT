package model;

public class ProveedorHospedaje extends Empleado implements Registrable {
    private String tipoHospedaje;

    public ProveedorHospedaje(String nombre, int edad, String rut, Direccion direccion, double sueldo, String tipoHospedaje) {
        super(nombre, edad, rut, direccion, sueldo);
        this.tipoHospedaje = tipoHospedaje;
    }

    @Override
    public String mostrarDatos() {
        return "Nombre: " + super.getNombre() +
                " | Edad: " + super.getEdad() +
                " | Tipo Hospedaje: " + tipoHospedaje + "\n";
    }

    public String getTipoHospedaje() {
        return tipoHospedaje;
    }

    public void setTipoHospedaje(String tipoHospedaje) {
        this.tipoHospedaje = tipoHospedaje;
    }

    @Override
    public String toString() {
        return "Info de Proveedor";
    }
}
