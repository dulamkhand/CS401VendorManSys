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
        String selectStmt = "SELECT * FROM invoice WHERE id="+id;
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
          
            Invoice o = null;
            if (rs.next()) {
                o = new Invoice();
                o.setId(rs.getInt("ID"));
                o.setName(rs.getString("NAME"));
                o.setAmount(rs.getDouble("AMOUNT"));
                o.setCurrency(rs.getString("CURRENCY"));
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
        String selectStmt = "SELECT id, name, amount, currency, status"
                + " FROM invoice WHERE 1;";
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
                list.add(o);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }
    
    public static void insert(String name, Double amount, String currency, Integer statusId) 
            throws SQLException, ClassNotFoundException {
        String updateStmt =
            "INSERT INTO invoice (NAME, AMOUNT, CURRENCY, STATUS) "
            + " VALUES(" + name + ", " + amount + ", '" + currency + "', " + statusId + ");";

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