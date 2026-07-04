package net.saadbr.repository;

import net.saadbr.model.AccountStatus;
import net.saadbr.model.AccountType;
import net.saadbr.model.BankAccount;
import net.saadbr.model.BankDirector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author saade
 **/
public class AccountRepositoryImpl implements AccountRepository {
    private static final AccountRepositoryImpl accountRepository;
    static {
        System.out.println("Singleton instantiation");
        accountRepository = new AccountRepositoryImpl();
    }
    private Map<Long, BankAccount> bankAccounts = new HashMap();
    private long accountsCount = 0;
    private AccountRepositoryImpl() {}
    @Override
    public synchronized BankAccount save(BankAccount account) {
        Long accountId;
        accountId =++accountsCount;
        bankAccounts.put(accountId, account);
        account.setAccountId(accountId);
        return account;
    }

    @Override
    public List<BankAccount> findAll() {
        return bankAccounts.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<BankAccount> findById(long id) {
        BankAccount account = bankAccounts.get(id);
        if (account == null) {
            return Optional.empty();
        }
        return Optional.of(account);
    }

    @Override
    public List<BankAccount> searchAccounts(Predicate<BankAccount> predicate) {
        return bankAccounts.values().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public BankAccount update(BankAccount account) {
        bankAccounts.put(account.getAccountId(), account);
        return account;
    }

    @Override
    public void deleteById(long id) {
        bankAccounts.remove(id);
    }

    public void populateData(){
        for (int i = 0; i < 10 ; i++){
            BankAccount account = BankDirector.acountBuilder()
                    .balance(1000+Math.random()*90000)
                    .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                    .status(Math.random()>0.5? AccountStatus.ACTIVATED:AccountStatus.CREATED)
                    .currency(Math.random()>0.5?"MAD":"EUR")
                    .build();
            save(account);
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println("Accounts count: "+accountsCount);
        System.out.println("Size of bank accounts: "+bankAccounts.values().size());
    }
    public synchronized static AccountRepositoryImpl getInstance() {
        return accountRepository;
    }
}
