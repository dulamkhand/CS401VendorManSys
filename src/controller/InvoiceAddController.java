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
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import model.invoice.InvoiceStatus;
import model.invoice.InvoiceStatusDAO;
import model.order.Order;
import model.order.OrderDAO;

/**
 * Projects Scene Controller.
 * 
 * @author Group 1.
 */
public class InvoiceAddController implements Initializable {
    
    @FXML
    TextField nameTF;
    
    @FXML
    ListView ordersLV;
    
    @FXML
    ComboBox statusCB;
  
    @FXML
    Label messageL;
    
    private Map<Integer, Order> orderList;
    private Map<Integer, InvoiceStatus> statusList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.orderList = OrderDAO.listInMap();
            ordersLV.getItems().addAll(this.orderList.values());
            ordersLV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            
            this.statusList = InvoiceStatusDAO.list();
            statusCB.getItems().addAll(this.statusList.values());
        } catch (ClassNotFoundException | SQLException ex) {
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
        if (ordersLV.getSelectionModel().isEmpty()) {
            sb.append("\nOrder is required.");
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
            System.out.println(ordersLV.getSelectionModel());
            System.out.println(ordersLV.getSelectionModel().getSelectedItems().get(0));
            System.out.println(ordersLV.getSelectionModel().getSelectedItems().get(1));
            
            ObservableList<String> ordersSelected = ordersLV.getSelectionModel().getSelectedItems();
            for(String o : ordersSelected) {
               System.out.println(Integer.parseInt(o.split(" - ")[0]));
            }
            
            //InvoiceDAO.insert(nameTF.getCharacters().toString(), Double.parseDouble(amountTF.getCharacters().toString()),
            //        nameTF.getCharacters().toString(), 3);

            //Main.rootLayoutController.go2orders(event);
        }
        
    }
}