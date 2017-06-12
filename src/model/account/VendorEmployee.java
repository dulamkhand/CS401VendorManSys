/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.account;

import java.util.Date;

/**
 *
 * @author bek
 */
public abstract class VendorEmployee {

    private Account account;
    
    public VendorEmployee() {
    }

    VendorEmployee(Account acc) {
        this.account = acc;
    }

    public Account getAccount() {
        return account;
    }

    void setAccount(Account account) {
        this.account = account;
    }
}
