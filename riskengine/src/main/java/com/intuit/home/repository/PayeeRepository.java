package com.intuit.home.repository;

import com.intuit.home.entity.Payee;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PayeeRepository  extends CrudRepository<Payee, UUID> {
}
