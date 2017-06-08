/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.account;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author bek
 */
public class AccountType {

    private static final int id1 = 1;
    private static final int id2 = 2;
    private static final int id3 = 3;
    private static final String type1 = "COMPANY";
    private static final String type2 = "PERSON";
    private static final String type3 = "EMPLOYEE";
    private IntegerProperty id;
    private StringProperty type;

    private AccountType(int id, String type) {
        this.id = new SimpleIntegerProperty(id);
        this.type = new SimpleStringProperty(type);
    }

    public static AccountType getCompanyAccountType() {
        return new AccountType(id1, type1);
    }

    public static AccountType getPersonAccountType() {
        return new AccountType(id2, type2);
    }

    public static AccountType getEmployeeAccountType() {
        return new AccountType(id3, type3);
    }

    public IntegerProperty getId() {
        return id;
    }

    public StringProperty getType() {
        return type;
    }
}
