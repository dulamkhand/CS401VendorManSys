/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.item;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.project.Project;
import model.servicetype.ServiceType;

/**
 *
 * @author bek
 */
public class Item {
    private IntegerProperty id;
    private Project project;
    private StringProperty name;
    private IntegerProperty numberWords;
    private ServiceType serviceType;
	
    public Item() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.numberWords = new SimpleIntegerProperty();
    }
    public IntegerProperty getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id.set(id);
    }
    
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    
    public StringProperty getName() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
    
    public IntegerProperty getNumberWords() {
        return numberWords;
    }

    public void setNumberWords(Integer numberWords) {
        this.numberWords.set(numberWords);
    }
    
    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}