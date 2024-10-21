package com.isc.wallet1.service;

import com.isc.wallet1.model.Account;
import com.isc.wallet1.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {

        return accountRepository.save(account);
    }

    public Optional<Account> getAccount(Long id) {

        return accountRepository.findById(id);
    }

    public void deleteAccount(Long id) {

        accountRepository.deleteById(id);
    }
}
