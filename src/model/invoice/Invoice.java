/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.invoice;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.account.Vendor;
import model.order.Order;

/**
 *
 * @author bek
 */
public class Invoice {
    //unique
    private IntegerProperty id;
    private StringProperty name;
    private DoubleProperty amount;
    private StringProperty currency;
    
    private ListProperty<Order> orders;
    private InvoiceStatus status;
    private ApprovalStatus approvalStatus;
    private Vendor vendor;
    
    public Invoice() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.amount = new SimpleDoubleProperty();
        this.currency = new SimpleStringProperty();
    }
    
    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    public ApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(ApprovalStatus status) {
        this.approvalStatus = status;
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
