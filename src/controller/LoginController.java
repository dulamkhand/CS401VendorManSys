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

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.account.AccountEmployeeVendorDAO;
import model.account.AccountTypeEnum;
import model.account.EmployeeAccount;
import model.account.VendorAccount;

/**
 * Login Controller.
 *
 * @author Group 1.
 */
public class LoginController implements Initializable {

    /**
     * Username - TextField.
     */
    @FXML
    private TextField usernameTF;

    /**
     * Password - PasswordField.
     */
    @FXML
    private PasswordField passwordPF;

    /**
     * Message - Label.
     */
    @FXML
    private Label messageL;

    /**
     * User Type - String.
     */

    public LoginController() {
    }
    
    

    /**
     * Validate Form.
     *
     * @return Boolean
     */
    private Boolean validateForm() {
        Boolean retValue = false;

        if (usernameTF.getCharacters().length() == 0) {
            messageL.setText("Please, inform the username");
        } else if (passwordPF.getCharacters().length() == 0) {
            messageL.setText("Please, inform the password");
        } else {
            retValue = true;
        }

        return retValue;
    }

    /**
     * Validate User.
     *
     * @return Boolean
     */
    private Boolean validateUser() throws SQLException {
        try {
            Main.employee = AccountEmployeeVendorDAO.findEmployee(usernameTF.getText());
            if (Main.employee == null) {
                Main.vendor = AccountEmployeeVendorDAO.findVendor(usernameTF.getText());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Boolean retValue = false;

        // validate user on database.
        if (Main.employee == null && Main.vendor == null) {
            System.out.println("NULL NULL");
            return false;
        }
        if (Main.employee != null) {
            System.out.println("SUPER_SUPER");
            Main.userType = Main.employee.getAccount().getAccountType().get();
            boolean password = passwordPF.getText().equals(Main.employee.getAccount().getPassword().get());
            if(!password)
                messageL.setText("incorrect password");
            return password;
        }
        if (Main.vendor != null) {
            Main.userType = Main.vendor.getAccount().getAccountType().get();
            return passwordPF.getText().equals(Main.vendor.getAccount().getPassword());
        }
        return retValue;
    }

    /**
     * Handle Reset Button Action.
     *
     * @param event - ActionEvent
     */
    @FXML
    private void handleResetButtonAction(ActionEvent event) {
        usernameTF.clear();
        passwordPF.clear();
    }

    /**
     * Handle Login Button Action.
     *
     * @param event - ActionEvent
     */
    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws Exception {
        if (validateForm() && validateUser()) {
            if (Main.userType.equals(AccountTypeEnum.EMPLOYEE.toString())) {
                //root = FXMLLoader.load(getClass().getResource("view/Employee.fxml"));
                Main.rootLayoutController = new RootLayoutController();
                Main.rootLayoutController.go2homepage(event); // redirects to homepage once logged in
            } else if (Main.userType.equals(AccountTypeEnum.SUPER_USER.toString())) {
                Main.superUserController = new SuperUserController();
                Main.superUserController.go2homepage(event);
                
            } else if (Main.userType.equals(AccountTypeEnum.COMPANY.toString()) || Main.userType.equals(AccountTypeEnum.PERSON.toString())) {

            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Main.employee = null;
        Main.userType = "";
        Main.vendor = null;
    }
    
    
}
