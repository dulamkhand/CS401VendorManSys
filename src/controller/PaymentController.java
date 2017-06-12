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
import model.payment.Payment;
import model.payment.PaymentDAO;

/**
 * Projects Scene Controller.
 * 
 * @author Group 1.
 */
public class PaymentController implements Initializable {
    
    /**
     * Item Table View.
     */
    @FXML
    private TableView<Payment> paymentTV;
    
    /**
     * ID Table Column.
     */
    @FXML
    private TableColumn<Payment, Integer> idTC;
    
    /**
     * Name Table Column.
     */
    @FXML
    private TableColumn<Payment, String> invoiceTC;
    
    /**
     * Rate Table Column.
     */
    @FXML
    private TableColumn<Payment, String> codeTC;
    
    /**
     * Number Words Table Column.
     */
    @FXML
    private TableColumn<Payment, Double> amountTC;
    
    /**
     * Number Words Table Column.
     */
    @FXML
    private TableColumn<Payment, String> currencyTC;
    
    @FXML
    public void index(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("view/Payment.fxml"));
        AnchorPane achorPane = (AnchorPane) loader.load();

        RootLayoutController.borderPane.setCenter(achorPane);
    }
    
    /**
     * Handle Add Button Action.
     * 
     * @param event - ActionEvent
     */
     @FXML
    private void handleAddButtonAction(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("view/PaymentAdd.fxml"));  
        AnchorPane achorPane = (AnchorPane) loader.load();

        RootLayoutController.borderPane.setCenter(achorPane);
    }
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       idTC.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
       invoiceTC.setCellValueFactory(cellData -> cellData.getValue().getInvoice());
       codeTC.setCellValueFactory(cellData -> cellData.getValue().getCode());
       amountTC.setCellValueFactory(cellData -> cellData.getValue().getAmount().asObject());
       currencyTC.setCellValueFactory(cellData -> cellData.getValue().getCurrency());
       
        try {
            this.paymentTV.setItems(PaymentDAO.list());
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProjectsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}