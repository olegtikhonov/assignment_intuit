package com.intuit.home.service;

import com.intuit.home.entity.Payer;
import com.intuit.home.entity.Payment;
import com.intuit.home.repository.PayerRepository;
import com.intuit.home.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class PayerService {
    private PayerRepository payerRepository;
    private PaymentRepository paymentRepository;

    public PayerService(PayerRepository payerRepository,PaymentRepository paymentRepository) {
        this.payerRepository = payerRepository;
        this.paymentRepository = paymentRepository;
    }

    public Payer getPayerById(UUID userID) {
        return payerRepository.findById(userID).get();
    }

    public List<Payer> getAllPayers() {
        List<Payer> result = new ArrayList<>();
        payerRepository.findAll().forEach(result::add);
        return result;
    }

    public List<Payment> getAllPayments() {
        List<Payment> allPayments = new ArrayList<>();
        paymentRepository.findAll().forEach(allPayments::add);
        return allPayments;
    }
}
