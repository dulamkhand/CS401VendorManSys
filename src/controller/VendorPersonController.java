/*
 * To change this license header, choose License Headers in Project Properties.
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.account.AccountEmployeeVendorDAO;
import model.account.EmployeeResult;
import model.account.PersonResult;
import util.DBUtil;

/**
 * FXML Controller class
 *
 * @author bek
 */
public class VendorPersonController implements Initializable {

    // static member will be used in other controllers
    static public AnchorPane ancorPane;
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
    private Label errorMessage;
    @FXML
    private TableColumn<PersonResult, String> loginNameColumn;
    @FXML
    private Button addPersonButton;
    @FXML
    private TextField ssnText;
    @FXML
    private TextField nationalityText;
    @FXML
    private TextField searchPersonText;
    @FXML
    private Button searchPersonButton;
    @FXML
    private TableColumn<PersonResult, String> vendorNumberColumn;
    @FXML
    private TableColumn<PersonResult, String> accNumberColumn;
    @FXML
    private TableColumn<PersonResult, String> nameColumn;
    @FXML
    private TableColumn<PersonResult, String> surnameColumn;
    @FXML
    private TableColumn<PersonResult, String> ssnColumn;
    @FXML
    private TableColumn<PersonResult, String> nationalityColumn;
    @FXML
    private TableView<PersonResult> personTV;

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
            VendorPersonController.ancorPane = (AnchorPane) loader.load();

            //show the scene containing the borderPane
            Scene scene = new Scene(VendorPersonController.ancorPane); //We are sending borderPane to the Scene.
            Main.primaryStage.setScene(scene); //Set the scene in primary stage.

            //show the primary stage
            Main.primaryStage.show(); //Display the primary stage

        } catch (Exception ex) {
            Logger.getLogger(RootLayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleAddPersonButton(ActionEvent event) throws SQLException {
        errorMessage.setText("");
        if (validateForm()) {
            try {
                AccountEmployeeVendorDAO.insertPerson(accNumberText.getText(), loginText.getText(), passwordText.getText(), numberText.getText(), nameText.getText(), surnameText.getText(), ssnText.getText(), nationalityText.getText());
                clearPersonAddForm();
                errorMessage.setText("Successfully added");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VendorPersonController.class.getName()).log(Level.SEVERE, null, ex);
                errorMessage.setText(ex.getMessage().substring(0, 100));
            }
        }
    }

    private Boolean validateForm() {
        return nonEmpty() && accountNumberValidation() && vendorNumberValidation() && loginValidation();
    }

    private Boolean nonEmpty() {
        if (nameText.getText().isEmpty() || surnameText.getText().isEmpty() || numberText.getText().isEmpty()
                || accNumberText.getText().isEmpty() || loginText.getText().isEmpty() || passwordText.getText().isEmpty()
                || ssnText.getText().isEmpty() || nationalityText.getText().isEmpty()) {
            errorMessage.setText("Please fill all the fields correctly");
            return false;
        }
        errorMessage.setText("");
        return true;
    }

    private Boolean vendorNumberValidation() {
        Pattern p = Pattern.compile("V[0-9]{5}");
        Matcher m = p.matcher(numberText.getText());
        if (!m.matches()) {
            errorMessage.setText("Vendor number must be:\n Capital V followed by 5-digits");
            return false;
        }
        return m.matches();
    }

    private Boolean loginValidation() {
        Pattern p = Pattern.compile("[a-z]{1}[a-z_]+");
        Matcher m = p.matcher(loginText.getText());
        if (!m.matches()) {
            errorMessage.setText("login must contain:\n Only small letters");
        }
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
            errorMessage.setText(s);
        }
        return isNumber && accNumberText.getCharacters().length() == 5;
    }

    private void clearPersonAddForm() {
        nameText.setText("");
        surnameText.setText("");
        numberText.setText("");
        accNumberText.setText("");
        loginText.setText("");
        passwordText.setText("");
        ssnText.setText("");
        nationalityText.setText("");
    }

    @FXML
    private void handleSearchPersonButton(ActionEvent event) {
        vendorNumberColumn.setCellValueFactory(cellData -> cellData.getValue().getNumber());
        accNumberColumn.setCellValueFactory(cellData -> cellData.getValue().getAccNumber());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
        surnameColumn.setCellValueFactory(cellData -> cellData.getValue().getSurename());
        ssnColumn.setCellValueFactory(cellData -> cellData.getValue().getSsn());
        nationalityColumn.setCellValueFactory(cellData -> cellData.getValue().getNationality());
        loginNameColumn.setCellValueFactory(cellData -> cellData.getValue().getLogin());
        
        try {
            this.personTV.setItems(AccountEmployeeVendorDAO.findPersonByVendorNumberFuzzy(searchPersonText.getText()));
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(ProjectsController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void index(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("view/VendorPerson.fxml"));
        AnchorPane achorPane = (AnchorPane) loader.load();

        RootLayoutController.borderPane.setCenter(achorPane);
    }
}
