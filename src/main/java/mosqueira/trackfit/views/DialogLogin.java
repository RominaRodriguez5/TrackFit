package mosqueira.trackfit.views;
import at.favre.lib.crypto.bcrypt.BCrypt;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import mosqueira.trackfit.Main;
import mosqueira.trackfit.dataAccess.DataAccess;
import mosqueira.trackfit.dto.Usuaris;

/**
 * Clase que representa el cuadro de diálogo de inicio de sesión.
 * Permite a los usuarios ingresar su correo electrónico y contraseña para autenticarse.
 * @author Romina Mosqueira
 */

public class DialogLogin extends javax.swing.JDialog {

    private Main mainFra;
    private DataAccess da = new DataAccess();
    private Usuaris loggedInUser;
    private JCheckBoxMenuItem darkMode;
    JCheckBox showPasswordCheckBox = new JCheckBox("Show password");
  /**
     * Constructor de la clase DialogLogin.
     * @param parent Marco principal de la aplicación.
     * @param modal Indica si el cuadro de diálogo es modal.
     * @param isDarkMode Estado del modo oscuro.
     */
      public DialogLogin(java.awt.Frame parent, boolean modal, boolean isDarkMode) {
        super(parent, modal);
        initComponents();
        this.mainFra = (Main) parent;
        setLocationRelativeTo(this);
        
        // Inicializar el checkbox del modo oscuro
        darkMode = new JCheckBoxMenuItem("Modo oscuro");
        darkMode.setState(isDarkMode);
        darkMode.addActionListener(e -> applyDarkMode(darkMode.getState()));
        jMenuEdit.add(darkMode);
        
        // Aplicar el estado del modo oscuro al abrir el login
        applyDarkMode(isDarkMode);
        
        // Agregar checkbox para mostrar/ocultar la contraseña
        jPanelLogin.add(showPasswordCheckBox);
        showPasswordCheckBox.setBounds(290, 360, 180, 20);
        showPasswordCheckBox.addActionListener(e -> {
            txtPassword.setEchoChar(showPasswordCheckBox.isSelected() ? (char) 0 : '*');
        });

        // Agregar iconos a los elementos visuales
        addIcons();
    }

    /**
     * Método que añade iconos a los elementos visuales.
     */
    private void addIcons() {
        Email.setIcon(ThemeManager.resizeIcon("/images/email_icon.png", 50, 50));
        Password.setIcon(ThemeManager.resizeIcon("/images/password_icon.png", 50, 50));
        botonAcceso.setIcon(ThemeManager.resizeIcon("/images/login_icon.png", 60, 60));
        jMenufile.setIcon(ThemeManager.resizeIcon("/images/file_icon.png", 16, 16));
        jMenuReturn.setIcon(ThemeManager.resizeIcon("/images/return_icon.png", 16, 16));
        jMenuEdit.setIcon(ThemeManager.resizeIcon("/images/edit_icon.png", 16, 16));
    }

    /**
     * Aplica el tema oscuro o claro a la interfaz de usuario.
     * @param isDarkMode Indica si se debe aplicar el modo oscuro.
     */
    public void applyDarkMode(boolean isDarkMode) {
        if (isDarkMode) {
            ThemeManager.applyDarkMode(jPanelLogin);
            ThemeManager.applyDarkModeToComponents(txtEmail, txtPassword, showPasswordCheckBox);
        } else {
            ThemeManager.applyLightMode(jPanelLogin);
            ThemeManager.applyLightModeToComponents(txtEmail, txtPassword, showPasswordCheckBox);
        }
        jPanelLogin.repaint();
    }

    /**
     * Obtiene el usuario que ha iniciado sesión.
     * @return Objeto Usuaris con la información del usuario.
     */
    public Usuaris getLoggedInUser() {
        return loggedInUser;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLogin = new javax.swing.JPanel();
        botonAcceso = new javax.swing.JButton();
        Password = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        Email = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jlogo = new javax.swing.JLabel();
        jMenuBarLogin = new javax.swing.JMenuBar();
        jMenufile = new javax.swing.JMenu();
        jMenuReturn = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(700, 600));
        setModal(true);

        jPanelLogin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanelLogin.setMinimumSize(new java.awt.Dimension(700, 600));
        jPanelLogin.setPreferredSize(new java.awt.Dimension(700, 600));

        botonAcceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login_icon.png"))); // NOI18N
        botonAcceso.setBorder(null);
        botonAcceso.setBorderPainted(false);
        botonAcceso.setContentAreaFilled(false);
        botonAcceso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonAcceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAccesoActionPerformed(evt);
            }
        });

        Password.setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
        Password.setForeground(new java.awt.Color(255, 153, 102));
        Password.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/password_icon.png"))); // NOI18N
        Password.setMinimumSize(new java.awt.Dimension(0, 0));

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPassword.setText("string");

        Email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/email_icon.png"))); // NOI18N
        Email.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setText("a@b.c");

        jlogo.setBackground(new java.awt.Color(191, 154, 207));
        jlogo.setForeground(new java.awt.Color(204, 204, 255));
        jlogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        jlogo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jlogo.setRequestFocusEnabled(false);
        jlogo.setVerifyInputWhenFocusTarget(false);
        jlogo.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(botonAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addComponent(jlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70)
                .addComponent(botonAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        botonAcceso.getAccessibleContext().setAccessibleParent(botonAcceso);

        jMenuBarLogin.setBackground(new java.awt.Color(102, 102, 102));
        jMenuBarLogin.setBorder(null);
        jMenuBarLogin.setForeground(new java.awt.Color(255, 255, 255));

        jMenufile.setBackground(new java.awt.Color(0, 0, 0));
        jMenufile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenufile.setForeground(new java.awt.Color(255, 255, 255));
        jMenufile.setText("File");
        jMenufile.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenufile.setPreferredSize(new java.awt.Dimension(50, 20));
        jMenufile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenufileActionPerformed(evt);
            }
        });

        jMenuReturn.setText("Return...");
        jMenuReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuReturnActionPerformed(evt);
            }
        });
        jMenufile.add(jMenuReturn);

        jMenuBarLogin.add(jMenufile);

        jMenuEdit.setBackground(new java.awt.Color(0, 0, 0));
        jMenuEdit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuEdit.setForeground(new java.awt.Color(255, 255, 255));
        jMenuEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_exercise_icon.png"))); // NOI18N
        jMenuEdit.setText("Edit");
        jMenuEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuEdit.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jMenuEdit.setPreferredSize(new java.awt.Dimension(50, 20));
        jMenuBarLogin.add(jMenuEdit);

        setJMenuBar(jMenuBarLogin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Maneja la acción de presionar el botón de acceso.
     * @param evt Evento de acción.
     */
    private void botonAccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAccesoActionPerformed
      
        String email = txtEmail.getText();
        Usuaris usuario = da.getUser(email);
        // Restablecer los bordes de los campos
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK));
        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK));
        // Validar que el email no esté vacío
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: The email cannot be empty.");
            txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLUE));
            return;
        }

        if (usuario.isInstructor()) {

            if (BCrypt.verifyer().verify(txtPassword.getPassword(), usuario.getPasswordHash()).verified) {
                mainFra.setLoggedInstructor(usuario);
                mainFra.showListFrame(usuario);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,"The password is incorrect.");
            }

        } else {
            JOptionPane.showMessageDialog(this,"User not found.");
            txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLUE));
        }
    
    }//GEN-LAST:event_botonAccesoActionPerformed
    /**
     * Acción del menú de archivo.
     * @param evt Evento de acción.
     */

    private void jMenufileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenufileActionPerformed
        jMenuEdit.add(darkMode);
    }//GEN-LAST:event_jMenufileActionPerformed
      /**
     * Acción del menú para regresar.
     * @param evt Evento de acción.
     */
    private void jMenuReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuReturnActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jMenuReturnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Email;
    private javax.swing.JLabel Password;
    private javax.swing.JButton botonAcceso;
    private javax.swing.JMenuBar jMenuBarLogin;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenuItem jMenuReturn;
    private javax.swing.JMenu jMenufile;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JLabel jlogo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables

}
