/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.invoice;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author bek
 */
public class ApprovalStatus {
    private IntegerProperty id;
    //approved, not approved, rejected etc.
    private StringProperty status;
}
