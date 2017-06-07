/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.item;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import model.servicetype.ServiceType;

/**
 *
 * @author bek
 */
public class Item {
    private IntegerProperty id;
    private StringProperty name;
    private IntegerProperty numberOfWords;
    private ServiceType service;
}
