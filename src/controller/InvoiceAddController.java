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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.invoice.InvoiceDAO;

/**
 * Projects Scene Controller.
 * 
 * @author Group 1.
 */
public class InvoiceAddController implements Initializable {
    
    @FXML
    TextField nameTF;
   
    @FXML
    TextField amountTF;
    
    @FXML
    TextField currencyTF;
    
    @FXML
    ComboBox statusCB;
  
    @FXML
    Label messageL;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            //projectCB.getItems().addAll(OrderProjectDAO.getProjectItems());
            
            //currencyCB.getItems().addAll("USD", "MNT", "RUR", "AUD");
            
            statusCB.getItems().addAll("Active", "In Progress", "Fully");
            
        } catch (Exception ex) {
            Logger.getLogger(OrderAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Boolean validateForm() {
        Boolean retValue = true;
        StringBuilder sb = new StringBuilder();
        
        if (nameTF.getCharacters().toString().isEmpty()) {
            sb.append("\nName is required.");
            retValue = false;
        }
        if (statusCB.getSelectionModel().isEmpty()) {
            sb.append("\nStatus is required.");
            retValue = false;
        } 
        
        if (!retValue) messageL.setText(sb.toString());
        return retValue;
    }
    
    @FXML
    private void back(ActionEvent event) throws Exception {
        Main.rootLayoutController.go2invoices(event);
    }
   
    @FXML
    private void confirm(ActionEvent event) throws Exception {
        if (validateForm()) {
            // inserts into db
            InvoiceDAO.insert(nameTF.getCharacters().toString(), Double.parseDouble(amountTF.getCharacters().toString()),
                    nameTF.getCharacters().toString(), 3);
            Main.rootLayoutController.go2orders(event);
        }
        
    }
}