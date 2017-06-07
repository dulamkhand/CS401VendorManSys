/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.*;

/**
 *
 * @author Khandaa
 */
public class Item {
    
    private IntegerProperty id;
    private IntegerProperty projectId;
    private StringProperty name;
    private IntegerProperty numberWords;
    private StringProperty createdDate;

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
}