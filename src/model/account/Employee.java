/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.account;

import java.util.Date;
import javafx.beans.property.*;

/**
 *
 * @author Khandaa
 */
public class Employee extends VendorEmployee {

    private StringProperty number;
    private StringProperty firstName;
    private StringProperty lastName;

    Employee(StringProperty number, StringProperty firstName, StringProperty lastName, Account acc) {
        super(acc);
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    Employee(StringProperty number, Account acc){
        super(acc);
        this.number = number;
    }
    
    Employee(Account acc, Date created) {
        super(acc);
    }

    public StringProperty getNumber() {
        return number;
    }

    public void setNumber(StringProperty number) {
        this.number = number;
    }
    
    public StringProperty numberProperty() {
        return number;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

}
