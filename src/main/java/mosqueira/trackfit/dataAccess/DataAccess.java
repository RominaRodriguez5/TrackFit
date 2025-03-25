package mosqueira.trackfit.dataAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import mosqueira.trackfit.dto.Exercicis;
import mosqueira.trackfit.dto.Usuaris;
import mosqueira.trackfit.dto.Workouts;
import mosqueira.trackfit.dto.ExercicisWorKouts;

/**
 * Clase que maneja el acceso a datos para la aplicación TrackFit. Contiene
 * métodos para interactuar con la base de datos, incluyendo la obtención,
 * actualización, inserción y eliminación de datos relacionados con usuarios,
 * ejercicios y entrenamientos.
 *
 * @author Lulas
 */
public class DataAccess {
    
    /**
     * Establece una conexión con la base de datos.
     *
     * @return la conexión a la base de datos.
     */
    public static Connection getConnection() {
        Connection connection = null;
        Properties properties = new Properties();

        try {
            properties.load(DataAccess.class.getClassLoader().getResourceAsStream("properties/application.properties"));
            String connectionUrl = properties.getProperty("connectionUrl");
            connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Obtiene todos los usuarios que no son instructores.
     *
     * @return una lista de objetos {@link Usuaris} representando a los
     * usuarios.
     */
    public ArrayList<Usuaris> getAllUsers() {
        ArrayList<Usuaris> usuaris = new ArrayList<>();
        String sql = "SELECT * FROM Usuaris WHERE Instructor=0";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql); ResultSet resultSet = selectStatement.executeQuery()) {

            while (resultSet.next()) {
                Usuaris user = new Usuaris();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setInstructor(resultSet.getBoolean("Instructor"));
                usuaris.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuaris;
    }

    /**
     * Obtiene un usuario específico por su correo electrónico.
     *
     * @param email el correo electrónico del usuario a obtener.
     * @return el objeto {@link Usuaris} que representa al usuario.
     */
    public static Usuaris getUser(String email) {
        Usuaris user = null;
        String sql = "SELECT * FROM Usuaris WHERE Email = ?";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setString(1, email);
            ResultSet resultSet = selectStatement.executeQuery();
            user = new Usuaris();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setInstructor(resultSet.getBoolean("Instructor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Obtiene una lista de usuarios asignados a un instructor específico.
     *
     * @param instructor el instructor cuyo usuarios serán obtenidos.
     * @return una lista de objetos {@link Usuaris} asignados al instructor.
     */
    public List<Usuaris> getAllUsersInstructor(Usuaris instructor) {
        ArrayList<Usuaris> usuaris = new ArrayList<>();
        // Si el instructor es null, retornamos una lista vacía.
        if (instructor == null) {
            return usuaris;
        }
        int instructorId = instructor.getId();
        String sql = "SELECT * FROM Usuaris WHERE AssignedInstructor = ? AND Instructor != 1";
        Connection connection = getConnection();
        try {
            try (PreparedStatement selectStatement = connection.prepareStatement(sql)) {
                // Establecemos el ID del instructor como parámetro en la consulta.
                selectStatement.setInt(1, instructorId);
                // Ejecutamos la consulta.
                ResultSet resultSet = selectStatement.executeQuery();
                // Procesamos los resultados.
                while (resultSet.next()) {
                    Usuaris user = new Usuaris();
                    // Asignamos los valores de la base de datos a la clase Usuaris.
                    user.setId(resultSet.getInt("Id"));
                    user.setNom(resultSet.getString("Nom"));
                    user.setEmail(resultSet.getString("Email"));
                    user.setPasswordHash(resultSet.getString("PasswordHash"));
                    // Si Instructor es igual a 1 (es instructor), seteamos 'true'. Si no, 'false'.
                    user.setInstructor(resultSet.getInt("Instructor") == 1);
                    // Añadimos el usuario a la lista.
                    usuaris.add(user);
                }
            }
            connection.close();  // Cerramos la conexión.
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuaris;  // Retornamos la lista de usuarios.
    }

    /**
     * Obtiene los entrenamientos de un usuario específico.
     *
     * @param userId el identificador del usuario.
     * @return una lista de objetos {@link Workouts} correspondientes a los
     * entrenamientos del usuario.
     */
    public ArrayList<Workouts> getWorkoutsForUser(int userId) {
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

    /**
     * Obtiene todos los entrenamientos registrados.
     *
     * @return una lista de objetos {@link Workouts} con todos los
     * entrenamientos disponibles.
     */
    public List<Workouts> getWorkoutsList() {
        List<Workouts> workouts = new ArrayList<>();
        String sql = "SELECT * FROM workouts";
        Connection connection = getConnection();
        try {
            PreparedStatement selectStatement = connection.prepareStatement(sql);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Workouts workout = new Workouts();
                workout.setId(resultSet.getInt("id"));  // Asumiendo que tienes un campo id
                workout.setForDate(resultSet.getString("for_date"));  // Suponiendo que la fecha esté en el formato correcto
                workout.setUserId(resultSet.getInt("user_id"));
                workout.setComments(resultSet.getString("comments"));
                workouts.add(workout);
            }
            selectStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return workouts;
    }

    /**
     * Guarda un nuevo entrenamiento en la base de datos.
     *
     * @param workout el objeto {@link Workouts} que representa el entrenamiento
     * a guardar.
     */
    public void getSaveWorkout(Workouts workout) {
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

    /**
     * Obtiene todos los ejercicios registrados.
     *
     * @return una lista de objetos {@link Exercicis} con los detalles de los
     * ejercicios.
     */
    public ArrayList<Exercicis> getInfoExercise() {
        ArrayList<Exercicis> infoExercicis = new ArrayList<>();
        String sql = "SELECT * FROM Exercicis";
        Connection connection = getConnection();
        try {
            PreparedStatement selectStatement = connection.prepareStatement(sql);
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
        return infoExercicis;
    }

    /**
     * Guarda un nuevo ejercicio en la base de datos.
     *
     * @param nom el nombre del ejercicio.
     * @param descripcion la descripción del ejercicio.
     */
    public void getSaveExercici(String nom, String descripcion) {
        String sql = "INSERT INTO Exercicis (NomExercici, Descripcio) VALUES (?, ?)";
        Connection connection = getConnection();

        try {
            PreparedStatement insertStatement = connection.prepareStatement(sql);
            insertStatement.setString(1, nom);
            insertStatement.setString(2, descripcion);

            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected > 0);

            insertStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Obtiene los ejercicios asociados con un entrenamiento específico.
     *
     * @param workoutId el identificador del entrenamiento.
     * @return una lista de objetos {@link Exercicis} asociados con el
     * entrenamiento.
     */
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

    /**
     * Inserta una nueva relación entre un ejercicio y un entrenamiento en la
     * tabla `ExercicisWorkouts`. Primero verifica si los IDs proporcionados
     * existen en las tablas correspondientes. Si alguno de los IDs no existe,
     * la inserción no se lleva a cabo.
     *
     * @param exercicisWorkout el objeto {@link ExercicisWorKouts} que contiene
     * los IDs del ejercicio y el entrenamiento.
     */
    public void insertarRelaciones(ExercicisWorKouts exercicisWorkout) {
        //Primero, verificar si los IDs existen en sus respectivas tablas
        if (!existeId("Exercicis", exercicisWorkout.getIdExercici()) || !existeId("Workouts", exercicisWorkout.getIdWorkouts())) {
            return;  // No continuar con la inserción
        }

        // Si ambos IDs existen, proceder con la inserción en la tabla ExercicisWorkouts
        String sql = "INSERT INTO ExercicisWorkouts (IdExercici, IdWorkout) VALUES (?, ?)";

        try (Connection connection = getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, exercicisWorkout.getIdExercici());  // Set exerciciId
            pstmt.setInt(2, exercicisWorkout.getIdWorkouts());  // Set workoutId
            pstmt.executeUpdate();  // Ejecutar la inserción
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, "Error al insertar la relación entre ejercicios y entrenamientos", ex);
        }
    }

    /**
     * Actualiza el nombre y la descripción de un ejercicio existente en la base
     * de datos.
     *
     * @param id el ID del ejercicio que se quiere actualizar.
     * @param newName el nuevo nombre del ejercicio.
     * @param newDescripcio la nueva descripción del ejercicio.
     */
    public void getUpdateExercici(int id, String newName, String newDescripcio) {
        String sql = "UPDATE Exercicis SET NomExercici = ?, Descripcio = ? WHERE Id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newName);
            stmt.setString(2, newDescripcio);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un ejercicio de la base de datos. Primero elimina las relaciones
     * en la tabla `ExercicisWorkouts` que están asociadas con este ejercicio, y
     * luego elimina el ejercicio en sí desde la tabla `Exercicis`. Utiliza una
     * transacción para garantizar que ambas operaciones se realicen de forma
     * atómica.
     *
     * @param idEjercicio el ID del ejercicio que se desea eliminar.
     */
    public void getDeleteEjercicio(int idEjercicio) {
        // Primero, eliminamos los registros relacionados en ExercicisWorkouts
        String deleteReferencesSql = "DELETE FROM ExercicisWorkouts WHERE IdExercici = ?";
        String deleteEjercicioSql = "DELETE FROM Exercicis WHERE Id = ?";

        try (Connection conn = getConnection()) {
            // Desactivar auto-commit para realizar una transacción
            conn.setAutoCommit(false);

            try (PreparedStatement stmt1 = conn.prepareStatement(deleteReferencesSql); PreparedStatement stmt2 = conn.prepareStatement(deleteEjercicioSql)) {

                // Eliminar referencias en ExercicisWorkouts
                stmt1.setInt(1, idEjercicio);
                stmt1.executeUpdate();

                // Ahora eliminar el ejercicio de Exercicis
                stmt2.setInt(1, idEjercicio);
                stmt2.executeUpdate();

                // Confirmar la transacción
                conn.commit();
            } catch (SQLException e) {
                // Revertir la transacción en caso de error
                conn.rollback();
                throw e;  // Relanzar la excepción para manejarla en otro lugar
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifica si un ID específico existe en una tabla dada.
     *
     * @param tableName el nombre de la tabla en la que se desea verificar la
     * existencia del ID.
     * @param id el ID que se desea verificar.
     * @return true si el ID existe en la tabla, false en caso contrario.
     */
    private boolean existeId(String tableName, int id) {
        String sql = "SELECT COUNT(*) FROM " + tableName + " WHERE Id = ?";
        try (Connection connection = getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;  // Si hay al menos una fila, significa que el ID existe
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, "Error al verificar existencia del ID en la tabla " + tableName, ex);
        }
        return false;
    }

    /**
     * Registra un nuevo usuario en la base de datos.
     *
     * @param u el objeto {@link Usuaris} que contiene los datos del nuevo
     * usuario.
     * @return el ID del nuevo usuario insertado en la base de datos.
     */
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
}