/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.account;

import java.util.Date;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author bek
 */
public class EmployeeAccountFactory {

    private EmployeeAccountFactory() {
    }

    public static EmployeeAccount createAccountEmployee(String number, String empNumber, String login, String password, String firstName, String lastName) {
        Account account = new Account(new SimpleStringProperty(number), new SimpleStringProperty(login), new SimpleStringProperty(password), new SimpleStringProperty(AccountTypeEnum.EMPLOYEE.toString()));
        Employee employee = new Employee(new SimpleStringProperty(empNumber), new SimpleStringProperty(firstName), new SimpleStringProperty(lastName), account);
        account.setVendorEmployee(employee);
        return new EmployeeAccountImpl(employee, account);
    }
    
    public static EmployeeAccount createSuperUser(String number, String empNumber, String login, String password, Date created, String firstName, String lastName) {
        Account account = new Account(new SimpleStringProperty(number), new SimpleStringProperty(login), new SimpleStringProperty(password), new SimpleStringProperty(AccountTypeEnum.EMPLOYEE.toString()));
        Employee employee = new Employee(new SimpleStringProperty(empNumber), new SimpleStringProperty(firstName), new SimpleStringProperty(lastName), account);
        account.setVendorEmployee(employee);
        return new EmployeeAccountImpl(employee, account);
    }
}
