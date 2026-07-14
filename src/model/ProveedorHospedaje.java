package model;

public class ProveedorHospedaje extends Persona {
    private String tipoHospedaje;

    public ProveedorHospedaje(String nombre, int edad, Direccion direccion, String tipoHospedaje) {
        super(nombre, edad, direccion);
        this.tipoHospedaje = tipoHospedaje;
    }

    public String getTipoHospedaje() {
        return tipoHospedaje;
    }

    public void setTipoHospedaje(String tipoHospedaje) {
        this.tipoHospedaje = tipoHospedaje;
    }
}
