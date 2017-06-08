package model.payment;

import util.DBUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 *
 * @author Khandaa
 */
public class PaymentStatusDAO {
  
    public static PaymentStatus find(Integer id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM payment_status WHERE id="+id;
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
    
    
    public static ObservableMap<Integer, PaymentStatus> list() throws SQLException, 
            ClassNotFoundException {
        String selectStmt = "SELECT id, name FROM payment_status;";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            ObservableMap<Integer, PaymentStatus> map = FXCollections.observableHashMap();
            PaymentStatus os;
            int i = 0;
            while (rs.next()) {   
                os = new PaymentStatus();
                os.setId(rs.getInt("id"));
                os.setName(rs.getString("name"));
                map.put(i++, os);
            }
            return map;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }
}