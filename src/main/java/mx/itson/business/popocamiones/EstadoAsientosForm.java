/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.business.popocamiones;

import javax.swing.*;
import java.awt.*;
import mx.itson.entidades.popocamiones.Autobus;

public class EstadoAsientosForm extends JDialog {
/*
    private JPanel panelAsientos;

    public EstadoAsientosForm(JFrame parent, Autobus autobus) {
        super(parent, "Estado de Asientos - Gráfico", true);
        setSize(500, 500);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        // Panel para los asientos
        panelAsientos = new JPanel();
        panelAsientos.setLayout(new GridLayout(4, 5, 10, 10)); // 4 filas x 5 columnas, con separación

        // Crear los botones que representan los asientos
        agregarAsientos(autobus);

        // Botón de cierre
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());

        // Agregar el panel y el botón a la ventana
        add(panelAsientos, BorderLayout.CENTER);
        add(btnCerrar, BorderLayout.SOUTH);
    }

    private void agregarAsientos(Autobus autobus) {
        boolean[] asientos = autobus.getAsientos();
        for (int i = 0; i < asientos.length; i++) {
            JButton btnAsiento = new JButton("Asiento " + (i + 1));
            btnAsiento.setHorizontalAlignment(SwingConstants.CENTER);

            // Cambiar el color dependiendo del estado
            if (asientos[i]) {
                btnAsiento.setBackground(Color.RED);
                btnAsiento.setForeground(Color.WHITE);
                btnAsiento.setToolTipText("Ocupado");
            } else {
                btnAsiento.setBackground(Color.GREEN);
                btnAsiento.setForeground(Color.BLACK);
                btnAsiento.setToolTipText("Disponible");
            }

            btnAsiento.setEnabled(false); // Deshabilitar para que no sean clicables
            panelAsientos.add(btnAsiento);
        }
    }
    
    public void actualizarAsientos(Autobus autobus) {
        panelAsientos.removeAll(); // Limpia los asientos actuales
        agregarAsientos(autobus); // Vuelve a agregar los asientos actualizados
        panelAsientos.revalidate();
        panelAsientos.repaint();
       
    }

  */  
}


 