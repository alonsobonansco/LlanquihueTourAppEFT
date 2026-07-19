package model;

/**
 *
 */
public class Direccion {
    private String calle;
    private String sector;
    private String ciudad;

    public Direccion(String calle, String sector, String ciudad) {
        setCalle(calle);
        setSector(sector);
        setCiudad(ciudad);
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        if (calle == null || calle.isBlank()) {
            throw new IllegalArgumentException("Calle no válida. ");
        }
        this.calle = calle;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        if (sector == null || sector.isBlank()) {
            throw new IllegalArgumentException("Sector no válido. ");
        }
        this.sector = sector;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        if (ciudad == null || ciudad.isBlank()) {
            throw new IllegalArgumentException("Ciudad no válida. ");
        }
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Calle: " + calle + " | Sector: " + sector + " | Ciudad: " + ciudad;
    }
}
