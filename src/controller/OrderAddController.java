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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.order.OrderDAO;
import model.order.OrderProjectDAO;

/**
 * Projects Scene Controller.
 * 
 * @author Group 1.
 */
public class OrderAddController implements Initializable {
   
    @FXML
    ComboBox projectCB;
   
    @FXML
    TextField amountTF;
    
    @FXML
    ComboBox currencyCB;
    
    @FXML
    ComboBox statusCB;
  
    @FXML
    Label messageL;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            projectCB.getItems().addAll(OrderProjectDAO.getProjectItems());
            
            currencyCB.getItems().addAll("USD", "MNT", "RUR", "AUD");
            
            statusCB.getItems().addAll("Active", "In Progress", "Fully");
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(OrderAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Boolean validateForm() {
        Boolean retValue = true;
        StringBuilder sb = new StringBuilder();
        
        if (projectCB.getSelectionModel().isEmpty()) {
            sb.append("\nProject is required.");
            retValue = false;
        }
//        if (!amountTF.getCharacters().toString().matches("[0-9]*")) {
//            sb.append("\nAmount is required.");
//            retValue = false;
//        } 
//        if (currencyCB.getSelectionModel().isEmpty()) {
//            sb.append("\nCurrency is required.");
//            retValue = false;
//        } 
        if (statusCB.getSelectionModel().isEmpty()) {
            sb.append("\nStatus is required.");
            retValue = false;
        } 
        
        if (!retValue) messageL.setText(sb.toString());
        return retValue;
    }
    
    @FXML
    private void back(ActionEvent event) throws Exception {
        Main.rootLayoutController.go2orders(event);
    }
   
    @FXML
    private void confirm(ActionEvent event) throws Exception {
        if (validateForm()) {
            // inserts into db
            //System.out.println(projectCB.getSelectionModel().getSelectedIndex());
            //System.out.println(projectCB.getSelectionModel().getSelectedItem());
            //System.out.println(amountTF.getCharacters().toString());
            //System.out.println(currencyCB.getValue().toString());
        
            OrderDAO.insert(2, Double.parseDouble(amountTF.getCharacters().toString()), 
                    currencyCB.getValue().toString(), 3);
            Main.rootLayoutController.go2orders(event);
        }
        
    }
    
    
    
}