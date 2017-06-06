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
package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Login Scene Controller.
 * 
 * @author Group 1.
 */
public class LoginSceneController implements Initializable {
    
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
        Parent root = null;
        Scene scene = null;
        Stage stage = null;
        
        if (validateForm() && validateUser()) {
            if (userType.equals("E")) {
                root = FXMLLoader.load(getClass().getResource("EmployeeScene.fxml"));
            } else {
                //root = FXMLLoader.load(getClass().getResource("VendorScene.fxml"));
            }
            
            scene = new Scene(root);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}