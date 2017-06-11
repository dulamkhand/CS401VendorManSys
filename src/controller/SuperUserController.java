/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.account.AccountEmployeeVendorDAO;

/**
 * FXML Controller class
 *
 * @author bek
 */
public class SuperUserController implements Initializable {

    // static member will be used in other controllers
    static public AnchorPane ancorPane;
    @FXML
    private Button searchEmpBtn;
    @FXML
    private Button deleteEmpBtn;
    @FXML
    private Button updateEmpBtn;
    @FXML
    private Button addEmployeeButton;
    @FXML
    private TextField nameText;
    @FXML
    private TextField surnameText;
    @FXML
    private TextField numberText;
    @FXML
    private TextField accNumberText;
    @FXML
    private TextField loginText;
    @FXML
    private PasswordField passwordText;
    @FXML
    private TableView<?> employeeTable;
    @FXML
    private TableColumn<?, ?> empIdColumn;
    @FXML
    private TableColumn<?, ?> empNameColumn;
    @FXML
    private TableColumn<?, ?> empLastNameColumn;
    @FXML
    private TableColumn<?, ?> empEmailColumn;
    @FXML
    private TableColumn<?, ?> empPhoneNumberColumn;
    @FXML
    private TableColumn<?, ?> empHireDateColumn;
    @FXML
    private Button searchEmpsBtn;
    @FXML
    private Label errorMessage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void go2homepage(ActionEvent event) {
        try {
            // load rootLayout
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/SuperUser.fxml"));
            SuperUserController.ancorPane = (AnchorPane) loader.load();

            //show the scene containing the borderPane
            Scene scene = new Scene(SuperUserController.ancorPane); //We are sending borderPane to the Scene.
            Main.primaryStage.setScene(scene); //Set the scene in primary stage.

            //show the primary stage
            Main.primaryStage.show(); //Display the primary stage

        } catch (Exception ex) {
            Logger.getLogger(RootLayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleAddEmployeeButton(ActionEvent event) throws SQLException {
        errorMessage.setText("");
        if (validateForm()) {
            try {
                AccountEmployeeVendorDAO.insert(accNumberText.getText(), loginText.getText(), passwordText.getText(), numberText.getText() , nameText.getText(), surnameText.getText());
                clearEmpAddForm();
                errorMessage.setText("Successfully added");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SuperUserController.class.getName()).log(Level.SEVERE, null, ex);
                errorMessage.setText(ex.getMessage().substring(0, 100));
            }
        }
    }

    private Boolean validateForm() {
        return nonEmpty() && accountNumberValidation() && employeeNumberValidation() && loginValidation();
    }

    private Boolean nonEmpty() {
        if (nameText.getText().isEmpty() || surnameText.getText().isEmpty() || numberText.getText().isEmpty()
                || accNumberText.getText().isEmpty() || loginText.getText().isEmpty() || passwordText.getText().isEmpty()) {
            errorMessage.setText("Please fill all the fields correctly");
            return false;
        }
        errorMessage.setText("");
        return true;
    }
    
    private Boolean employeeNumberValidation() {
        Pattern p = Pattern.compile("E[0-9]{5}");
        Matcher m = p.matcher(numberText.getText());
        if(!m.matches()){
            errorMessage.setText("Employee number must be:\n Capital E followed by 5-digits");
            return false;
        }
        return m.matches();
    }
    
    private Boolean loginValidation() {
        Pattern p = Pattern.compile("[a-z]+");
        Matcher m = p.matcher(loginText.getText());
        if(!m.matches())
            errorMessage.setText("login must contain:\n Only small letters");
        return m.matches();
    }

    private Boolean accountNumberValidation() {
        boolean isNumber = true;
        try {
            Integer.parseInt(accNumberText.getText());
        } catch (Exception e) {
            isNumber = true;
            errorMessage.setText("Account number must be 5-digit number");
        }
        if (accNumberText.getCharacters().length() != 5) {
            String s = errorMessage.getText() + "\n" + "Number must be exact 5-digit number";
        }
        return isNumber && accNumberText.getCharacters().length() == 5;
    }
    
    private void clearEmpAddForm(){
        nameText.setText("");
        surnameText.setText("");
        numberText.setText("");
        accNumberText.setText("");
        loginText.setText("");
        passwordText.setText("");
    }

}
