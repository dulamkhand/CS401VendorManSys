/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.account;

import java.util.Date;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import model.servicetype.ServiceType;

/**
 *
 * @author bek
 */
public abstract class Vendor {
    private IntegerProperty id;
    private Date created;
    //optional (0..1) we could add it later
    private List<ServiceType> services;
    //must have
    private Account account;
}
