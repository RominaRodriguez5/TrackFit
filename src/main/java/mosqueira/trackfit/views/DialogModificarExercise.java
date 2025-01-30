/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package mosqueira.trackfit.views;

import java.awt.Frame;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import mosqueira.trackfit.dataAccess.DataAccess;
import mosqueira.trackfit.dto.Exercicis;

/**
 *
 * @author Lulas
 */
public class DialogModificarExercise extends javax.swing.JDialog {

    private DataAccess da = new DataAccess();
    private List<Exercicis> listExercicis;
    private Exercicis exercici;

    /**
     * Creates new form DialogModificarExercise
     */
    public DialogModificarExercise(Frame parent, boolean modal, Exercicis listExerc) {
        super(parent, modal);
        initComponents();
        this.exercici = listExerc;
        listExercicis = da.getInfoExercise();
        setLocationRelativeTo(parent);
        loadExercisesIntoComboBox();
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

        jDesktopModificar.setForeground(new java.awt.Color(153, 153, 153));

        jNomExerciciModificar.setBackground(new java.awt.Color(255, 255, 153));
        jNomExerciciModificar.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jNomExerciciModificar.setText("Name Exercicis");
        jDesktopModificar.add(jNomExerciciModificar);
        jNomExerciciModificar.setBounds(30, 90, 100, 30);

        jDescripcioExercicisModificar.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jDescripcioExercicisModificar.setText("Descripcio");
        jDesktopModificar.add(jDescripcioExercicisModificar);
        jDescripcioExercicisModificar.setBounds(30, 180, 110, 30);
        jDesktopModificar.add(jTextNomExerciciModificar);
        jTextNomExerciciModificar.setBounds(150, 90, 180, 30);

        jButtonAddModificado.setText("Add");
        jButtonAddModificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddModificadoActionPerformed(evt);
            }
        });
        jDesktopModificar.add(jButtonAddModificado);
        jButtonAddModificado.setBounds(70, 250, 100, 23);

        jButtonCancelModificacion.setText("Cancel");
        jButtonCancelModificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelModificacionActionPerformed(evt);
            }
        });
        jDesktopModificar.add(jButtonCancelModificacion);
        jButtonCancelModificacion.setBounds(220, 250, 90, 23);
        jDesktopModificar.add(jTextDescripcioModificar);
        jTextDescripcioModificar.setBounds(150, 180, 180, 30);

        jComboExercicis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboExercicis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboExercicisActionPerformed(evt);
            }
        });
        jDesktopModificar.add(jComboExercicis);
        jComboExercicis.setBounds(160, 20, 140, 22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jDesktopModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jDesktopModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private void jButtonAddModificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddModificadoActionPerformed
       try {
            String newName = jTextNomExerciciModificar.getText();
            String newDescripcio = jTextDescripcioModificar.getText();
            int id = exercici.getId(); 
            da.getUpdateExercici(id, newName, newDescripcio);

            // Mensaje de éxito
            JOptionPane.showMessageDialog(this, "Exercise successfully modified.");
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAddModificadoActionPerformed

    private void jButtonCancelModificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelModificacionActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelModificacionActionPerformed

    private void jComboExercicisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboExercicisActionPerformed
    // Cuando el usuario selecciona un ejercicio, actualiza los campos de texto
        int selectItem = jComboExercicis.getSelectedIndex();
        if (selectItem >= 0) {
            exercici = listExercicis.get(selectItem);
            jTextNomExerciciModificar.setText(exercici.getNomExercici());
            jTextDescripcioModificar.setText(exercici.getDescripcio());
        }
    }//GEN-LAST:event_jComboExercicisActionPerformed

    /**
     * @param args the command line arguments
     */

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
