/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.order;

import java.sql.Date;
import javafx.beans.property.*;
import model.invoice.Invoice;
import model.project.Project;

/**
 *
 * @author Khandaa
 */
public class Order {
    
    private IntegerProperty id;
    private DoubleProperty amount;
    private StringProperty currency;
    private Date created;
    private Project project;
    private OrderStatus status;
    //optional (0..1)
    private Invoice invoice;

    public Order() {
        this.id = new SimpleIntegerProperty();
        this.amount = new SimpleDoubleProperty();
        this.currency = new SimpleStringProperty();
    }
    
    @Override
    public String toString() {
        return this.id.getValue().toString() + " - " + this.project.getTitle().getValue();
    }
    
    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
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

    public IntegerProperty getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id.set(id);
    }
    
}
