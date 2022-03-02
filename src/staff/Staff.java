/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;

import BD.DataBase;
import entity.Dresseur;
import entity.RateVet;
import entity.User;
import entity.Veterinaire;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import services.ServiceDresseur;
import services.ServiceRateVet;
import services.ServiceVeterinaire;

/**
 *
 * @author sadok
 */
public class Staff extends Application{

   
    @Override
    public void start(Stage primaryStage) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("AjouterVet.fxml"));
                    
                    Scene scene = new Scene(root);
                    
                    primaryStage.setTitle("Ajouter un véterinaire");
                    primaryStage.setScene(scene);
                    primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }




//int connectedUser  = 1;
      
     
        /*while(true){
            System.out.println("1-ajouter un vet");            
            System.out.println("2-supprimer un vet");  
            System.out.println("3-afficher les vets");  
            System.out.println("4-quit!!!");  
            
            System.out.println("do your thing ..:)");       
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    

            int choice = Integer.parseInt(myObj.nextLine());  // Read user input
           // x=choice;
            if(choice==1){
                   ServiceVeterinaire sv = new ServiceVeterinaire();
                   Veterinaire vet = new Veterinaire(1, "test","test", "test", "test","2022-02-02");
                   try {
                       sv.ajouterVeterinaire(vet);
                   } catch (SQLException ex) {
                       System.out.println(ex.getMessage());
           //    Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
                   }
            }
            else if(choice==2){
                   ServiceVeterinaire sv = new ServiceVeterinaire();
                   Veterinaire vet = new Veterinaire(1, "test","test", "test", "test","2022-02-02");
                   try {
                       sv.deleteVeterinaire(vet);
                   } catch (SQLException ex) {
                       System.out.println(ex.getMessage());
           //    Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
                   } 
            }
            else if(choice==3){
                   ServiceVeterinaire sv = new ServiceVeterinaire();
                   System.out.println(sv.afficherVeterinaire());
            }
      
            else{
                break;
            }
            
           
 
        }*/
   /*while(true){
            System.out.println("1-ajouter un dre");            
            System.out.println("2-supprimer un dre");  
            System.out.println("3-afficher les dres");  
            System.out.println("4-modifier un dre");  
            System.out.println("5-Quitt");  

            System.out.println("do your thing ..:)");       
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    

            int choice = Integer.parseInt(myObj.nextLine());  // Read user input
           // x=choice;
            if(choice==1){
                   ServiceDresseur sd = new ServiceDresseur();
                   Dresseur dre = new Dresseur(1, "test","test","test", "test", "test","2022-02-02",2222);
                   try {
                       sd.ajouterDresseur(dre);
                   } catch (SQLException ex) {
                       System.out.println(ex.getMessage());
           //    Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
                   }
            }
            else if(choice==2){
                   ServiceDresseur sd = new ServiceDresseur();
                   Dresseur dre = new Dresseur(2, "test","test","test", "test", "test","2022-02-02",2222);
                   try {
                       sd.deleteDresseur(dre);
                   } catch (SQLException ex) {
                       System.out.println(ex.getMessage());
           //    Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
                   } 
            }
            else if(choice==3){
                   ServiceDresseur sd = new ServiceDresseur();
                   System.out.println(sd.afficherDresseur());
            }
      
            else if(choice==4){
             ServiceDresseur sd = new ServiceDresseur();
             Dresseur dre = new Dresseur(3, "test","test","test", "test", "test","2022-02-02",2222);
             dre.setId(2);
             dre.setNom("esprit");
             sd.modifierDresseur(dre);
                
            }
            else{
       break;
   }
    }*/
//String regex= "^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+[.]+[A-Za-z0-9+_.-]+$"; 
//        Pattern pattern = Pattern.compile(regex);
// 
//        String email="a@esprit";
//        Matcher matcher = pattern.matcher(email);
//
    
    
    
    
//            System.out.println(matcher.matches());
//ServiceRateVet sr = new ServiceRateVet();
//           Veterinaire vet = new Veterinaire(5, "test", "test", "test", "test", "test");
//           User user = new User(connectedUser, "test", "test");
//           RateVet rate = new RateVet(0, 0, user, vet);
//sr.ajouterRateVet(rate);
//            System.out.println(sr.afficherRateVet());
    
    



}
