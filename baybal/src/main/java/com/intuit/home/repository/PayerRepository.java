package com.intuit.home.repository;

import com.intuit.home.entity.Payer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PayerRepository extends CrudRepository<Payer, UUID> {
}
