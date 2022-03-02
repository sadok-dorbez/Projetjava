/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author sadok
 */
public class AfficherVetController implements Initializable {

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtAdress;
    @FXML
    private TextField txtDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setTxtId(String message){
        this.txtId.setText(message);
    }
    public void setTxtNom(String message){
        this.txtNom.setText(message);
    }
    public void setTxtPrenom(String message){
        this.txtPrenom.setText(message);
    }
    public void setTxtEmail(String message){
        this.txtEmail.setText(message);
    }
    public void setTxtAdress(String message){
        this.txtAdress.setText(message);
    }
    
    public void setTxtDate(Date message){
        this.txtDate.setText(""+message);
    }

}
