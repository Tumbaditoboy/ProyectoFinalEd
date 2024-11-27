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

    public ReporteBoletosForm(JFrame parent, Autobus autobus) {
        super(parent, "Reporte de Boletos", true);
        setSize(500, 300);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        // Cargar los datos de los boletos vendidos
        cargarDatosReporte(autobus);

        // Crear la tabla con los datos
        tableReporte = new JTable(data, columnas);
        JScrollPane scrollPane = new JScrollPane(tableReporte);

        // Agregar la tabla al panel
        add(scrollPane, BorderLayout.CENTER);

        // Botón para cerrar el reporte
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        add(btnCerrar, BorderLayout.SOUTH);
    }

    private void cargarDatosReporte(Autobus autobus) {
        // Obtenemos la lista de pasajeros
        int fila = autobus.getPasajeros().size();
        data = new Object[fila][4];

        // Llenamos la tabla con los datos de los pasajeros
        for (int i = 0; i < fila; i++) {
            Pasajero pasajero = autobus.getPasajeros().get(i);
            data[i][0] = pasajero.getNombre();
            data[i][1] = pasajero.getDestino();
            data[i][2] = pasajero.getPrecio();
            data[i][3] = pasajero.getAsiento();
        }
    }
}


