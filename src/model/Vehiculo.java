package model;

public class Vehiculo implements Registrable {
    private String tipoVehiculo;
    private String patente;
    private int capacidadMaxima;

    public Vehiculo(String tipoVehiculo, int capacidadMaxima) {
        this.tipoVehiculo = tipoVehiculo;
        this.capacidadMaxima = capacidadMaxima;
    }

    @Override
    public String mostrarDatos() {
        return "Tipo: " + tipoVehiculo +
                " | Patente: " + patente +
                " | Capacidad máxima: " + capacidadMaxima + "\n";
    }

    public String getTipo() {
        return tipoVehiculo;
    }

    public void setTipo(String tipo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    @Override
    public String toString() {
        return "Hola, soy un vehículo";
    }
}
