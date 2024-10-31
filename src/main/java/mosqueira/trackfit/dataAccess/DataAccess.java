package mosqueira.trackfit.dataAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import mosqueira.trackfit.dto.Usuari;


/**
 *
 * @author Lulas
 */
    public class DataAccess {

    public static Connection getConnection(){
        Connection connection = null;
        Properties properties=new Properties();
        
        try {
          properties.load(DataAccess.class.getClassLoader().getResourceAsStream("properties/application.properties"));
          //String connectionString = "jdbc:sqlserver://localhost:1433;database=simulapdb;user=sa;" + "password=Pwd1234;encrypt=false;trustServerCertificate=true;";
          String connectionUrl=properties.getProperty("connectionUrl");
          connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
           // Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, e);
           e.printStackTrace();
        }
        return connection;
    }
   
    public ArrayList<Usuari>getUsuarios(){
        ArrayList<Usuari> usuarios =new ArrayList<>();
        String sql= "SELECT * FROM Usuaris";
        Connection connection =getConnection(); 
        try {
            PreparedStatement selectStatement = connection.prepareStatement(sql);
                ResultSet resultSet=selectStatement.executeQuery();
                while(resultSet.next()){
                    Usuari user=new Usuari();
                    user.setId(resultSet.getInt("Id"));
                    user.setNom(resultSet.getString("Nom"));
                    user.setEmail(resultSet.getString("Email"));
                    user.setPasswordHash(resultSet.getString("PasswordHash"));
                    
                    //user.setFoto("Foto");
                    user.setInstructor(resultSet.getBoolean("Instructor"));
                    usuarios.add(user);
                }
                selectStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
   
    public static Usuari getUsuario(String email){
        Usuari user =new Usuari();
        String sql= "SELECT * FROM Usuaris WHERE Email=?";
        Connection connection =getConnection(); 
        try {
            PreparedStatement selectStatement = connection.prepareStatement(sql);
                selectStatement.setString(1,email);
                ResultSet resultSet=selectStatement.executeQuery();
                while(resultSet.next()){
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
    public int registerUser (Usuari u){
        int newUserId=0;
        Connection connection= getConnection();
        String sql= "INSERT INTO Usuaris(NOm,Email,PasswordHash,Instructor)"+
                "VALUES(?,?,?,?)";
         try {
             PreparedStatement insertStatement=connection.prepareStatement(sql);
             insertStatement.setString(1,u.getNom());
             insertStatement.setString(2,u.getEmail());
             insertStatement.setString(3, u.getPasswordHash());
             insertStatement.setBoolean(4, u.Instructor());
             newUserId=insertStatement.executeUpdate();
             
             insertStatement.close();
             connection.close();
             
         } catch (SQLException ex) {
             Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
         }
        return newUserId;
    }

    public int getLastInsertedUserId(){
        String sql= "SELECT MAX(Id) FROM Usuaris";
        int userId=0;
        Connection connection =getConnection(); 
            try {
                PreparedStatement selectStatement = connection.prepareStatement(sql);
                ResultSet resultSet=selectStatement.executeQuery();
                while(resultSet.next()){
                    userId=resultSet.getInt(1);
                }
                selectStatement.close();
                connection.close();
            }catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userId;
    }
}