/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.itson.business.popocamiones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import mx.itson.entidades.popocamiones.Autobus;

/**
 *
 * @author dzlan
 */
public class EstadosAsientosForm extends javax.swing.JFrame {

    /**
     * Creates new form EstadosAsientosFormm
     */
    public EstadosAsientosForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EstadosAsientosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstadosAsientosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstadosAsientosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstadosAsientosForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstadosAsientosForm().setVisible(true);
            }
        });
    }

        private JPanel panelAsientos;

    public EstadosAsientosForm(JFrame parent, Autobus autobus) {
        super("Estado de Asientos - Gráfico");
        setSize(500, 500);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        
        panelAsientos = new JPanel();
        panelAsientos.setLayout(new GridLayout(4, 5, 10, 10)); 

        
        agregarAsientos(autobus);

        
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());

        
        add(panelAsientos, BorderLayout.CENTER);
        add(btnCerrar, BorderLayout.SOUTH);
    }

    private void agregarAsientos(Autobus autobus) {
        boolean[] asientos = autobus.getAsientos();
        for (int i = 0; i < asientos.length; i++) {
            JButton btnAsiento = new JButton("Asiento " + (i + 1));
            btnAsiento.setHorizontalAlignment(SwingConstants.CENTER);

            
            if (asientos[i]) {
                btnAsiento.setBackground(Color.RED);
                btnAsiento.setForeground(Color.WHITE);
                btnAsiento.setToolTipText("Ocupado");
            } else {
                btnAsiento.setBackground(Color.GREEN);
                btnAsiento.setForeground(Color.BLACK);
                btnAsiento.setToolTipText("Disponible");
            }

            btnAsiento.setEnabled(false); 
            panelAsientos.add(btnAsiento);
        }
    }
    
    public void actualizarAsientos(Autobus autobus) {
        panelAsientos.removeAll(); 
        agregarAsientos(autobus); 
        panelAsientos.revalidate();
        panelAsientos.repaint();
       
    }
    
    
  
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
