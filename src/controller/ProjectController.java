/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.EmployeeDAO;
import model.Employee;
import model.Project;
import model.ProjectDAO;
import java.sql.Date;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Khandaa
 */
public class ProjectController {
    @FXML
    private TextField nameColumn;
    @FXML
    private TextArea resultArea;
    @FXML
    private TableView projectTable;
    

  

    //Search all employees
    @FXML
    private void getList(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Project> projects = ProjectDAO.getList();
            //Populate Employees on TableView
            populate(projects);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }

    //Populate Employee
    @FXML
    private void populate (Project p) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Project> projects = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        projects.add(p);
        //Set items to the projectTable
        projectTable.setItems(projects);
    }
    
    //Initializing the controller class.
    //This method is automatically called after the fxml file has been loaded.
    @FXML
    private void initialize () {
        /*
        The setCellValueFactory(...) that we set on the table columns are used to determine
        which field inside the Employee objects should be used for the particular column.
        The arrow -> indicates that we're using a Java 8 feature called Lambdas.
        (Another option would be to use a PropertyValueFactory, but this is not type-safe

        We're only using StringProperty values for our table columns in this example.
        When you want to use IntegerProperty or DoubleProperty, the setCellValueFactory(...)
        must have an additional asObject():
        */
        //idColumn.setCellValueFactory(cellData -> cellData.getValue().employeeIdProperty().asObject());
        //nameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        //employeeIdColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        //vendorIdColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
    }

    

    //Set Employee information t    o Text Area
    @FXML
    private void setEmpInfoToTextArea ( Employee emp) {
        resultArea.setText("First Name: " + emp.getFirstName() + "\n" +
                "Last Name: " + emp.getLastName());
    }

    //Populate Employee for TableView and Display Employee on TextArea
    @FXML
    private void populateAndShow(Project p) throws ClassNotFoundException {
        if (p != null) {
            populate(p);
            //setEmpInfoToTextArea(p);
        } else {
            resultArea.setText("This employee does not exist!\n");
        }
    }

    //Populate Employees for TableView
    @FXML
    private void populate (ObservableList<Project> data) throws ClassNotFoundException {
        //Set items to the projectTable
        projectTable.setItems(data);
    }
}
