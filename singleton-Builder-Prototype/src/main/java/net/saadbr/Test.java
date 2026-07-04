package net.saadbr;

import net.saadbr.model.AccountStatus;
import net.saadbr.model.AccountType;
import net.saadbr.model.BankAccount;
import net.saadbr.model.Customer;

/**
 * @author saade
 **/
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        BankAccount acc = new BankAccount();
        acc.setAccountId(1L);
        acc.setBalance(9000);
        acc.setCurrency("EUR");
        acc.setType(AccountType.SAVING_ACCOUNT);
        acc.setStatus(AccountStatus.CREATED);
        acc.setCustomer(new Customer(1L,"Saad"));
        BankAccount acc2 = acc.clone();
        acc.getCustomer().setName("Rhita");
        System.out.println(acc);
        System.out.println(acc2);
    }
}
