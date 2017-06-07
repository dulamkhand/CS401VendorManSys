/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.project;

import java.util.Date;
import javafx.beans.property.*;
import model.account.Vendor;
import model.item.Item;
import model.order.Order;

/**
 *
 * @author Khandaa
 */
public class Project {

    private IntegerProperty id;
    private StringProperty number;
    private StringProperty title;
    private DoubleProperty amount;
    private StringProperty currency;
    private Date created;
    private Vendor vendor;
    private ProjectStatus status;
    private ListProperty<Item> items;
    //optional(0..1)
    private Order order;
    
    public Project() {
        this.id = new SimpleIntegerProperty();
        this.number = new SimpleStringProperty();
        this.title = new SimpleStringProperty();
        this.amount = new SimpleDoubleProperty();
        this.currency = new SimpleStringProperty();
       
        this.created = new Date();
        //this.vendor = new Vendor();
        this.status = new ProjectStatus();
        //this.items = 
        this.order = null;
    }
    
    @Override
    public String toString() {
        return this.title.getValue();
    }
    
    public IntegerProperty getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id.set(id);
    }

    public StringProperty getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number.set(number);
    }

    public StringProperty getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
    

}
