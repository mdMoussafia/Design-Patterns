package net.saadbr;

import net.saadbr.model.AccountType;
import net.saadbr.model.BankAccount;
import net.saadbr.repository.AccountRepositoryImpl;
import net.saadbr.util.JsonSerializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.function.Predicate;

@SpringBootApplication
public class DpBankApplication {

    public static void main(String[] args) throws IOException {
        JsonSerializer<BankAccount> bankAccountJsonSerializer = new JsonSerializer<>();
        AccountRepositoryImpl repository = AccountRepositoryImpl.getInstance();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                repository.populateData();
            }).start();
        }
        System.out.println("Tape a character");
        System.in.read();
        repository.populateData();
        repository.findAll().stream()
                .map(bankAccountJsonSerializer::toJson)
                .forEach(System.out::println);
        System.out.println("\n\n");
        BankAccount account = repository.findById(1L).orElse(null);
        if (account != null) {
            System.out.println(bankAccountJsonSerializer.toJson(account));
        }
        System.out.println("\n\n");
        repository.searchAccounts(new Predicate<BankAccount>() {
            @Override
            public boolean test(BankAccount bankAccount) {
                return bankAccount.getType().equals(AccountType.CURRENT_ACCOUNT) && bankAccount.getBalance() > 80000;
            }
        }).stream()
                .map(bankAccountJsonSerializer::toJson)
                .forEach(System.out::println);
    }
}
