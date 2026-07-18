package model;

public class Chofer extends Empleado implements Registrable {
    private String tipoLicencia;

    public Chofer(String nombre, int edad, String rut,
                  String calle, String sector, String ciudad,
                  double sueldo, String tipoLicencia) {
        super(nombre, edad, rut, calle, sector, ciudad, sueldo);
        setTipoLicencia(tipoLicencia);
    }

    @Override
    public String mostrarDatos() {
        return "Nombre: " + super.getNombre() +
                " | Edad: " + super.getEdad() +
                " | Rut: " + super.getRut() +
                " | Tipo Licencia: " + tipoLicencia + "\n";
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        if (tipoLicencia == null || tipoLicencia.isBlank()) {
            throw new IllegalArgumentException("La licencia debe ser válida. ");
        }
        this.tipoLicencia = tipoLicencia;
    }
}
