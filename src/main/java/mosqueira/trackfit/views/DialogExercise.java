package mosqueira.trackfit.views;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.JOptionPane;
import mosqueira.trackfit.dataAccess.DataAccess;

/**
 * DialogExercise es un JDialog que permite la creación de nuevos ejercicios.
 * Proporciona una interfaz gráfica para que los usuarios ingresen el nombre y la descripción de un ejercicio.
 * Incluye validaciones básicas para evitar campos vacíos y confirma la acción del usuario antes de cerrar.
 *
 * @author Romina Mosqueira
 */
public class DialogExercise extends javax.swing.JDialog {
    /**
    * Instancia de la clase DataAccess para la interacción con la base de datos.
    */
    private DataAccess da = new DataAccess();
    /**
     * Constructor de la clase DialogExercise.
     * 
     * @param parent La ventana padre del diálogo.
     * @param modal Define si el diálogo es modal o no.
     */
    public DialogExercise(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        applyStyles();
    }
     /**
     * Aplica estilos personalizados a los componentes de la interfaz.
     */
       private void applyStyles() {
        jDesktopVisualExercicis.setBackground(new java.awt.Color(240, 240, 240));
        jNombreExercicis.setFont(new java.awt.Font("SansSerif", Font.BOLD, 12));
        jNombreExercicis.setForeground(new java.awt.Color(0, 51, 102));
        jDescripcioExercicis.setFont(new java.awt.Font("SansSerif", Font.BOLD, 12));
        jDescripcioExercicis.setForeground(new java.awt.Color(0, 51, 102));
        jTextNombreExercici.setFont(new java.awt.Font("SansSerif", Font.PLAIN, 12));
        jTextDescripcio.setFont(new java.awt.Font("SansSerif", Font.PLAIN, 12));
        jButtonGuardarExercicis.setBackground(new java.awt.Color(0, 153, 76));
        jButtonGuardarExercicis.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancelExercici.setBackground(new java.awt.Color(255, 51, 51));
        jButtonCancelExercici.setForeground(new java.awt.Color(255, 255, 255));
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
    /**
     * Método llamado cuando el usuario presiona el botón "Add".
     * Valida los campos antes de guardar el ejercicio en la base de datos.
     * 
     * @param evt Evento de acción generado por el botón.
     */
    private void jButtonGuardarExercicisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarExercicisActionPerformed
        String nombreExercici = jTextNombreExercici.getText().trim();
        String descripcioExercici = jTextDescripcio.getText().trim();
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
    /**
     * Método llamado cuando el usuario presiona el botón "Cancel".
     * Muestra una confirmación antes de cerrar el diálogo.
     * 
     * @param evt Evento de acción generado por el botón.
     */
    private void jButtonCancelExerciciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelExerciciActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_jButtonCancelExerciciActionPerformed


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
