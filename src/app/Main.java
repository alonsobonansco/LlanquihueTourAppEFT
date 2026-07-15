package app;

import model.Direccion;
import model.ProveedorHospedaje;

public class Main {
    public static void main(String[] args) {
        System.out.println("Y aquí se ejecuta algo.");

        Direccion dir = new Direccion("asd", "asd", "asd");

        ProveedorHospedaje cliente = new ProveedorHospedaje(
                "Jaime", 45, dir, 800000, "Cabañas");
    }
}