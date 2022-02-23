/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import BD.DataBase;
import entity.Dresseur;
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
public class ServiceDresseur {
    
    private Connection con;
    private Statement ste;
    private PreparedStatement pst;
    public ServiceDresseur(){
            con = DataBase.getInstance().getConnection();
    }
    public  boolean ajouterDresseur(Dresseur dre) throws SQLException  {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd") ; 
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        String requeteInsert1 = "INSERT INTO `pi`.`dresseur` ( `nom`,`prenom`, `specialite`,`address`,`email`,`date`, `num`) VALUES ( '" + dre.getNom()+ "','" + dre.getPrenom()+ "','" + dre.getSpecialite()+ "','" + dre.getAddress()+ "','" + dre.getEmail()+ "','" + date + "'," + dre.getNum() + " );";
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
         
       }
       finally{ste.close();}
       
       return false;         
  
        
        
    }
       public boolean deleteDresseur(Dresseur dre ) throws SQLException  {
       try {
           ste=con.createStatement();
       
           String sql="DELETE FROM `pi`.`dresseur` WHERE id="+dre.getId();  
           if(ste.executeUpdate(sql)==1){
               System.out.println("line deleted ");
               return true;
               
           }
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
     finally{ste.close();}
      return false;  
    }
       public ArrayList<Dresseur> afficherDresseur() {
           Statement statment;
           ArrayList<Dresseur> list = new ArrayList<Dresseur>();
                   try {
      
                       statment = con.createStatement();
                       ResultSet rs = statment.executeQuery("select * from dresseur");
                       while(rs.next()) {
                           Dresseur dre = new Dresseur(rs.getInt("id"), rs.getString("nom"),rs.getString("prenom"),rs.getString("specialite"), rs.getString("email"), rs.getString("address"), rs.getString("date"),rs.getInt("num"));
                           list.add(dre);
                           
                           
                       }
                   } catch (SQLException ex) {
                       System.out.println(ex.getMessage());
                      
                   }
             
                   return list;
           
       }
       /*
   public  boolean updateDresseur(Dresseur dre) throws SQLException  {


        
        String requeteInsert1 = "UPDATE `pi`.`dresseur` Where 	id=?";
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
       
       }
       finally{ste.close();}
       
       return false;         
  
        
        
    }
*/
   public void modifierDresseur(Dresseur dre){
       String req="UPDATE dresseur set nom=?,prenom=?,specialite=?,email=?,address=?,date=?,num=? WHERE id=?";
       PreparedStatement pst;
       try {
           pst = con.prepareStatement(req);
           pst.setString(1, dre.getNom());
           pst.setString(2, dre.getPrenom());
           pst.setString(3, dre.getSpecialite());
           pst.setString(4, dre.getEmail());
           pst.setString(5, dre.getAddress());
           pst.setString(6,dre.getDate());
           pst.setInt(7, dre.getNum());
           pst.setInt(8, dre.getId());
           pst.executeUpdate();
           System.out.println("modification avec succes");
           
       }catch (SQLException ex){
           System.err.println(ex.getMessage());
       }
   }
        

     
 
    
}
