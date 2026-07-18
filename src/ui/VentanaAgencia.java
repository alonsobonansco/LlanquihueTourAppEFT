package ui;

import model.GuiaTuristico;
import model.Registrable;
import service.GestorEntidades;

import javax.swing.*;
import java.awt.*;

import java.util.List;

public class VentanaAgencia extends JFrame {
    private final GestorEntidades gestorEntidades;

    public VentanaAgencia(GestorEntidades gestorEntidades) {
        this.gestorEntidades = gestorEntidades;

        setTitle("Sistema de Registro - Llanquihue Tour App");
        setSize(500, 290);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(3, 1, 0, 5));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JButton btnRegistrar = new JButton("Registrar nueva entidad");
        btnRegistrar.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        btnRegistrar.setFocusable(false);
        JButton btnMostrar = new JButton("Ver todos los registros");
        btnMostrar.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        btnMostrar.setFocusable(false);
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        btnBuscar.setFocusable(false);

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnBuscar);
        add(panelBotones, BorderLayout.CENTER);

        btnBuscar.addActionListener(e -> escogerBusqueda());
    }

    public void escogerBusqueda() {
        String[] opciones = {"Guía", "Chofer", "Hospedaje"};

        int opcionElegida = JOptionPane.showOptionDialog(
                this, "¿Qué tipo de entidad desea buscar?",
                "Seleccionar entidad", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]
        );

        StringBuilder sb = new StringBuilder();
        String busqueda = "";

        switch (opcionElegida) {
            case 0 -> {
                busqueda = JOptionPane.showInputDialog(this, "Ingrese el idioma a buscar: ");
                if (busqueda == null || busqueda.isBlank()) return;

                List<Registrable> listaGuias = gestorEntidades.buscarGuiaPorIdioma(busqueda.trim());

                sb.append("--- Guías que hablan ").append(busqueda).append(" ---\n\n");
                if (listaGuias.isEmpty()) sb.append("No se encontraron registros.\n");

                for (Registrable r : listaGuias) {
                    sb.append(r.mostrarDatos());
                }
            }

            case 1 -> {
                busqueda = JOptionPane.showInputDialog(this, "Ingrese el tipo de licencia a buscar: ");
                if (busqueda == null || busqueda.isBlank()) return;

                List<Registrable> listaChoferes = gestorEntidades.buscarChoferPorLicencia(busqueda.trim());

                sb.append("--- Choferes con licencia ").append(busqueda).append(" ---\n\n");
                if (listaChoferes.isEmpty()) sb.append("No se encontraron registros.\n");

                for (Registrable r : listaChoferes) {
                    sb.append(r.mostrarDatos());
                }
            }

            case 2 -> {
                busqueda = JOptionPane.showInputDialog(this, "Ingrese el tipo de hospedaje a buscar: ");
                if (busqueda == null || busqueda.isBlank()) return;

                List<Registrable> listaHospedajes = gestorEntidades.buscarHospedajePorTipo(busqueda.trim());

                sb.append("--- Hospedajes de tipo ").append(busqueda).append(" ---\n\n");
                if (listaHospedajes.isEmpty()) sb.append("No se encontraron registros.\n");

                for (Registrable r : listaHospedajes) {
                    sb.append(r.mostrarDatos());
                }
            }

            default -> {
            }
        }

        if (!busqueda.isBlank()) {
            JOptionPane.showMessageDialog(this, sb.toString(), "Resultados de Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void iniciarVentana() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }
}
