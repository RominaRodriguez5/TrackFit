package mosqueira.trackfit.views;

import java.awt.Color;
import java.awt.Image;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import mosqueira.componentecalendar.TrainingData;
import mosqueira.trackfit.Main;
import mosqueira.trackfit.dataAccess.DataAccess;
import mosqueira.trackfit.dto.Exercicis;
import mosqueira.trackfit.dto.ExercicisWorKouts;
import mosqueira.trackfit.dto.Usuaris;
import mosqueira.trackfit.dto.Workouts;

/**
 *
 * @author Lulas
 */
public class ListPanelUsuariosAsignados extends javax.swing.JPanel {

    private Main mainFra;
    private Usuaris instructor;
    private Usuaris usuarioSeleccionado;
    private DataAccess da = new DataAccess();
    private List<Usuaris> listUsers;
    private List<Exercicis> listExercise;

    /**
     * Creates new form ListPanel
     */
    public ListPanelUsuariosAsignados(Main jFrameMain, Usuaris instructor, boolean isDarkMode) {
        initComponents();
        this.instructor = instructor;
        this.mainFra = jFrameMain;
        this.listExercise = listExercise;
        assignedUsers();
        inicializarTablaWorkouts();
        inicializarTablaListaExercicis();
        // Asignar íconos a los botones
        asignarIconosABotones();
        componenteCalendar1.addTrainingEventListener((List<TrainingData> trainings) -> {
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (TrainingData training : trainings) {
                listModel.addElement(training.toString());
            }
             JOptionPane.showMessageDialog(jPanelCalendar, listModel);
        });
        // Aplicar el estado inicial de Dark Mode
        applyDarkMode(isDarkMode);
    }

    private ImageIcon resizeIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }

    private void asignarIconosABotones() {
        // Asignar íconos a los botones, con un tamaño adecuado (ajustable)
        jButtonAddWorkouts.setIcon(resizeIcon("/images/path_to_icon.png", 50, 50)); 
        jButtonShowExercise.setIcon(resizeIcon("/images/show_exercise_icon.png", 30, 30)); 
        jButtonAgregar.setIcon(resizeIcon("/images/add_exercise_icon.png", 30, 30));
        jButtonModificar.setIcon(resizeIcon("/images/edit_exercise_icon.png", 30, 30)); 
        jButtonEliminar.setIcon(resizeIcon("/images/delete_exercise_icon.png", 30, 30)); 
        jButtonAddExerciseToWorkouts.setIcon(resizeIcon("/images/add_exercise_to_workout_icon.png", 50, 50)); 
    }

    public void applyDarkMode(boolean isDarkMode) {
        if (isDarkMode) {
            this.setBackground(Color.DARK_GRAY);
            this.setForeground(Color.WHITE);
            // Cambiar colores de componentes internos
            for (java.awt.Component component : this.getComponents()) {
                component.setBackground(Color.DARK_GRAY);
                component.setForeground(Color.WHITE);
            }
        } else {
            this.setBackground(new Color(249, 249, 231));
            this.setForeground(Color.BLACK);
            // Cambiar colores de componentes internos
            for (java.awt.Component component : this.getComponents()) {
                component.setBackground(new Color(249, 249, 231));
                component.setForeground(Color.BLACK);
            }
        }
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLogo = new javax.swing.JLabel();
        jButtonAddWorkouts = new javax.swing.JButton();
        jButtonAddExerciseToWorkouts = new javax.swing.JButton();
        jPanelAssignedExercicis = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListExercise = new javax.swing.JList<>();
        jPanelListUsers = new javax.swing.JPanel();
        jComboBoxListUsers = new javax.swing.JComboBox<>();
        jPanelWorkoutsTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableWorkouts = new javax.swing.JTable();
        jPanelExercicis = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableExercicis = new javax.swing.JTable();
        jButtonAgregar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonShowExercise = new javax.swing.JButton();
        jPanelCalendar = new javax.swing.JPanel();
        componenteCalendar1 = new mosqueira.componentecalendar.ComponenteCalendar();

        setBackground(new java.awt.Color(249, 249, 231));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMinimumSize(new java.awt.Dimension(700, 600));
        setPreferredSize(new java.awt.Dimension(700, 600));
        setRequestFocusEnabled(false);
        setLayout(null);

        jLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        jLogo.setText("jLabel2");
        jLogo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 51)));
        jLogo.setPreferredSize(new java.awt.Dimension(150, 150));
        jLogo.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        add(jLogo);
        jLogo.setBounds(590, 0, 180, 110);

        jButtonAddWorkouts.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        jButtonAddWorkouts.setToolTipText("New Workouts");
        jButtonAddWorkouts.setBorder(null);
        jButtonAddWorkouts.setContentAreaFilled(false);
        jButtonAddWorkouts.setPreferredSize(new java.awt.Dimension(30, 30));
        jButtonAddWorkouts.setRequestFocusEnabled(false);
        jButtonAddWorkouts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddWorkoutsActionPerformed(evt);
            }
        });
        add(jButtonAddWorkouts);
        jButtonAddWorkouts.setBounds(190, 290, 70, 50);

        jButtonAddExerciseToWorkouts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_exercise_to_workout_icon.png"))); // NOI18N
        jButtonAddExerciseToWorkouts.setToolTipText("Add Exercise  to  Workouts");
        jButtonAddExerciseToWorkouts.setBorder(null);
        jButtonAddExerciseToWorkouts.setBorderPainted(false);
        jButtonAddExerciseToWorkouts.setContentAreaFilled(false);
        jButtonAddExerciseToWorkouts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddExerciseToWorkoutsActionPerformed(evt);
            }
        });
        add(jButtonAddExerciseToWorkouts);
        jButtonAddExerciseToWorkouts.setBounds(90, 290, 70, 50);

        jPanelAssignedExercicis.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Assigned Exercise", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SimSun", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanelAssignedExercicis.setLayout(null);

        jListExercise.setBackground(new java.awt.Color(249, 249, 231));
        jListExercise.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jListExercise.setForeground(new java.awt.Color(0, 0, 0));
        jListExercise.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Exercise List" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListExercise);

        jPanelAssignedExercicis.add(jScrollPane2);
        jScrollPane2.setBounds(20, 30, 170, 210);

        add(jPanelAssignedExercicis);
        jPanelAssignedExercicis.setBounds(360, 10, 210, 270);

        jPanelListUsers.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List Users", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SimSun", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanelListUsers.setLayout(null);

        jComboBoxListUsers.setBackground(new java.awt.Color(153, 153, 153));
        jComboBoxListUsers.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxListUsers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxListUsers.setActionCommand("");
        jComboBoxListUsers.setPreferredSize(new java.awt.Dimension(652, 395));
        jComboBoxListUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxListUsersActionPerformed(evt);
            }
        });
        jPanelListUsers.add(jComboBoxListUsers);
        jComboBoxListUsers.setBounds(10, 30, 180, 30);

        add(jPanelListUsers);
        jPanelListUsers.setBounds(10, 10, 330, 80);

        jPanelWorkoutsTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Workouts Table", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SimSun", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanelWorkoutsTable.setLayout(null);

        jTableWorkouts.setBackground(new java.awt.Color(153, 153, 153));
        jTableWorkouts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jTableWorkouts.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableWorkouts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableWorkouts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableWorkoutsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableWorkouts);

        jPanelWorkoutsTable.add(jScrollPane1);
        jScrollPane1.setBounds(10, 30, 290, 120);

        add(jPanelWorkoutsTable);
        jPanelWorkoutsTable.setBounds(10, 110, 330, 160);

        jPanelExercicis.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Exercise", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SimSun", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanelExercicis.setForeground(new java.awt.Color(0, 0, 0));
        jPanelExercicis.setLayout(null);

        jTableExercicis.setBackground(new java.awt.Color(153, 153, 153));
        jTableExercicis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jTableExercicis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableExercicisMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableExercicis);

        jPanelExercicis.add(jScrollPane3);
        jScrollPane3.setBounds(70, 70, 180, 220);

        jButtonAgregar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAgregar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_exercise_icon.png"))); // NOI18N
        jButtonAgregar.setToolTipText("Add New Exercise");
        jButtonAgregar.setBorder(null);
        jButtonAgregar.setBorderPainted(false);
        jButtonAgregar.setContentAreaFilled(false);
        jButtonAgregar.setPreferredSize(new java.awt.Dimension(50, 50));
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });
        jPanelExercicis.add(jButtonAgregar);
        jButtonAgregar.setBounds(190, 20, 30, 30);

        jButtonEliminar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonEliminar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_exercise_icon.png"))); // NOI18N
        jButtonEliminar.setToolTipText("Delete");
        jButtonEliminar.setBorder(null);
        jButtonEliminar.setBorderPainted(false);
        jButtonEliminar.setContentAreaFilled(false);
        jButtonEliminar.setPreferredSize(new java.awt.Dimension(50, 50));
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanelExercicis.add(jButtonEliminar);
        jButtonEliminar.setBounds(250, 20, 30, 30);

        jButtonModificar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonModificar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_exercise_icon.png"))); // NOI18N
        jButtonModificar.setToolTipText("Modify");
        jButtonModificar.setBorder(null);
        jButtonModificar.setBorderPainted(false);
        jButtonModificar.setContentAreaFilled(false);
        jButtonModificar.setPreferredSize(new java.awt.Dimension(50, 50));
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanelExercicis.add(jButtonModificar);
        jButtonModificar.setBounds(120, 20, 40, 30);

        jButtonShowExercise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/show_exercise_icon.png"))); // NOI18N
        jButtonShowExercise.setToolTipText("Show Exercise");
        jButtonShowExercise.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 51))));
        jButtonShowExercise.setBorderPainted(false);
        jButtonShowExercise.setContentAreaFilled(false);
        jButtonShowExercise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowExerciseActionPerformed(evt);
            }
        });
        jPanelExercicis.add(jButtonShowExercise);
        jButtonShowExercise.setBounds(40, 20, 50, 30);

        add(jPanelExercicis);
        jPanelExercicis.setBounds(10, 380, 330, 310);

        jPanelCalendar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Calendar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SimSun", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanelCalendar.setLayout(null);

        componenteCalendar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 153)));
        componenteCalendar1.setActiveButtonColor(new java.awt.Color(255, 153, 51));
        jPanelCalendar.add(componenteCalendar1);
        componenteCalendar1.setBounds(20, 40, 370, 300);

        add(jPanelCalendar);
        jPanelCalendar.setBounds(350, 290, 420, 400);
    }// </editor-fold>//GEN-END:initComponents

    private void assignedUsers() {
        List<Usuaris> usuariosAsignados = da.getAllUsersInstructor(instructor);
        DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>();
        listUsers = usuariosAsignados;
        for (Usuaris usuario : usuariosAsignados) {
            dcbm.addElement(usuario.getNom());
        }
        jComboBoxListUsers.setModel(dcbm);
        updateTableExercicis(new ArrayList<>());
    }

    private void jComboBoxListUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxListUsersActionPerformed
        // Verifica que se ha seleccionado un usuario válido
        String selectedUserName = (String) jComboBoxListUsers.getSelectedItem();
        if (selectedUserName != null && !selectedUserName.isEmpty()) {
            // Busca el objeto Usuaris correspondiente al nombre seleccionado
            for (Usuaris usuario : listUsers) {
                if (usuario.getNom().equals(selectedUserName)) {
                    usuarioSeleccionado = usuario; // Actualiza el usuario seleccionado
                    int userId = usuario.getId();
                    updateTableWorkouts(userId); // Actualiza la tabla de workouts

                }
            }
        }
    }//GEN-LAST:event_jComboBoxListUsersActionPerformed

    private void jTableWorkoutsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableWorkoutsMouseClicked
        int selectedRow = jTableWorkouts.getSelectedRow();
        if (selectedRow != -1) {
            try {
                // Obtener el valor de la columna de ID y convertir a Integer
                Object idValue = jTableWorkouts.getValueAt(selectedRow, 0);
                int workoutId = (idValue instanceof Integer) ? (Integer) idValue : Integer.parseInt(idValue.toString());

                List<Exercicis> exercicis = da.getExercicisForWorkout(workoutId);
                listExercicisAssignedWorkouts(exercicis);

                if (exercicis.isEmpty()) {
                    jListExercise.setVisible(false);
                } else {
                    jListExercise.setVisible(true);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error: Error: The workout select is not a valid.");
            }
        }
    }//GEN-LAST:event_jTableWorkoutsMouseClicked

    private void jButtonAddWorkoutsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddWorkoutsActionPerformed

        // Crear una instancia del diálogo con el usuario seleccionado
        DialogWorkouts workouts = new DialogWorkouts(mainFra, true);
        workouts.setVisible(true);
    }//GEN-LAST:event_jButtonAddWorkoutsActionPerformed
    private void listExercicisAssignedWorkouts(List<Exercicis> listExercicis) {
        //MUESTRA LA LISTA del ejercicio que esta ASIGNADO al workout
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Exercicis ex : listExercicis) {
            listModel.addElement(ex.getNomExercici() + " " + ex.getDescripcio());
        }
        jListExercise.setModel(listModel);
    }

    private void inicializarTablaWorkouts() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{"Workout", "ForDate", "Comments"});
        jTableWorkouts.setModel(dtm);
        jListExercise.setVisible(false);
    }

    private void updateTableWorkouts(int userId) {
        DefaultTableModel dtm = (DefaultTableModel) jTableWorkouts.getModel();
        dtm.setRowCount(0);

        ArrayList<Workouts> workouts = da.getWorkoutsForUser(userId);

        for (Workouts workout : workouts) {   
            dtm.addRow(new Object[]{workout.getId(), workout.getForDate(), workout.getComments()});
        }
    }

    private void inicializarTablaListaExercicis() {
        // Inicializa la tabla de ejercicios con los datos desde la base de datos
        List<Exercicis> listaEjercicios = da.getInfoExercise();
        if (listaEjercicios == null || listaEjercicios.isEmpty()) {
        listExercicisAssignedWorkouts(listaEjercicios);
        }
    }

    public void updateTableExercicis(List<Exercicis> exercici) {
        listExercise = exercici;
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Name Exercise", "Description"});
        for (Exercicis exercicis : exercici) {
            model.addRow(new Object[]{Integer.valueOf(exercicis.getId()), exercicis.getNomExercici(), exercicis.getDescripcio()});
        }
        jTableExercicis.setModel(model);
        jTableExercicis.getColumnModel().getColumn(0).setMinWidth(0);
        jTableExercicis.getColumnModel().getColumn(0).setMaxWidth(0);
    }

    private void jButtonShowExerciseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShowExerciseActionPerformed
        // Obtener los ejercicios de la base de datos
        List<Exercicis> exercicisList = da.getInfoExercise();
        // Actualizar la tabla con los ejercicios obtenidos
        updateTableExercicis(exercicisList);
    }//GEN-LAST:event_jButtonShowExerciseActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        if (usuarioSeleccionado == null || usuarioSeleccionado.getId() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a valid user or workout first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DialogExercise exercicis = new DialogExercise(mainFra, true);
        exercicis.setVisible(true);
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jTableExercicisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableExercicisMouseClicked
        // Obtiene la fila seleccionada
        int selectedRow = jTableExercicis.getSelectedRow();

        // Verifica que haya una fila seleccionada
        if (selectedRow != -1) {
            try {
                // Obtiene el objeto Exercicis de la lista basado en la fila seleccionada
                Exercicis selectedExercici = listExercise.get(selectedRow);

                jButtonModificar.setEnabled(true);  
                int id = selectedExercici.getId();  
                jButtonModificar.setActionCommand(String.valueOf(id));  // Establecer el ID en el comando del botón

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: Could not retrieve the exercise information.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an exercise to edit.", "Selection Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jTableExercicisMouseClicked

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        // Verifica si listExercise está inicializada y no es vacía
        if (listExercise == null) {
            listExercise = new ArrayList<>();
        }

        // Obtiene la fila seleccionada de la tabla
        int select = jTableExercicis.getSelectedRow();
        if (select == -1) {
            JOptionPane.showMessageDialog(this, "Error: Could not retrieve the exercise ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Asegura que la selección esté dentro de los límites de la lista
        if (select >= 0 && select < listExercise.size()) {
            Exercicis selectExercici = listExercise.get(select);

            // Crear y mostrar el cuadro de diálogo de modificación
            DialogModificarExercise modificarDialog = new DialogModificarExercise(mainFra, true, selectExercici);
            modificarDialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid exercise selection.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("listExercise is null: " + (listExercise == null));
        System.out.println("listExercise size: " + (listExercise != null ? listExercise.size() : 0));
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        int selectedRow = jTableExercicis.getSelectedRow();
        if (selectedRow != -1) {
            try {
                // Obtener el ID del ejercicio (por ejemplo, en la primera columna)
                int id = (int) jTableExercicis.getValueAt(selectedRow, 0);

                // Confirmar la eliminación
                int confirm = JOptionPane.showConfirmDialog(this,
                        "¿Are you sure you want to delete this exercise?",
                        "Confirm deletion",
                        JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    // Llamar al método para eliminar el ejercicio
                    da.getDeleteEjercicio(id);

                    // Actualizar la tabla después de eliminar
                    updateTableExercicis(da.getInfoExercise());

                    // Mensaje de éxito
                    JOptionPane.showMessageDialog(this, "Exercise deleted successfully.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error while trying to delete the exercise.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an exercise to delete.");
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonAddExerciseToWorkoutsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddExerciseToWorkoutsActionPerformed
        // Obtener el w seleccionado
        int selectedRow = jTableWorkouts.getSelectedRow();
        if (selectedRow != -1) {
            // Obtener el ID del w (suponemos que el ID está en la primera columna)
            int workoutId = (int) jTableWorkouts.getValueAt(selectedRow, 0);  // O el índice correcto para el ID

            // Obtener los ejercicios seleccionados
            int[] selectedRowsExercicis = jTableExercicis.getSelectedRows();  // Obtener filas seleccionadas en la tabla de ejercicios
            ArrayList<Exercicis> selectedExercicis = new ArrayList<>();

            for (int rowIndex : selectedRowsExercicis) {
                // Obtener el valor de la celda de ID en la columna oculta (suponiendo que el ID está en la columna 0)
                Object exerciciIdValue = jTableExercicis.getValueAt(rowIndex, 0);  // ID de la columna oculta

                int exerciciId;
                if (exerciciIdValue instanceof Integer) {
                    exerciciId = (Integer) exerciciIdValue;  // Si es Integer, lo usamos directamente
                } else {
                    throw new IllegalArgumentException(".");
                }

                // Crear un objeto Exercicis con el ID obtenido
                Exercicis exercici = new Exercicis();
                exercici.setId(exerciciId);  // Asignamos el ID
                selectedExercicis.add(exercici);
            }

            // Para cada ejercicio seleccionado, crear la relación en la base de datos
            for (Exercicis exercici : selectedExercicis) {
                ExercicisWorKouts workoutExercici = new ExercicisWorKouts();
                workoutExercici.setIdWorkouts(workoutId);
                workoutExercici.setIdExercici(exercici.getId());

                // Guardar la relación en la base de datos
                da.insertarRelaciones(workoutExercici);
            }

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, "Exercise(s) added to the workout successfully");

            // Actualizar la tabla de workouts para reflejar los cambios
            inicializarTablaWorkouts();  // Asumiendo que tienes esta lista de workouts

            // Actualizar la lista de ejercicios asignados al w
            List<Exercicis> exercicis = da.getExercicisForWorkout(workoutId);
            listExercicisAssignedWorkouts(exercicis);  // Asegúrate de que este método actualiza correctamente la UI
        } else {
            JOptionPane.showMessageDialog(this, "Please select a workout.");
        }
    }//GEN-LAST:event_jButtonAddExerciseToWorkoutsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private mosqueira.componentecalendar.ComponenteCalendar componenteCalendar1;
    private javax.swing.JButton jButtonAddExerciseToWorkouts;
    private javax.swing.JButton jButtonAddWorkouts;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonShowExercise;
    private javax.swing.JComboBox<String> jComboBoxListUsers;
    private javax.swing.JList<String> jListExercise;
    private javax.swing.JLabel jLogo;
    private javax.swing.JPanel jPanelAssignedExercicis;
    private javax.swing.JPanel jPanelCalendar;
    private javax.swing.JPanel jPanelExercicis;
    private javax.swing.JPanel jPanelListUsers;
    private javax.swing.JPanel jPanelWorkoutsTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableExercicis;
    private javax.swing.JTable jTableWorkouts;
    // End of variables declaration//GEN-END:variables
}
