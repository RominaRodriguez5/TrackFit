package mosqueira.trackfit.dto;

/**
 * Esta clase representa la relación entre ejercicios y entrenamientos.
 * Se utiliza para vincular un ejercicio con un entrenamiento específico en la aplicación TrackFit.
 * 
 * @author Romina Mosqueira
 */
public class ExercicisWorKouts {

    private int id;
    private int idWorkouts;
    private int IdExercici;
 

    /**
     * Obtiene el identificador de la relación entre ejercicio y entrenamiento.
     * 
     * @return el identificador de la relación.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador de la relación entre ejercicio y entrenamiento.
     * 
     * @param id el identificador de la relación.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador del ejercicio asociado a esta relación.
     * 
     * @return el identificador del ejercicio.
     */
    public int getIdExercici() {
        return IdExercici;
    }

    /**
     * Establece el identificador del ejercicio asociado a esta relación.
     * 
     * @param IdExercici el identificador del ejercicio.
     */
    public void setIdExercici(int IdExercici) {
        this.IdExercici = IdExercici;
    }

    /**
     * Obtiene el identificador del entrenamiento asociado a esta relación.
     * 
     * @return el identificador del entrenamiento.
     */
    public int getIdWorkouts() {
        return idWorkouts;
    }

    /**
     * Establece el identificador del entrenamiento asociado a esta relación.
     * 
     * @param idWorkouts el identificador del entrenamiento.
     */
    public void setIdWorkouts(int idWorkouts) {
        this.idWorkouts = idWorkouts;
    }
}
