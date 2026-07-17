package app;

import data.CargadorEntidades;
import model.Chofer;
import model.Registrable;
import model.Vehiculo;
import ui.VentanaAgencia;
import util.RutInvalidoException;
import util.RutValidator;

import java.util.List;

public class Main {
    public static void main(String[] args) throws RutInvalidoException {
        VentanaAgencia ventanaAgencia = new VentanaAgencia();
        //ventanaAgencia.iniciarVentana();

        CargadorEntidades cargadorEntidades = new CargadorEntidades();

        List<Registrable> listaEntidades = cargadorEntidades.cargarEntidades("/registros.txt");

        System.out.println(listaEntidades);

    }


}