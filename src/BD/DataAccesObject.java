package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sadok
 */
public class DataAccesObject {
   
   private DataBase database=new DataBase();
   private ResultSet rs;
   private PreparedStatement pstmt;
   private Connection con;
   public DataAccesObject()
   {
       
   }
   public void saveData(String query){
           con=database.getConnection();
       try {
           pstmt=con.prepareStatement(query);
           pstmt.executeUpdate();
       } catch (SQLException ex) {
ex.printStackTrace();       }
      
           }
}
