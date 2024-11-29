/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mx.itson.ui.popocamiones;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import mx.itson.business.popocamiones.ComprarBoletoForm;
import mx.itson.business.popocamiones.EstadosAsientosForm;
import mx.itson.business.popocamiones.MoverTerminalForm;
import mx.itson.entidades.popocamiones.Autobus;

public class PantallaPrincipal extends JFrame {
    private Autobus autobus;

    public PantallaPrincipal() {
        setTitle("Sistema de Autobuses");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new GridLayout(5, 1, 10, 10)); 

       
        autobus = new Autobus();

        
        JButton btnVenderBoleto = new JButton("Comprar Boleto");
        JButton btnMostrarAsientos = new JButton("Mostrar Asientos");
        JButton btnMoverTerminal = new JButton("Mover Terminal");
        JButton btnSalir = new JButton("Salir");

       
        btnVenderBoleto.addActionListener((ActionEvent e) -> abrirVenderBoleto());
        btnMostrarAsientos.addActionListener((ActionEvent e) -> abrirMostrarAsientos());
        btnMoverTerminal.addActionListener((ActionEvent e) -> abrirMoverTerminal());
        btnSalir.addActionListener((ActionEvent e) -> System.exit(0));

       
        add(btnVenderBoleto);
        add(btnMostrarAsientos);
        add(btnMoverTerminal);
        add(btnSalir);
    }

    private void abrirVenderBoleto() {
        new ComprarBoletoForm(this, autobus).setVisible(true);
    }

    private void abrirMostrarAsientos() {
        new EstadosAsientosForm(this, autobus).setVisible(true);
    }

    private void abrirMoverTerminal() {
        new MoverTerminalForm(autobus).setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PantallaPrincipal().setVisible(true));
    }
}



