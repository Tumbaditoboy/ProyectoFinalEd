/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.business.popocamiones;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import mx.itson.entidades.popocamiones.Autobus;

public class ComprarBoletoForm extends JDialog {
    private JComboBox<String> cmbAsientos;
    private JTextField txtNombre;
    private JComboBox<String> cmbDestino;
    private JLabel lblPrecioValor;

    public ComprarBoletoForm(JFrame parent, Autobus autobus) {
        super(parent, "Comprar Boleto", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(6, 2));

        
        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(10);

        
        JLabel lblDestino = new JLabel("Destino:");
        cmbDestino = new JComboBox<>();
        cargarTerminales(autobus);

       
        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecioValor = new JLabel("0"); 

        
        cmbDestino.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    actualizarPrecio();
                }
            }
        });

        
        JLabel lblAsiento = new JLabel("Asiento:");
        cmbAsientos = new JComboBox<>();
        cargarAsientosDisponibles(autobus);

        
        JButton btnVender = new JButton("Comprar Boleto");
        btnVender.addActionListener((ActionEvent e) -> {
            String nombre = txtNombre.getText().trim();
            String destino = String.valueOf(cmbDestino.getSelectedItem());
            double precio = Double.parseDouble(lblPrecioValor.getText());
            int asiento = Integer.parseInt(cmbAsientos.getSelectedItem().toString());

            if (autobus.venderBoleto(asiento, nombre, destino, precio)) {
                JOptionPane.showMessageDialog(this, "Boleto comprado exitosamente.");
                dispose(); 
            } else {
                JOptionPane.showMessageDialog(this, "Asiento no disponible.");
            }
        });

        
        add(lblNombre);
        add(txtNombre);
        add(lblDestino);
        add(cmbDestino);
        add(lblPrecio);
        add(lblPrecioValor);
        add(lblAsiento);
        add(cmbAsientos);
        add(new JLabel()); 
        add(btnVender);
    }

    private void cargarAsientosDisponibles(Autobus autobus) {
        for (int i = 1; i <= 20; i++) {
            if (!autobus.getAsientos()[i - 1]) {
                cmbAsientos.addItem(String.valueOf(i));
            }
        }
    }

    private void cargarTerminales(Autobus autobus) {
        for (String terminal : autobus.getTerminales()) {
            cmbDestino.addItem(terminal);
        }
    }

    private void actualizarPrecio() {
        
        String destino = String.valueOf(cmbDestino.getSelectedItem());
        double precio = 0;

        
        switch (destino) {
            case "Navojoa":
                precio = 100;
                break;
            case "Obregón":
                precio = 150;
                break;
            case "Empalme":
                precio = 200;
                break;
            case "Guaymas":
                precio = 250;
                break;
            case "Hermosillo":
                precio = 300;
                break;
            case "Santa Ana":
                precio = 350;
                break;
            case "Magdalena":
                precio = 400;
                break;
            case "Imuris":
                precio = 450;
                break;
            case "Nogales":
                precio = 500;
                break;
        }

        
        lblPrecioValor.setText(String.valueOf(precio));
    }
}


