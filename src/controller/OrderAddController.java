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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import model.order.OrderDAO;
import model.order.OrderProjectDAO;
import model.order.OrderStatus;
import model.project.Project;

/**
 * Projects Scene Controller.
 * 
 * @author Group 1.
 */
public class OrderAddController implements Initializable {
   
    @FXML
    ComboBox projectCB;
    
    @FXML
    ComboBox statusCB;
  
    @FXML
    Label messageL;

    private Map<Integer, Project> projectList;
    private Map<Integer, OrderStatus> statusList;
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.projectList = OrderProjectDAO.getProjectList();
            projectCB.getItems().addAll(this.projectList.values());
           
            this.statusList = OrderProjectDAO.getOrderStatusList();
            statusCB.getItems().addAll(this.statusList.values());
            
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
            Project p = this.projectList.get(projectCB.getSelectionModel().getSelectedIndex());
            OrderStatus os = this.statusList.get(statusCB.getSelectionModel().getSelectedIndex());

            OrderDAO.insert(p.getId().getValue(), p.getAmount().getValue(), 
                    p.getCurrency().getValue(), os.getId().getValue());

            Main.rootLayoutController.go2orders(event);
        }
        
    }

}