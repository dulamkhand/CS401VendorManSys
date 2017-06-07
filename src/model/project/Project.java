/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.project;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
