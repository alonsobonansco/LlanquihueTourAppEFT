package model;

public abstract class Empleado extends Persona {
    private double sueldo;

    public Empleado(String nombre, int edad, String rut, String calle, String sector, String ciudad, double sueldo) {
        super(nombre, edad, rut, calle, sector, ciudad);
        setSueldo(sueldo);
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        if (sueldo <= 0) {
            throw new IllegalArgumentException("El sueldo no puede ser negativo o cero. ");
        }
        this.sueldo = sueldo;
    }

    private void validarEdadEmpleado(int edad) {
        if (edad < 18) {
            throw new IllegalArgumentException("Un empleado no puede ser menor de edad. ");
        }
    }
}
