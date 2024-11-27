/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.business.popocamiones;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import mx.itson.entidades.popocamiones.Autobus;

public class VenderBoletoForm extends JDialog {
    private JComboBox<String> cmbAsientos;
    private JTextField txtNombre;
    private JTextField txtDestino;
    private JTextField txtPrecio;

    public VenderBoletoForm(JFrame parent, Autobus autobus) {
        super(parent, "Vender Boleto", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(5, 2));

        // Combobox para seleccionar el asiento
        cmbAsientos = new JComboBox<>();
        cargarAsientosDisponibles(autobus);

        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(10);

        JLabel lblDestino = new JLabel("Destino:");
        txtDestino = new JTextField(10);

        JLabel lblPrecio = new JLabel("Precio:");
        txtPrecio = new JTextField(10);

        JButton btnVender = new JButton("Vender Boleto");
        btnVender.addActionListener((ActionEvent e) -> {
            String nombre = txtNombre.getText().trim();
            String destino = txtDestino.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            int asiento = Integer.parseInt(cmbAsientos.getSelectedItem().toString());

            if (autobus.venderBoleto(asiento, nombre, destino, precio)) {
                JOptionPane.showMessageDialog(this, "Boleto vendido exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Asiento no disponible.");
            }
        });

        add(lblNombre);
        add(txtNombre);
        add(lblDestino);
        add(txtDestino);
        add(lblPrecio);
        add(txtPrecio);
        add(new JLabel("Asiento:"));
        add(cmbAsientos);
        add(btnVender);
    }

    private void cargarAsientosDisponibles(Autobus autobus) {
        for (int i = 1; i <= 20; i++) {
            if (!autobus.getAsientos()[i - 1]) {
                cmbAsientos.addItem(String.valueOf(i));
            }
        }
    }
}


