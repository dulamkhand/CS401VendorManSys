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
public class VendorAccountImpl implements VendorAccount {

    private Account account;
    private Vendor vendor;

    VendorAccountImpl(Vendor vendor, Account account) {
        this.account = account;
        this.vendor = vendor;
    }

    @Override
    public Vendor getVendor() {
        return vendor;
    }

    @Override
    public Account getAccount() {
        return account;
    }

}
