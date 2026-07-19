package model;

/**
 * Clase que representa un vehículo de la agencia.
 */
public class Vehiculo implements Registrable {
    private String tipoVehiculo;
    private String patente;
    private int capacidadMaxima;

    public Vehiculo(String tipoVehiculo, String patente, int capacidadMaxima) {
        setTipoVehiculo(tipoVehiculo);
        setPatente(patente);
        setCapacidadMaxima(capacidadMaxima);
    }

    @Override
    public String mostrarDatos() {
        return "Tipo: " + tipoVehiculo +
                " | Patente: " + patente +
                " | Capacidad máxima: " + capacidadMaxima + "\n";
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        if (tipoVehiculo == null || tipoVehiculo.isBlank()) {
            throw new IllegalArgumentException("El tipo de vehículo debe ser válido.");
        }
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        if (patente == null || patente.isBlank()) {
            throw new IllegalArgumentException("La patente no es válida.");
        }
        this.patente = patente;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        if (capacidadMaxima < 1) {
            throw new IllegalArgumentException("El vehículo debe tener capacidad para al menos una persona.");
        }
        this.capacidadMaxima = capacidadMaxima;
    }
}
