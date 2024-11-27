/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.business.popocamiones;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import mx.itson.entidades.popocamiones.Autobus;

public class RegistrarAutobusForm extends JDialog {
    private JTextField txtPlaca;
    private JTextField txtAsientos;

    public RegistrarAutobusForm(JFrame parent, Autobus autobus) {
        super(parent, "Registrar Autobús", true);
        setSize(300, 200);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(3, 2));

        JLabel lblPlaca = new JLabel("Placa:");
        txtPlaca = new JTextField(10);

        JLabel lblAsientos = new JLabel("Número de Asientos:");
        txtAsientos = new JTextField(10);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener((ActionEvent e) -> {
            String placa = txtPlaca.getText().trim();
            int asientos = Integer.parseInt(txtAsientos.getText().trim());
            autobus.registrarAutobus(placa, asientos);
            JOptionPane.showMessageDialog(this, "Autobús registrado exitosamente.");
            dispose();
        });

        add(lblPlaca);
        add(txtPlaca);
        add(lblAsientos);
        add(txtAsientos);
        add(btnGuardar);
    }
}


