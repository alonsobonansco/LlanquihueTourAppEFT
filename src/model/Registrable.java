package model;

/**
 * Interfaz en común para las entidades registrables de la agencia:
 * Chofer-GuiaTuristico-ProveedorHospedaje-Vehiculo
 */
public interface Registrable {
    /**
     * Método que las clases que implementen Registrable deben incorporar
     * usando @Override.
     *
     * @return Un string con los datos de cada clase.
     */
    String mostrarDatos();
}
