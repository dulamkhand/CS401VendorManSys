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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Projects Scene Controller.
 * 
 * @author Group 1.
 */
public class ProjectsSceneController implements Initializable {
    
    /**
     * Handle New Button Action.
     * 
     * @param event - ActionEvent
     */
     @FXML
    private void handleNewButtonAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));

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