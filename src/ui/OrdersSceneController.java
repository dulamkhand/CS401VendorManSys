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
package ui;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Employee;
import model.Order;
import model.OrderDAO;

/**
 * Orders Scene Controller.
 * 
 * @author Group 1.
 */
public class OrdersSceneController implements Initializable {
    
    @FXML
    private TableView orderTable;
    @FXML
    private TableColumn<Order, Integer> idColumn;
    @FXML
    private TableColumn<Order, Double> amountColumn;
    @FXML
    private TableColumn<Order, String> currencyColumn;
    
    //Initializing the controller class.
    //This method is automatically called after the fxml file has been loaded.
    @FXML
    private void initialize () {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        amountColumn.setCellValueFactory(cellData -> cellData.getValue().getAmount().asObject());
        currencyColumn.setCellValueFactory(cellData -> cellData.getValue().getCurrency());
    }
    
    //List all orders
    @FXML
    private void list(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Order information
            ObservableList<Order> list = OrderDAO.list();
            //Populate Order on TableView
            populateOrders(list);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    
    //Populate Orders for TableView
    @FXML
    private void populateOrders (ObservableList<Order> list) throws ClassNotFoundException {
        //Set items to the orderTable
        orderTable.setItems(list);
    }
    
    //Populate Order
    @FXML
    private void populateOrder (Order o) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Order> list = FXCollections.observableArrayList();
        //Add order to the ObservableList
        list.add(o);
        //Set items to the orderTable
        orderTable.setItems(list);
    }

   
    
    /**
     * Handle New Button Action.
     * 
     * @param event - ActionEvent
     */
     @FXML
    private void handleAddButtonAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("OrderAddScene.fxml"));

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Handle Close Button Action.
     * 
     * @param event - ActionEvent
     */
     @FXML
    private void handleCloseButtonAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}