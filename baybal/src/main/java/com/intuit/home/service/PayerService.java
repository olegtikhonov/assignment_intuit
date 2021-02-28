package com.intuit.home.service;

import com.intuit.home.entity.Payer;
import com.intuit.home.repository.PayerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class PayerService {
    private PayerRepository payerRepository;

    public PayerService(PayerRepository payerRepository) {
        this.payerRepository = payerRepository;
    }

    public Payer getPayerById(UUID userID) {
        return payerRepository.findById(userID).get();
    }

    public List<Payer> getAllPayers() {
        List<Payer> result = new ArrayList<>();
        payerRepository.findAll().forEach(result::add);
        return result;
    }
}
