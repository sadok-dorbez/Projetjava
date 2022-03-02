/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import BD.DataBase;
import entity.RateVet;
import entity.User;
import entity.Veterinaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 *
 * @author sadok
 */
public class ServiceRateVet {
    private Connection con;
    private Statement ste;
    private PreparedStatement pst;
    public ServiceRateVet(){
            con = DataBase.getInstance().getConnection();
    }
    public  boolean ajouterRateVet(RateVet rate) throws SQLException  {

        String requeteInsert1 = "INSERT INTO `pi`.`ratevet` ( `ratevalue`,`userid`, `vetid`) VALUES ( '" + rate.getRateValue()+ "','" + rate.getUserId().getId()+ "','" + rate.getVetId().getId()+ "' );";
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
       public boolean deleteRate(RateVet rate ) throws SQLException  {
       try {
           ste=con.createStatement();
       
           String sql="DELETE FROM `pi`.`ratevet` WHERE id="+rate.getId();  
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
       public HashMap<Veterinaire,Double> afficherRateVet() {
           Statement statment;
           HashMap<Veterinaire,ArrayList<RateVet>> map = new HashMap<>();
           HashMap<Veterinaire,Double> p = new HashMap<>();  
                         
                   try {
      
                       statment = con.createStatement();
                       ResultSet rs = statment.executeQuery("select veterinaire.id as vetid,veterinaire.nom,veterinaire.prenom,veterinaire.email,veterinaire.address,veterinaire.date,ratevet.rateValue ,ratevet.id as rateid from veterinaire inner join ratevet on veterinaire.id=ratevet.vetid;");
                       while(rs.next()) {
                           Veterinaire vet = new Veterinaire(rs.getInt("vetid"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("address"), rs.getString("date"));
                          
                           RateVet rate = new RateVet(rs.getInt("rateid"),rs.getInt("ratevalue"), new User(0,"",""), vet);
                           if(map.containsKey(vet)){
                            map.get(vet).add(rate);
                           } 
                           else{
                               ArrayList<RateVet> list = new ArrayList<>();
                               list.add(rate);
                               
                               map.put(vet,list);
                           }
                         
                           
                       }
                       
                        map.entrySet().stream().map((t) -> { //att c,v
                                
                             double a = t.getValue().stream().map(m->m.getRateValue()).reduce(0,(e, u) -> {   //tlem
                                   
                                   return (e+u); //To change body of generated lambdas, choose Tools | Templates.
                               });
                             a= a/t.getValue().size();
                               
                               HashMap<Veterinaire,Double> finalMap = new HashMap<>();
                               finalMap.put(t.getKey(), a);
                               return  finalMap.entrySet().stream().findFirst();
                               
                           }).forEach((t) -> {
                               p.put(t.get().getKey(),t.get().getValue());
                          });
                   } catch (SQLException ex) {
                       System.out.println(ex.getMessage());
                      
                   }
             
                   return p;
           
       }
       public HashMap<Veterinaire,Double> getMostRatedVet(){
            HashMap<Veterinaire,Double> rate = afficherRateVet();
            HashMap<Veterinaire,Double> finalMap = new HashMap<>();
            rate.entrySet().stream().sorted((o1, o2) -> {
                
                return o1.getValue().compareTo(o2.getValue()); //To change body of generated lambdas, choose Tools | Templates.
            }).forEach((t) -> {
                finalMap.put(t.getKey(), t.getValue());
            });
              return finalMap;      
                    
           
           
           
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
  
    
    
    
    
}
