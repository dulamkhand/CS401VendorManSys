/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.payment;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.account.Vendor;
import model.invoice.Invoice;

/**
 *
 * @author bek
 */
public class Payment {
    private IntegerProperty id;
    private DoubleProperty amount;
    private StringProperty currency;
    private PaymentStatus status;
    private ListProperty<Invoice> invoices;
    private StringProperty invoice;
    private Vendor vendor;
    private StringProperty code;
    
    public Payment() {
        this.id = new SimpleIntegerProperty();
        this.amount = new SimpleDoubleProperty();
        this.currency = new SimpleStringProperty();
        this.invoice = new SimpleStringProperty();
        this.code = new SimpleStringProperty();
    }
    
    public IntegerProperty getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id.set(id);
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
    
    public StringProperty getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code.set(code);
    }
    
    public StringProperty getInvoice() {
        return invoice;
    }
    
    public void setInvoice(String invoice) {
        this.invoice.set(invoice);
    }
}
