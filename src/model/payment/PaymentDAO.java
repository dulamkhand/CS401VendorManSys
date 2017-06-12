package model.payment;

import util.DBUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Khandaa
 */
public class PaymentDAO {
  
    public static PaymentStatus find(Integer id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM payment WHERE id="+id;
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
          
            PaymentStatus os = null;
            if (rs.next()) {
                os = new PaymentStatus();
                os.setId(rs.getInt("ID"));
                os.setName(rs.getString("NAME"));
            }
            return os;
        } catch (SQLException e) {
            System.out.println("While searching a PaymentStatus with " + 
                    id + " id, an error occurred: " + e);
            throw e;
        }
    }
    
    
    public static ObservableList<Payment> list() throws SQLException, 
            ClassNotFoundException {
        String selectStmt = "SELECT * FROM payment";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Payment> list = FXCollections.observableArrayList();

            Payment p;
            while (rs.next()) {
                p = new Payment();
                p.setId(rs.getInt("ID"));
                p.setInvoice(rs.getString("INVOICE_ID"));
                p.setCode(rs.getString("CODE"));
                p.setAmount(rs.getDouble("AMOUNT"));
                p.setCurrency(rs.getString("CURRENCY"));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }
    
    public static void insert(String code, Double amount, String currency, String invoice_name) 
            throws SQLException, ClassNotFoundException {
        String updateStmt =
                "INSERT INTO payment\n" +
                "(CODE, AMOUNT, CURRENCY, STATUS, INVOICE_ID)\n" +
                "VALUES('"+code+"', "+amount+", '"+currency+"', NULL, '"+invoice_name+"')\n";

        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT Operation: " + e);
            throw e;
        }
    }
}