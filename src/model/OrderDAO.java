package model;

import util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Khandaa
 */
public class OrderDAO {
  
    public static Order find(String id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM order WHERE id="+id;
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
          
            Order o = null;
            if (rs.next()) {
                o = new Order();
                o.setId(rs.getInt("ID"));
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
        String selectStmt = "SELECT * FROM orders WHERE 1;";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Order> list = FXCollections.observableArrayList();

            Order p;
            while (rs.next()) {
                p = new Order();
                p.setId(rs.getInt("ID"));
                //System.out.println(rs.getString("ID"));
                p.setAmount(rs.getDouble("AMOUNT"));
                //System.out.println(rs.getString("AMOUNT"));
                p.setCurrency(rs.getString("CURRENCY"));        
                //System.out.println(rs.getString("CURRENCY"));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }
    
    public static void insert(Double amount, String currency) 
            throws SQLException, ClassNotFoundException {
        String updateStmt =
            "BEGIN\n" +
                "INSERT INTO order\n" +
                "(AMOUNT, CURRENCY)\n" +
                "VALUES(" + amount + ", '" + currency + "');\n" +
                "END;";

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
                "   UPDATE order\n" +
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
                "   DELETE FROM order\n" +
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