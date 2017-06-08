package model.order;

import util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.project.Project;
import model.project.ProjectDAO;

/**
 *
 * @author Khandaa
 */
public class OrderDAO {
  
    public static Order find(String id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM orders WHERE id="+id;
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
          
            Order o = null;
            if (rs.next()) {
                o = new Order();
                o.setId(rs.getInt("ID"));
                o.setProject(ProjectDAO.find(rs.getInt("PROJECT_ID")));
                o.setAmount(rs.getDouble("AMOUNT"));
                o.setCurrency(rs.getString("CURRENCY"));
            }
            return o;
        } catch (SQLException e) {
            System.out.println("While searching a order with " + 
                    id + " id, an error occurred: " + e);
            throw e;
        }
    }

    public static ObservableList<Order> list() throws SQLException, 
            ClassNotFoundException {
        String selectStmt = "SELECT id, project_id, amount, currency, status"
                + " FROM orders WHERE 1;";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Order> list = FXCollections.observableArrayList();

            Order o;
            while (rs.next()) {
                o = new Order();
                o.setId(rs.getInt("ID"));
                o.setProject(ProjectDAO.find(rs.getInt("PROJECT_ID")));
                o.setAmount(rs.getDouble("AMOUNT"));
                o.setCurrency(rs.getString("CURRENCY"));
                list.add(o);
                //System.out.println(o.toString());
            }
            return list;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }
    
    public static void insert(Integer projectId, Double amount, String currency, Integer statusId) 
            throws SQLException, ClassNotFoundException {
        String updateStmt =
            "INSERT INTO orders (PROJECT_ID, AMOUNT, CURRENCY, STATUS) "
            + " VALUES(" + projectId + ", " + amount + ", '" + currency + "', " + statusId + ");";

        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT Operation: " + e);
            throw e;
        }
    }
   
    public static void update (String id, String amount, Integer currency) 
            throws SQLException, ClassNotFoundException {
        String updateStmt =
            "BEGIN\n" +
                "   UPDATE orders\n" +
                "      SET amount = '" + amount + "'\n" +
                "      SET currency = '" + currency + "'\n" +
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
                "   DELETE FROM orders\n" +
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