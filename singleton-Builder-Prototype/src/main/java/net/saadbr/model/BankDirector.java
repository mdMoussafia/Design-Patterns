package net.saadbr.model;

/**
 * @author saade
 **/
public class BankDirector {
    public static BankAccount.AccountBuilder acountBuilder() {
        return new BankAccount.AccountBuilder();
    }
}
