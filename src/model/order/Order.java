/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.order;

import com.sun.xml.internal.bind.v2.TODO;
import java.util.Date;
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
    
    
    
    @Override
    public String toString() {
        return String.format("Order(%s): amount(%s), currency(%s), created(%s), project(%s).", this.id.getValue(), 
                this.amount.getValue(), this.currency.getValue(), this.created.toString(), this.project.toString());
        //to-do revise this implementation
        //return String.format("Order(%s): amount(%s), currency(%s).", this.id.getValue(), 
        //       this.amount.getValue(), this.currency.getValue());
    }
  

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
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
