package com.intuit.home.repository;

import com.intuit.home.entity.Payee;
import com.intuit.home.entity.Payer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface PayeeRepository extends CrudRepository<Payee, UUID> {
    @Query(value = "SELECT p FROM Payee p WHERE p.payeeId = ?1")
    Optional<Payee> findByPayeeId(UUID payerId);
}
