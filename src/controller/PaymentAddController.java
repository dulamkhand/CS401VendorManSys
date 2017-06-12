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
import model.invoice.Invoice;
import model.invoice.InvoiceDAO;
import model.payment.PaymentDAO;

/**
 * Projects Scene Controller.
 * 
 * @author Group 1.
 */
public class PaymentAddController implements Initializable {
    
    /**
     * Name TextField.
     */
    @FXML
    TextField codeTF;
    
    /**
     * Rate TextField.
     */
    @FXML
    TextField amountTF;
    
    /**
     * Number Words TextField.
     */
    @FXML
    TextField currencyTF;
    
    /**
     * Service Combo Box.
     */
    @FXML
    ComboBox invoiceCB;
    
    /**
     * Words TextField.
     */
    @FXML
    Label messageL;
    
    private Boolean validateForm() {
        Boolean retValue = false;
        
        if (codeTF.getCharacters().length() == 0) {
            messageL.setText("Please, inform the code");
        } if (amountTF.getCharacters().length() == 0) {
            messageL.setText("Please, inform the amount");
        } if (currencyTF.getCharacters().length() == 0) {
            messageL.setText("Please, inform the currency");
        } else if (invoiceCB.getSelectionModel().isEmpty()) {
            messageL.setText("Please, select the invoice");
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
            
            PaymentDAO.insert(codeTF.getText(), new Double(amountTF.getText()), currencyTF.getText(),
                    ((String) invoiceCB.getSelectionModel().getSelectedItem()));
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/Payment.fxml"));  
            AnchorPane achorPane = (AnchorPane) loader.load();

            RootLayoutController.borderPane.setCenter(achorPane);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Invoice combobox.
        List<String> invoiceNameList = new ArrayList<String>();
        ObservableList<Invoice> invoiceOL = null;
        
        try {
            invoiceOL = FXCollections.observableList(InvoiceDAO.list());
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProjectsController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        for (Invoice invoice : invoiceOL) {
            invoiceNameList.add(invoice.getName().get());
        }
        
        invoiceCB.getItems().addAll(invoiceNameList);
    }
}