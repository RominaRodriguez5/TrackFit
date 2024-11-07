package mosqueira.trackfit.dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import mosqueira.trackfit.dto.Exercicis;
import mosqueira.trackfit.dto.Usuaris;
import mosqueira.trackfit.dto.Workouts;

/**
 *
 * @author Lulas
 */
public class DataAccess {

    public static Connection getConnection() {
        Connection connection = null;
        Properties properties = new Properties();

        try {
            properties.load(DataAccess.class.getClassLoader().getResourceAsStream("properties/application.properties"));
            //String connectionString = "jdbc:sqlserver://localhost:1433;database=simulapdb;user=sa;" + "password=Pwd1234;encrypt=false;trustServerCertificate=true;";
            String connectionUrl = properties.getProperty("connectionUrl");
            connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            // Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        return connection;
    }

    public ArrayList<Usuaris> getUsuarios() {
        ArrayList<Usuaris> usuarios = new ArrayList<>();
        String sql = "SELECT Nom FROM Usuaris";
        Connection connection = getConnection();
        try {
            PreparedStatement selectStatement = connection.prepareStatement(sql);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Usuaris user = new Usuaris();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                //user.setEmail(resultSet.getString("Email"));
                //user.setPasswordHash(resultSet.getString("PasswordHash"));
                //user.setFoto("Foto");
                //user.setInstructor(resultSet.getBoolean("isInstructor"));
                usuarios.add(user);
            }
            selectStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    public static Usuaris getUsuario(String email) {
        Usuaris user = new Usuaris();
        String sql = "SELECT * FROM Usuaris WHERE Email=?";
        Connection connection = getConnection();
        try {
            PreparedStatement selectStatement = connection.prepareStatement(sql);
            selectStatement.setString(1, email);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                //user.setFoto("Foto");
                user.setInstructor(resultSet.getBoolean("Instructor"));
            }
            selectStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public ArrayList<Usuaris> getInstrutor() {
        ArrayList<Usuaris> usersInstructor = new ArrayList<>();
        String sql = "SELECT * FROM Usuaris WHERE AssignedInstructor = ? AND Instructor != 1"; // Utiliza la columna AssignedInstructor
        Connection connection = getConnection();

        try {
            PreparedStatement selectStatement = connection.prepareStatement(sql);
            selectStatement.setInt(1, 7); // Establecer el ID del instructor
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Usuaris user = new Usuaris();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                usersInstructor.add(user);
            }
            selectStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usersInstructor;
    }
    
    public int registerUser(Usuaris u) {
        int newUserId = 0;
        Connection connection = getConnection();
        String sql = "INSERT INTO Usuaris(NOm,Email,PasswordHash,Instructor)"
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement insertStatement = connection.prepareStatement(sql);
            insertStatement.setString(1, u.getNom());
            insertStatement.setString(2, u.getEmail());
            insertStatement.setString(3, u.getPasswordHash());
            insertStatement.setBoolean(4, u.isInstructor());
            newUserId = insertStatement.executeUpdate();

            insertStatement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newUserId;
    }
    
    public List<Workouts> getWorkoutsList() {
        List<Workouts> workouts = new ArrayList<>();
        String sql = "SELECT * FROM workouts";  // Ajusta la consulta según tu estructura de base de datos
        Connection connection = getConnection();
        try {
             PreparedStatement selectStatement = connection.prepareStatement(sql);
              ResultSet resultSet = selectStatement.executeQuery();
                while (resultSet.next()){
                    Workouts workout = new Workouts();
                    workout.setId(resultSet.getInt("id"));  // Asumiendo que tienes un campo id
                    workout.setForDate(resultSet.getString("for_date"));  // Suponiendo que la fecha esté en el formato correcto
                    workout.setUserId(resultSet.getInt("user_id"));
                    workout.setComments(resultSet.getString("comments"));
                    workouts.add(workout);
                }
                    selectStatement.close();
                    connection.close();
            }catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return workouts;
    }

    public void saveWorkout(Workouts workout) {
        String sql = "INSERT INTO Workouts (ForDate, UserId, Comments) VALUES (?, ?, ?)";

        try (Connection connection = getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Establecemos los valores en el PreparedStatement
            pstmt.setString(1, workout.getForDate()); 
            pstmt.setInt(2, workout.getUserId());
            pstmt.setString(3, workout.getComments());

            // Ejecutamos la actualización
            int affectedRows = pstmt.executeUpdate();

            // Si se inserta correctamente, obtenemos el ID generado
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        workout.setId(generatedKeys.getInt(1));  // Asignamos el ID generado al objeto Workout
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Workouts> getWorkoutsUser(int userId) {
        ArrayList<Workouts> workout = new ArrayList<>();
        String sql = "SELECT Id, UserId, ForDate, Comments FROM Workouts WHERE UserId = ?";

        try (
                Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql)) {
            selectStatement.setInt(1, userId);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Workouts workouts = new Workouts();
                workouts.setUserId(resultSet.getInt("UserId"));
                workouts.setId(resultSet.getInt("Id"));
                workouts.setForDate(resultSet.getString("ForDate"));
                workouts.setComments(resultSet.getString("Comments"));
                workout.add(workouts);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return workout;
    }

    public ArrayList<Exercicis> getExercicisForWorkout(int workoutId) {
        ArrayList<Exercicis> exercicisList = new ArrayList<>();
        String sql = "SELECT e.Id, e.NomExercici, e.Descripcio "
                + "FROM Exercicis e "
                + "JOIN ExercicisWorkouts ew ON e.Id = ew.IdExercici "
                + "WHERE ew.IdWorkout = ?"; // Filtrar por idWorkouts

        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql)) {

            // Establecer el ID del workout en la consulta
            selectStatement.setInt(1, workoutId);
            ResultSet resultSet = selectStatement.executeQuery();

            // Recorrer los resultados y crear objetos Exercicis
            while (resultSet.next()) {
                Exercicis exercici = new Exercicis();
                exercici.setId(resultSet.getInt("Id"));
                exercici.setNomExercici(resultSet.getString("NomExercici"));
                exercici.setDescripcio(resultSet.getString("Descripcio"));
                // Aquí puedes agregar más campos si existen en la base de datos
                exercicisList.add(exercici);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return exercicisList;
    }

    public ArrayList<Exercicis> getInfoExercicis() {
        ArrayList<Exercicis> infoExercicis = new ArrayList<>();
        String sql = "SELECT * FROM Exercicis";
        Connection connection = getConnection();
        try {
            PreparedStatement selectStatement = connection.prepareStatement(sql);
            // Establecer el ID del instructor
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Exercicis infoExercici = new Exercicis();
                infoExercici.setNomExercici(resultSet.getString("NomExercici"));
                infoExercici.setDescripcio(resultSet.getString("Descripcio"));
                infoExercici.setId(resultSet.getInt("Id"));
                infoExercicis.add(infoExercici);
            }
            selectStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Usuarios encontrados: " + infoExercicis.size());
        return infoExercicis;
    }

    public void insertarRelaciones(Workouts workout, ArrayList<Exercicis> ejerciciosSeleccionados) {
        // Asumimos que la relación entre ejercicios y entrenamientos está en la tabla ExercicisWorkouts
        String sql = "INSERT INTO ExercicisWorkouts (IdExercici, IdWorkout) VALUES (?, ?)";

        try (Connection connection = getConnection(); PreparedStatement insertStatement = connection.prepareStatement(sql)) {

            // Iteramos por los ejercicios seleccionados
            for (Exercicis ejercici : ejerciciosSeleccionados) {
                // Establecemos los parámetros en la sentencia SQL
                insertStatement.setInt(1, ejercici.getId());  // Id del ejercicio
                insertStatement.setInt(2, workout.getId());   // Id del entrenamiento
                insertStatement.addBatch();  // Agregamos a batch para insertar múltiples registros en una sola transacción
            }

            // Ejecutamos el batch de inserciones
            insertStatement.executeBatch();
            connection.commit();  // Confirmamos la transacción

        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
