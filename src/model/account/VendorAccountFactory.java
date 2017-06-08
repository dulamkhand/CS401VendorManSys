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

    public static VendorAccount createVendorCompany(String number, int empId, String login, String password, String compRegNumber, String name, String compRep, String vendorNumber) {
        Account account = new Account(new SimpleStringProperty(number), new SimpleStringProperty(login), new SimpleStringProperty(password), new SimpleStringProperty(AccountTypeEnum.COMPANY.toString()));
        Company company = new Company(new SimpleStringProperty(compRegNumber), new SimpleStringProperty(name), new SimpleStringProperty(compRep), account, new SimpleStringProperty(vendorNumber));
        account.setVendorEmployee(company);
        return new VendorAccountImpl(company, account);
    }

    public static VendorAccount createVendorPerson(String number, int empId, String login, String password, Date created, String firstName, String lastName, String SSN, String nationality, String vendorNumber) {
        Account account = new Account(new SimpleStringProperty(number), new SimpleStringProperty(login), new SimpleStringProperty(password), new SimpleStringProperty(AccountTypeEnum.PERSON.toString()));
        Person person = new Person(new SimpleStringProperty(firstName), new SimpleStringProperty(lastName), new SimpleStringProperty(SSN), new SimpleStringProperty(nationality), account, new SimpleStringProperty(vendorNumber));
        account.setVendorEmployee(person);
        return new VendorAccountImpl(person, account);
    }
}
