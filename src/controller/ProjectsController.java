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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    private TableView<String> projectsTV;
    
    /**
     * Project Table Column.
     */
    @FXML
    private TableColumn projectTC;
    
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
        System.out.println("asfasf");
        
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
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/ProjectAdd.fxml"));

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
       System.out.println("erwe");
       
        // searches all projects on database and loads the table view with them.
        projectsTV.getItems().addAll(
                "Mongolian to Russian",
                "Russian to Mongolian");
    }
}