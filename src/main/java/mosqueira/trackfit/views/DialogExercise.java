/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package mosqueira.trackfit.views;
import java.awt.Frame;
import javax.swing.JOptionPane;
import mosqueira.trackfit.dataAccess.DataAccess;

/**
 *
 * @author Lulas
 */
public class DialogExercise extends javax.swing.JDialog {
   
    private DataAccess da = new DataAccess();

    public DialogExercise(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopVisualExercicis = new javax.swing.JDesktopPane();
        jButtonGuardarExercicis = new javax.swing.JButton();
        jButtonCancelExercici = new javax.swing.JButton();
        jNombreExercicis = new javax.swing.JLabel();
        jTextNombreExercici = new javax.swing.JTextField();
        jTextDescripcio = new javax.swing.JTextField();
        jDescripcioExercicis = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonGuardarExercicis.setText("Add");
        jButtonGuardarExercicis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarExercicisActionPerformed(evt);
            }
        });
        jDesktopVisualExercicis.add(jButtonGuardarExercicis);
        jButtonGuardarExercicis.setBounds(70, 220, 100, 23);

        jButtonCancelExercici.setText("Cancel");
        jButtonCancelExercici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelExerciciActionPerformed(evt);
            }
        });
        jDesktopVisualExercicis.add(jButtonCancelExercici);
        jButtonCancelExercici.setBounds(230, 220, 90, 23);

        jNombreExercicis.setBackground(new java.awt.Color(255, 255, 153));
        jNombreExercicis.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jNombreExercicis.setText("Name Exercicis");
        jDesktopVisualExercicis.add(jNombreExercicis);
        jNombreExercicis.setBounds(30, 70, 100, 30);
        jDesktopVisualExercicis.add(jTextNombreExercici);
        jTextNombreExercici.setBounds(150, 70, 180, 30);
        jDesktopVisualExercicis.add(jTextDescripcio);
        jTextDescripcio.setBounds(150, 140, 180, 30);

        jDescripcioExercicis.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jDescripcioExercicis.setText("Description");
        jDesktopVisualExercicis.add(jDescripcioExercicis);
        jDescripcioExercicis.setBounds(30, 140, 110, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopVisualExercicis, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopVisualExercicis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarExercicisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarExercicisActionPerformed
   String nombreExercici = jTextNombreExercici.getText();
   String descripcioExercici = jTextDescripcio.getText();
    if (nombreExercici.isEmpty() || descripcioExercici.isEmpty()) {
        JOptionPane.showMessageDialog(jDesktopVisualExercicis, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    // Guardar el ejercicio en la base de datos
    da.getSaveExercici(nombreExercici, descripcioExercici);
    // Mostrar mensaje de éxito
    JOptionPane.showMessageDialog(this, "Exercise added successfully.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    // Cerrar el diálogo
    dispose();
    }//GEN-LAST:event_jButtonGuardarExercicisActionPerformed

    private void jButtonCancelExerciciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelExerciciActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelExerciciActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelExercici;
    private javax.swing.JButton jButtonGuardarExercicis;
    private javax.swing.JLabel jDescripcioExercicis;
    private javax.swing.JDesktopPane jDesktopVisualExercicis;
    private javax.swing.JLabel jNombreExercicis;
    private javax.swing.JTextField jTextDescripcio;
    private javax.swing.JTextField jTextNombreExercici;
    // End of variables declaration//GEN-END:variables
}
