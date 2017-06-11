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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import model.account.AccountTypeEnum;
import model.project.Project;
import model.project.ProjectDAO;

/**
 * Projects Scene Controller.
 * 
 * @author Group 1.
 */
public class ProjectsController implements Initializable {
    
    /**
     * Projects Table View.
     */
    @FXML
    private TableView<Project> projectsTV;
    
    /**
     * ID Table Column.
     */
    @FXML
    private TableColumn<Project, Integer> idTC;
    
    /**
     * Title Table Column.
     */
    @FXML
    private TableColumn<Project, String> titleTC;
    
    /**
     * Item Table Column.
     */
    @FXML
    private TableColumn<Project, String> serviceTC;
    
    /**
     * Amount Table Column.
     */
    @FXML
    private TableColumn<Project, Double> amountTC;
    
    /**
     * Currency Table Column.
     */
    @FXML
    private TableColumn<Project, String> currencyTC;
    
    /**
     * Vendor Table Column.
     */
    @FXML
    private TableColumn<Project, String> vendorTC;
    
    /**
     * Status Table Column.
     */
    @FXML
    private TableColumn<Project, String> statusTC;
    @FXML
    private Button addB;
    
    public void index(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("view/Projects.fxml"));  
        AnchorPane achorPane = (AnchorPane) loader.load();

        RootLayoutController.borderPane.setCenter(achorPane);
    }
    
    /**
     * Handle New Button Action.
     * 
     * @param event - ActionEvent
     */
     @FXML
    private void handleAddButtonAction(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("view/ProjectAdd.fxml"));  
        AnchorPane achorPane = (AnchorPane) loader.load();

        RootLayoutController.borderPane.setCenter(achorPane);
    }
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       if(Main.userType.equals(AccountTypeEnum.COMPANY.toString()) || Main.userType.equals(AccountTypeEnum.PERSON.toString()))
           addB.setVisible(false);
       
       idTC.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
       titleTC.setCellValueFactory(cellData -> cellData.getValue().getTitle());
       serviceTC.setCellValueFactory(cellData -> cellData.getValue().getServiceName());
       amountTC.setCellValueFactory(cellData -> cellData.getValue().getAmount().asObject());
       currencyTC.setCellValueFactory(cellData -> cellData.getValue().getCurrency());
       //vendorTC.setCellValueFactory(cellData -> cellData.getValue().getVendor());
       statusTC.setCellValueFactory(cellData -> cellData.getValue().getProjectStatus().getStatus());
       
        try {
            this.projectsTV.setItems(ProjectDAO.list());
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProjectsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}