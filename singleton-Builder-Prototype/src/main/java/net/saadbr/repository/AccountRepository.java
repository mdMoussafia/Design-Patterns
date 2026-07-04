package net.saadbr.repository;

import net.saadbr.model.BankAccount;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author saade
 **/
public interface AccountRepository {
    BankAccount save(BankAccount account);
    List<BankAccount> findAll();
    Optional<BankAccount> findById(long id);
    List<BankAccount> searchAccounts(Predicate<BankAccount> predicate);
    BankAccount update(BankAccount account);
    void deleteById(long id);
}
