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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Projects Scene Controller.
 * 
 * @author Group 1.
 */
public class ProjectAddController implements Initializable {
    
    /**
     * Item Combo Box.
     */
    @FXML
    ComboBox itemCB;
    
    /**
     * Vendor Combo Box.
     */
    @FXML
    ComboBox vendorCB;
    
    /**
     * Words TextField.
     */
    @FXML
    TextField wordsTF;
    
    /**
     * Words TextField.
     */
    @FXML
    Label messageL;
    
    private Boolean validateForm() {
        Boolean retValue = false;
        
        if (itemCB.getSelectionModel().isEmpty()) {
            messageL.setText("Please, select the item");
        } else if (wordsTF.getCharacters().length() == 0) {
            messageL.setText("Please, inform the words quantity");
        } else if (!wordsTF.getCharacters().toString().matches("[0-9]*")) {
            messageL.setText("Please, inform just numbers in words field");
        } else if (vendorCB.getSelectionModel().isEmpty()) {
            messageL.setText("Please, select the vendor");
        } else {
            retValue = true;
        }
        
        return retValue;
    }
    
    /**
     * Handle Item Combo Box Action.
     * 
     * @param event - ActionEvent
     */
     @FXML
    private void handleItemComboBoxAction(ActionEvent event) throws Exception {
        
        // searches all vendors of the selected item on database and load the vendor combobox with it.
        vendorCB.getItems().addAll(
                "Bek",
                "Khandaa",
                "Rafael");
    }
    
    /**
     * Handle Confirm Button Action.
     * 
     * @param event - ActionEvent
     */
     @FXML
    private void handleConfirmButtonAction(ActionEvent event) throws Exception {
        if (validateForm()) {
            
            // inserts the new Project on database.
            
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Projects.fxml"));
            
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        }
    }
    
    /**
     * Handle Close Button Action.
     * 
     * @param event - ActionEvent
     */
     @FXML
    private void handleCloseButtonAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // searches all items on database and load the item combobox with them.
        itemCB.getItems().addAll(
                "Mongolian to Russian",
                "Russian to Mongolian",
                "English to Russian",
                "Russian to English");
    }
}