package database.entity.dao;

import database.entity.Project;
import database.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Khandaa
 */
public class ProjectDAO {
  
    public static Project find(String id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM project WHERE id="+id;
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
          
            Project p = null;
            if (rs.next()) {
                p = new Project();
                p.setId(rs.getInt("ID"));
                p.setTitle(rs.getString("TITLE"));
                p.setAmount(rs.getDouble("AMOUNT"));
                p.setCurrency(rs.getString("CURRENCY"));
                p.setVendorId(rs.getInt("VENDOR_ID"));
                p.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
                //p.setCreatedDate(new SimpleIntegerProperty(rs.getDate("CREATED_DATE")));
            }
            return p;
        } catch (SQLException e) {
            System.out.println("While searching a project with " + 
                    id + " id, an error occurred: " + e);
            throw e;
        }
    }

    public static ObservableList<Project> getList () throws SQLException, 
            ClassNotFoundException {
        String selectStmt = "SELECT * FROM project";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Project> list = FXCollections.observableArrayList();

            Project p;
            while (rs.next()) {
                p = new Project();
                p.setId(rs.getInt("ID"));
                p.setTitle(rs.getString("TITLE"));
                p.setAmount(rs.getDouble("AMOUNT"));
                p.setCurrency(rs.getString("CURRENCY"));
                p.setVendorId(rs.getInt("VENDOR_ID"));
                p.setEmployeeId(rs.getInt("EMPLOYEE_ID"));                
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }
    
    public static void insert(String title, Integer employeeId, Integer vendorId) 
            throws SQLException, ClassNotFoundException {
        String updateStmt =
            "BEGIN\n" +
                "INSERT INTO project\n" +
                "(TITLE, EMPLOYEE_ID, PROJECT_ID, VENDOR_ID)\n" +
                "VALUES('"+title+"', '"+employeeId+"','"+vendorId+"');\n" +
                "END;";

        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
   
    public static void update (String id, String title, Integer employeeId, Integer vendorId) 
            throws SQLException, ClassNotFoundException {
        String updateStmt =
            "BEGIN\n" +
                "   UPDATE project\n" +
                "      SET title = '" + title + "'\n" +
                "      SET EMPLOYEE_ID = '" + employeeId + "'\n" +
                "      SET VENDOR_ID = '" + vendorId + "'\n" +
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
                "   DELETE FROM project\n" +
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