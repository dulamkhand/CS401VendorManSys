/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.payment;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
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
    private Vendor vendor;
}
