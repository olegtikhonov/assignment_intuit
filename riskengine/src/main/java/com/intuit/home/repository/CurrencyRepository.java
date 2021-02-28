package com.intuit.home.repository;

import com.intuit.home.entity.Currency;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;


public interface CurrencyRepository  extends CrudRepository<Currency, Integer> {
    //select iso_name from currency where currency_id = 1;
    @Query(value = "SELECT p FROM Currency p WHERE p.currencyId = ?1")
    Optional<Currency> findByName(int currencyId);
}
