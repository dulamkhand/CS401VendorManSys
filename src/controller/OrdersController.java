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
import model.Project;

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
    private TableColumn<Order, Project> projectTC;
    @FXML
    private TableColumn<Order, Double> amountTC;
    @FXML
    private TableColumn<Order, String> currencyTC;
    @FXML
    private TableColumn<Order, String> statusTC;
    
    //Initializing the controller class.
    //This method is automatically called after the fxml file has been loaded.
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
        The setCellValueFactory(...) that we set on the table columns are used to determine
        which field inside the Order objects should be used for the particular column.
        The arrow -> indicates that we're using a Java 8 feature called Lambdas.
        (Another option would be to use a PropertyValueFactory, but this is not type-safe

        We're only using StringProperty values for our table columns in this example.
        When you want to use IntegerProperty or DoubleProperty, the setCellValueFactory(...)
        must have an additional asObject():
        */
        idTC.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        amountTC.setCellValueFactory(cellData -> cellData.getValue().getAmount().asObject());
        currencyTC.setCellValueFactory(cellData -> cellData.getValue().getCurrency());
        //statusTC.setCellValueFactory(cellData -> cellData.getValue().getStatus());
        
        //Get all Order information
        try {
            ObservableList<Order> list = OrderDAO.list();
            //Populate Order on TableView
            this.orderTV.setItems(list);
            
            //System.out.debug("OrdersSceneController is initialized");
            //System.out.debug("this.orderTable: " + this.orderTable);
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