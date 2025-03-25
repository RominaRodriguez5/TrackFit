package mosqueira.trackfit.dto;

/**
 * Esta clase representa un usuario en el sistema TrackFit. Un usuario puede ser un instructor o un estudiante,
 * y contiene información sobre su identidad, credenciales y asignaciones.
 * 
 * @author Romina Mosqueira
 */
public class Usuaris {

    private int Id;
    private String Nom;
    private String Email;
    private String PasswordHash;
    private boolean Instructor;
    private int AssignedInstructor;

    /**
     * Obtiene el identificador del usuario.
     * 
     * @return el identificador del usuario.
     */
    public int getId() {
        return Id;
    }

    /**
     * Establece el identificador del usuario.
     * 
     * @param Id el identificador del usuario.
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return el nombre del usuario.
     */
    public String getNom() {
        return Nom;
    }

    /**
     * Establece el nombre del usuario.
     * 
     * @param Nom el nombre del usuario.
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * 
     * @return el correo electrónico del usuario.
     */
    public String getEmail() {
        return Email;
    }

    /**
     * Establece el correo electrónico del usuario.
     * 
     * @param Email el correo electrónico del usuario.
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * Obtiene el hash de la contraseña del usuario.
     * 
     * @return el hash de la contraseña del usuario.
     */
    public String getPasswordHash() {
        return PasswordHash;
    }

    /**
     * Establece el hash de la contraseña del usuario.
     * 
     * @param PasswordHash el hash de la contraseña del usuario.
     */
    public void setPasswordHash(String PasswordHash) {
        this.PasswordHash = PasswordHash;
    }

    /**
     * Verifica si el usuario es un instructor.
     * 
     * @return {@code true} si el usuario es un instructor, de lo contrario {@code false}.
     */
    public boolean isInstructor() {
        return Instructor;
    }

    /**
     * Establece si el usuario es un instructor.
     * 
     * @param Instructor {@code true} si el usuario es un instructor, de lo contrario {@code false}.
     */
    public void setInstructor(boolean Instructor) {
        this.Instructor = Instructor;
    }

    /**
     * Obtiene el identificador del instructor asignado al usuario.
     * 
     * @return el identificador del instructor asignado.
     */
    public int getAssignedInstructor() {
        return AssignedInstructor;
    }

    /**
     * Establece el identificador del instructor asignado al usuario.
     * 
     * @param AssignedInstructor el identificador del instructor asignado.
     */
    public void setAssignedInstructor(int AssignedInstructor) {
        this.AssignedInstructor = AssignedInstructor;
    }

    /**
     * Retorna una representación en cadena del nombre del usuario.
     * 
     * @return el nombre del usuario.
     */
    @Override
    public String toString() {
        return Nom;
    }
}
