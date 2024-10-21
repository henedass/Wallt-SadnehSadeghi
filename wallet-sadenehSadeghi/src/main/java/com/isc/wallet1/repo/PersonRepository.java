package com.isc.wallet1.repo;

import com.isc.wallet1.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
