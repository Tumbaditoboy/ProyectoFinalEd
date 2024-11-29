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
    private JLabel lblTotalGanancia; // Etiqueta para mostrar la ganancia total

    public ReporteBoletosForm(JFrame parent, Autobus autobus) {
        super(parent, "Reporte de Boletos", true);
        setSize(500, 400); // Ajustamos el tamaño para incluir la etiqueta
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        // Cargar los datos de los boletos vendidos
        cargarDatosReporte(autobus);

        // Crear la tabla con los datos
        tableReporte = new JTable(data, columnas);
        JScrollPane scrollPane = new JScrollPane(tableReporte);

        // Calcular la ganancia total
        double totalGanancia = calcularTotalGanancia(autobus);

        // Etiqueta para mostrar la ganancia total
        lblTotalGanancia = new JLabel("Total de Ganancias: $" + totalGanancia);
        lblTotalGanancia.setFont(new Font("Arial", Font.BOLD, 14));
        lblTotalGanancia.setHorizontalAlignment(SwingConstants.CENTER);

        // Botón para cerrar el reporte
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());

        // Panel inferior para la etiqueta y el botón
        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.add(lblTotalGanancia, BorderLayout.NORTH);
        panelInferior.add(btnCerrar, BorderLayout.SOUTH);

        // Agregar componentes al formulario
        add(scrollPane, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }

    private void cargarDatosReporte(Autobus autobus) {
        // Usamos la lista de reporte final
        int fila = autobus.getPasajerosParaReporte().size();
        data = new Object[fila][4];

        // Llenamos la tabla con los datos de los pasajeros del reporte final
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




