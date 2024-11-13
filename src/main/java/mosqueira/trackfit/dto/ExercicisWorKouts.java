
package mosqueira.trackfit.dto;

/**
 *
 * @author Lulas
 */
public class ExercicisWorKouts {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the IdExercici
     */
    public int getIdExercici() {
        return IdExercici;
    }

    /**
     * @param IdExercici the IdExercici to set
     */
    public void setIdExercici(int IdExercici) {
        this.IdExercici = IdExercici;
    }

    /**
     * @return the idWorkouts
     */
    public int getIdWorkouts() {
        return idWorkouts;
    }

    /**
     * @param idWorkouts the idWorkouts to set
     */
    public void setIdWorkouts(int idWorkouts) {
        this.idWorkouts = idWorkouts;
    }
    private int id;
    private int idWorkouts; 
    private int IdExercici;
}


