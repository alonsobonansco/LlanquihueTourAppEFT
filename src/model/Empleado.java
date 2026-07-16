package model;

public abstract class Empleado extends Persona {
    private double sueldo;

    public Empleado(String nombre, int edad, String rut, Direccion direccion, double sueldo) {
        super(nombre, edad, rut, direccion);
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
