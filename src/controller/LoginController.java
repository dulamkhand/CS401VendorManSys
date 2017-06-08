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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.account.AccountDAO;
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
    private String userType = "E";
    private EmployeeAccount employee = null;
    private VendorAccount vendor = null;

    public LoginController() {
        this.setEmployee(null);
        this.setVendor(null);
        this.setUserType("");
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
            employee = AccountDAO.findEmployee(usernameTF.getText());
            if (employee == null) {
                vendor = AccountDAO.findVendor(usernameTF.getText());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Boolean retValue = false;

        // validate user on database.
        if (employee == null && vendor == null) {
            System.out.println("FALSE");
            return false;
        }
        if (employee != null) {
            System.out.println("Employee employee");
            userType = employee.getAccount().getAccountType().get();
            boolean password = passwordPF.getText().equals(employee.getAccount().getPassword().get());
            if(!password)
                messageL.setText("incorrect password");
            return password;
        }
        if (vendor != null) {
            userType = vendor.getAccount().getAccountType().get();
            return passwordPF.getText().equals(vendor.getAccount().getPassword());
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
            if (userType.equals(AccountTypeEnum.EMPLOYEE.toString())) {
                //root = FXMLLoader.load(getClass().getResource("view/Employee.fxml"));
                Main.rootLayoutController = new RootLayoutController();
                Main.rootLayoutController.go2homepage(event); // redirects to homepage once logged in
            } else if (userType.equals(AccountTypeEnum.SUPER_USER.toString())) {
                //root = FXMLLoader.load(getClass().getResource("view/Vendor.fxml"));
            } else if (userType.equals(AccountTypeEnum.COMPANY.toString()) || userType.equals(AccountTypeEnum.PERSON.toString())) {

            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public EmployeeAccount getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeAccount employee) {
        this.employee = employee;
    }

    public VendorAccount getVendor() {
        return vendor;
    }

    public void setVendor(VendorAccount vendor) {
        this.vendor = vendor;
    }
    
    
}
