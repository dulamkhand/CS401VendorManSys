/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.account;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author bek
 */
public class CompanyResult {

    private StringProperty number;
    private StringProperty accNumber;
    private StringProperty login;
    private StringProperty name;
    private StringProperty surename;
    private StringProperty password;
    private StringProperty ssn;
    private StringProperty nationality;

    public CompanyResult() {
        this.number = new SimpleStringProperty();
        this.accNumber = new SimpleStringProperty();
        this.login = new SimpleStringProperty();
        this.name = new SimpleStringProperty();
        this.surename = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.ssn = new SimpleStringProperty();
        this.nationality = new SimpleStringProperty();
    }

    public CompanyResult(StringProperty number, StringProperty accNumber, StringProperty login, StringProperty name, StringProperty surename) {
        this.number = number;
        this.accNumber = accNumber;
        this.login = login;
        this.name = name;
        this.surename = surename;
    }

    public StringProperty getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number.set(number);
    }

    public StringProperty getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber.set(accNumber);
    }

    public StringProperty getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public StringProperty getName() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename.set(surename);
    }

    public StringProperty getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
}
