package app;

import data.CargadorEntidades;
import model.Registrable;
import ui.VentanaAgencia;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        VentanaAgencia ventanaAgencia = new VentanaAgencia();
        //ventanaAgencia.iniciarVentana();

        CargadorEntidades cargadorEntidades = new CargadorEntidades();

        List<Registrable> listaEntidades = cargadorEntidades.cargarEntidades("/registros.txt");

        System.out.println(listaEntidades);
    }
}
