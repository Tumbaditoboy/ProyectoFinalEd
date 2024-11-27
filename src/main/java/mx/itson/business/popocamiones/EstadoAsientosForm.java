/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.business.popocamiones;

import javax.swing.*;
import java.awt.*;
import mx.itson.entidades.popocamiones.Autobus;

public class EstadoAsientosForm extends JDialog {
    private JTextArea txtEstadoAsientos;

    public EstadoAsientosForm(JFrame parent, Autobus autobus) {
        super(parent, "Estado de Asientos", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        txtEstadoAsientos = new JTextArea();
        txtEstadoAsientos.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtEstadoAsientos);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());

        add(scrollPane, BorderLayout.CENTER);
        add(btnCerrar, BorderLayout.SOUTH);

        mostrarEstadoAsientos(autobus);
    }

    private void mostrarEstadoAsientos(Autobus autobus) {
        StringBuilder estado = new StringBuilder("Estado de los Asientos:\n");
        for (int i = 1; i <= 20; i++) {
            estado.append("Asiento ").append(i).append(": ");
            estado.append(autobus.getAsientos()[i - 1] ? "Ocupado" : "Disponible").append("\n");
        }
        txtEstadoAsientos.setText(estado.toString());
    }
}


