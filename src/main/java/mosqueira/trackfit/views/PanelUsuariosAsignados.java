package mosqueira.trackfit.views;
import java.awt.Dimension;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import mosqueira.componentecalendar.TrainingData;
import mosqueira.trackfit.Main;
import mosqueira.trackfit.dataAccess.DataAccess;
import mosqueira.trackfit.dto.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Lulas
 */
public class PanelUsuariosAsignados extends javax.swing.JPanel {
    private final Main mainFra;
    private final Usuaris instructor;
    private Usuaris usuarioSeleccionado;
    private final DataAccess da = new DataAccess();
    private List<Usuaris> listUsers;
    private List<Exercicis> listExercise;
    

    /**
     * Creates new form ListPanel
     *
     * @param jFrameMain
     * @param instructor
     * @param isDarkMode
     */
    public PanelUsuariosAsignados(Main jFrameMain, Usuaris instructor, boolean isDarkMode) {
        this.instructor = instructor;
        this.mainFra = jFrameMain;
       setPreferredSize(new Dimension(200, 200));
        initializeComponents();
        initializeListeners();
        applyDarkMode(isDarkMode);

    }
     private void PanelPrincipal() {
        setLayout(new MigLayout("wrap 1, fill", "[grow]", "[grow][grow]") );
        // Panel superior con sesión del instructor y calendario
        jSesionInstructor = new JPanel(new MigLayout("fill", "[grow 80][grow 20]", "[grow]"));
     
        // Panel contenedor para ejercicios y calendario
        JPanel panelInferior = new JPanel(new MigLayout("fill", "[grow ][grow ]", "[grow]"));
        panelInferior.add(jPanelExercicis, "grow");
        panelInferior.add(jPanelCalendar, "grow");

        add(panelInferior, "grow");
    }

    private void initializeComponents() {
        initComponents();
        PanelPrincipal();
        assignedUsers();
        inicializarTablaWorkouts();
        inicializarTablaListaExercicis();
        asignarIconosABotones();
    }

    private void initializeListeners() {
        componenteCalendar1.addTrainingEventListener((List<TrainingData> trainings) -> {
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (TrainingData training : trainings) {
                listModel.addElement(training.toString());
            }
            JOptionPane.showMessageDialog(jPanelCalendar, listModel);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSesionInstructor = new javax.swing.JPanel();
        userComboBox = new javax.swing.JComboBox<>();
        jScrollWorkoutsTable = new javax.swing.JScrollPane();
        workoutsTable = new javax.swing.JTable();
        addWorkoutsButton = new javax.swing.JButton();
        addExerciseToWorkoutButton = new javax.swing.JButton();
        jScrollExerciseList = new javax.swing.JScrollPane();
        exerciseList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jPanelCalendar = new javax.swing.JPanel();
        componenteCalendar1 = new mosqueira.componentecalendar.ComponenteCalendar();
        jPanelExercicis = new javax.swing.JPanel();
        showExerciseButton = new javax.swing.JButton();
        jScrollTableExercise = new javax.swing.JScrollPane();
        exercisesTable = new javax.swing.JTable();
        addExerciseButton = new javax.swing.JButton();
        deleteExerciseButton = new javax.swing.JButton();
        editExerciseButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(249, 249, 231));

        jSesionInstructor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sesion Instructor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SimSun", 0, 36), new java.awt.Color(0, 0, 0))); // NOI18N
        jSesionInstructor.setForeground(new java.awt.Color(51, 51, 51));
        jSesionInstructor.setPreferredSize(new java.awt.Dimension(1254, 800));

        userComboBox.setBackground(new java.awt.Color(153, 153, 153));
        userComboBox.setForeground(new java.awt.Color(0, 0, 0));
        userComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        userComboBox.setActionCommand("");
        userComboBox.setPreferredSize(null);
        userComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userComboBoxActionPerformed(evt);
            }
        });

        workoutsTable.setBackground(new java.awt.Color(153, 153, 153));
        workoutsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        workoutsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        workoutsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        workoutsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                workoutsTableMouseClicked(evt);
            }
        });
        jScrollWorkoutsTable.setViewportView(workoutsTable);

        addWorkoutsButton.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        addWorkoutsButton.setToolTipText("New Workouts");
        addWorkoutsButton.setBorder(null);
        addWorkoutsButton.setContentAreaFilled(false);
        addWorkoutsButton.setPreferredSize(new java.awt.Dimension(30, 30));
        addWorkoutsButton.setRequestFocusEnabled(false);
        addWorkoutsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWorkoutsButtonActionPerformed(evt);
            }
        });

        addExerciseToWorkoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_exercise_to_workout_icon.png"))); // NOI18N
        addExerciseToWorkoutButton.setToolTipText("Add Exercise  to  Workouts");
        addExerciseToWorkoutButton.setBorder(null);
        addExerciseToWorkoutButton.setBorderPainted(false);
        addExerciseToWorkoutButton.setContentAreaFilled(false);
        addExerciseToWorkoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExerciseToWorkoutButtonActionPerformed(evt);
            }
        });

        exerciseList.setBackground(new java.awt.Color(249, 249, 231));
        exerciseList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exerciseList.setForeground(new java.awt.Color(0, 0, 0));
        exerciseList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Exercise List" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollExerciseList.setViewportView(exerciseList);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        jLabel1.setText("List Exercise");

        javax.swing.GroupLayout jSesionInstructorLayout = new javax.swing.GroupLayout(jSesionInstructor);
        jSesionInstructor.setLayout(jSesionInstructorLayout);
        jSesionInstructorLayout.setHorizontalGroup(
            jSesionInstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jSesionInstructorLayout.createSequentialGroup()
                .addGroup(jSesionInstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jSesionInstructorLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(addWorkoutsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(362, 362, 362)
                        .addComponent(addExerciseToWorkoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jSesionInstructorLayout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(userComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jSesionInstructorLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollWorkoutsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addGroup(jSesionInstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollExerciseList, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102))
        );
        jSesionInstructorLayout.setVerticalGroup(
            jSesionInstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jSesionInstructorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jSesionInstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jSesionInstructorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollWorkoutsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jSesionInstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addExerciseToWorkoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addWorkoutsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jSesionInstructorLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollExerciseList, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelCalendar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Calendar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SimSun", 0, 24), new java.awt.Color(0, 0, 0))); // NOI18N

        componenteCalendar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 153)));
        componenteCalendar1.setActiveButtonColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanelCalendarLayout = new javax.swing.GroupLayout(jPanelCalendar);
        jPanelCalendar.setLayout(jPanelCalendarLayout);
        jPanelCalendarLayout.setHorizontalGroup(
            jPanelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCalendarLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(componenteCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanelCalendarLayout.setVerticalGroup(
            jPanelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalendarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(componenteCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanelExercicis.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Exercise", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SimSun", 0, 24), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanelExercicis.setForeground(new java.awt.Color(0, 0, 0));

        showExerciseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/show_exercise_icon.png"))); // NOI18N
        showExerciseButton.setToolTipText("Show Exercise");
        showExerciseButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 51))));
        showExerciseButton.setBorderPainted(false);
        showExerciseButton.setContentAreaFilled(false);
        showExerciseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showExerciseButtonActionPerformed(evt);
            }
        });

        exercisesTable.setBackground(new java.awt.Color(153, 153, 153));
        exercisesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        exercisesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exercisesTableMouseClicked(evt);
            }
        });
        jScrollTableExercise.setViewportView(exercisesTable);

        addExerciseButton.setBackground(new java.awt.Color(255, 255, 255));
        addExerciseButton.setForeground(new java.awt.Color(0, 0, 0));
        addExerciseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_exercise_icon.png"))); // NOI18N
        addExerciseButton.setToolTipText("Add New Exercise");
        addExerciseButton.setBorder(null);
        addExerciseButton.setBorderPainted(false);
        addExerciseButton.setContentAreaFilled(false);
        addExerciseButton.setPreferredSize(new java.awt.Dimension(50, 50));
        addExerciseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExerciseButtonActionPerformed(evt);
            }
        });

        deleteExerciseButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteExerciseButton.setForeground(new java.awt.Color(0, 0, 0));
        deleteExerciseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_exercise_icon.png"))); // NOI18N
        deleteExerciseButton.setToolTipText("Delete");
        deleteExerciseButton.setBorder(null);
        deleteExerciseButton.setBorderPainted(false);
        deleteExerciseButton.setContentAreaFilled(false);
        deleteExerciseButton.setPreferredSize(new java.awt.Dimension(50, 50));
        deleteExerciseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteExerciseButtonActionPerformed(evt);
            }
        });

        editExerciseButton.setBackground(new java.awt.Color(255, 255, 255));
        editExerciseButton.setForeground(new java.awt.Color(0, 0, 0));
        editExerciseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_exercise_icon.png"))); // NOI18N
        editExerciseButton.setToolTipText("Modify");
        editExerciseButton.setBorder(null);
        editExerciseButton.setBorderPainted(false);
        editExerciseButton.setContentAreaFilled(false);
        editExerciseButton.setPreferredSize(new java.awt.Dimension(50, 50));
        editExerciseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editExerciseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelExercicisLayout = new javax.swing.GroupLayout(jPanelExercicis);
        jPanelExercicis.setLayout(jPanelExercicisLayout);
        jPanelExercicisLayout.setHorizontalGroup(
            jPanelExercicisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExercicisLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelExercicisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelExercicisLayout.createSequentialGroup()
                        .addComponent(showExerciseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(addExerciseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(deleteExerciseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(editExerciseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollTableExercise, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanelExercicisLayout.setVerticalGroup(
            jPanelExercicisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExercicisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollTableExercise, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelExercicisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteExerciseButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(editExerciseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(showExerciseButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(addExerciseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSesionInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, 1289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelExercicis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jSesionInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelExercicis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método para redimensionar imágenes y usarlas como iconos en los botones.
     *
     * @param path Ruta del archivo de imagen en el proyecto (ubicado en
     * /resources).
     * @param width Ancho deseado del icono.
     * @param height Alto deseado del icono.
     * @return ImageIcon redimensionado.
     */

    /**
     * Asigna iconos redimensionados a los botones de la interfaz.
     */
    private void asignarIconosABotones() {
        addWorkoutsButton.setIcon(ThemeManager.resizeIcon("/images/path_to_icon.png", 50, 50));
        showExerciseButton.setIcon(ThemeManager.resizeIcon("/images/show_exercise_icon.png", 30, 30));
        addExerciseButton.setIcon(ThemeManager.resizeIcon("/images/add_exercise_icon.png", 30, 30));
        editExerciseButton.setIcon(ThemeManager.resizeIcon("/images/edit_exercise_icon.png", 30, 30));
        deleteExerciseButton.setIcon(ThemeManager.resizeIcon("/images/delete_exercise_icon.png", 30, 30));
        addExerciseToWorkoutButton.setIcon(ThemeManager.resizeIcon("/images/add_exercise_to_workout_icon.png", 50, 50));
    }

    /**
     * Aplica el modo oscuro o claro a la interfaz y sus componentes.
     *
     * @param isDarkMode Indica si se debe activar el modo oscuro (true) o claro
     * (false).
     */
public void applyDarkMode(boolean isDarkMode) {
    if (isDarkMode) {
        // Paneles
        ThemeManager.applyDarkMode(this, jPanelCalendar,jSesionInstructor, jPanelExercicis);

        // Tablas y listas
        ThemeManager.applyDarkModeToTables(workoutsTable, exercisesTable);
        ThemeManager.applyDarkModeToLists(exerciseList);

        // Otros componentes
        ThemeManager.applyDarkModeToComponents(addWorkoutsButton, addExerciseToWorkoutButton,
            addExerciseButton, deleteExerciseButton, editExerciseButton, showExerciseButton,
            jScrollExerciseList, jScrollWorkoutsTable, jScrollTableExercise, userComboBox);
    } else {
        ThemeManager.applyLightMode(this, jPanelCalendar,jSesionInstructor, jPanelExercicis);

        ThemeManager.applyLightModeToTables(workoutsTable, exercisesTable);
        ThemeManager.applyLightModeToLists(exerciseList);

        ThemeManager.applyLightModeToComponents(addWorkoutsButton, addExerciseToWorkoutButton,
            addExerciseButton, deleteExerciseButton, editExerciseButton, showExerciseButton,
            jScrollExerciseList, jScrollWorkoutsTable, jScrollTableExercise, userComboBox);
    }

    revalidate();
    repaint();
}


    /**
     * Carga los usuarios asignados a un instructor y los muestra en un combo
     * box. Luego, actualiza la tabla de ejercicios con una lista vacía.
     */
    private void assignedUsers() {
        List<Usuaris> assignedUsers = da.getAllUsersInstructor(instructor); // Obtiene la lista de usuarios
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        listUsers = assignedUsers; // Guarda la lista globalmente

        // Agrega los nombres de los usuarios al combo box
        for (Usuaris user : assignedUsers) {
            comboBoxModel.addElement(user.getNom());
        }

        userComboBox.setModel(comboBoxModel); // Asigna el modelo al combo box
        updateTableExercicis(new ArrayList<>()); // Limpia la tabla de ejercicios
    }

    /**
     * Evento que se ejecuta cuando el usuario selecciona un elemento del combo
     * box. Se obtiene el usuario seleccionado y se actualiza la tabla de
     * workouts.
     */

    private void userComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userComboBoxActionPerformed
        String selectedUserName = (String) userComboBox.getSelectedItem();
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
    }//GEN-LAST:event_userComboBoxActionPerformed
    /**
     * Evento que se ejecuta cuando el usuario hace clic en una fila de la tabla
     * de workouts. Se obtiene el ID del workout seleccionado y se muestran sus
     * ejercicios.
     */
    private void workoutsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_workoutsTableMouseClicked
        int selectedRow = workoutsTable.getSelectedRow();
        if (selectedRow != -1) {
            try {
                // Obtener el valor de la columna de ID y convertir a Integer
                Object idValue = workoutsTable.getValueAt(selectedRow, 0);
                int workoutId = (idValue instanceof Integer) ? (Integer) idValue : Integer.parseInt(idValue.toString());

                List<Exercicis> exercicis = da.getExercicisForWorkout(workoutId);
                listExercicisAssignedWorkouts(exercicis);
                // Ocultar la lista si no hay ejercicios
                exerciseList.setVisible(!exercicis.isEmpty());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error: Error: The workout select is not a valid.");
            }
        }

    }//GEN-LAST:event_workoutsTableMouseClicked
    /**
     * Muestra los ejercicios asignados a un workout en una lista.
     */
    private void addWorkoutsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWorkoutsButtonActionPerformed
        // Crear una instancia del diálogo con el usuario seleccionado
        DialogWorkouts workouts = new DialogWorkouts(mainFra, true);
        workouts.setVisible(true);
    }//GEN-LAST:event_addWorkoutsButtonActionPerformed
    /**
     * Muestra los ejercicios asignados a un workout en una lista.
     */
    private void listExercicisAssignedWorkouts(List<Exercicis> listExercicis) {
        //MUESTRA LA LISTA del ejercicio que esta ASIGNADO al workout
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Exercicis ex : listExercicis) {
            listModel.addElement(ex.getNomExercici() + " " + ex.getDescripcio());
        }
        exerciseList.setModel(listModel);
        exerciseList.setVisible(true);  // Muestra la lista
        exerciseList.revalidate();
        exerciseList.repaint();
    }

    /**
     * Inicializa la tabla de workouts con las columnas predefinidas.
     */
    private void inicializarTablaWorkouts() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{"Workout", "ForDate", "Comments"});
        workoutsTable.setModel(dtm);
        exerciseList.setVisible(false);
    }

    private void updateTableWorkouts(int userId) {
        DefaultTableModel dtm = (DefaultTableModel) workoutsTable.getModel();
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
            model.addRow(new Object[]{exercicis.getId(), exercicis.getNomExercici(), exercicis.getDescripcio()});
        }
        exercisesTable.setModel(model);
        exercisesTable.getColumnModel().getColumn(0).setMinWidth(0);
        exercisesTable.getColumnModel().getColumn(0).setMaxWidth(0);
    }

    private void showExerciseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showExerciseButtonActionPerformed
        List<Exercicis> exercicisList = da.getInfoExercise();
        // Actualizar la tabla con los ejercicios obtenidos
        updateTableExercicis(exercicisList);
    }//GEN-LAST:event_showExerciseButtonActionPerformed

    private void addExerciseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExerciseButtonActionPerformed
        if (usuarioSeleccionado == null || usuarioSeleccionado.getId() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a valid user or workout first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DialogExercise exercicis = new DialogExercise(mainFra, true);
        exercicis.setVisible(true);
    }//GEN-LAST:event_addExerciseButtonActionPerformed

    private void exercisesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exercisesTableMouseClicked
        // Obtiene la fila seleccionada
        int selectedRow = exercisesTable.getSelectedRow();

        // Verifica que haya una fila seleccionada
        if (selectedRow != -1) {
            try {
                // Obtiene el objeto Exercicis de la lista basado en la fila seleccionada
                Exercicis selectedExercici = listExercise.get(selectedRow);

                editExerciseButton.setEnabled(true);
                int id = selectedExercici.getId();
                editExerciseButton.setActionCommand(String.valueOf(id));  // Establecer el ID en el comando del botón

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: Could not retrieve the exercise information.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an exercise to edit.", "Selection Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_exercisesTableMouseClicked

    private void editExerciseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editExerciseButtonActionPerformed
        // Verifica si listExercise está inicializada y no es vacía
        if (listExercise == null) {
            listExercise = new ArrayList<>();
        }

        // Obtiene la fila seleccionada de la tabla
        int select = exercisesTable.getSelectedRow();
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
    }//GEN-LAST:event_editExerciseButtonActionPerformed

    private void deleteExerciseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteExerciseButtonActionPerformed
        int selectedRow = exercisesTable.getSelectedRow();
        if (selectedRow != -1) {
            try {
                // Obtener el ID del ejercicio (por ejemplo, en la primera columna)
                int id = (int) exercisesTable.getValueAt(selectedRow, 0);

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

    }//GEN-LAST:event_deleteExerciseButtonActionPerformed

    private void addExerciseToWorkoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExerciseToWorkoutButtonActionPerformed
        // Obtener el w seleccionado
        int selectedRow = workoutsTable.getSelectedRow();
        if (selectedRow != -1) {
            // Obtener el ID del w (suponemos que el ID está en la primera columna)
            int workoutId = (int) workoutsTable.getValueAt(selectedRow, 0);  // O el índice correcto para el ID

            // Obtener los ejercicios seleccionados
            int[] selectedRowsExercicis = exercisesTable.getSelectedRows();  // Obtener filas seleccionadas en la tabla de ejercicios
            ArrayList<Exercicis> selectedExercicis = new ArrayList<>();

            for (int rowIndex : selectedRowsExercicis) {
                // Obtener el valor de la celda de ID en la columna oculta (suponiendo que el ID está en la columna 0)
                Object exerciciIdValue = exercisesTable.getValueAt(rowIndex, 0);  // ID de la columna oculta

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

        }
    }//GEN-LAST:event_addExerciseToWorkoutButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addExerciseButton;
    private javax.swing.JButton addExerciseToWorkoutButton;
    private javax.swing.JButton addWorkoutsButton;
    private mosqueira.componentecalendar.ComponenteCalendar componenteCalendar1;
    private javax.swing.JButton deleteExerciseButton;
    private javax.swing.JButton editExerciseButton;
    private javax.swing.JList<String> exerciseList;
    private javax.swing.JTable exercisesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelCalendar;
    private javax.swing.JPanel jPanelExercicis;
    private javax.swing.JScrollPane jScrollExerciseList;
    private javax.swing.JScrollPane jScrollTableExercise;
    private javax.swing.JScrollPane jScrollWorkoutsTable;
    private javax.swing.JPanel jSesionInstructor;
    private javax.swing.JButton showExerciseButton;
    private javax.swing.JComboBox<String> userComboBox;
    private javax.swing.JTable workoutsTable;
    // End of variables declaration//GEN-END:variables
}
