/*
 * To change this license header, choose License Headers in Invoice Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import model.invoice.Invoice;
import model.invoice.InvoiceDAO;


/**
 *
 * @author Khandaa
 */
public class InvoicesController implements Initializable  {
    @FXML
    private TableView<Invoice> invoiceTV;
    @FXML
    private TableColumn<Invoice, Integer> idTC;
    @FXML
    private TableColumn<Invoice, String> nameTC;
    @FXML
    private TableColumn<Invoice, Double> amountTC;
    @FXML
    private TableColumn<Invoice, String> currencyTC;
    @FXML
    private TableColumn<Invoice, String> statusTC;
    
    //Initializing the controller class.
    //This method is automatically called after the fxml file has been loaded.
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
        The setCellValueFactory(...) that we set on the table columns are used to determine
        which field inside the Invoice objects should be used for the particular column.
        The arrow -> indicates that we're using a Java 8 feature called Lambdas.
        (Another option would be to use a PropertyValueFactory, but this is not type-safe

        We're only using StringProperty values for our table columns in this example.
        When you want to use IntegerProperty or DoubleProperty, the setCellValueFactory(...)
        must have an additional asObject():
        */
        idTC.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        nameTC.setCellValueFactory(cellData -> cellData.getValue().getName());
        amountTC.setCellValueFactory(cellData -> cellData.getValue().getAmount().asObject());
        currencyTC.setCellValueFactory(cellData -> cellData.getValue().getCurrency());
        //statusTC.setCellValueFactory(cellData -> cellData.getValue().getStatus());
        
        //Get all Invoice information
        try {
            ObservableList<Invoice> list = InvoiceDAO.list();
            //Populate Invoice on TableView
            this.invoiceTV.setItems(list);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(InvoicesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @FXML
    public void index(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("view/Invoices.fxml"));  
        AnchorPane achorPane = (AnchorPane) loader.load();

        RootLayoutController.borderPane.setCenter(achorPane);
    }

     @FXML
    private void add(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("view/InvoiceAdd.fxml"));  
        AnchorPane achorPane = (AnchorPane) loader.load();

        RootLayoutController.borderPane.setCenter(achorPane);
    }
}
