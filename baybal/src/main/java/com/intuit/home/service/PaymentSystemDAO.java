package com.intuit.home.service;

import com.intuit.home.entity.Payee;
import com.intuit.home.entity.PaymentMethod;
import com.intuit.home.repository.PayeeRepository;
import com.intuit.home.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Provides data access mechanism, as a wrapper of repositories
 */
@Service
public class PaymentSystemDAO {
    @Autowired private PaymentMethodRepository paymentRepository;
    @Autowired private PayeeRepository payeeRepository;


    /**
     * Gets payment methods by user id.
     *
     * @param payerId
     * @return
     */
    public List<PaymentMethod> getPaymentMethods(UUID payerId) {
        Optional<List<PaymentMethod>> result = paymentRepository.findByPayerId(payerId);
        return (result.isPresent()) ? result.get() : Collections.emptyList();
    }

    /**
     * Gets a list of payees.
     * @return
     */
    public List<Payee> getPayees() {
        List<Payee> result = new ArrayList<>();
        payeeRepository.findAll().forEach(result::add);
        return result;
    }
}
