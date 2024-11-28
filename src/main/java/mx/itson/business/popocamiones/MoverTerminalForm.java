/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.business.popocamiones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import mx.itson.entidades.popocamiones.Autobus;

public class MoverTerminalForm extends JDialog {

    private JLabel lblTerminalActual;
    private JTextArea txtReporte;
    private JButton btnSiguienteTerminal;
    private int terminalIndex = 0; // Índice de la terminal actual
    private Autobus autobus;

    public MoverTerminalForm(JFrame parent, Autobus autobus) {
        super(parent, "Mover Terminal", true);
        this.autobus = autobus;
        setSize(500, 400);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        // Etiqueta para la terminal actual
        lblTerminalActual = new JLabel("Terminal Actual: " + autobus.getTerminales().get(terminalIndex));
        lblTerminalActual.setFont(new Font("Arial", Font.BOLD, 16));
        lblTerminalActual.setHorizontalAlignment(SwingConstants.CENTER);

        // Área de texto para mostrar el reporte de pasajeros
        txtReporte = new JTextArea();
        txtReporte.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtReporte);

        // Botón para avanzar a la siguiente terminal
        btnSiguienteTerminal = new JButton("Siguiente Terminal");
        btnSiguienteTerminal.addActionListener((ActionEvent e) -> moverASiguienteTerminal());

        // Botón para cerrar
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener((ActionEvent e) -> dispose());

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2, 10, 10));
        panelBotones.add(btnSiguienteTerminal);
        panelBotones.add(btnCerrar);

        // Agregar componentes al formulario
        add(lblTerminalActual, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // Mostrar los pasajeros iniciales
        actualizarReporte();
    }

    private void moverASiguienteTerminal() {
        
    // Obtener la terminal actual
    String terminalActual = autobus.getTerminales().get(terminalIndex);

    // Contar cuántos pasajeros se bajan en la terminal actual
    long pasajerosBajados = autobus.getPasajeros().stream()
            .filter(p -> p.getDestino().equalsIgnoreCase(terminalActual))
            .count();

    // Liberar asientos y eliminar pasajeros que se bajan
    autobus.bajarPasajerosEnTerminal(terminalActual);

    // Mostrar información en el área de texto
    txtReporte.append("Terminal: " + terminalActual + "\n");
    txtReporte.append("Se bajaron " + pasajerosBajados + " pasajeros.\n");

    // Mostrar estado actualizado de pasajeros y asientos
    actualizarReporte();

    // Avanzar al siguiente índice de la terminal
    terminalIndex++;
    if (terminalIndex < autobus.getTerminales().size()) {
        lblTerminalActual.setText("Terminal Actual: " + autobus.getTerminales().get(terminalIndex));
    } else {
        lblTerminalActual.setText("Terminal Finalizada: " + terminalActual);
        btnSiguienteTerminal.setEnabled(false); // Deshabilitar el botón
    }
}
    



    private void actualizarReporte() {
        // Mostrar el estado de los asientos y pasajeros
        txtReporte.append("--- Estado Actual ---\n");
        txtReporte.append("Pasajeros actuales: " + autobus.getPasajeros().size() + "\n");
        txtReporte.append("Asientos disponibles:\n");

        for (int i = 0; i < autobus.getAsientos().length; i++) {
            txtReporte.append("Asiento " + (i + 1) + ": ");
            txtReporte.append(autobus.getAsientos()[i] ? "Ocupado\n" : "Disponible\n");
        }
        txtReporte.append("\n");
    }
}

