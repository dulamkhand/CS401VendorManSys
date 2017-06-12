/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.account;

import javafx.beans.property.StringProperty;

/**
 *
 * @author bek
 */
public class Person extends Vendor {
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty SSN;
    private StringProperty nationality;
    
    public Person() {
    }

    public Person(StringProperty firstName, StringProperty lastName, StringProperty SSN, StringProperty nationality, Account acc, StringProperty number) {
        super(acc, number);
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.nationality = nationality;
    }
    
    public void setFirstName(StringProperty firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(StringProperty lastName) {
        this.lastName = lastName;
    }
    
    public StringProperty getFirstName() {
        return firstName;
    }
    
    public StringProperty getLastName() {
        return lastName;
    }
}
