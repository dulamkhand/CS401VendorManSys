/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.account;

import java.util.Date;
import javafx.beans.property.IntegerProperty;
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

    public Person(StringProperty firstName, StringProperty lastName, StringProperty SSN, StringProperty nationality, Account acc, Date date, IntegerProperty id) {
        super(acc, date, id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.nationality = nationality;
    }
    
    
}
