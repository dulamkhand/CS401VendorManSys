/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.account;

/**
 *
 * @author bek
 */
public class EmployeeAccountImpl implements EmployeeAccount {

    private Employee employee;
    private Account account;

    EmployeeAccountImpl(Employee employee, Account account) {
        this.employee = employee;
        this.account = account;
    }

    @Override
    public Employee getEmployee() {
        return employee;
    }

    @Override
    public Account getAccount() {
        return account;
    }

}
