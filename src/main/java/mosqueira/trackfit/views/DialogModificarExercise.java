package mosqueira.trackfit.views;
import java.awt.Font;
import java.awt.Frame;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import mosqueira.trackfit.dataAccess.DataAccess;
import mosqueira.trackfit.dto.Exercicis;

/**
 * DialogModificarExercise es una ventana de diálogo para modificar los datos de un ejercicio.
 * Permite seleccionar un ejercicio existente, modificar su nombre y descripción, y guardar los cambios.
 * 
 * @author Romina Mosqueira
 */
public class DialogModificarExercise extends javax.swing.JDialog {

    private DataAccess da = new DataAccess();
    private List<Exercicis> listExercicis;
    private Exercicis exercici;

     /**
     * Constructor de la clase.
     * 
     * @param parent Ventana padre.
     * @param modal Indica si el diálogo es modal.
     * @param listExerc Ejercicio a modificar.
     */
    public DialogModificarExercise(Frame parent, boolean modal, Exercicis listExerc) {
        super(parent, modal);
        initComponents();
        this.exercici = listExerc;
        listExercicis = da.getInfoExercise();
        setLocationRelativeTo(parent);
        loadExercisesIntoComboBox();
        applyStyles();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopModificar = new javax.swing.JDesktopPane();
        jNomExerciciModificar = new javax.swing.JLabel();
        jDescripcioExercicisModificar = new javax.swing.JLabel();
        jTextNomExerciciModificar = new javax.swing.JTextField();
        jButtonAddModificado = new javax.swing.JButton();
        jButtonCancelModificacion = new javax.swing.JButton();
        jTextDescripcioModificar = new javax.swing.JTextField();
        jComboExercicis = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("MODIFICAR EXERCISE\n"); // NOI18N
        setPreferredSize(new java.awt.Dimension(497, 400));

        jDesktopModificar.setForeground(new java.awt.Color(153, 153, 153));

        jNomExerciciModificar.setBackground(new java.awt.Color(255, 255, 153));
        jNomExerciciModificar.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jNomExerciciModificar.setText("Name Exercicis");
        jNomExerciciModificar.setPreferredSize(new java.awt.Dimension(497, 400));

        jDescripcioExercicisModificar.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jDescripcioExercicisModificar.setText("Descripcio");

        jButtonAddModificado.setText("Add");
        jButtonAddModificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddModificadoActionPerformed(evt);
            }
        });

        jButtonCancelModificacion.setText("Cancel");
        jButtonCancelModificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelModificacionActionPerformed(evt);
            }
        });

        jComboExercicis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboExercicis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboExercicisActionPerformed(evt);
            }
        });

        jDesktopModificar.setLayer(jNomExerciciModificar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopModificar.setLayer(jDescripcioExercicisModificar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopModificar.setLayer(jTextNomExerciciModificar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopModificar.setLayer(jButtonAddModificado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopModificar.setLayer(jButtonCancelModificacion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopModificar.setLayer(jTextDescripcioModificar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopModificar.setLayer(jComboExercicis, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopModificarLayout = new javax.swing.GroupLayout(jDesktopModificar);
        jDesktopModificar.setLayout(jDesktopModificarLayout);
        jDesktopModificarLayout.setHorizontalGroup(
            jDesktopModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopModificarLayout.createSequentialGroup()
                .addGroup(jDesktopModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopModificarLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jComboExercicis, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopModificarLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jNomExerciciModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jTextNomExerciciModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopModificarLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jDescripcioExercicisModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextDescripcioModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopModificarLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jButtonAddModificado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButtonCancelModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jDesktopModificarLayout.setVerticalGroup(
            jDesktopModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopModificarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jComboExercicis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jDesktopModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomExerciciModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNomExerciciModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jDesktopModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDescripcioExercicisModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextDescripcioModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jDesktopModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAddModificado)
                    .addComponent(jButtonCancelModificacion))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopModificar, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopModificar, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Aplica estilos personalizados a los componentes de la interfaz gráfica.
     */
    private void applyStyles() {
        jDesktopModificar.setBackground(new java.awt.Color(240, 240, 240));  
        jNomExerciciModificar.setFont(new java.awt.Font("SansSerif", Font.BOLD, 12));
        jNomExerciciModificar.setForeground(new java.awt.Color(0, 51, 102));  
        jDescripcioExercicisModificar.setFont(new java.awt.Font("SansSerif", Font.BOLD, 12));
        jDescripcioExercicisModificar.setForeground(new java.awt.Color(0, 51, 102));  //
        jTextNomExerciciModificar.setFont(new java.awt.Font("SansSerif", Font.PLAIN, 12));
        jTextNomExerciciModificar.setBackground(new java.awt.Color(255, 255, 255));  // 
        jTextDescripcioModificar.setFont(new java.awt.Font("SansSerif", Font.PLAIN, 12));
        jTextDescripcioModificar.setBackground(new java.awt.Color(255, 255, 255));  
        // Botones con colores personalizados
        jButtonAddModificado.setBackground(new java.awt.Color(0, 153, 76));
        jButtonAddModificado.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancelModificacion.setBackground(new java.awt.Color(255, 51, 51));
        jButtonCancelModificacion.setForeground(new java.awt.Color(255, 255, 255));
    }
    /**
     * Carga los ejercicios en el ComboBox.
     */
    private void loadExercisesIntoComboBox() {
        // Cargar los ejercicios en el comboBox solo una vez
        if (listExercicis != null && !listExercicis.isEmpty()) {
            DefaultComboBoxModel<String> listModel = new DefaultComboBoxModel<>();
            for (Exercicis ex : listExercicis) {
                listModel.addElement(ex.getNomExercici() + " " + ex.getDescripcio());
            }
            jComboExercicis.setModel(listModel);
        } else {
            JOptionPane.showMessageDialog(this, "No exercises found.");
        }
    }
     /**
     * Acción realizada al presionar el botón "Add" para modificar un ejercicio.
     * 
     * @param evt Evento de acción.
     */
    private void jButtonAddModificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddModificadoActionPerformed
        try {
            String newName = jTextNomExerciciModificar.getText().trim();
            String newDescripcio = jTextDescripcioModificar.getText().trim();

            if (newName.isEmpty() || newDescripcio.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Both fields must be filled.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int id = exercici.getId();
            da.getUpdateExercici(id, newName, newDescripcio);

            // Actualizar ComboBox
            listExercicis = da.getInfoExercise();  // Actualiza la lista de ejercicios
            loadExercisesIntoComboBox();  // Recarga el ComboBox con los ejercicios actualizados

            JOptionPane.showMessageDialog(this, "Exercise successfully modified.");
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAddModificadoActionPerformed
    /**
     * Acción realizada al presionar el botón "Cancel" para cancelar la modificación.
     * 
     * @param evt Evento de acción.
     */
    private void jButtonCancelModificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelModificacionActionPerformed
        try {
            String newName = jTextNomExerciciModificar.getText().trim();
            String newDescripcio = jTextDescripcioModificar.getText().trim();

            if (newName.isEmpty() || newDescripcio.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Both fields must be filled.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int id = exercici.getId();
            da.getUpdateExercici(id, newName, newDescripcio);

            JOptionPane.showMessageDialog(this, "Exercise successfully modified.");
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonCancelModificacionActionPerformed

    /**
     * Acción realizada cuando se selecciona un ejercicio en el ComboBox.
     * 
     * @param evt Evento de acción.
     */
    private void jComboExercicisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboExercicisActionPerformed
        // Cuando el usuario selecciona un ejercicio, actualiza los campos de texto
        int selectItem = jComboExercicis.getSelectedIndex();
        if (selectItem >= 0) {
            exercici = listExercicis.get(selectItem);
            jTextNomExerciciModificar.setText(exercici.getNomExercici());
            jTextDescripcioModificar.setText(exercici.getDescripcio());
        }
    }//GEN-LAST:event_jComboExercicisActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddModificado;
    private javax.swing.JButton jButtonCancelModificacion;
    private javax.swing.JComboBox<String> jComboExercicis;
    private javax.swing.JLabel jDescripcioExercicisModificar;
    private javax.swing.JDesktopPane jDesktopModificar;
    private javax.swing.JLabel jNomExerciciModificar;
    private javax.swing.JTextField jTextDescripcioModificar;
    private javax.swing.JTextField jTextNomExerciciModificar;
    // End of variables declaration//GEN-END:variables
}
