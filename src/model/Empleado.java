package model;

public abstract class Empleado extends Persona {
    private double sueldo;

    public Empleado (String nombre, int edad, Direccion direccion, double sueldo) {
        super(nombre, edad, direccion);
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Empleado";
    }
}
