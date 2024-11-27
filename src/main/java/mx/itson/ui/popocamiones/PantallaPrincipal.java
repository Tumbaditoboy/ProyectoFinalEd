/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mx.itson.ui.popocamiones;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import mx.itson.business.popocamiones.EstadoAsientosForm;
import mx.itson.business.popocamiones.RegistrarAutobusForm;
import mx.itson.business.popocamiones.ReporteBoletosForm;
import mx.itson.business.popocamiones.VenderBoletoForm;
import mx.itson.entidades.popocamiones.Autobus;

public class PantallaPrincipal extends JFrame {

    private Autobus autobus;

    public PantallaPrincipal() {
        setTitle("Sistema de Autobuses");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana
        setLayout(new GridLayout(5, 1, 10, 10)); // Diseño con botones verticales

        // Crear autobús
        autobus = new Autobus("ABC123");

        // Botones principales
        JButton btnRegistrarAutobus = new JButton("Registrar Autobús");
        JButton btnVenderBoleto = new JButton("Vender Boleto");
        JButton btnMostrarAsientos = new JButton("Mostrar Asientos");
        JButton btnGenerarReporte = new JButton("Generar Reporte");
        JButton btnSalir = new JButton("Salir");

        // Agregar acciones a los botones
        btnRegistrarAutobus.addActionListener((ActionEvent e) -> abrirRegistrarAutobus());
        btnVenderBoleto.addActionListener((ActionEvent e) -> abrirVenderBoleto());
        btnMostrarAsientos.addActionListener((ActionEvent e) -> abrirMostrarAsientos());
        btnGenerarReporte.addActionListener((ActionEvent e) -> abrirGenerarReporte());
        btnSalir.addActionListener((ActionEvent e) -> System.exit(0));

        // Agregar botones al Frame
        add(btnRegistrarAutobus);
        add(btnVenderBoleto);
        add(btnMostrarAsientos);
        add(btnGenerarReporte);
        add(btnSalir);
    }

    // Métodos para abrir otras ventanas
    private void abrirRegistrarAutobus() {
        new RegistrarAutobusForm(this, autobus).setVisible(true);
    }

    private void abrirVenderBoleto() {
        new VenderBoletoForm(this, autobus).setVisible(true);
    }

    private void abrirMostrarAsientos() {
        new EstadoAsientosForm(this, autobus).setVisible(true);
    }

    private void abrirGenerarReporte() {
        new ReporteBoletosForm(this, autobus).setVisible(true);
    }

    // Ejecutar la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PantallaPrincipal().setVisible(true));
    }
}


