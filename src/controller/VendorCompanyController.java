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
import model.account.CompanyResult;
import model.account.EmployeeResult;
import util.DBUtil;

/**
 * FXML Controller class
 *
 * @author bek
 */
public class VendorCompanyController implements Initializable {

    // static member will be used in other controllers
    static public AnchorPane ancorPane;
    @FXML
    private TextField nameText;
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
    private TextField searchVendorNumberText;
    @FXML
    private Button addVendorButton;
    @FXML
    private TextField companyRegNumberText;
    @FXML
    private TextField compRepText;
    @FXML
    private Button searchVendorButton;
    @FXML
    private TableColumn<CompanyResult, String> numberColumn;
    @FXML
    private TableColumn<CompanyResult, String> accNumberColumn;
    @FXML
    private TableColumn<CompanyResult, String> nameColumn;
    @FXML
    private TableColumn<CompanyResult, String> regNumberColumn;
    @FXML
    private TableColumn<CompanyResult, String> representativeColumn;
    @FXML
    private TableView<CompanyResult> vendorTV;
    @FXML
    private TableColumn<CompanyResult, String> loginNameColumn;

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
            VendorCompanyController.ancorPane = (AnchorPane) loader.load();

            //show the scene containing the borderPane
            Scene scene = new Scene(VendorCompanyController.ancorPane); //We are sending borderPane to the Scene.
            Main.primaryStage.setScene(scene); //Set the scene in primary stage.

            //show the primary stage
            Main.primaryStage.show(); //Display the primary stage

        } catch (Exception ex) {
            Logger.getLogger(RootLayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleAddVendorButton(ActionEvent event) throws SQLException {
        errorMessage.setText("");
        if (validateForm()) {
            try {
                AccountEmployeeVendorDAO.insertCompany(accNumberText.getText(), loginText.getText(), passwordText.getText(), numberText.getText(), nameText.getText(), companyRegNumberText.getText(), compRepText.getText());
                clearCompanyAddForm();
                errorMessage.setText("Successfully added");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VendorCompanyController.class.getName()).log(Level.SEVERE, null, ex);
                errorMessage.setText(ex.getMessage().substring(0, 100));
            }
        }
    }

    private Boolean validateForm() {
        return nonEmpty() && accountNumberValidation() && vendorNumberValidation() && loginValidation();
    }

    private Boolean nonEmpty() {
        if (nameText.getText().isEmpty() || compRepText.getText().isEmpty() || numberText.getText().isEmpty()
                || accNumberText.getText().isEmpty() || loginText.getText().isEmpty() || passwordText.getText().isEmpty()
                || companyRegNumberText.getText().isEmpty()) {
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
        boolean isNumber = false;
        try {
            Integer.parseInt(accNumberText.getText());
            isNumber = true;
        } catch (Exception e) {
            errorMessage.setText("Account number must be 5-digit number");
        }
        if (accNumberText.getCharacters().length() != 5) {
            String s = errorMessage.getText() + "\n" + "Number must be exact 5-digit number";
            errorMessage.setText(s);
        }
        return isNumber && accNumberText.getCharacters().length() == 5;
    }

    private void clearCompanyAddForm() {
        nameText.setText("");
        compRepText.setText("");
        numberText.setText("");
        accNumberText.setText("");
        loginText.setText("");
        passwordText.setText("");
        companyRegNumberText.setText("");
    }

    @FXML
    private void handleSearchVendorButton(ActionEvent event) {
        numberColumn.setCellValueFactory(cellData -> cellData.getValue().getNumber());
        accNumberColumn.setCellValueFactory(cellData -> cellData.getValue().getAccNumber());
        loginNameColumn.setCellValueFactory(cellData -> cellData.getValue().getLogin());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
        representativeColumn.setCellValueFactory(cellData -> cellData.getValue().getCompanyRep());
        regNumberColumn.setCellValueFactory(cellData -> cellData.getValue().getCompanyRegNum());

        try {
            this.vendorTV.setItems(AccountEmployeeVendorDAO.findCompanyByVendorNumberFuzzy(searchVendorNumberText.getText()));
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(ProjectsController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void index(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("view/VendorCompany.fxml"));
        AnchorPane achorPane = (AnchorPane) loader.load();

        RootLayoutController.borderPane.setCenter(achorPane);
    }
}
