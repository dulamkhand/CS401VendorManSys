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
    private StringProperty title;
    private DoubleProperty amount;
    private StringProperty currency;
    private Date created;
    private Vendor vendor;
    private ProjectStatus projectStatus;
    private ListProperty<Item> itemList;
    private Order order;
    
    public Project() {
        this.id = new SimpleIntegerProperty();
        this.title = new SimpleStringProperty();
        this.amount = new SimpleDoubleProperty();
        this.currency = new SimpleStringProperty();
        this.created = new Date();
        this.projectStatus = new ProjectStatus();
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
    
    public ListProperty getItemList() {
        return itemList;
    }

    public void setItemList(ListProperty<Item> itemList) {
        this.itemList = itemList;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
    
    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }
    
    public StringProperty getServiceName() {
        StringProperty serviceName = null;
        
        if (itemList != null && itemList.size() > 0) {
            serviceName = itemList.get(0).getServiceType().getName();
        }
        
        return serviceName;
    }
}