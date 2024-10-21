package com.isc.wallet1.repo;

import com.isc.wallet1.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,Long> {
}
