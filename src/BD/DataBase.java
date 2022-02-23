package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author sadok
 */
public class DataBase {
     String url = "jdbc:mysql://localhost:3306/pi";
     
     String login = "root";
     String pwd = "";
    public  static DataBase db;
    public Connection con;
    public DataBase() {
         try {
             con=DriverManager.getConnection(url, login, pwd);
             System.out.println("connexion etablie");
         } catch (SQLException ex) {
             System.out.println(ex);
         }
    }
    
    public Connection  getConnection()
    {
    return con;
    }     
    public static DataBase getInstance()
    {if(db==null)
        db=new DataBase();
    return db;
    }     
}