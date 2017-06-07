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
import model.Order;
import model.OrderDAO;

/**
 * Orders Scene Controller.
 * 
 * @author Group 1.
 */
public class OrdersSceneController implements Initializable {
    
    @FXML
    private TableView<Order> orderTable;
    @FXML
    private TableColumn<Order, Integer> idColumn;
    @FXML
    private TableColumn<Order, Double> amountColumn;
    @FXML
    private TableColumn<Order, String> currencyColumn;
    
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
        idColumn.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        amountColumn.setCellValueFactory(cellData -> cellData.getValue().getAmount().asObject());
        currencyColumn.setCellValueFactory(cellData -> cellData.getValue().getCurrency());
    }
    
    //List all orders
    @FXML
    public void listAllOrders(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Order information
            ObservableList<Order> list = OrderDAO.list();
            //Populate Order on TableView
            orderTable.setItems(list);
        } catch (SQLException e){
            System.out.println("Error occurred while getting order information from DB.\n" + e);
            throw e;
        }
    }
   
    @FXML
    private void add(Order o) throws ClassNotFoundException {
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

    @FXML
    private void redirect2projects(ActionEvent event) throws Exception {
        // 
    }
}