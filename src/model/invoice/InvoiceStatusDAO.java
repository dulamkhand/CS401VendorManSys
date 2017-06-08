package model.invoice;

import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 *
 * @author Khandaa
 */
public class InvoiceStatusDAO {
  
    public static InvoiceStatus find(Integer id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM invoice_status WHERE id="+id;
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
          
            InvoiceStatus os = null;
            if (rs.next()) {
                os = new InvoiceStatus();
                os.setId(rs.getInt("ID"));
                os.setName(rs.getString("NAME"));
            }
            return os;
        } catch (SQLException e) {
            System.out.println("While searching a InvoiceStatus with " + 
                    id + " id, an error occurred: " + e);
            throw e;
        }
    }
    
    public static ObservableMap<Integer, InvoiceStatus> list() throws SQLException, 
            ClassNotFoundException {
        String selectStmt = "SELECT id, name FROM invoice_status;";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            ObservableMap<Integer, InvoiceStatus> map = FXCollections.observableHashMap();
            InvoiceStatus os;
            int i = 0;
            while (rs.next()) {   
                os = new InvoiceStatus();
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