package mosqueira.trackfit.dto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que representa un entrenamiento en la aplicación TrackFit.
 * Contiene información relacionada con el entrenamiento, como la fecha, el usuario asignado y los comentarios.
 * 
 * @author Romina Mosqueira
 */
public class Workouts {

    private int Id;
    private String forDate;
    private int userId;
    private String comments;

    /**
     * Obtiene la fecha del entrenamiento en formato "dd/MM/yyyy HH:mm".
     * Si la fecha no está disponible o tiene un formato incorrecto, retorna una cadena vacía.
     * 
     * @return la fecha del entrenamiento en formato "dd/MM/yyyy HH:mm".
     */
    public String getForDate() {
        if (forDate == null || forDate.isEmpty()) {
            return "";
        }

        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            Date date = inputDateFormat.parse(forDate);
            return outputDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return forDate;
        }
    }

    /**
     * Establece la fecha del entrenamiento.
     * 
     * @param forDate la fecha del entrenamiento en formato "yyyy-MM-dd HH:mm:ss".
     */
    public void setForDate(String forDate) {
        this.forDate = forDate;
    }

    /**
     * Obtiene el identificador único del entrenamiento.
     * 
     * @return el identificador del entrenamiento.
     */
    public int getId() {
        return Id;
    }

    /**
     * Establece el identificador único del entrenamiento.
     * 
     * @param Id el identificador del entrenamiento.
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * Obtiene el identificador del usuario asignado a este entrenamiento.
     * 
     * @return el identificador del usuario asignado al entrenamiento.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Establece el identificador del usuario asignado a este entrenamiento.
     * 
     * @param userId el identificador del usuario asignado.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Obtiene los comentarios asociados con el entrenamiento.
     * 
     * @return los comentarios del entrenamiento.
     */
    public String getComments() {
        return comments;
    }

    /**
     * Establece los comentarios asociados con el entrenamiento.
     * 
     * @param comments los comentarios del entrenamiento.
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
}
