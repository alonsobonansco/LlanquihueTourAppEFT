package app;

import model.Cliente;
import model.Direccion;

public class Main {
    public static void main(String[] args) {
        System.out.println("Y aquí se ejecuta algo.");

        Direccion dir = new Direccion("asd", "asd", "asd");

        Cliente cliente = new Cliente("Jaime", 45, dir);
    }
}