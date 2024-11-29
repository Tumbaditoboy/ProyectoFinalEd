/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.business.popocamiones;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import mx.itson.entidades.popocamiones.Autobus;

/**
 *
 * @author Akane
 */
public class MoverTerminalForm extends JFrame {
    private JLabel lblTerminalActual;
    private JTextArea txtReporte;
    private JButton btnSiguienteTerminal, btnGenerarReporte;
    private int terminalIndex = 0; // Índice de la terminal actual
    private Autobus autobus;
    private EstadosAsientosForm ventanaAsientos;

    public MoverTerminalForm(Autobus autobus) {
        super("Mover Terminal");
        this.autobus = autobus;
        setSize(500, 400);
        setLocation(200, 100);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventanaAsientos = new EstadosAsientosForm(null, autobus);
        ventanaAsientos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaAsientos.setVisible(true);

        lblTerminalActual = new JLabel("Terminal Actual: " + autobus.getTerminales().get(terminalIndex));
        lblTerminalActual.setFont(new Font("Arial", Font.BOLD, 16));
        lblTerminalActual.setHorizontalAlignment(SwingConstants.CENTER);

        txtReporte = new JTextArea();
        txtReporte.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtReporte);

        btnSiguienteTerminal = new JButton("Siguiente Terminal");
        btnSiguienteTerminal.addActionListener((ActionEvent e) -> moverASiguienteTerminal());

        btnGenerarReporte = new JButton("Generar Reporte");
        btnGenerarReporte.setEnabled(false); // Deshabilitado por defecto
        btnGenerarReporte.addActionListener((ActionEvent e) -> abrirGenerarReporte());

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener((ActionEvent e) -> {
            ventanaAsientos.dispose();
            dispose();
        });

        JPanel panelBotones = new JPanel(new GridLayout(1, 3, 10, 10));
        panelBotones.add(btnSiguienteTerminal);
        panelBotones.add(btnGenerarReporte);
        panelBotones.add(btnCerrar);

        add(lblTerminalActual, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        actualizarReporte();
    }

    private void moverASiguienteTerminal() {
        String terminalActual = autobus.getTerminales().get(terminalIndex);

        long pasajerosBajados = autobus.getPasajeros().stream()
                .filter(p -> p.getDestino().equalsIgnoreCase(terminalActual))
                .count();

        autobus.bajarPasajerosEnTerminal(terminalActual);

        txtReporte.append("Terminal: " + terminalActual + "\n");
        txtReporte.append("Se bajaron " + pasajerosBajados + " pasajeros.\n");

        actualizarReporte();
        ventanaAsientos.actualizarAsientos(autobus);

        terminalIndex++;
        if (terminalIndex < autobus.getTerminales().size()) {
            lblTerminalActual.setText("Terminal Actual: " + autobus.getTerminales().get(terminalIndex));
        } else {
            lblTerminalActual.setText("Terminal Finalizada: " + terminalActual);
            btnSiguienteTerminal.setEnabled(false);
            btnGenerarReporte.setEnabled(true); // Habilitar el botón al llegar a Nogales
        }
    }

    private void actualizarReporte() {
        txtReporte.append("--- Estado Actual ---\n");
        txtReporte.append("Pasajeros actuales: " + autobus.getPasajeros().size() + "\n");
        txtReporte.append("Asientos disponibles:\n");

        for (int i = 0; i < autobus.getAsientos().length; i++) {
            txtReporte.append("Asiento " + (i + 1) + ": ");
            txtReporte.append(autobus.getAsientos()[i] ? "Ocupado\n" : "Disponible\n");
        }
        txtReporte.append("\n");
    }

    private void abrirGenerarReporte() {
        new ReporteBoletosForm(this, autobus).setVisible(true);
    }
}

