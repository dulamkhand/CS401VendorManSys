/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.invoice;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.StringProperty;
import model.account.Vendor;
import model.order.Order;

/**
 *
 * @author bek
 */
public class Invoice {
    //unique
    private StringProperty name;
    private InvoiceStatus status;
    private DoubleProperty amount;
    private StringProperty currency;
    private ListProperty<Order> orders;
    private ApprovalStatus approvalStatus;
    private Vendor vendor;
}
