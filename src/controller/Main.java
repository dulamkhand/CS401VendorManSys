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

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.account.EmployeeAccount;
import model.account.VendorAccount;

/**
 * Vendor Management System.
 *
 * @author Group 1.
 */
public class Main extends Application {

    // static member will be used in RootLayoutController
    public static Stage primaryStage;
    
    // static member will be used in other controllers to switch between controllers/pages
    public static RootLayoutController rootLayoutController;
    public static SuperUserController superUserController;
    public static String userType;
    public static EmployeeAccount employee;
    public static VendorAccount vendor;

    @Override
    public void start(Stage stage) throws Exception {
        Main.primaryStage = stage;
        Main.primaryStage.setTitle("Vendor Management System");

        // load login page
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Login.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
