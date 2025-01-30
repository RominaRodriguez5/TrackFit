package mosqueira.trackfit.views;

import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import mosqueira.trackfit.dataAccess.DataAccess;
import mosqueira.trackfit.dto.Usuaris;
import mosqueira.trackfit.dto.Workouts;

/**
 *
 * @author Lulas
 */
public class DialogWorkouts extends javax.swing.JDialog {

    private Usuaris usuarioSeleccionado;
    private DataAccess da = new DataAccess();
    private List<Usuaris> listUsers;

    public DialogWorkouts(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent); // Centra el diálogo en el frame principal
        cargarUsuarios();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopVisualWorkout = new javax.swing.JDesktopPane();
        jComment = new javax.swing.JLabel();
        jListUsers = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jSpinnerForDate = new javax.swing.JSpinner();
        jComboBoxUsersWork = new javax.swing.JComboBox<>();
        jTextComment = new javax.swing.JTextField();
        jButtonAddWorkout = new javax.swing.JButton();
        jButtonCancelarWorkouts = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jComment.setText("Comment");

        jListUsers.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jListUsers.setText(" Users List");

        jLabelDate.setBackground(new java.awt.Color(255, 255, 153));
        jLabelDate.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jLabelDate.setText("For Date");

        jSpinnerForDate.setModel(new javax.swing.SpinnerDateModel());

        jComboBoxUsersWork.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxUsersWork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUsersWorkActionPerformed(evt);
            }
        });

        jButtonAddWorkout.setText("Add");
        jButtonAddWorkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddWorkoutActionPerformed(evt);
            }
        });

        jButtonCancelarWorkouts.setText("Cancel");
        jButtonCancelarWorkouts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarWorkoutsActionPerformed(evt);
            }
        });

        jDesktopVisualWorkout.setLayer(jComment, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopVisualWorkout.setLayer(jListUsers, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopVisualWorkout.setLayer(jLabelDate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopVisualWorkout.setLayer(jSpinnerForDate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopVisualWorkout.setLayer(jComboBoxUsersWork, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopVisualWorkout.setLayer(jTextComment, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopVisualWorkout.setLayer(jButtonAddWorkout, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopVisualWorkout.setLayer(jButtonCancelarWorkouts, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopVisualWorkoutLayout = new javax.swing.GroupLayout(jDesktopVisualWorkout);
        jDesktopVisualWorkout.setLayout(jDesktopVisualWorkoutLayout);
        jDesktopVisualWorkoutLayout.setHorizontalGroup(
            jDesktopVisualWorkoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopVisualWorkoutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopVisualWorkoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jDesktopVisualWorkoutLayout.createSequentialGroup()
                        .addComponent(jComment, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextComment, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopVisualWorkoutLayout.createSequentialGroup()
                        .addComponent(jListUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxUsersWork, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopVisualWorkoutLayout.createSequentialGroup()
                        .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jSpinnerForDate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDesktopVisualWorkoutLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButtonAddWorkout, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(jButtonCancelarWorkouts, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );
        jDesktopVisualWorkoutLayout.setVerticalGroup(
            jDesktopVisualWorkoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopVisualWorkoutLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jDesktopVisualWorkoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerForDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jDesktopVisualWorkoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jListUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxUsersWork, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jDesktopVisualWorkoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComment, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextComment, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(jDesktopVisualWorkoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddWorkout)
                    .addComponent(jButtonCancelarWorkouts))
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopVisualWorkout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopVisualWorkout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void cargarUsuarios() {
        List<Usuaris> usuariosAsignados = da.getAllUsers(); 
        DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>();

        for (Usuaris usuario : usuariosAsignados) {
            dcbm.addElement(usuario.getNom());
        }
        jComboBoxUsersWork.setModel(dcbm);
        listUsers = usuariosAsignados;
    }

    private void jComboBoxUsersWorkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUsersWorkActionPerformed
        String selectedUserName = (String) jComboBoxUsersWork.getSelectedItem();
        if (selectedUserName != null && !selectedUserName.isEmpty()) {
            // Busca el objeto Usuaris correspondiente al nombre seleccionado
            for (Usuaris usuario : listUsers) {
                if (usuario.getNom().equals(selectedUserName)) {
                    usuarioSeleccionado = usuario; // Actualiza el usuario seleccionado
                    
                    System.out.println("Usuario seleccionado (Work): " + usuarioSeleccionado.getId());
                    break;
                }

            }
            
        }
    }//GEN-LAST:event_jComboBoxUsersWorkActionPerformed

    private void jButtonAddWorkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddWorkoutActionPerformed
        // Verifica si el usuario está seleccionado
        if (usuarioSeleccionado == null || usuarioSeleccionado.getId() == 0) {
            // Si no hay un usuario seleccionado, muestra un mensaje de error
            JOptionPane.showMessageDialog(this, "Please select a valid user", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Detener la ejecución si no hay usuario seleccionado
        }
        String comments = jTextComment.getText();
        Date dateWork = (Date) jSpinnerForDate.getValue();
        // Formatea la fecha en formato adecuado para la base de datos
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fecha = dateFormat.format(dateWork);
        // Crear un nuevo objeto Workouts
        Workouts nuevoWorkout = new Workouts();
        nuevoWorkout.setForDate(fecha);
        nuevoWorkout.setUserId(usuarioSeleccionado.getId());
        nuevoWorkout.setComments(comments);
        // Aquí puedes guardar el nuevo workout en la base de datos o en memoria
        da.getSaveWorkout(nuevoWorkout);

        // Mostrar un mensaje de éxito
        JOptionPane.showMessageDialog(this, "Workout created successfully.");
        dispose();

    }//GEN-LAST:event_jButtonAddWorkoutActionPerformed

    private void jButtonCancelarWorkoutsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarWorkoutsActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarWorkoutsActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddWorkout;
    private javax.swing.JButton jButtonCancelarWorkouts;
    private javax.swing.JComboBox<String> jComboBoxUsersWork;
    private javax.swing.JLabel jComment;
    private javax.swing.JDesktopPane jDesktopVisualWorkout;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jListUsers;
    private javax.swing.JSpinner jSpinnerForDate;
    private javax.swing.JTextField jTextComment;
    // End of variables declaration//GEN-END:variables

}
