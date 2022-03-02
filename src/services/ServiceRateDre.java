/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import BD.DataBase;
import entity.RateDre;
import entity.User;
import entity.Dresseur;
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
public class ServiceRateDre {
    private Connection con;
    private Statement ste;
    private PreparedStatement pst;
    public ServiceRateDre(){
            con = DataBase.getInstance().getConnection();
    }
    public  boolean ajouterRateDre(RateDre rate) throws SQLException  {

        String requeteInsert1 = "INSERT INTO `pi`.`ratedre` ( `ratevalue`,`userid`, `vetid`) VALUES ( '" + rate.getRateValue()+ "','" + rate.getUserId().getId()+ "','" + rate.getDreId().getId()+ "' );";
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
       public boolean deleteRate(RateDre rate ) throws SQLException  {
       try {
           ste=con.createStatement();
       
           String sql="DELETE FROM `pi`.`ratedre` WHERE id="+rate.getId();  
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
       public HashMap<Dresseur,Double> afficherRateDre() {
           Statement statment;
           HashMap<Dresseur,ArrayList<RateDre>> map = new HashMap<>();
           HashMap<Dresseur,Double> p = new HashMap<>();  
                         
                   try {
      
                       statment = con.createStatement();
                       ResultSet rs = statment.executeQuery("select dresseur.id as dreid,dresseur.nom,dresseur.prenom,dresseur.specialite,dresseur.email,dresseur.address,dresseur.date,dresseur.num,ratedre.rateValue ,ratedre.id as rateid from dresseur inner join ratedre on dresseur.id=ratedre.dreid;");
                       while(rs.next()) {
                           Dresseur dre = new Dresseur(rs.getInt("dreid"), rs.getString("nom"), rs.getString("prenom"),rs.getString("specialite") ,rs.getString("email"), rs.getString("address"), rs.getString("date"),rs.getInt("num"));
                          
                           RateDre rate = new RateDre(rs.getInt("rateid"),rs.getInt("ratevalue"), new User(0,"",""), dre);
                           if(map.containsKey(dre)){
                            map.get(dre).add(rate);
                           } 
                           else{
                               ArrayList<RateDre> list = new ArrayList<>();
                               list.add(rate);
                               
                               map.put(dre,list);
                           }
                         
                           
                       }
                       
                        map.entrySet().stream().map((t) -> {
                                
                             double a = t.getValue().stream().map(m->m.getRateValue()).reduce(0,(e, u) -> {
                                   
                                   return (e+u); //To change body of generated lambdas, choose Tools | Templates.
                               });
                             a= a/t.getValue().size();
                               
                               HashMap<Dresseur,Double> finalMap = new HashMap<>();
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
       public HashMap<Dresseur,Double> getMostRatedDressers(){
            HashMap<Dresseur,Double> rate = afficherRateDre();
            HashMap<Dresseur,Double> finalMap = new HashMap<>();
            rate.entrySet().stream().sorted((o1, o2) -> {
                
                return o1.getValue().compareTo(o2.getValue()); //To change body of generated lambdas, choose Tools | Templates.
            }).forEach((t) -> {
                finalMap.put(t.getKey(), t.getValue());
            });
              return finalMap;      
                    
           
           
           
       }
}