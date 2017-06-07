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
     * Project Table Column.
     */
    @FXML
    private TableColumn<Project, String> projectTC;
    
    /**
     * Item Table Column.
     */
    @FXML
    private TableColumn itemTC;
    
    /**
     * Status Table Column.
     */
    @FXML
    private TableColumn statusTC;
   
    
    @FXML
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
    private void handleAdd(ActionEvent event) throws Exception {
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
       projectTC.setCellValueFactory(cellData -> cellData.getValue().getTitle());
       
       //Get all Order information
        try {
            
            //Populate Order on TableView
            this.projectsTV.setItems(ProjectDAO.list());
            
            //System.out.debug("OrdersSceneController is initialized");
            //System.out.debug("this.orderTable: " + this.orderTable);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProjectsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}