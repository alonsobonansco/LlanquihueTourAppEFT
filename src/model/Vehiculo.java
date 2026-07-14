package model;

public class Vehiculo implements Registrable {
    private String tipo;
    private int capacidadMaxima;

    public Vehiculo(String tipo, int capacidadMaxima) {
        this.tipo = tipo;
        this.capacidadMaxima = capacidadMaxima;
    }

    @Override
    public void registrar() {
        System.out.println("Vehiculo registrado");
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Mostrando datos del vehículo");
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
