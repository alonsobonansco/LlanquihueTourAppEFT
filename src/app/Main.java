package app;

import data.CargadorEntidades;
import model.Registrable;
import service.GestorEntidades;
import ui.VentanaAgencia;

import java.util.List;

/**
 * Punto de entrada de la aplicación. Crea un objeto CargadorEntidades para
 * cargar datos desde archivo a una List, la que se manda a un GestorEntidades
 * para trabajar sobre ella y este último a VentanaAgencia, que luego inicia
 * la ventana principal.
 *
 * @author Alonso Bonansco
 * @version 1.0.0
 * @since Semana 9
 */
public class Main {
    public static void main(String[] args) {
        CargadorEntidades cargadorEntidades = new CargadorEntidades();

        List<Registrable> listaEntidades = cargadorEntidades.cargarEntidades("/registros.txt");

        GestorEntidades gestorEntidades = new GestorEntidades(listaEntidades);

        VentanaAgencia ventanaAgencia = new VentanaAgencia(gestorEntidades);
        ventanaAgencia.iniciarVentana();
    }
}
