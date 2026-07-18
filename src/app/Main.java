package app;

import data.CargadorEntidades;
import model.Registrable;
import service.GestorEntidades;
import ui.VentanaAgencia;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CargadorEntidades cargadorEntidades = new CargadorEntidades();

        List<Registrable> listaEntidades = cargadorEntidades.cargarEntidades("/registros.txt");

        GestorEntidades gestorEntidades = new GestorEntidades(listaEntidades);

        VentanaAgencia ventanaAgencia = new VentanaAgencia(gestorEntidades);
        ventanaAgencia.iniciarVentana();
    }
}
