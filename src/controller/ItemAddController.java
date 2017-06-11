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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.item.ItemDAO;
import model.servicetype.ServiceType;
import model.servicetype.ServiceTypeDAO;

/**
 * Projects Scene Controller.
 * 
 * @author Group 1.
 */
public class ItemAddController implements Initializable {
    
    /**
     * Name TextField.
     */
    @FXML
    TextField nameTF;
    
    /**
     * Rate TextField.
     */
    @FXML
    TextField rateTF;
    
    /**
     * Number Words TextField.
     */
    @FXML
    TextField numberWordsTF;
    
    /**
     * Service Combo Box.
     */
    @FXML
    ComboBox serviceCB;
    
    /**
     * Words TextField.
     */
    @FXML
    Label messageL;
    
    private Boolean validateForm() {
        Boolean retValue = false;
        
        if (nameTF.getCharacters().length() == 0) {
            messageL.setText("Please, inform the name");
        } if (rateTF.getCharacters().length() == 0) {
            messageL.setText("Please, inform the rate");
        } if (numberWordsTF.getCharacters().length() == 0) {
            messageL.setText("Please, inform the number of words");
        } else if (serviceCB.getSelectionModel().isEmpty()) {
            messageL.setText("Please, select the service");
        } else {
            retValue = true;
        }
        
        return retValue;
    }
    
    /**
     * Handle Confirm Button Action.
     * 
     * @param event - ActionEvent
     */
     @FXML
    private void handleConfirmButtonAction(ActionEvent event) throws Exception {
        if (validateForm()) {
            
            ItemDAO.insert(nameTF.getText(), new Double(rateTF.getText()), new Integer(numberWordsTF.getText()),
                    ((String) serviceCB.getSelectionModel().getSelectedItem()));
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/Items.fxml"));  
            AnchorPane achorPane = (AnchorPane) loader.load();

            RootLayoutController.borderPane.setCenter(achorPane);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Service combobox.
        List<String> serviceNameList = new ArrayList<String>();
        ObservableList<ServiceType> serviceOL = null;
        
        try {
            serviceOL = FXCollections.observableList(ServiceTypeDAO.list());
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProjectsController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        for (ServiceType service : serviceOL) {
            serviceNameList.add(service.getName());
        }
        
        serviceCB.getItems().addAll(serviceNameList);
    }
}