package model.item;

import util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Khandaa
 */
public class ItemDAO {
  
    public static Item find(Integer id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM item WHERE id="+id;
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
          
            Item i = null;
            if (rs.next()) {
                i = new Item();
                i.setId(rs.getInt("ID"));
                //i.setProjectId(rs.getInt("PROJECT_ID"));
                i.setName(rs.getString("NAME"));
                i.setNumberWords(rs.getInt("NB_WORDS"));
            }
            return i;
        } catch (SQLException e) {
            System.out.println("While searching an item with " + 
                    id + " id, an error occurred: " + e);
            throw e;
        }
    }

    public static ObservableList<Item> list() throws SQLException, 
            ClassNotFoundException {
        String selectStmt = "SELECT * FROM item";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<Item> list = FXCollections.observableArrayList();

            Item i;
            while (rs.next()) {
                i = new Item();
                i.setId(rs.getInt("ID"));
                //i.setProjectId(rs.getInt("PROJECT_ID"));
                i.setName(rs.getString("NAME"));
                i.setNumberWords(rs.getInt("NB_WORDS"));
                list.add(i);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }
    
    public static void insert(Integer projectId, String name, Integer numberWords) 
            throws SQLException, ClassNotFoundException {
        String updateStmt =
            "BEGIN\n" +
                "INSERT INTO item\n" +
                "(PROJECT_ID, NAME, NB_WORDS)\n" +
                "VALUES('"+projectId+"', '"+name+"', "+numberWords+");\n" +
                "END;";

        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT Operation: " + e);
            throw e;
        }
    }
   
    public static void update (String id, Integer projectId, String name, Integer numberWords) 
            throws SQLException, ClassNotFoundException {
        String updateStmt =
            "BEGIN\n" +
                "   UPDATE item\n" +
                "      SET PROJECT_ID = " + projectId + "\n" +
                "      SET NAME = '" + name + "'\n" +
                "      SET NB_WORDS = " + numberWords + "\n" +
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
                "   DELETE FROM item\n" +
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