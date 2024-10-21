package com.isc.wallet1.service;

import com.isc.wallet1.model.Account;
import com.isc.wallet1.model.Transaction;
import com.isc.wallet1.repo.AccountRepository;
import com.isc.wallet1.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Transaction createTransaction(Long accountId, Long amount, String transactionType) {
        Optional<Account> accountOpt = accountRepository.findById(accountId);
        if (accountOpt.isPresent()) {
            Account account = accountOpt.get();

            // اگر تراکنش برداشت است و موجودی کافی نیست
            if (transactionType.equalsIgnoreCase("withdrawal") && account.getBalance() < amount) {
                throw new RuntimeException("Insufficient balance for withdrawal");
            }

            // به روز رسانی موجودی حساب
            if (transactionType.equalsIgnoreCase("deposit")) {
                account.setBalance(account.getBalance() + amount);
            } else if (transactionType.equalsIgnoreCase("withdrawal")) {
                account.setBalance(account.getBalance() - amount);
            }

            // ذخیره تراکنش
            Transaction transaction = new Transaction();
            transaction.setAccount(account);
            transaction.setAmount(amount);
            transaction.setTransactionDate(LocalDate.now());
            transaction.setTransactionType(transactionType);

            accountRepository.save(account);  // به روز رسانی حساب
            return transactionRepository.save(transaction);  // ذخیره تراکنش
        } else {
            throw new RuntimeException("Account not found");
        }
    }

    public List<Transaction> getTransactionsByAccount(Long accountId) {
        Optional<Account> accountOpt = accountRepository.findById(accountId);
        if (accountOpt.isPresent()) {
            return transactionRepository.findByAccount(accountOpt.get());
        } else {
            throw new RuntimeException("Account not found");
        }
    }
}
