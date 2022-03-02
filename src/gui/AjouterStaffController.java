/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entity.Veterinaire;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.ServiceVeterinaire;

/**
 * FXML Controller class
 *
 * @author sadok
 */
public class AjouterStaffController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfAdress;
    @FXML
    private Button btnValider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveVet(ActionEvent event) throws SQLException {
        String Nom = tfNom.getText();
        String Prenom = tfPrenom.getText();
        String Adress = tfAdress.getText();
        String Email = tfEmail.getText();
        DataValidation validator = new DataValidation();
         if (validator.isNotEmpty(tfEmail)  && validator.isNotEmpty(tfNom)
               && validator.isNotEmpty(tfAdress) && validator.isNotEmpty(tfPrenom) ) {

            if (validator.emailFormat(tfEmail) 
                    && validator.textAlphabet(tfNom) && validator.textAlphabet(tfPrenom)) {
                
        Veterinaire vet = new Veterinaire(0, Nom, Prenom, Email, Adress, Email);
        ServiceVeterinaire sv = new ServiceVeterinaire();
        sv.ajouterVeterinaire(vet);
        
        FXMLLoader loader = 
                new FXMLLoader(getClass().getResource("AfficherVet.fxml"));
            
         
        try {
            Parent root = loader.load();
            AfficherVetController dwc =loader.getController();
            dwc.setTxtId(""+vet.getId());
            dwc.setTxtNom(vet.getNom());
            dwc.setTxtPrenom(vet.getPrenom());
            dwc.setTxtEmail(vet.getEmail());
            dwc.setTxtId(vet.getDate());
            
            
           
        } catch (IOException ex) {
            System.out.println("Error:"+ex.getMessage()); 
            }
    }
}
    }
}   
/*
private void addModerateur1() {
        DataValidation validator = new DataValidation();

        String id_moderateur = tfidmoderateur.getText();
        String nom = tfnom.getText();
        String prenom = tfprenom.getText();
        String myDate = String.valueOf(tfdatenaissance.getValue());
        String email = tfemail.getText();
        int telephone = Integer.parseInt(tftelephone.getText());
        String password = tfpassword.getText();
        if (validator.isNotEmpty(tfemail) && validator.isNotEmpty(tfpassword) && validator.isNotEmpty(tfnom)
                && validator.isNotEmpty(tfprenom) && validator.isNotEmpty(tftelephone) && validator.isNotEmpty(tfdatenaissance.getEditor())) {

            if (validator.emailFormat(tfemail) && validator.textNumeric(tftelephone) && validator.dataLength(tftelephone, "8")
                    && validator.textAlphabet(tfnom) && validator.textAlphabet(tfprenom)) {

                Authentification aa = new Authentification();
                ModerateurCRUD mc = new ModerateurCRUD();
                Moderateur m = new Moderateur(nom, prenom, java.sql.Date.valueOf(myDate), email, telephone, aa.hashagePWD(password));

                mc.ajouterModerateur(m);
                showModerateur();
            }

        }
    }



*/
