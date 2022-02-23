/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import BD.DataBase;
import entity.Veterinaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sadok
 */
public class ServiceVeterinaire {
    
               private Connection con;
    private Statement ste;
    private PreparedStatement pst;
    public ServiceVeterinaire(){
            con = DataBase.getInstance().getConnection();
    }
    public  boolean ajouterVeterinaire(Veterinaire vet) throws SQLException  {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd") ; 
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        String requeteInsert1 = "INSERT INTO `pi`.`veterinaire` ( `nom`,`prenom`,`address`,`email`,`date`) VALUES ( '" + vet.getNom()+ "','" + vet.getPrenom()+ "','" + vet.getAddress()+ "','" + vet.getEmail()+ "','" + date + "' );";
       try {
           ste = con.createStatement();
           if(ste.executeUpdate(requeteInsert1)==1){
               System.out.println("line inserted");
               ste.close(); 
               return true;
            }
           
       } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
         //  Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
       }
       finally{ste.close();}
       
       return false;         
  
        
        
    }
       public boolean deleteVeterinaire(Veterinaire vet) throws SQLException  {
       try {
           ste=con.createStatement();
       
           String sql="DELETE FROM `pi`.`veterinaire` WHERE id="+vet.getId();  
           if(ste.executeUpdate(sql)==1){
               System.out.println("line deleted ");
               return true;
               
           }
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
            //   Logger.getLogger(ServiceReponse.class.getName()).log(Level.SEVERE, null, ex);
       }
     finally{ste.close();}
      return false;  
    }
       public ArrayList<Veterinaire> afficherVeterinaire() {
           Statement statment;
           ArrayList<Veterinaire> list = new ArrayList<Veterinaire>();
                   try {
      
                       statment = con.createStatement();
                       ResultSet rs = statment.executeQuery("select * from veterinaire");
                       while(rs.next()) {
                           Veterinaire vet = new Veterinaire(rs.getInt("id"), rs.getString("nom"),rs.getString("prenom"), rs.getString("email"), rs.getString("address"), rs.getString("date"));
                           list.add(vet);
                           
                           
                       }
                   } catch (SQLException ex) {
                       System.out.println(ex.getMessage());
                       //Logger.getLogger(ServiceVeterinaire.class.getName()).log(Level.SEVERE, null, ex);
                   }
             
                   return list;
           
       }
   public  boolean updateVeterinaire(Veterinaire vet) throws SQLException  {


        
        String requeteInsert1 = "UPDATE `pi`.`veterinaire` ";
       try {
           ste = con.createStatement();
           if(ste.executeUpdate(requeteInsert1)==1){
               System.out.println("line inserted");
               ste.close(); 
               return true;
            }
           
       } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
         //  Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
       }
       finally{ste.close();}
       
       return false;         
  
        
        
    }
        

     
 
    
}
