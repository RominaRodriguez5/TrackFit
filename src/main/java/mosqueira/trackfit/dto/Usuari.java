
package mosqueira.trackfit.dto;

/**
 *
 * @author Lulas
 */
public class Usuari {

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

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] Foto) {
        this.Foto = Foto;
    }

    public boolean Instructor() {
        return Instructor;
    }

    public void setInstructor(boolean Instructor) {
        this.Instructor = Instructor;
    }
    private int Id;
    private String Nom;
    private String Email;
    private String PasswordHash;
    private byte[] Foto;
    private boolean Instructor;

}
