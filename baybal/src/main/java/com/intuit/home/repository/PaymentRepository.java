package com.intuit.home.repository;

import com.intuit.home.entity.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface PaymentRepository extends CrudRepository<Payment, UUID> {
}
