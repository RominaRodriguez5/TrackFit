package mosqueira.trackfit;
import mosqueira.trackfit.views.ThemeManager;
import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import mosqueira.trackfit.views.PanelUsuariosAsignados;
import javax.swing.JOptionPane;
import mosqueira.trackfit.dto.Usuaris;
import mosqueira.trackfit.views.DialogLogin;
import static mosqueira.trackfit.views.ThemeManager.resizeIcon;
import net.miginfocom.swing.MigLayout;

/**
 * Clase principal de la aplicación TrackFit.
 * Gestiona la interfaz principal, el inicio de sesión, la visualización de usuarios asignados,
 * el cambio de temas y la navegación en el menú.
 * @author Romina Mosqueira
 */
public class Main extends javax.swing.JFrame {

    private PanelUsuariosAsignados listF;
    private static Usuaris instructor;
    private JCheckBoxMenuItem darkMode;

    
    /**
     * Constructor de la clase Main. Inicializa la ventana principal y sus componentes.
     */
    
    public Main() {
        initComponents();
        setupWindow();
        setupIconsAndMenus();
    }

    /**
     * Configura la ventana principal: centrado, diseño y eventos.
     */
    public void setupWindow() {
        setLocationRelativeTo(this); // Centra la ventana

        jPanelMain.setLayout(new MigLayout("wrap, align center", "[center]", "[][]40[]"));
        jPanelMain.add(jlogo, "align center, gaptop 50");
        jPanelMain.add(IraDialogo, "align center, gaptop 50");
        // Añadir jPanelMain al centro del contenedor principal
        getContentPane().add(jPanelMain, BorderLayout.CENTER);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanelMain.revalidate();
                jPanelMain.repaint();
            }
        });
        // Agregar un listener para la confirmación de salida
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                confirmExit();
            }
        });
    }

     /**
     * Muestra un cuadro de diálogo de confirmación al intentar salir de la aplicación.
     */
    private void confirmExit() {
        int option = JOptionPane.showConfirmDialog(Main.this,
                "Are you sure you want to exit?", "Confirm exit",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            // Si selecciona "Sí", cierra la aplicación
            System.exit(0);
        } else {
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }

   /**
     * Configura los iconos y menús de la aplicación, incluyendo el modo oscuro.
     */
    private void setupIconsAndMenus() {
        // Configurar ítems del menú de archivo
        jMenuExit.addActionListener(evt -> this.jMenuExitActionPerformed(evt));
        logout.addActionListener(evt -> this.logoutActionPerformed(evt));

        // Configurar ítems del menú de ayuda
        jMenuItemAbout.addActionListener(evt -> this.jMenuItemAboutActionPerformed(evt));

        // Configurar ítem de modo oscuro
        darkMode = new JCheckBoxMenuItem("Modo oscuro");
        darkMode.addActionListener(evt -> toggleTheme());
        jMenuHelp.add(darkMode); // Añadir al menú de ayuda

        // Configurar íconos para los botones y menús
        IraDialogo.setIcon(ThemeManager.resizeIcon("/images/access_icon1.png", 100, 100));
    }

    /**
     * Muestra el panel de usuarios asignados con la información de un
     * instructor.
     *
     * @param u El usuario (instructor) que se ha iniciado sesión.
     */
    public void showListFrame(Usuaris u) {
        this.instructor = u;
        getContentPane().removeAll();
        // Crear el panel ListUsers y pasarlo al marco
        listF = new PanelUsuariosAsignados(this, instructor, isDarkModeEnabled());

        // Agregar el panel de usuarios
        getContentPane().add(listF);
        listF.revalidate();
        repaint();
    }

    /**
     * Método llamado al iniciar la aplicación para configurar la interfaz
     * gráfica. Este código se genera automáticamente desde el editor de
     * formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        IraDialogo = new javax.swing.JButton();
        jlogo = new javax.swing.JLabel();
        jMenuFrame = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuExit = new javax.swing.JMenuItem();
        logout = new javax.swing.JMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuItemAbout = new javax.swing.JMenuItem();
        jMenuWeb = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.GreyInline"));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.darkGray);

        jPanelMain.setBackground(new java.awt.Color(204, 204, 204));
        jPanelMain.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelMain.setPreferredSize(new java.awt.Dimension(1000, 900));
        jPanelMain.setRequestFocusEnabled(false);

        IraDialogo.setBackground(new java.awt.Color(255, 255, 255));
        IraDialogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/access_icon1.png"))); // NOI18N
        IraDialogo.setBorder(null);
        IraDialogo.setBorderPainted(false);
        IraDialogo.setContentAreaFilled(false);
        IraDialogo.setDefaultCapable(false);
        IraDialogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        IraDialogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IraDialogoActionPerformed(evt);
            }
        });

        jlogo.setBackground(new java.awt.Color(255, 255, 255));
        jlogo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        jlogo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jlogo.setRequestFocusEnabled(false);
        jlogo.setVerifyInputWhenFocusTarget(false);
        jlogo.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(IraDialogo, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addComponent(jlogo)
                .addGap(0, 0, 0)
                .addComponent(IraDialogo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanelMain, java.awt.BorderLayout.CENTER);

        jMenuFrame.setBackground(new java.awt.Color(102, 102, 102));
        jMenuFrame.setBorder(null);
        jMenuFrame.setForeground(new java.awt.Color(0, 0, 0));

        jMenuFile.setBackground(new java.awt.Color(0, 0, 0));
        jMenuFile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuFile.setForeground(new java.awt.Color(255, 255, 255));
        jMenuFile.setText("File");
        jMenuFile.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuFile.setMinimumSize(new java.awt.Dimension(652, 395));
        jMenuFile.setPreferredSize(new java.awt.Dimension(50, 20));

        jMenuExit.setText("Exit");
        jMenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuExitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuExit);

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jMenuFile.add(logout);

        jMenuFrame.add(jMenuFile);

        jMenuHelp.setBackground(new java.awt.Color(0, 0, 0));
        jMenuHelp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuHelp.setForeground(new java.awt.Color(255, 255, 255));
        jMenuHelp.setText("Help");
        jMenuHelp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuHelp.setPreferredSize(new java.awt.Dimension(50, 20));

        jMenuItemAbout.setText("About");
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuItemAbout);

        jMenuFrame.add(jMenuHelp);

        jMenuWeb.setBackground(new java.awt.Color(0, 0, 0));
        jMenuWeb.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuWeb.setForeground(new java.awt.Color(255, 255, 255));
        jMenuWeb.setText("Web");
        jMenuWeb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuWeb.setPreferredSize(new java.awt.Dimension(50, 20));
        jMenuWeb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuWebMouseClicked(evt);
            }
        });
        jMenuFrame.add(jMenuWeb);

        setJMenuBar(jMenuFrame);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
    * Acción que se ejecuta al hacer clic en el botón "Exit" del menú.
    */
    private void jMenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuExitActionPerformed
        confirmExit();
    }//GEN-LAST:event_jMenuExitActionPerformed
     /**
     * Establece el instructor que ha iniciado sesión.
     *
     * @param instructor Usuario de tipo instructor.
     */
    public void setLoggedInstructor(Usuaris instructor) {
        this.instructor = instructor;
    }

     /**
     * Obtiene el instructor actualmente logueado.
     *
     * @return Instructor activo en la sesión.
     */
    public static Usuaris getLoggedInstructor() {
        return instructor;
    }
     /**
     * Acción ejecutada al hacer clic en "Iniciar sesión".
     */
    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        getContentPane().add(jPanelMain);
        jPanelMain.setVisible(true);
        listF.setVisible(false);
    }//GEN-LAST:event_logoutActionPerformed
     /**
     * Acción ejecutada al hacer clic en "Acerca de" en el menú.
     */
    private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutActionPerformed
        // Asignar icono redimensionado al menú
        ImageIcon icon = resizeIcon("/images/about_icon.png", 20, 20); // 20x20 es el tamaño deseado
        JOptionPane.showMessageDialog(this,
                "Developed by Romina Marlene Mosqueira Rodriguez\n"
                + "Course: 2º DAM \n"
                + "Resources used:\n"
                + "- Logo: Canva\n"
                + "- Other resources: Teacher, Classmates, ChatGPT",
                "About",
                JOptionPane.INFORMATION_MESSAGE,
                icon);
    }//GEN-LAST:event_jMenuItemAboutActionPerformed
    /**
    * Acción que se ejecuta al hacer clic en el botón "Iniciar sesión".
    */
    private void IraDialogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IraDialogoActionPerformed
        DialogLogin iraDialogo = new DialogLogin(this, true, isDarkModeEnabled());
        iraDialogo.setVisible(true);
        iraDialogo.applyDarkMode(isDarkModeEnabled());

    }//GEN-LAST:event_IraDialogoActionPerformed
     /**
     * Acción ejecutada al hacer clic en "Web" en el menú.
     */
    private void jMenuWebMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuWebMouseClicked
        // Crear el ítem de menú para "Visitar nuestro sitio web"
        try {
            String url = "http://www.ejemplo.com/"; // Cambia esta URL por la de tu sitio web
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url)); // Abre la URL en el navegador predeterminado
        } catch (IOException e) {
            // Manejo de errores si no se puede abrir el sitio

        }
    }//GEN-LAST:event_jMenuWebMouseClicked
    /**
    * Alterna entre modo oscuro y claro.
    */
    private void toggleTheme() {
        // Verificar si el modo oscuro está activado
        boolean isDarkMode = darkMode.isSelected();
        // Aplicar el tema en base a la selección
        applyTheme(isDarkMode);
    }
    /**
     * Aplica el tema oscuro o claro a la interfaz.
     * 
     * @param isDarkMode Indica si el modo oscuro debe ser aplicado (true) o el modo claro (false).
     */
    public void applyTheme(boolean isDarkMode) {
        if (isDarkMode) {
            
            ThemeManager.applyDarkMode(jPanelMain, listF);
           
            ThemeManager.applyDarkModeToComponents(jlogo, IraDialogo, jMenuFile, jMenuExit, logout, jMenuHelp, jMenuItemAbout, jMenuWeb);
        } else {
            
            ThemeManager.applyLightMode(jPanelMain, listF);
            
            ThemeManager.applyLightModeToComponents(jlogo, IraDialogo, jMenuFile, jMenuExit, logout, jMenuHelp, jMenuItemAbout, jMenuWeb);
        }
    }
    /**
     * Determina si el modo oscuro está habilitado.
     * 
     * @return true si el modo oscuro está activado, false si no.
     */
    public boolean isDarkModeEnabled() {
        // Retornar si el checkbox de modo oscuro está seleccionado
        return darkMode.isSelected();
    }
    /**
     * Método principal de la aplicación.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IraDialogo;
    private javax.swing.JMenuItem jMenuExit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuBar jMenuFrame;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenu jMenuWeb;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JLabel jlogo;
    private javax.swing.JMenuItem logout;
    // End of variables declaration//GEN-END:variables

}
