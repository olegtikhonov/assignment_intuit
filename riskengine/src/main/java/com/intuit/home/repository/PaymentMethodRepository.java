package com.intuit.home.repository;


import com.intuit.home.entity.PaymentMethod;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, UUID> {
    @Query(value = "SELECT p FROM PaymentMethod p WHERE p.payerId = ?1")
    Optional<List<PaymentMethod>> findByPayerId(UUID payerId);

    @Query(value = "SELECT p FROM PaymentMethod p WHERE p.paymentMethodId = ?1")
    Optional<PaymentMethod> findByPaymentMethodId(UUID payerId);
}
