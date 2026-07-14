package model;

public class Direccion {
    private String calle;
    private String sector;
    private String ciudad;

    public Direccion(String calle, String sector, String ciudad) {
        this.calle = calle;
        this.sector = sector;
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "¬¬";
    }
}
