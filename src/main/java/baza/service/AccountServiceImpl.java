package baza.service;

import baza.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    private AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

}
