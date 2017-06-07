/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.account;

import java.sql.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author bek
 */
public class Account {
    private IntegerProperty id;
    private StringProperty loginName;
    private StringProperty password;
    private Date creationDate;
    private AccountType type;
    
    //should have only one of them
    private Vendor vendor;
    private Employee employee;
}
