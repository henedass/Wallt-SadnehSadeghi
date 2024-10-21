package com.isc.wallet1.repo;


import com.isc.wallet1.model.Account;
import com.isc.wallet1.model.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    List<Transaction> findByAccount(Account account);
}

