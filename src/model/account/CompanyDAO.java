package model.account;

import model.servicetype.*;
import util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Khandaa
 */
public class CompanyDAO {
    public static ServiceType find(Integer id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM service WHERE id=" + id + ";";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
          
            ServiceType s = null;
            if (rs.next()) {
                s = new ServiceType();
                s.setId(rs.getInt("ID"));
                s.setName(rs.getString("NAME"));
            }
            return s;
        } catch (SQLException e) {
            System.out.println("While searching a service type with " + 
                    id + " id, an error occurred: " + e);
            throw e;
        }
    }

    public static ObservableList<Company> list() throws SQLException, 
            ClassNotFoundException {
        String selectStmt = "SELECT * FROM company;";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Company> list = FXCollections.observableArrayList();

            Company c;
            while (rs.next()) {
                c = new Company();
                c.setName(new SimpleStringProperty(rs.getString("NAME")));
                list.add(c);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }
    
    public static void insert(Integer id, String name) 
            throws SQLException, ClassNotFoundException {
        String updateStmt =
            "BEGIN\n" +
                "INSERT INTO service\n" +
                "(ID, NAME)\n" +
                "VALUES('"+id+"', '"+name+"');\n" +
                "END;";

        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT Operation: " + e);
            throw e;
        }
    }
   
    public static void update (String id, String name) 
            throws SQLException, ClassNotFoundException {
        String updateStmt =
            "BEGIN\n" +
                "   UPDATE service\n" +
                "      SET title = '" + name + "'\n" +
                "    WHERE ID = " + id + ";\n" +
                "   COMMIT;\n" +
                "END;";
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

    public static void delete(String id) throws SQLException, ClassNotFoundException {
        String updateStmt =
            "BEGIN\n" +
                "   DELETE FROM service\n" +
                "         WHERE id ="+ id +";\n" +
                "   COMMIT;\n" +
                "END;";

        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

}