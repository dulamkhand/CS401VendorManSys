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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import model.item.Item;
import model.item.ItemDAO;

/**
 * Projects Scene Controller.
 * 
 * @author Group 1.
 */
public class ItemsController implements Initializable {
    
    /**
     * Item Table View.
     */
    @FXML
    private TableView<Item> itemsTV;
    
    /**
     * ID Table Column.
     */
    @FXML
    private TableColumn<Item, Integer> idTC;
    
    /**
     * Name Table Column.
     */
    @FXML
    private TableColumn<Item, String> nameTC;
    
    /**
     * Rate Table Column.
     */
    @FXML
    private TableColumn<Item, Double> rateTC;
    
    /**
     * Number Words Table Column.
     */
    @FXML
    private TableColumn<Item, Integer> numberWordsTC;
    
    @FXML
    public void index(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("view/Items.fxml"));
        AnchorPane achorPane = (AnchorPane) loader.load();

        RootLayoutController.borderPane.setCenter(achorPane);
    }
    
    /**
     * Handle New Button Action.
     * 
     * @param event - ActionEvent
     */
     @FXML
    private void handleAdd(ActionEvent event) throws Exception {/*
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("view/ProjectAdd.fxml"));  
        AnchorPane achorPane = (AnchorPane) loader.load();

        RootLayoutController.borderPane.setCenter(achorPane);*/
    }
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       idTC.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
       nameTC.setCellValueFactory(cellData -> cellData.getValue().getName());
       //serviceTC.setCellValueFactory(cellData -> cellData.getValue().getServiceName());
       rateTC.setCellValueFactory(cellData -> cellData.getValue().getRate().asObject());
       numberWordsTC.setCellValueFactory(cellData -> cellData.getValue().getNumberWords().asObject());
       //vendorTC.setCellValueFactory(cellData -> cellData.getValue().getVendor());
       //statusTC.setCellValueFactory(cellData -> cellData.getValue().getProjectStatus().getStatus());
       
        try {
            this.itemsTV.setItems(ItemDAO.list());
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProjectsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}