/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package mosqueira.trackfit.views;
import java.awt.Font;
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
        setLocationRelativeTo(parent);
        applyStyles(); 
    }
 private void applyStyles() {
    // Establecemos un esquema de colores consistentes para los componentes
    jDesktopVisualExercicis.setBackground(new java.awt.Color(240, 240, 240));  // Fondo de la ventana

    // Estilo para las etiquetas
    jNombreExercicis.setFont(new java.awt.Font("SansSerif", Font.BOLD, 12));  // Etiqueta en negrita
    jNombreExercicis.setForeground(new java.awt.Color(0, 51, 102));  // Color para las etiquetas

    jDescripcioExercicis.setFont(new java.awt.Font("SansSerif", Font.BOLD, 12));  // Etiqueta en negrita
    jDescripcioExercicis.setForeground(new java.awt.Color(0, 51, 102));  // Color para las etiquetas

    // Estilo para los campos de texto
    jTextNombreExercici.setFont(new java.awt.Font("SansSerif", Font.PLAIN, 12));
    jTextNombreExercici.setBackground(new java.awt.Color(255, 255, 255));  // Fondo blanco para el campo de texto

    jTextDescripcio.setFont(new java.awt.Font("SansSerif", Font.PLAIN, 12));
    jTextDescripcio.setBackground(new java.awt.Color(255, 255, 255));  // Fondo blanco para el campo de texto

    // Estilo para los botones
    jButtonGuardarExercicis.setBackground(new java.awt.Color(0, 153, 76));  // Verde para el botón de guardar
    jButtonGuardarExercicis.setForeground(new java.awt.Color(255, 255, 255));  // Texto en blanco

    jButtonCancelExercici.setBackground(new java.awt.Color(255, 51, 51));  // Rojo para el botón de cancelar
    jButtonCancelExercici.setForeground(new java.awt.Color(255, 255, 255));  // Texto en blanco
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
        setPreferredSize(new java.awt.Dimension(497, 400));

        jDesktopVisualExercicis.setPreferredSize(new java.awt.Dimension(497, 400));

        jButtonGuardarExercicis.setText("Add");
        jButtonGuardarExercicis.setPreferredSize(new java.awt.Dimension(497, 400));
        jButtonGuardarExercicis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarExercicisActionPerformed(evt);
            }
        });

        jButtonCancelExercici.setText("Cancel");
        jButtonCancelExercici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelExerciciActionPerformed(evt);
            }
        });

        jNombreExercicis.setBackground(new java.awt.Color(255, 255, 153));
        jNombreExercicis.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jNombreExercicis.setText("Name Exercicis");

        jDescripcioExercicis.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jDescripcioExercicis.setText("Description");

        jDesktopVisualExercicis.setLayer(jButtonGuardarExercicis, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopVisualExercicis.setLayer(jButtonCancelExercici, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopVisualExercicis.setLayer(jNombreExercicis, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopVisualExercicis.setLayer(jTextNombreExercici, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopVisualExercicis.setLayer(jTextDescripcio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopVisualExercicis.setLayer(jDescripcioExercicis, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopVisualExercicisLayout = new javax.swing.GroupLayout(jDesktopVisualExercicis);
        jDesktopVisualExercicis.setLayout(jDesktopVisualExercicisLayout);
        jDesktopVisualExercicisLayout.setHorizontalGroup(
            jDesktopVisualExercicisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopVisualExercicisLayout.createSequentialGroup()
                .addGroup(jDesktopVisualExercicisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopVisualExercicisLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jNombreExercicis, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jTextNombreExercici, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopVisualExercicisLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jDescripcioExercicis, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextDescripcio, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopVisualExercicisLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jButtonGuardarExercicis, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jButtonCancelExercici, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jDesktopVisualExercicisLayout.setVerticalGroup(
            jDesktopVisualExercicisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopVisualExercicisLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jDesktopVisualExercicisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNombreExercicis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNombreExercici, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jDesktopVisualExercicisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDescripcioExercicis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextDescripcio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jDesktopVisualExercicisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardarExercicis, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelExercici, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(157, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopVisualExercicis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopVisualExercicis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
