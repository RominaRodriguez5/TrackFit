
package mosqueira.trackfit.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Lulas
 */
public class Workouts {
    
    
    /**
     * @return the forDate
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
     * @param forDate the forDate to set
     */
    public void setForDate(String forDate) {
        this.forDate = forDate;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
   private int Id;
   private String forDate;
   private int userId;
   private String comments;

}
