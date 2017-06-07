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
    private IntegerProperty projectId;
    private StringProperty name;
    private IntegerProperty numberOfWords;
    private ServiceType serviceType;
  
    public Item() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.numberWords = new SimpleIntegerProperty();
        this.createdDate = new SimpleStringProperty();
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
    
    public StringProperty getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(StringProperty createdDate) {
        this.createdDate = createdDate;
    }
  
    public Item() {
        this.id = new SimpleIntegerProperty();
        this.projectId = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.numberWords = new SimpleIntegerProperty();
        this.createdDate = new SimpleStringProperty();
    }

    public IntegerProperty getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id.set(id);
    }
    
    public IntegerProperty getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId.set(projectId);
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
    
    public StringProperty getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(StringProperty createdDate) {
        this.createdDate = createdDate;
    }
    
    private Project project;
    
    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
