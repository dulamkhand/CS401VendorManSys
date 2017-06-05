/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entity;

import javafx.beans.property.*;

/**
 *
 * @author Khandaa
 */
public class Project {
    
    private IntegerProperty id;
    private StringProperty name;
    private IntegerProperty employeeId;
    private IntegerProperty vendorId;
    private StringProperty createdDate;

    public Project() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.employeeId = new SimpleIntegerProperty();
        this.vendorId = new SimpleIntegerProperty();
        this.createdDate = new SimpleStringProperty();
    }

    public IntegerProperty getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id.set(id);
    }

    public StringProperty getName() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public IntegerProperty getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId.set(employeeId);
    }

    public IntegerProperty getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId.set(vendorId);
    }

    public StringProperty getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(StringProperty createdDate) {
        this.createdDate = createdDate;
    }
    
    

}
