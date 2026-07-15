package model;

public class ProveedorHospedaje extends Empleado {
    private String tipoHospedaje;

    public ProveedorHospedaje(String nombre, int edad, Direccion direccion, double sueldo, String tipoHospedaje) {
        super(nombre, edad, direccion, sueldo);
        this.tipoHospedaje = tipoHospedaje;
    }

    public String getTipoHospedaje() {
        return tipoHospedaje;
    }

    public void setTipoHospedaje(String tipoHospedaje) {
        this.tipoHospedaje = tipoHospedaje;
    }
}
