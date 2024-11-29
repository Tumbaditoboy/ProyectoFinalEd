/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.business.popocamiones;

import javax.swing.*;
import java.awt.*;
import mx.itson.entidades.popocamiones.Autobus;
import mx.itson.entidades.popocamiones.Pasajero;

public class ReporteBoletosForm extends JDialog {

    private JTable tableReporte;
    private String[] columnas = {"Nombre", "Destino", "Precio", "Asiento"};
    private Object[][] data;
    private JLabel lblTotalGanancia; 

    public ReporteBoletosForm(JFrame parent, Autobus autobus) {
        super(parent, "Reporte de Boletos", true);
        setSize(500, 400); 
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        
        cargarDatosReporte(autobus);

       
        tableReporte = new JTable(data, columnas);
        JScrollPane scrollPane = new JScrollPane(tableReporte);

        
        double totalGanancia = calcularTotalGanancia(autobus);

       
        lblTotalGanancia = new JLabel("Total de Ganancias: $" + totalGanancia);
        lblTotalGanancia.setFont(new Font("Arial", Font.BOLD, 14));
        lblTotalGanancia.setHorizontalAlignment(SwingConstants.CENTER);

       
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());

        
        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.add(lblTotalGanancia, BorderLayout.NORTH);
        panelInferior.add(btnCerrar, BorderLayout.SOUTH);

        
        add(scrollPane, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }

    private void cargarDatosReporte(Autobus autobus) {
     
        int fila = autobus.getPasajerosParaReporte().size();
        data = new Object[fila][4];

        
        for (int i = 0; i < fila; i++) {
            Pasajero pasajero = autobus.getPasajerosParaReporte().get(i);
            data[i][0] = pasajero.getNombre();
            data[i][1] = pasajero.getDestino();
            data[i][2] = pasajero.getPrecio();
            data[i][3] = pasajero.getAsiento();
        }
    }

    private double calcularTotalGanancia(Autobus autobus) {
        return autobus.getPasajerosParaReporte().stream()
                .mapToDouble(Pasajero::getPrecio)
                .sum();
    }
}




