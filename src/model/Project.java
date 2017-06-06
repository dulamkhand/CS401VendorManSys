/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.*;

/**
 *
 * @author Khandaa
 */
public class Project {
    
    private IntegerProperty id;
    private StringProperty title;
    private DoubleProperty amount;
    private StringProperty currency;
    private IntegerProperty vendorId;
    private StringProperty createdDate;

    public Project() {
        this.id = new SimpleIntegerProperty();
        this.title = new SimpleStringProperty();
        this.amount = new SimpleDoubleProperty();
        this.currency = new SimpleStringProperty();
        this.vendorId = new SimpleIntegerProperty();
        this.createdDate = new SimpleStringProperty();
    }

    public IntegerProperty getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id.set(id);
    }

    public StringProperty getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
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

    public DoubleProperty getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount.set(amount);
    }

    public StringProperty getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency.set(currency);
    }
    

}
