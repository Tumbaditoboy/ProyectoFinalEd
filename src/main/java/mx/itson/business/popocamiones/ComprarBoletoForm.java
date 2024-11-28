/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.business.popocamiones;
import javax.swing.*;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import mx.itson.entidades.popocamiones.Autobus;

public class ComprarBoletoForm extends JDialog {
    private JComboBox<String> cmbAsientos;
    private JTextField txtNombre;
    private JComboBox<String> cmbDestino;
    private JTextField txtPrecio;

    public ComprarBoletoForm(JFrame parent, Autobus autobus) {
        super(parent, "Comprar Boleto", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(5, 2));

        // Combobox para seleccionar el asiento
        cmbAsientos = new JComboBox<>();
        cargarAsientosDisponibles(autobus);

        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(10);

        JLabel lblDestino = new JLabel("Destino:");       
        cmbDestino = new JComboBox<>();
        cargarTerminales(autobus);

        JLabel lblPrecio = new JLabel("Precio:");
        txtPrecio = new JTextField(10);

        JButton btnVender = new JButton("Comprar Boleto");
        btnVender.addActionListener((ActionEvent e) -> {
            String nombre = txtNombre.getText().trim();
            String destino = String.valueOf(cmbDestino.getSelectedItem());
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            int asiento = Integer.parseInt(cmbAsientos.getSelectedItem().toString());

            if (autobus.venderBoleto(asiento, nombre, destino, precio)) {
                JOptionPane.showMessageDialog(this, "Boleto comprado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Asiento no disponible.");
            }
        });

        add(lblNombre);
        add(txtNombre);
        add(lblDestino);
        add(cmbDestino);
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
    private void cargarTerminales(Autobus autobus){
        List<String> terminales = autobus.getTerminales();
        for (String t : terminales){
            cmbDestino.addItem(t);
        }
    }
}


