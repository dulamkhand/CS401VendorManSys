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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * Projects Scene Controller.
 * 
 * @author Group 1.
 */
public class OrderAddSceneController implements Initializable {
    
    /**
     * Vendor Combo Box.
     */
    ComboBox vendorCB;
    
    /**
     * Item Combo Box.
     */
    ComboBox itemCB;
    
    /**
     * Handle Item Combo Box Action.
     * 
     * @param event - ActionEvent
     */
     @FXML
    private void handleItemComboBoxAction(ActionEvent event) throws Exception {
        // searches all vendors of the selected item and load the vendor combobox with it.
        List<String> itemList = new ArrayList<String>();
        
        itemList.add("Bek");
        itemList.add("Khandaa");
        itemList.add("Rafael");
        
        vendorCB.getItems().addAll(itemList);
    }
    
    /**
     * Handle Confirm Button Action.
     * 
     * @param event - ActionEvent
     */
     @FXML
    private void handleConfirmButtonAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ProjectsScene.fxml"));

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
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
        // searches all vendors of the selected item and load the vendor combobox with it.
        ObservableList<String> itemList = FXCollections.observableArrayList(
                "Mongolian to Russian",
                "Russian to Mongolian",
                "English to Russian",
                "Russian to English");
        
        itemCB = new ComboBox(itemList);
    }   
}