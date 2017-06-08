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

    private IntegerProperty id;
    private StringProperty loginName;
    private StringProperty password;
    private Date created;
    private AccountType type;
    private VendorEmployee vendorEmployee;

    Account(IntegerProperty id, StringProperty loginName, StringProperty password, Date created, AccountType type) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
        this.created = created;
        this.type = type;
    }

    

    public IntegerProperty getId() {
        return id;
    }

    void setId(IntegerProperty id) {
        this.id = id;
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

    public Date getCreated() {
        return created;
    }

    void setCreated(Date created) {
        this.created = created;
    }

    public AccountType getType() {
        return type;
    }

    void setType(AccountType type) {
        this.type = type;
    }

    public VendorEmployee getVendorEmployee() {
        return vendorEmployee;
    }

    void setVendorEmployee(VendorEmployee vendorEmployee) {
        this.vendorEmployee = vendorEmployee;
    }
}
