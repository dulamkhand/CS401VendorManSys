package model.invoice;

import model.invoice.*;
import util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Khandaa
 */
public class InvoiceDAO {
  
    public static Invoice find(String id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT a.*, concat(d.id) as STATUSID, concat(d.STATUS) as STATUS\n"
                + "FROM invoice a\n"
                + "JOIN invoice_status d ON a.status = d.id\n"
                + "WHERE id = " + id + ";";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
          
            Invoice o = null;
            if (rs.next()) {
                o = new Invoice();
                o.setId(rs.getInt("ID"));
                o.setName(rs.getString("NAME"));
                o.setAmount(rs.getDouble("AMOUNT"));
                o.setCurrency(rs.getString("CURRENCY"));
                o.setStatus(new InvoiceStatus(rs.getInt("STATUSID"), rs.getString("STATUS")));
            }
            return o;
        } catch (SQLException e) {
            System.out.println("While searching a invoice with " + 
                    id + " id, an error occurred: " + e);
            throw e;
        }
    }

    public static ObservableList<Invoice> list() throws SQLException, 
            ClassNotFoundException {
        String selectStmt = "SELECT a.id, a.name, a.amount, a.currency,\n" + 
                "concat(b.id, '-', c.title ) as ORDERS,\n" +
                "concat(d.id) as STATUSID, concat(d.STATUS) as STATUS\n" +
                "FROM `invoice` a\n" +
                "LEFT OUTER JOIN orders b ON a.id = b.invoice_id\n" +
                "JOIN project c ON b.project_id = c.id\n" +
                "JOIN invoice_status d ON a.status = d.id";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Invoice> list = FXCollections.observableArrayList();

            Invoice o;
            while (rs.next()) {
                o = new Invoice();
                o.setId(rs.getInt("ID"));
                o.setName(rs.getString("NAME"));
                o.setAmount(rs.getDouble("AMOUNT"));
                o.setCurrency(rs.getString("CURRENCY"));
                o.setStatus(new InvoiceStatus(rs.getInt("STATUSID"), rs.getString("STATUS")));
                o.setOrderids(rs.getString("ORDERS"));
                list.add(o);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }
    
    public static Integer insert(String name, Double amount, String currency, Integer statusId) 
            throws SQLException, ClassNotFoundException {
        Integer id = null;
        String updateStmt =
            "INSERT INTO invoice (NAME, AMOUNT, CURRENCY, STATUS) "
            + " VALUES('" + name + "', " + amount + ", '" + currency + "', " + statusId + ");";

        try {
            id = DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT Operation: " + e);
            throw e;
        }
        return id;
    }
   
    public static void update (String id, String amount, Integer currency) 
            throws SQLException, ClassNotFoundException {
        String updateStmt =
            "BEGIN\n" +
                "   UPDATE invoice\n" +
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
                "   DELETE FROM invoice\n" +
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