/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.account;

import java.util.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author bek
 */
public class Account {

    private StringProperty number;
    private StringProperty loginName;
    private StringProperty password;
    private StringProperty accountType;
    private VendorEmployee vendorEmployee;

    Account(StringProperty number, StringProperty loginName, StringProperty password, StringProperty type) {
        this.number = number;
        this.loginName = loginName;
        this.password = password;
        this.accountType = type;
    }

    

    public StringProperty getNumber() {
        return number;
    }

    void setNumber(StringProperty number) {
        this.number = number;
    }

    public StringProperty getLoginName() {
        return loginName;
    }

    void setLoginName(StringProperty loginName) {
        this.loginName = loginName;
    }

    public StringProperty getPassword() {
        return password;
    }

    public void setPassword(StringProperty password) {
        this.password = password;
    }

    public VendorEmployee getVendorEmployee() {
        return vendorEmployee;
    }

    void setVendorEmployee(VendorEmployee vendorEmployee) {
        this.vendorEmployee = vendorEmployee;
    }

    public StringProperty getAccountType() {
        return accountType;
    }

    public void setAccountType(StringProperty accountType) {
        this.accountType = accountType;
    }
}
