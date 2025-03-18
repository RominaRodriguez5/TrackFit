
package mosqueira.trackfit.dto;

/**
 *
 * @author Lulas
 */
public class Usuaris {

    /**
     * @return the AssignedInstructor
     */
    public int getAssignedInstructor() {
        return AssignedInstructor;
    }

    /**
     * @param AssignedInstructor the AssignedInstructor to set
     */
    public void setAssignedInstructor(int AssignedInstructor) {
        this.AssignedInstructor = AssignedInstructor;
    }
     
    @Override
    public String toString(){
        return Nom;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPasswordHash() {
        return PasswordHash;
    }

    public void setPasswordHash(String PasswordHash) {
        this.PasswordHash = PasswordHash;
    }

    public boolean isInstructor() {
        return Instructor;
    }

    public void setInstructor(boolean Instructor) {
        this.Instructor = Instructor;
    }

    private int Id;
    private String Nom;
    private String Email;
    private String PasswordHash;
    private boolean Instructor;
    private int AssignedInstructor;
}