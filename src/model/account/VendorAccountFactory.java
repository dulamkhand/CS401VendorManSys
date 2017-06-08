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
public class VendorAccountFactory {

    private VendorAccountFactory() {
    }

    public static VendorAccount createVendorCompany(int accId, int empId, String login, String password, Date created, String compRegNumber, String name, String compRep, int vendorId) {
        Account account = new Account(new SimpleIntegerProperty(accId), new SimpleStringProperty(login), new SimpleStringProperty(password), created, AccountType.getEmployeeAccountType());
        Company company = new Company(new SimpleStringProperty(compRegNumber), new SimpleStringProperty(name), new SimpleStringProperty(compRep), account, created, new SimpleIntegerProperty(vendorId));
        account.setVendorEmployee(company);
        return new VendorAccountImpl(company, account);
    }
    
    public static VendorAccount createVendorPerson(int accId, int empId, String login, String password, Date created, String firstName, String lastName, String SSN, String nationality, int vendorId) {
        Account account = new Account(new SimpleIntegerProperty(accId), new SimpleStringProperty(login), new SimpleStringProperty(password), created, AccountType.getEmployeeAccountType());
        Person person = new Person(new SimpleStringProperty(firstName), new SimpleStringProperty(lastName), new SimpleStringProperty(SSN), new SimpleStringProperty(nationality), account, created, new SimpleIntegerProperty(vendorId));
        account.setVendorEmployee(person);
        return new VendorAccountImpl(person, account);
    }
}