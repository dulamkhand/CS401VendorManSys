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

    public static EmployeeAccount createAccountEmployee(int accId, int empId, String login, String password, Date created, String firstName, String lastName) {
        Account account = new Account(new SimpleIntegerProperty(accId), new SimpleStringProperty(login), new SimpleStringProperty(password), created, AccountType.getEmployeeAccountType());
        Employee employee = new Employee(new SimpleIntegerProperty(empId), new SimpleStringProperty(firstName), new SimpleStringProperty(lastName), account, created);
        account.setVendorEmployee(employee);
        return new EmployeeAccountImpl(employee, account);
    }
}
