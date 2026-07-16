package ui;

import javax.swing.*;
import java.awt.*;

public class VentanaAgencia extends JFrame {
    public VentanaAgencia() {
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
        JButton btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        btnSalir.setFocusable(false);

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnSalir);
        add(panelBotones, BorderLayout.CENTER);
    }

    public void iniciarVentana() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }
}
