package model.order;

import util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableMap;
import model.project.Project;

/**
 *
 * @author Khandaa
 */
public class OrderProjectDAO {
  
    public static ObservableMap<Integer, Project> listInMap() throws SQLException, 
            ClassNotFoundException {
        String selectStmt = "SELECT id, title, amount, currency FROM "
                + "project WHERE id not in (select project_id from orders);";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            ObservableMap<Integer, Project> map = FXCollections.observableHashMap();
            Project p;
            int i = 0;
            while (rs.next()) {   
                p = new Project();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setAmount(rs.getDouble("amount"));
                p.setCurrency(rs.getString("currency"));
                map.put(i++, p);
            }
            return map;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }
    
    
}