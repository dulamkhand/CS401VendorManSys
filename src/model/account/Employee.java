/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.account;

import javafx.beans.property.*;

/**
 *
 * @author Khandaa
 */

public class Employee {
   
    private IntegerProperty employeeId;
    private StringProperty firstName;
    private StringProperty lastName;
   
    public int getEmployeeId() {
        return employeeId.get();
    }

    public void setEmployeeId(int employeeId){
        this.employeeId.set(employeeId);
    }

    public IntegerProperty employeeIdProperty(){
        return employeeId;
    }

    public String getFirstName () {
        return firstName.get();
    }

    public void setFirstName(String firstName){
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName () {
        return lastName.get();
    }

    public void setLastName(String lastName){
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

}
