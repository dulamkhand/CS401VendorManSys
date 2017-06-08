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

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import model.order.Order;
import model.order.OrderDAO;

/**
 * Orders Scene Controller.
 * 
 * @author Group 1.
 */
public class OrdersController implements Initializable {
    
    @FXML
    private TableView<Order> orderTV;
    @FXML
    private TableColumn<Order, Integer> idTC;
    @FXML
    private TableColumn<Order, String> projectTC;
    @FXML
    private TableColumn<Order, Double> amountTC;
    @FXML
    private TableColumn<Order, String> currencyTC;
    @FXML
    private TableColumn<Order, String> statusTC;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idTC.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        projectTC.setCellValueFactory(cellData -> cellData.getValue().getProject().getTitle());
        amountTC.setCellValueFactory(cellData -> cellData.getValue().getAmount().asObject());
        currencyTC.setCellValueFactory(cellData -> cellData.getValue().getCurrency());
        statusTC.setCellValueFactory(cellData -> cellData.getValue().getStatus().getName());
        
        try {
            ObservableList<Order> list = OrderDAO.list();
            this.orderTV.setItems(list);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(OrdersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void index(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("view/Orders.fxml"));  
        AnchorPane achorPane = (AnchorPane) loader.load();

        RootLayoutController.borderPane.setCenter(achorPane);
    }

     @FXML
    private void add(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("view/OrderAdd.fxml"));  
        AnchorPane achorPane = (AnchorPane) loader.load();

        RootLayoutController.borderPane.setCenter(achorPane);
    }
    
   

}