package pl.lomianki.testing.account;

import java.util.List;
import java.util.stream.Collectors;

public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    List<Account> getAllActiveAccounts() {
//        return accountRepository.getAllAccounts().stream().filter(a->a.isActive()).collect(Collectors.toList());
        return accountRepository.getAllAccounts().stream()
                .filter(Account::isActive)
                .collect(Collectors.toList());
    }
}
