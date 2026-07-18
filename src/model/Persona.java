package model;

public abstract class Persona {
    private String nombre;
    private int edad;
    private String rut;
    private Direccion direccion;

    public Persona(String nombre, int edad, String rut,
                   String calle, String sector, String ciudad) {
        setNombre(nombre);
        setEdad(edad);
        setRut(rut);
        this.direccion = new Direccion(calle, sector, ciudad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la persona no puede estar vacío. ");
        }
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La persona no puede tener edad negativa. ");
        }
        this.edad = edad;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        if (rut == null || rut.isBlank()) {
            throw new IllegalArgumentException("El rut de la persona no puede estar vacío. ");
        }
        this.rut = rut;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
