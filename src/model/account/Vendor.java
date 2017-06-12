/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.account;

import java.util.Date;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.StringProperty;
import model.servicetype.ServiceType;

/**
 *
 * @author bek
 */
public abstract class Vendor extends VendorEmployee {

    private StringProperty number;
    //optional (0..1) we could add it later
    private ListProperty<ServiceType> services;
    
    public Vendor() {
    }

    Vendor(Account acc, StringProperty number) {
        super(acc);
        this.number = number;
        this.services = new SimpleListProperty<>();
    }

    public void addServiceType(ServiceType s) {
        this.services.add(s);
    }

}
