package model.order;

import util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.project.Project;

/**
 *
 * @author Khandaa
 */
public class OrderProjectDAO {
  
    public static ObservableList<Project> getProjectItems() throws SQLException, 
            ClassNotFoundException {
        String selectStmt = "SELECT * FROM project where id not in "
                + "(select project_id from orders);";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Project> list = FXCollections.observableArrayList();

            Project p;
            while (rs.next()) {
                p = new Project();
                p.setId(rs.getInt("ID"));
                p.setTitle(rs.getString("TITLE"));         
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }
    
}