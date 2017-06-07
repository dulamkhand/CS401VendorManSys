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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Order;
import model.OrderDAO;

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
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ObservableList<Order> list = OrderDAO.list();
            projectCB.getItems().addAll(list);
            
            currencyCB.getItems().addAll("USD", "MNT", "RUR", "AUD");
            
            statusCB.getItems().addAll("Active", "In Progress", "Fully");
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(OrderAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Boolean validateForm() {
        Boolean retValue = false;
        
//        if (itemCB.getSelectionModel().isEmpty()) {
//            messageL.setText("Please, select the item");
//        } else if (wordsTF.getCharacters().length() == 0) {
//            messageL.setText("Please, inform the words quantity");
//        } else if (!wordsTF.getCharacters().toString().matches("[0-9]*")) {
//            messageL.setText("Please, inform just numbers in words field");
//        } else if (vendorCB.getSelectionModel().isEmpty()) {
//            messageL.setText("Please, select the vendor");
//        } else {
//            retValue = true;
//        }
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
//            OrderDAO.insert(projectCB.getValue(), amountTF.getCharacters().toString(), 
//                    currencyCB.getValue(), statusCB.getValue());
            OrderDAO.insert(2, Double.parseDouble(amountTF.getCharacters().toString()), 
                    currencyCB.getValue().toString(), 3);
        }
        Main.rootLayoutController.go2orders(event);
    }
    
    
    
}