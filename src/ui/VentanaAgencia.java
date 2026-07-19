package ui;

import data.CargadorEntidades;
import data.EntidadesFactory;
import model.Registrable;
import service.GestorEntidades;
import util.RutInvalidoException;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;

public class VentanaAgencia extends JFrame {
    private final GestorEntidades gestorEntidades;
    private final CargadorEntidades cargadorEntidades = new CargadorEntidades();

    public VentanaAgencia(GestorEntidades gestorEntidades) {
        this.gestorEntidades = gestorEntidades;

        setTitle("Sistema de Registros - Llanquihue Tour App");
        setSize(500, 290);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 1, 0, 5));
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
        JButton btnEliminar = new JButton("Eliminar registro");
        btnEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        btnEliminar.setFocusable(false);

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnEliminar);
        add(panelBotones, BorderLayout.CENTER);

        btnRegistrar.addActionListener(e -> registrarEntidad());
        btnMostrar.addActionListener(e -> mostrarEntidades());
        btnBuscar.addActionListener(e -> buscarEntidad());
        btnEliminar.addActionListener(e -> eliminarEntidad());
    }

    public void registrarEntidad() {
        String[] opciones = {"Guía", "Chofer", "Hospedaje", "Vehículo"};

        int opcionElegida = JOptionPane.showOptionDialog(
                this, "¿Qué tipo de entidad desea registrar?",
                "Seleccionar entidad", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]
        );

        switch (opcionElegida) {
            case 0 -> {
                try {
                    String nombre = JOptionPane.showInputDialog(this, "Nombre:");
                    if (nombre == null || nombre.isBlank()) return;

                    String edadTexto = JOptionPane.showInputDialog(this, "Edad:");
                    if (edadTexto == null || edadTexto.isBlank()) return;
                    int edad = Integer.parseInt(edadTexto);

                    String rut = JOptionPane.showInputDialog(this, "RUT:");
                    if (rut == null || rut.isBlank()) return;

                    String calle = JOptionPane.showInputDialog(this, "Calle:");
                    if (calle == null || calle.isBlank()) return;

                    String sector = JOptionPane.showInputDialog(this, "Sector:");
                    if (sector == null || sector.isBlank()) return;

                    String ciudad = JOptionPane.showInputDialog(this, "Ciudad:");
                    if (ciudad == null || ciudad.isBlank()) return;

                    String sueldoTexto = JOptionPane.showInputDialog(this, "Sueldo:");
                    if (sueldoTexto == null || sueldoTexto.isBlank()) return;
                    double sueldo = Double.parseDouble(sueldoTexto);

                    String numeroIdiomasTexto = JOptionPane.showInputDialog(this, "¿Cuántos idiomas habla el guía?:");
                    if (numeroIdiomasTexto == null || numeroIdiomasTexto.isBlank()) return;
                    int numeroIdiomas = Integer.parseInt(numeroIdiomasTexto);

                    List<String> listaIdiomas = new ArrayList<>();

                    for (int i = 1; i <= numeroIdiomas; i++) {
                        String idioma = JOptionPane.showInputDialog(this, "Añada un idioma:");
                        if (idioma == null || idioma.isBlank()) return;

                        listaIdiomas.add(idioma);
                    }

                    String unirIdiomas = String.join("|", listaIdiomas);

                    String[] partesGuia = {
                            "Guía", nombre, edadTexto, rut, calle, sector, ciudad, sueldoTexto, unirIdiomas
                    };

                    Registrable nuevoGuia = EntidadesFactory.crearEntidad(partesGuia);

                    gestorEntidades.agregarRegistrable(nuevoGuia);

                    cargadorEntidades.escribirEntidades(partesGuia);

                    JOptionPane.showMessageDialog(
                            this, "Guía registrado correctamente.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(
                            this, "Debe ingresar un dato válido.", "Error", JOptionPane.INFORMATION_MESSAGE);
                } catch (RutInvalidoException e) {
                    JOptionPane.showMessageDialog(
                            this, "El RUT ingresado no es válido.", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            case 1 -> {
                try {
                    String nombre = JOptionPane.showInputDialog(this, "Nombre:");
                    if (nombre == null || nombre.isBlank()) return;

                    String edadTexto = JOptionPane.showInputDialog(this, "Edad:");
                    if (edadTexto == null || edadTexto.isBlank()) return;
                    int edad = Integer.parseInt(edadTexto);

                    String rut = JOptionPane.showInputDialog(this, "RUT:");
                    if (rut == null || rut.isBlank()) return;

                    String calle = JOptionPane.showInputDialog(this, "Calle:");
                    if (calle == null || calle.isBlank()) return;

                    String sector = JOptionPane.showInputDialog(this, "Sector:");
                    if (sector == null || sector.isBlank()) return;

                    String ciudad = JOptionPane.showInputDialog(this, "Ciudad:");
                    if (ciudad == null || ciudad.isBlank()) return;

                    String sueldoTexto = JOptionPane.showInputDialog(this, "Sueldo:");
                    if (sueldoTexto == null || sueldoTexto.isBlank()) return;
                    double sueldo = Double.parseDouble(sueldoTexto);

                    String tipoLicencia = JOptionPane.showInputDialog(this, "Tipo licencia:");
                    if (tipoLicencia == null || tipoLicencia.isBlank()) return;

                    String[] partesChofer = {
                            "Chofer", nombre, edadTexto, rut, calle, sector, ciudad, sueldoTexto, tipoLicencia
                    };

                    Registrable nuevoGuia = EntidadesFactory.crearEntidad(partesChofer);

                    gestorEntidades.agregarRegistrable(nuevoGuia);

                    cargadorEntidades.escribirEntidades(partesChofer);

                    JOptionPane.showMessageDialog(
                            this, "Chofer registrado correctamente.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(
                            this, "Debe ingresar un dato válido.", "Error", JOptionPane.INFORMATION_MESSAGE);
                } catch (RutInvalidoException e) {
                    JOptionPane.showMessageDialog(
                            this, "El RUT ingresado no es válido.", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            case 2 -> {
                try {
                    String nombre = JOptionPane.showInputDialog(this, "Nombre:");
                    if (nombre == null || nombre.isBlank()) return;

                    String edadTexto = JOptionPane.showInputDialog(this, "Edad:");
                    if (edadTexto == null || edadTexto.isBlank()) return;
                    int edad = Integer.parseInt(edadTexto);

                    String rut = JOptionPane.showInputDialog(this, "RUT:");
                    if (rut == null || rut.isBlank()) return;

                    String calle = JOptionPane.showInputDialog(this, "Calle:");
                    if (calle == null || calle.isBlank()) return;

                    String sector = JOptionPane.showInputDialog(this, "Sector:");
                    if (sector == null || sector.isBlank()) return;

                    String ciudad = JOptionPane.showInputDialog(this, "Ciudad:");
                    if (ciudad == null || ciudad.isBlank()) return;

                    String sueldoTexto = JOptionPane.showInputDialog(this, "Sueldo:");
                    if (sueldoTexto == null || sueldoTexto.isBlank()) return;
                    double sueldo = Double.parseDouble(sueldoTexto);

                    String tipoHospedaje = JOptionPane.showInputDialog(this, "Tipo hospedaje:");
                    if (tipoHospedaje == null || tipoHospedaje.isBlank()) return;

                    String[] partesHospedaje = {
                            "Hospedaje", nombre, edadTexto, rut, calle, sector, ciudad, sueldoTexto, tipoHospedaje
                    };

                    Registrable nuevoHospedaje = EntidadesFactory.crearEntidad(partesHospedaje);

                    gestorEntidades.agregarRegistrable(nuevoHospedaje);

                    cargadorEntidades.escribirEntidades(partesHospedaje);

                    JOptionPane.showMessageDialog(
                            this, "Hospedaje registrado correctamente.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(
                            this, "Debe ingresar un dato válido.", "Error", JOptionPane.INFORMATION_MESSAGE);
                } catch (RutInvalidoException e) {
                    JOptionPane.showMessageDialog(
                            this, "El RUT ingresado no es válido.", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            case 3 -> {
                try {
                    String tipoVehiculo = JOptionPane.showInputDialog(this, "Tipo Vehículo:");
                    if (tipoVehiculo == null || tipoVehiculo.isBlank()) return;

                    String patente = JOptionPane.showInputDialog(this, "Patente:");
                    if (patente == null || patente.isBlank()) return;

                    String stringCapacidad = JOptionPane.showInputDialog(this, "Capacidad máxima:");
                    if (stringCapacidad == null || stringCapacidad.isBlank()) return;
                    int capacidadMaxima = Integer.parseInt(stringCapacidad);

                    String[] partesVehiculo = {
                            "Vehículo", tipoVehiculo, patente, stringCapacidad
                    };

                    Registrable nuevoVehiculo = EntidadesFactory.crearEntidad(partesVehiculo);

                    gestorEntidades.agregarRegistrable(nuevoVehiculo);

                    cargadorEntidades.escribirEntidades(partesVehiculo);

                    JOptionPane.showMessageDialog(
                            this, "Vehículo registrado correctamente.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(
                            this, "Debe ingresar una capacidad válida.", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            default -> {
            }
        }
    }

    public void mostrarEntidades() {
        String registros = gestorEntidades.mostrarRegistrables();

        JOptionPane.showMessageDialog(
                this, registros, "Registro de todas las entidades", JOptionPane.INFORMATION_MESSAGE);
    }

    public void buscarEntidad() {
        String[] opciones = {"Guía", "Chofer", "Hospedaje", "Vehículo"};

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

            case 3 -> {
                busqueda = JOptionPane.showInputDialog(this, "Ingrese el tipo de vehículo a buscar: ");
                if (busqueda == null || busqueda.isBlank()) return;

                List<Registrable> listaVehiculos = gestorEntidades.buscarVehiculoPorTipo(busqueda.trim());

                sb.append("--- Vehículos de tipo ").append(busqueda).append(" ---\n\n");
                if (listaVehiculos.isEmpty()) sb.append("No se encontraron registros.\n");

                for (Registrable r : listaVehiculos) {
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

    public void eliminarEntidad() {
        String eliminar = JOptionPane.showInputDialog(this, "Ingrese el RUT o Patente a eliminar: ");
        if (eliminar == null || eliminar.isBlank()) return;

        boolean eliminado = gestorEntidades.eliminarRegistro(eliminar.trim());

        if (eliminado) {
            cargadorEntidades.sobrescribirEntidades(gestorEntidades.getListaRegistrables());

            JOptionPane.showMessageDialog(
                    this, "Registro eliminado con éxito.", "Registro eliminado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    this, "No se encontró un registro que coincida.", "Registro no encontrado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void iniciarVentana() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }
}
