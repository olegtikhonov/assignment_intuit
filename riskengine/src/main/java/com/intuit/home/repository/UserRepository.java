package com.intuit.home.repository;

import com.intuit.home.entity.Payer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<Payer, UUID> {
    @Query(value = "SELECT p FROM Payer p WHERE p.payerId = ?1")
    Optional<Payer> findByPayerId(UUID payerId);
}
