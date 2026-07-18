package model;

public class ProveedorHospedaje extends Empleado implements Registrable {
    private String tipoHospedaje;

    public ProveedorHospedaje(String nombre, int edad, String rut,
                              String calle, String sector, String ciudad,
                              double sueldo, String tipoHospedaje) {
        super(nombre, edad, rut, calle, sector, ciudad, sueldo);
        setTipoHospedaje(tipoHospedaje);
    }

    @Override
    public String mostrarDatos() {
        return "Nombre: " + super.getNombre() +
                " | Edad: " + super.getEdad() +
                " | Rut: " + super.getRut() +
                " | Tipo Hospedaje: " + tipoHospedaje + "\n";
    }

    public String getTipoHospedaje() {
        return tipoHospedaje;
    }

    public void setTipoHospedaje(String tipoHospedaje) {
        if (tipoHospedaje == null || tipoHospedaje.isEmpty()) {
            throw new IllegalArgumentException("El tipo de hospedaje no puede estar vacío. ");
        }
        this.tipoHospedaje = tipoHospedaje;
    }
}
