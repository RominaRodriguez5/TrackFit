package mosqueira.trackfit.dto;
/**
 * Representa un ejercicio dentro del sistema de TrackFit.
 * Contiene información sobre el nombre, descripción, una imagen de demostración y un identificador único.
 * 
 * @author Romina Mosqueira
 */
public class Exercicis {

    private int Id;
    private String NomExercici;
    private String Descripcio;
    private byte[] DemoFoto;

    /**
     * Obtiene el identificador único del ejercicio.
     * 
     * @return El ID del ejercicio.
     */
    public int getId() {
        return Id;
    }

    /**
     * Establece el identificador único del ejercicio.
     * 
     * @param Id El nuevo ID del ejercicio.
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * Obtiene el nombre del ejercicio.
     * 
     * @return El nombre del ejercicio.
     */
    public String getNomExercici() {
        return NomExercici;
    }

    /**
     * Establece el nombre del ejercicio.
     * 
     * @param NomExercici El nuevo nombre del ejercicio.
     */
    public void setNomExercici(String NomExercici) {
        this.NomExercici = NomExercici;
    }

    /**
     * Obtiene la descripción del ejercicio.
     * 
     * @return La descripción del ejercicio.
     */
    public String getDescripcio() {
        return Descripcio;
    }

    /**
     * Establece la descripción del ejercicio.
     * 
     * @param Descripcio La nueva descripción del ejercicio.
     */
    public void setDescripcio(String Descripcio) {
        this.Descripcio = Descripcio;
    }

    /**
     * Obtiene la imagen de demostración del ejercicio.
     * 
     * @return Un array de bytes que representa la imagen de demostración.
     */
    public byte[] getDemoFoto() {
        return DemoFoto;
    }

    /**
     * Establece la imagen de demostración del ejercicio.
     * 
     * @param DemoFoto Un array de bytes con la imagen del ejercicio.
     */
    public void setDemoFoto(byte[] DemoFoto) {
        this.DemoFoto = DemoFoto;
    }

    /**
     * Devuelve una representación en cadena del ejercicio.
     * 
     * @return El nombre del ejercicio.
     */
    @Override
    public String toString() {
        return this.getNomExercici();
    }
}
