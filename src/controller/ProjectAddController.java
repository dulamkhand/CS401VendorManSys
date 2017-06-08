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
import model.item.Item;
import model.item.ItemDAO;
import model.project.ProjectDAO;
import model.servicetype.ServiceType;
import model.servicetype.ServiceTypeDAO;

/**
 * Projects Scene Controller.
 * 
 * @author Group 1.
 */
public class ProjectAddController implements Initializable {
    
    /**
     * Words TextField.
     */
    @FXML
    TextField titleTF;
    
    /**
     * Service Combo Box.
     */
    @FXML
    ComboBox serviceCB;
    
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
    //@FXML
    //TextField wordsTF;
    
    /**
     * Words TextField.
     */
    @FXML
    Label messageL;
    
    private Boolean validateForm() {
        Boolean retValue = false;
        
        if (titleTF.getCharacters().length() == 0) {
            messageL.setText("Please, inform the title");
        } else if (serviceCB.getSelectionModel().isEmpty()) {
            messageL.setText("Please, select the item");
        /*} else if (wordsTF.getCharacters().length() == 0) {
            messageL.setText("Please, inform the words quantity");
        } else if (!wordsTF.getCharacters().toString().matches("[0-9]*")) {
            messageL.setText("Please, inform just numbers in words field");
        } else if (vendorCB.getSelectionModel().isEmpty()) {
            messageL.setText("Please, select the vendor");*/
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
    private void handleServiceComboBoxAction(ActionEvent event) throws Exception {
        List<String> itemNameList = new ArrayList<String>();
        ObservableList<Item> itemOL = null;
        
        try {
            itemOL = FXCollections.observableList(ItemDAO.listAvailable((String) serviceCB.getSelectionModel().getSelectedItem()));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProjectsController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        for (Item item : itemOL) {
            itemNameList.add(item.getName().getValue());
        }
        
        itemCB.getItems().clear();
        itemCB.getItems().addAll(itemNameList);
    }
    
    /**
     * Handle Confirm Button Action.
     * 
     * @param event - ActionEvent
     */
     @FXML
    private void handleConfirmButtonAction(ActionEvent event) throws Exception {
        Item item = null;
        
        if (validateForm()) {
            ProjectDAO.insert(titleTF.getText(), null, null, null);
            
            item = ItemDAO.find((String) itemCB.getSelectionModel().getSelectedItem());
            item.setProject(ProjectDAO.find(titleTF.getText()));
            
            ItemDAO.update(item.getId().getValue(), item.getProject().getId().intValue(),
                       item.getName().getValue(), item.getNumberWords().getValue());
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/Projects.fxml"));  
            AnchorPane achorPane = (AnchorPane) loader.load();

            RootLayoutController.borderPane.setCenter(achorPane);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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