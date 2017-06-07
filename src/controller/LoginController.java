/**
 * Maharishi University Of Management, MSCS, April 2017 Entry
 * MPP Course, Professor Shafqat, Group 1:
 * Bek
 * Khandaa
 * Rafael
 * 
 * Vendor Management System
 * June of 2017
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Login Controller.
 * 
 * @author Group 1.
 */
public class LoginController implements Initializable {
    
    /**
     * Username - TextField.
     */
    @FXML
    private TextField usernameTF;
    
    /**
     * Password - PasswordField.
     */
    @FXML
    private PasswordField passwordPF;
    
    /**
     * Message - Label.
     */
    @FXML
    private Label messageL;
    
    /**
     * User Type - String.
     */
    private String userType = "E";
    
    /**
     * Validate Form.
     * 
     * @return Boolean
     */
    private Boolean validateForm() {
        Boolean retValue = false;
        
        if (usernameTF.getCharacters().length() == 0) {
            messageL.setText("Please, inform the username");
        } else if (passwordPF.getCharacters().length() == 0) {
            messageL.setText("Please, inform the password");
        } else {
            retValue = true;
        }
        
        return retValue;
    }
    
    /**
     * Validate User.
     * 
     * @return Boolean
     */
    private Boolean validateUser() {
        Boolean retValue = false;
        
        // validate user on database.
        retValue = true;
        
        return retValue;
    }
    
    /**
     * Handle Reset Button Action.
     * 
     * @param event - ActionEvent
     */
    @FXML
    private void handleResetButtonAction(ActionEvent event) {
        usernameTF.clear();
        passwordPF.clear();
    }
    
    /**
     * Handle Login Button Action.
     * 
     * @param event - ActionEvent
     */
     @FXML
    private void handleLoginButtonAction(ActionEvent event) throws Exception {
        if (validateForm() && validateUser()) {
            if (userType.equals("E")) {
                //root = FXMLLoader.load(getClass().getResource("view/Employee.fxml"));
                new RootLayoutController().go2homepage(event); // redirects to homepage once logged in
            } else {
                //root = FXMLLoader.load(getClass().getResource("view/Vendor.fxml"));
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}