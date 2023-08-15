package project.baza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.baza.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    private AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

}
