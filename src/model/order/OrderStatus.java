/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.order;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author bek
 */
public class OrderStatus {
    private IntegerProperty id;
    private StringProperty name;
    
    public OrderStatus() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
    }
    
    public OrderStatus(Integer id, String name) {
        this();
        this.setId(id);
        this.setName(name);
    }
    
    @Override
    public String toString() {
        return this.name.getValue();
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
}
