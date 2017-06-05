/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DialogPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Khandaa
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField loginTF;
    
    @FXML
    private PasswordField passwordPF;
    
    @FXML
    private DialogPane loginErrorDP;
    
    @FXML
    private void handleResetButtonAction(ActionEvent event) {
        loginTF.clear();
        passwordPF.clear();
    }
    
     @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        if (loginTF.getCharacters().length() == 0) {
            loginErrorDP.setVisible(true);
        }
        
        // calls next screen.
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
