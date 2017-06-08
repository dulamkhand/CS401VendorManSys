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

    private Date created;
    private Account account;

    VendorEmployee(Account acc, Date created) {
        this.account = acc;
        this.created = created;
    }

    public Account getAccount() {
        return account;
    }

    void setAccount(Account account) {
        this.account = account;
    }

    public Date getCreated() {
        return created;
    }

    void setCreated(Date created) {
        this.created = created;
    }
  
}
