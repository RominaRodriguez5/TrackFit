package mosqueira.trackfit.views;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import mosqueira.componentecalendar.TrainingData;
import mosqueira.trackfit.Main;
import mosqueira.trackfit.dataAccess.DataAccess;
import mosqueira.trackfit.dto.*;
import net.miginfocom.swing.MigLayout;

/**
 * PanelUsuariosAsignados representa un panel dentro de la aplicación TrackFit
 * donde un instructor puede gestionar los usuarios asignados a él, incluyendo
 * la visualización y asignación de entrenamientos y ejercicios.
 * @author Romina Mosqueira
 */
public class PanelUsuariosAsignados extends javax.swing.JPanel {

    private final Main mainFra;
    private final Usuaris instructor;
    private Usuaris usuarioSeleccionado;
    private final DataAccess da = new DataAccess();
    private List<Usuaris> listUsers;
    private List<Exercicis> listExercise;

    /**
     * Constructor de la clase PanelUsuariosAsignados.
     *
     * @param jFrameMain Referencia al marco principal de la aplicación.
     * @param instructor Instructor que gestiona los usuarios asignados.
     * @param isDarkMode Indica si el modo oscuro está habilitado.
     */
    public PanelUsuariosAsignados(Main jFrameMain, Usuaris instructor, boolean isDarkMode) {
        this.instructor = instructor;
        this.mainFra = jFrameMain;
        initializeComponents();
        initializeListeners();
        applyDarkMode(jFrameMain.isDarkModeEnabled());
    }

    /**
     * Inicializa todos los componentes de la interfaz gráfica.
     */
    private void initializeComponents() {
        initComponents();
        PanelPrincipal();
        assignedUsers();
        inicializarTablaWorkouts();
        inicializarTablaListaExercicis();
        asignarIconosABotones();
    }

    /**
     * Inicializa los listeners de eventos.
     */
    private void initializeListeners() {
        componenteCalendar1.addTrainingEventListener((List<TrainingData> trainings) -> {
            if (trainings.isEmpty()) {
                JOptionPane.showMessageDialog(jPanelCalendar, "No workouts available.", "Information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Crear un StringBuilder para almacenar la información de los entrenamientos
            StringBuilder trainingInfo = new StringBuilder();

            for (TrainingData training : trainings) {
                trainingInfo.append("Usuario: ").append(training.getUserName()).append("\n")
                        .append("Comentarios: ").append(training.getComment()).append("\n")
                        .append("Número de Ejercicios: ").append(training.getNumberOfExercises()).append("\n")
                        .append("Workouts ID: ").append(training.getWorkoutId()).append("\n")
                        .append("-------------------------------------------------\n");
            }

            // Crear un JTextArea para mostrar la información
            JTextArea textArea = new JTextArea(trainingInfo.toString());
            textArea.setEditable(false); // Hacer que el texto no sea editable
            textArea.setWrapStyleWord(true);
            textArea.setLineWrap(true);
            textArea.setFont(new Font("Arial", Font.PLAIN, 14)); // Ajustar la fuente
            textArea.setMargin(new Insets(5, 5, 5, 5));

            // Agregar el JTextArea a un JScrollPane para manejar contenido largo
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(200, 200));

            // Mostrar en un JOptionPane
            JOptionPane.showMessageDialog(jPanelCalendar, scrollPane, "Workout Details", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    /**
     * Configura y organiza los paneles principales dentro de la interfaz.
     */
    private void PanelPrincipal() {
        setLayout(new MigLayout("wrap 1, fill", "[grow]", "[grow][grow]"));
        setupSesionInstructorPanel();
        JPanel panelInferior = createInferiorPanel();
        add(jSesionInstructor, "growx, pushx, wrap");
        add(panelInferior, "grow, push");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                revalidate();
                repaint();
            }
        });
    }

    /**
     * Configura el panel de sesión del instructor con la tabla de workouts y
     * lista de ejercicios.
     */
    private void setupSesionInstructorPanel() {
        jSesionInstructor.setLayout(new MigLayout("fill", "[grow 50][grow 50]", "[][grow]"));
        jSesionInstructor.add(userComboBox, "span 2, growx, wrap");
        Box buttonBox = createButtonBox();
        jSesionInstructor.add(buttonBox, "span 2, wrap");
        jSesionInstructor.add(jScrollWorkoutsTable, "grow, push");
        jSesionInstructor.add(jScrollExerciseList, "grow, push");
    }

    /**
     * Crea un contenedor con botones de acciones principales.
     *
     * @return Un objeto Box con botones alineados horizontalmente.
     */
    private Box createButtonBox() {
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(addWorkoutsButton);
        buttonBox.add(Box.createHorizontalStrut(30));
        buttonBox.add(addExerciseToWorkoutButton);
        return buttonBox;
    }

    /**
     * Crea un panel inferior que contiene los ejercicios y calendario.
     *
     * @return Un JPanel que contiene el calendario y la lista de ejercicios.
     */
    private JPanel createInferiorPanel() {
        JPanel panelInferior = new JPanel(new MigLayout("fill", "[grow][grow]", "[grow]"));
        panelInferior.add(createEjerciciosPanel(), "grow, push");
        panelInferior.add(jPanelCalendar, "grow, push");
        return panelInferior;
    }

    /**
     * Crea el panel de ejercicios con los botones de acción.
     *
     * @return Un JPanel que contiene los botones y la tabla de ejercicios.
     */
    private JPanel createEjerciciosPanel() {
        jPanelExercicis.setLayout(new MigLayout("fill", "[grow]", "[][][grow]"));
        jPanelExercicis.add(createButtonBox2(), "wrap");
        jPanelExercicis.add(jScrollTableExercise, "span, grow, push");
        return jPanelExercicis;
    }

    /**
     * Crea un contenedor con botones de acciones principales.
     *
     * @return Un objeto Box con botones alineados horizontalmente.
     */
    private Box createButtonBox2() {
        Box buttonBox2 = Box.createHorizontalBox();
        buttonBox2.add(showExerciseButton);
        buttonBox2.add(Box.createHorizontalStrut(30));
        buttonBox2.add(addExerciseButton);
        buttonBox2.add(Box.createHorizontalStrut(30));
        buttonBox2.add(deleteExerciseButton);
        buttonBox2.add(Box.createHorizontalStrut(30));
        buttonBox2.add(editExerciseButton);
        return buttonBox2;
    }

    /**
     * Asigna iconos a los botones de la interfaz.
     */
    private void asignarIconosABotones() {
        addWorkoutsButton.setIcon(ThemeManager.resizeIcon("/images/path_to_icon.png", 60, 60));
        showExerciseButton.setIcon(ThemeManager.resizeIcon("/images/show_exercise_icon.png", 60, 60));
        addExerciseButton.setIcon(ThemeManager.resizeIcon("/images/add_exercise_icon.png", 60, 60));
        editExerciseButton.setIcon(ThemeManager.resizeIcon("/images/edit_exercise_icon.png", 60, 60));
        deleteExerciseButton.setIcon(ThemeManager.resizeIcon("/images/delete_exercise_icon.png", 60, 60));
        addExerciseToWorkoutButton.setIcon(ThemeManager.resizeIcon("/images/add_exercise_to_workout_icon.png", 60, 60));
    }

    /**
     * Aplica el modo oscuro o claro según la preferencia del usuario.
     *
     * @param isDarkMode Indica si el modo oscuro debe activarse.
     */
    public void applyDarkMode(boolean isDarkMode) {
        if (isDarkMode) {
            applyDarkModeStyles();
        } else {
            applyLightModeStyles();
        }
        revalidate();
        repaint();
    }

    /**
     * Aplica los estilos del modo oscuro a todos los componentes de la
     * interfaz.
     */
    private void applyDarkModeStyles() {
        ThemeManager.applyDarkMode(this, jPanelCalendar, jSesionInstructor, jPanelExercicis);
        ThemeManager.applyDarkModeToComponents(addWorkoutsButton, addExerciseToWorkoutButton,
                addExerciseButton, deleteExerciseButton, editExerciseButton, showExerciseButton,
                jScrollExerciseList, jScrollWorkoutsTable, jScrollTableExercise, userComboBox);

        ThemeManager.applyDarkModeToTablesAndLists(
                new JTable[]{workoutsTable, exercisesTable},
                new JList<?>[]{exerciseList}
        );
    }

    /**
     * Aplica los estilos del modo claro a todos los componentes de la interfaz.
     */
    private void applyLightModeStyles() {
        ThemeManager.applyLightMode(this, jPanelCalendar, jSesionInstructor, jPanelExercicis);
        ThemeManager.applyLightModeToComponents(addWorkoutsButton, addExerciseToWorkoutButton,
                addExerciseButton, deleteExerciseButton, editExerciseButton, showExerciseButton,
                jScrollExerciseList, jScrollWorkoutsTable, jScrollTableExercise, userComboBox);
        ThemeManager.applyDarkModeToTablesAndLists(
                new JTable[]{workoutsTable, exercisesTable},
                new JList<?>[]{exerciseList}
        );
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
        jPanelExercicis = new javax.swing.JPanel();
        showExerciseButton = new javax.swing.JButton();
        jScrollTableExercise = new javax.swing.JScrollPane();
        exercisesTable = new javax.swing.JTable();
        addExerciseButton = new javax.swing.JButton();
        deleteExerciseButton = new javax.swing.JButton();
        editExerciseButton = new javax.swing.JButton();
        jPanelCalendar = new javax.swing.JPanel();
        componenteCalendar1 = new mosqueira.componentecalendar.ComponenteCalendar();

        setBackground(new java.awt.Color(204, 204, 204));
        setForeground(new java.awt.Color(204, 204, 204));
        setMinimumSize(new java.awt.Dimension(900, 900));
        setPreferredSize(new java.awt.Dimension(1200, 900));

        jSesionInstructor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Users assigned to the Instructor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jSesionInstructor.setForeground(new java.awt.Color(30, 58, 95));
        jSesionInstructor.setPreferredSize(new java.awt.Dimension(400, 400));

        userComboBox.setBackground(new java.awt.Color(153, 153, 153));
        userComboBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        userComboBox.setForeground(new java.awt.Color(0, 0, 0));
        userComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        userComboBox.setActionCommand("");
        userComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userComboBoxActionPerformed(evt);
            }
        });

        workoutsTable.setBackground(new java.awt.Color(153, 153, 153));
        workoutsTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
        workoutsTable.setAlignmentX(1.5F);
        workoutsTable.setAlignmentY(1.5F);
        workoutsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        workoutsTable.setSelectionForeground(new java.awt.Color(255, 255, 204));
        workoutsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        workoutsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                workoutsTableMouseClicked(evt);
            }
        });
        jScrollWorkoutsTable.setViewportView(workoutsTable);

        addWorkoutsButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        addExerciseToWorkoutButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        exerciseList.setBackground(new java.awt.Color(153, 153, 153));
        exerciseList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exerciseList.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        exerciseList.setForeground(new java.awt.Color(30, 58, 95));
        jScrollExerciseList.setViewportView(exerciseList);

        javax.swing.GroupLayout jSesionInstructorLayout = new javax.swing.GroupLayout(jSesionInstructor);
        jSesionInstructor.setLayout(jSesionInstructorLayout);
        jSesionInstructorLayout.setHorizontalGroup(
            jSesionInstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jSesionInstructorLayout.createSequentialGroup()
                .addComponent(userComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addGroup(jSesionInstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jSesionInstructorLayout.createSequentialGroup()
                        .addComponent(addWorkoutsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addExerciseToWorkoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollWorkoutsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(176, 176, 176)
                .addComponent(jScrollExerciseList, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jSesionInstructorLayout.setVerticalGroup(
            jSesionInstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jSesionInstructorLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jSesionInstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jSesionInstructorLayout.createSequentialGroup()
                        .addComponent(jScrollWorkoutsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jSesionInstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addWorkoutsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addExerciseToWorkoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollExerciseList, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jPanelExercicis.setBackground(new java.awt.Color(204, 204, 204));
        jPanelExercicis.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Exercise", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24), new java.awt.Color(30, 58, 95))); // NOI18N
        jPanelExercicis.setForeground(new java.awt.Color(30, 58, 95));
        jPanelExercicis.setPreferredSize(new java.awt.Dimension(500, 355));

        showExerciseButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
        exercisesTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
        exercisesTable.setMinimumSize(new java.awt.Dimension(0, 0));
        exercisesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exercisesTableMouseClicked(evt);
            }
        });
        jScrollTableExercise.setViewportView(exercisesTable);

        addExerciseButton.setBackground(new java.awt.Color(255, 255, 255));
        addExerciseButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
        deleteExerciseButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
        editExerciseButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
                .addGap(8, 8, 8)
                .addComponent(showExerciseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(addExerciseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(deleteExerciseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(editExerciseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelExercicisLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jScrollTableExercise, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanelExercicisLayout.setVerticalGroup(
            jPanelExercicisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExercicisLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollTableExercise, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelExercicisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addExerciseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelExercicisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(deleteExerciseButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                        .addComponent(editExerciseButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(showExerciseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelCalendar.setBackground(new java.awt.Color(204, 204, 204));
        jPanelCalendar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Calendar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24), new java.awt.Color(30, 58, 95))); // NOI18N
        jPanelCalendar.setForeground(new java.awt.Color(30, 58, 95));
        jPanelCalendar.setName(""); // NOI18N
        jPanelCalendar.setPreferredSize(new java.awt.Dimension(600, 350));

        componenteCalendar1.setBackground(new java.awt.Color(102, 102, 102));
        componenteCalendar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 95)));
        componenteCalendar1.setForeground(new java.awt.Color(30, 58, 95));
        componenteCalendar1.setActiveButtonColor(new java.awt.Color(102, 204, 255));
        componenteCalendar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanelCalendarLayout = new javax.swing.GroupLayout(jPanelCalendar);
        jPanelCalendar.setLayout(jPanelCalendarLayout);
        jPanelCalendarLayout.setHorizontalGroup(
            jPanelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalendarLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(componenteCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanelCalendarLayout.setVerticalGroup(
            jPanelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalendarLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(componenteCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelExercicis, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanelCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSesionInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, 1226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSesionInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelCalendar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelExercicis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelCalendar.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Carga los usuarios asignados a un instructor y los muestra en un combo
     * box. Luego, actualiza la tabla de ejercicios con una lista vacía.
     */
    private void assignedUsers() {
        List<Usuaris> assignedUsers = da.getAllUsersInstructor(instructor);
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        listUsers = assignedUsers;
        for (Usuaris user : assignedUsers) {
            comboBoxModel.addElement(user.getNom());
        }
        userComboBox.setModel(comboBoxModel);
        updateTableExercicis(new ArrayList<>());
    }

    /**
     * Evento que se ejecuta cuando el usuario selecciona un elemento del combo
     * box. Se obtiene el usuario seleccionado y se actualiza la tabla de
     * workouts.
     */

    private void userComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userComboBoxActionPerformed
        String selectedUserName = (String) userComboBox.getSelectedItem();
        if (selectedUserName != null && !selectedUserName.isEmpty()) {
            for (Usuaris usuario : listUsers) {
                if (usuario.getNom().equals(selectedUserName)) {
                    usuarioSeleccionado = usuario;
                    int userId = usuario.getId();
                    updateTableWorkouts(userId);
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
                Object idValue = workoutsTable.getValueAt(selectedRow, 0);
                int workoutId = (idValue instanceof Integer) ? (Integer) idValue : Integer.parseInt(idValue.toString());
                List<Exercicis> exercicis = da.getExercicisForWorkout(workoutId);
                listExercicisAssignedWorkouts(exercicis);
                exerciseList.setVisible(!exercicis.isEmpty());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error: The workout select is not a valid.");
            }
        }

    }//GEN-LAST:event_workoutsTableMouseClicked
    /**
     * Muestra los ejercicios asignados a un workout en una lista.
     */
    private void addWorkoutsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWorkoutsButtonActionPerformed
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

    /**
     * Actualiza la tabla de entrenamientos con los datos del usuario
     * seleccionado.
     *
     * @param userId El ID del usuario cuyos entrenamientos se desean mostrar.
     */
    private void updateTableWorkouts(int userId) {
        DefaultTableModel dtm = (DefaultTableModel) workoutsTable.getModel();
        dtm.setRowCount(0);

        ArrayList<Workouts> workouts = da.getWorkoutsForUser(userId);

        for (Workouts workout : workouts) {
            dtm.addRow(new Object[]{workout.getId(), workout.getForDate(), workout.getComments()});

        }
    }

    /**
     * Inicializa la tabla de ejercicios con los datos obtenidos desde la base
     * de datos.
     */
    private void inicializarTablaListaExercicis() {
        // Inicializa la tabla de ejercicios con los datos desde la base de datos
        List<Exercicis> listaEjercicios = da.getInfoExercise();
        if (listaEjercicios == null || listaEjercicios.isEmpty()) {
            listExercicisAssignedWorkouts(listaEjercicios);
        }
    }

    /**
     * Actualiza la tabla de ejercicios con una lista de ejercicios
     * proporcionada.
     *
     * @param exercici Lista de ejercicios a mostrar en la tabla.
     */
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

    /**
     * Evento que se ejecuta cuando se hace clic en el botón para mostrar los
     * ejercicios. Obtiene una lista de todos los ejercicios desde la base de
     * datos y actualiza la tabla de ejercicios.
     *
     * @param evt El evento de acción que se genera al hacer clic en el botón.
     */
    private void showExerciseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showExerciseButtonActionPerformed
        List<Exercicis> exercicisList = da.getInfoExercise();
        // Actualizar la tabla con los ejercicios obtenidos
        updateTableExercicis(exercicisList);
    }//GEN-LAST:event_showExerciseButtonActionPerformed

    /**
     * Evento que se ejecuta cuando se hace clic en el botón para agregar un
     * ejercicio. Verifica si hay un usuario válido seleccionado, de lo
     * contrario, muestra un mensaje de error. Luego, abre el cuadro de diálogo
     * para agregar un nuevo ejercicio.
     *
     * @param evt El evento de acción que se genera al hacer clic en el botón.
     */
    private void addExerciseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExerciseButtonActionPerformed
        if (usuarioSeleccionado == null || usuarioSeleccionado.getId() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a valid user or workout first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DialogExercise exercicis = new DialogExercise(mainFra, true);
        exercicis.setVisible(true);
    }//GEN-LAST:event_addExerciseButtonActionPerformed
    /**
     * Evento que se ejecuta cuando se hace clic en la tabla de ejercicios.
     * Permite seleccionar un ejercicio de la tabla y habilita el botón de
     * edición. Además, establece el ID del ejercicio seleccionado en el comando
     * del botón de edición.
     *
     * @param evt El evento de acción que se genera al hacer clic en una fila de
     * la tabla.
     */
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
    /**
     * Evento que se ejecuta cuando se hace clic en el botón para editar un
     * ejercicio. Obtiene el ejercicio seleccionado de la tabla y abre el cuadro
     * de diálogo para modificarlo. Si no hay un ejercicio seleccionado o hay un
     * error, se muestra un mensaje de error.
     *
     * @param evt El evento de acción que se genera al hacer clic en el botón de
     * editar.
     */
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
    /**
     * Evento que se ejecuta cuando se hace clic en el botón para eliminar un
     * ejercicio. Elimina el ejercicio seleccionado de la base de datos y
     * actualiza la tabla para reflejar los cambios. Si no hay ejercicio
     * seleccionado o ocurre un error, muestra un mensaje de advertencia o
     * error.
     *
     * @param evt El evento de acción que se genera al hacer clic en el botón de
     * eliminar.
     */
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
    /**
     * Evento que se ejecuta cuando se hace clic en el botón para agregar
     * ejercicios a un entrenamiento. Permite seleccionar un entrenamiento de la
     * tabla y agregar los ejercicios seleccionados a ese entrenamiento.
     *
     * @param evt El evento de acción que se genera al hacer clic en el botón de
     * agregar ejercicios.
     */
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
