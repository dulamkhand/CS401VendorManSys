package model.order;

import util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableMap;
import model.invoice.Invoice;
import model.project.Project;
import model.project.ProjectDAO;

/**
 *
 * @author Khandaa
 */
public class OrderDAO {
  
    public static Order find(String id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT a.id, a.project_id, a.amount, a.currency,\n"+
                "concat(b.id) as project_id, concat(b.title) as project_name\n" +
                "FROM orders a\n" +
                "JOIN project b on b.id = a.project_id\n" +
                "WHERE invoice_id = 0 and id = " + id;
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
          
            Order o = null;
            if (rs.next()) {
                o = new Order();
                o.setId(rs.getInt("ID"));
                o.setProject(new Project(rs.getInt("PROJECT_ID"), rs.getString("PROJECT_NAME")));
                o.setAmount(rs.getDouble("AMOUNT"));
                o.setCurrency(rs.getString("CURRENCY"));
                o.setStatus(OrderStatusDAO.find(rs.getInt("STATUS")));
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
        String selectStmt = "SELECT a.id, a.project_id, a.amount, a.currency,\n" + 
                "CONCAT(b.name) as INVOICE_NAME,\n" +
                "CONCAT(c.ID) as STATUSID, CONCAT(c.status) as STATUS,\n" +
                "CONCAT(d.id) as PROJECT_ID, CONCAT(d.title) as PROJECT_NAME\n" +
                "FROM orders a\n" +
                "LEFT JOIN order_status c ON c.id = a.status\n" +
                "LEFT JOIN project d ON d.id = a.project_id\n" +
                "LEFT OUTER JOIN invoice b ON b.id = a.invoice_id;";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Order> list = FXCollections.observableArrayList();

            Order o;
            while (rs.next()) {
                o = new Order();
                o.setId(rs.getInt("ID"));
                o.setProject(new Project(rs.getInt("PROJECT_ID"), rs.getString("PROJECT_NAME")));
                o.setAmount(rs.getDouble("AMOUNT"));
                o.setCurrency(rs.getString("CURRENCY"));
                o.setStatus(new OrderStatus(rs.getInt("STATUSID"), rs.getString("STATUS")));
                o.setInvoice(new Invoice(rs.getString("INVOICE_NAME")));
                list.add(o);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }
    
    public static void insert(Integer projectId, Double amount, String currency, Integer statusId) 
            throws SQLException, ClassNotFoundException {
        String updateStmt = "INSERT INTO orders (PROJECT_ID, AMOUNT, CURRENCY, STATUS) "
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
                "   UPDATE orders\n" +
                "      SET amount = '" + amount + "'\n" +
                "      SET currency = '" + currency + "'\n" +
                "    WHERE ID = " + id + ";\n" +
                "   COMMIT;\n";
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }
    
    public static void updateWithInvoiceId(String ids, Integer invoiceId) 
            throws SQLException, ClassNotFoundException {
        String updateStmt = "UPDATE orders SET invoice_id = " + invoiceId +
                " WHERE ID in (" + ids + ");";
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

    public static void delete(String id) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "   DELETE FROM orders\n" +
                "         WHERE id ="+ id +";\n" +
                "   COMMIT;\n";

        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    
    public static ObservableMap<Integer, Order> listInInvoice() throws SQLException, 
            ClassNotFoundException {
        String selectStmt = "SELECT a.id, a.project_id, a.amount, a.currency,\n"+
                "concat(b.id) as project_id, concat(b.title) as project_name\n" +
                "FROM orders a\n" +
                "JOIN project b on b.id = a.project_id\n" +
                "WHERE invoice_id = 0;";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            ObservableMap<Integer, Order> map = FXCollections.observableHashMap();
            Order o;
            int i = 0;
            while (rs.next()) {   
                o = new Order();
                o.setId(rs.getInt("id"));
                o.setProject(new Project(rs.getInt("PROJECT_ID"), rs.getString("PROJECT_NAME")));
                o.setAmount(rs.getDouble("amount"));
                o.setCurrency(rs.getString("currency"));
                map.put(i++, o);
            }
            return map;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }
}