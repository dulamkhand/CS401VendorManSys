package model.account;

import model.account.*;
import util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bek
 */
public class AccountEmployeeVendorDAO {

    public static EmployeeAccount findEmployee(String login) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM account WHERE login_name = '" + login + "'";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);

            EmployeeAccount o = null;

            if (rs.next()) {
                String type = rs.getString("TYPE");
                System.out.println("TYPE: " + type);

                if (type.equals(AccountTypeEnum.SUPER_USER.toString())) {
                    o = EmployeeAccountFactory.createSuperUser(rs.getString("NUMBER"), rs.getString("vend_emp_id"), rs.getString("login_name"), rs.getString("password"));
                } else if (type.equals(AccountTypeEnum.EMPLOYEE.toString())) {
                    System.out.println(rs.getString("number"));
                    String selectEmpStmt = "SELECT * FROM employee WHERE acc_number = '" + rs.getString("number") + "'";
                    ResultSet rsEmp = DBUtil.dbExecuteQuery(selectEmpStmt);
                    if (rsEmp.next()) {
                        o = EmployeeAccountFactory.createAccountEmployee(rs.getString("number"), rs.getString("vend_emp_id"), rs.getString("login_name"), rs.getString("password"), rsEmp.getString("first_name"), rsEmp.getString("last_name"));
                    }
                }
            }
            return o;
        } catch (SQLException e) {
            System.out.println("While searching a order with "
                    + login + " id, an error occurred: " + e);
            throw e;
        }
    }

    public static ObservableList findEmployeeByNumberFuzzy(String number) throws SQLException, ClassNotFoundException {
        number = "%" + number + "%";
        String selectStmt = "SELECT employee.number as number, employee.acc_number as accNumber, account.login_name as login, employee.first_name as name, employee.last_name as surname"
                + " FROM employee "
                + "INNER JOIN account ON employee.number=account.vend_emp_id and employee.number like '" + number + "'";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);

            ObservableList<EmployeeResult> list = FXCollections.observableArrayList();

            EmployeeResult empRes;
            while (rs.next()) {
                empRes = new EmployeeResult();
                empRes.setNumber(rs.getString("number"));
                empRes.setAccNumber(rs.getString("acc_number"));
                empRes.setLogin(rs.getString("login_name"));
                empRes.setName(rs.getString("first_name"));
                empRes.setSurename(rs.getString("last_name"));
                list.add(empRes);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("While searching a order with "
                    + number + " number, an error occurred: " + e);
            throw e;
        }
    }
    
    public static ObservableList findPersonByVendorNumberFuzzy(String vendorNumber) throws SQLException, ClassNotFoundException {
        vendorNumber = "%" + vendorNumber + "%";
        String selectStmt = "SELECT person.vendor_number, person.acc_number, account.login_name, person.first_name, person.last_name, person.ssn, person.nationality"
                + " FROM person "
                + "INNER JOIN account ON person.vendor_number=account.vend_emp_id and person.vendor_number like '" + vendorNumber + "'";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);

            ObservableList<PersonResult> list = FXCollections.observableArrayList();

            PersonResult perRes;
            while (rs.next()) {
                perRes = new PersonResult();
                perRes.setNumber(rs.getString("vendor_number"));
                perRes.setAccNumber(rs.getString("acc_number"));
                perRes.setLogin(rs.getString("login_name"));
                perRes.setName(rs.getString("first_name"));
                perRes.setSurename(rs.getString("last_name"));
                perRes.setSsn(rs.getString("SSN"));
                perRes.setNationality(rs.getString("nationality"));
                list.add(perRes);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("While searching a order with "
                    + vendorNumber + " number, an error occurred: " + e);
            throw e;
        }
    }
    
    public static ObservableList findCompanyByVendorNumberFuzzy(String vendorNumber) throws SQLException, ClassNotFoundException {
        vendorNumber = "%" + vendorNumber + "%";
        String selectStmt = "SELECT company.vendor_number, company.acc_number, account.login_name, company.name, company.company_rep, company.comp_reg_number"
                + " FROM company "
                + "INNER JOIN account ON company.vendor_number=account.vend_emp_id and company.vendor_number like '" + vendorNumber + "'";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);

            ObservableList<CompanyResult> list = FXCollections.observableArrayList();

            CompanyResult compRes;
            while (rs.next()) {
                compRes = new CompanyResult();
                compRes.setNumber(rs.getString("vendor_number"));
                compRes.setAccNumber(rs.getString("acc_number"));
                compRes.setLogin(rs.getString("login_name"));
                compRes.setName(rs.getString("name"));
                compRes.setCompanyRegNum(rs.getString("comp_reg_number"));
                compRes.setCompanyRep(rs.getString("company_rep"));
                list.add(compRes);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("While searching a order with "
                    + vendorNumber + " number, an error occurred: " + e);
            throw e;
        }
    }

    public static VendorAccount findVendor(String login) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM account WHERE login_name = '" + login + "'";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);

            VendorAccount o = null;

            if (rs.next()) {
                String type = rs.getString("TYPE");

                if (type.equals(AccountTypeEnum.PERSON.toString())) {
                    String selectPersonStmt = "SELECT * FROM person WHERE vendor_number = '" + rs.getString("vend_emp_id") + "'";
                    ResultSet rsPerson = DBUtil.dbExecuteQuery(selectPersonStmt);
                    if (rsPerson.next()) {
                        o = VendorAccountFactory.createVendorPerson(rs.getString("number"), rs.getString("login_name"), rs.getString("password"), rsPerson.getString("first_name"), rsPerson.getString("last_name"), rsPerson.getString("SSN"), rsPerson.getString("nationality"), rsPerson.getString("vendor_number"));
                    }
                } else if (type.equals(AccountTypeEnum.COMPANY.toString())) {
                    String selectCompanyStmt = "SELECT * FROM company WHERE vendor_number = '" + rs.getString("vend_emp_id") + "'";
                    ResultSet rsCompany = DBUtil.dbExecuteQuery(selectCompanyStmt);
                    if (rsCompany.next()) {
                        o = VendorAccountFactory.createVendorCompany(rs.getString("number"), rs.getString("login_name"), rs.getString("password"), rsCompany.getString("comp_reg_number"), rsCompany.getString("name"), rsCompany.getString("company_rep"), rsCompany.getString("vendor_number"));
                    }
                }
            }
            return o;
        } catch (SQLException e) {
            System.out.println("While searching a order with "
                    + login + " id, an error occurred: " + e);
            throw e;
        }
    }

    public static void insert(String accNumber, String login, String password, String empId, String firstName, String lastName)
            throws SQLException, ClassNotFoundException {
        String updateStmt1
                = "INSERT INTO `account` (`number`, `login_name`, `password`, `type`, `vend_emp_id`) "
                + " VALUES ('" + accNumber + "', '" + login + "', '" + password + "', '" + AccountTypeEnum.EMPLOYEE.toString() + "', '" + empId + "')";
        String updateStmt2 = " INSERT INTO `employee` (`number`, `first_name`, `last_name`, `acc_number`) "
                + " VALUES ('" + empId + "', '" + firstName + "', '" + lastName + "', '" + accNumber + "')";
        try {
            DBUtil.dbExecuteUpdate(updateStmt1);
            DBUtil.dbExecuteUpdate(updateStmt2);
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT Operation: " + e);
            throw e;
        }
    }

    public static void insertPerson(String accNumber, String login, String password, String vendor_num, String firstName, String lastName, String ssn, String nationality)
            throws SQLException, ClassNotFoundException {
        String updateStmt1
                = "INSERT INTO `account` (`number`, `login_name`, `password`, `type`, `vend_emp_id`) "
                + " VALUES ('" + accNumber + "', '" + login + "', '" + password + "', '" + AccountTypeEnum.PERSON.toString() + "', '" + vendor_num + "')";
        String updateStmt2 = " INSERT INTO `person` (`first_name`, `last_name`, `SSN`, `nationality`, `vendor_number`, `acc_number`) "
                + " VALUES ('" + firstName + "', '" + lastName + "', '" + ssn + "', '" + nationality + "', '" + vendor_num + "', '" + accNumber + "')";
        try {
            DBUtil.dbExecuteUpdate(updateStmt1);
            DBUtil.dbExecuteUpdate(updateStmt2);
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT Operation: " + e);
            throw e;
        }
    }

    public static void insertCompany(String accNumber, String login, String password, String vendor_num, String name, String compRegNumber, String companyRep)
            throws SQLException, ClassNotFoundException {
        String updateStmt1
                = "INSERT INTO `account` (`number`, `login_name`, `password`, `type`, `vend_emp_id`) "
                + " VALUES ('" + accNumber + "', '" + login + "', '" + password + "', '" + AccountTypeEnum.COMPANY.toString() + "', '" + vendor_num + "')";
        String updateStmt2 = " INSERT INTO `company` (`vendor_number`, `comp_reg_number`, `name`, `company_rep`, `acc_number`) "
                + " VALUES ('" + vendor_num + "', '" + compRegNumber + "', '" + name + "', '" + companyRep + "', '" + accNumber + "')";
        try {
            DBUtil.dbExecuteUpdate(updateStmt1);
            DBUtil.dbExecuteUpdate(updateStmt2);
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT Operation: " + e);
            throw e;
        }
    }

//    public static void update (String id, String amount, Integer currency) 
//            throws SQLException, ClassNotFoundException {
//        String updateStmt =
//            "BEGIN\n" +
//                "   UPDATE Account\n" +
//                "      SET amount = '" + amount + "'\n" +
//                "      SET currency = '" + currency + "'\n" +
//                "    WHERE ID = " + id + ";\n" +
//                "   COMMIT;\n" +
//                "END;";
//        try {
//            DBUtil.dbExecuteUpdate(updateStmt);
//        } catch (SQLException e) {
//            System.out.print("Error occurred while UPDATE Operation: " + e);
//            throw e;
//        }
//    }
}
