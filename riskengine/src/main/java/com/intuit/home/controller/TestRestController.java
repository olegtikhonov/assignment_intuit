package com.intuit.home.controller;

import com.intuit.home.common.RequestConverter;
import com.intuit.home.entity.Payment;
import com.intuit.home.entity.PaymentMethod;
import com.intuit.home.repository.PayeeRepository;
import com.intuit.home.repository.PaymentMethodRepository;
import com.intuit.home.repository.PaymentRepository;
import com.intuit.home.request.PaymentRequest;
import com.intuit.home.response.PaymentResponse;
import com.intuit.home.service.NaiveRiskAnalysis;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
public class TestRestController {
    private static final Logger logger = LogManager.getLogger(TestRestController.class.getName());
    @Autowired private PaymentMethodRepository paymentMethodRepository;
    @Autowired private PayeeRepository payeeRepository;
    @Autowired private PaymentRepository paymentRepository;
    @Autowired private NaiveRiskAnalysis naiveRiskAnalysis;


    @GetMapping(path = "/payment/method", produces = MediaType.APPLICATION_JSON_VALUE)
    public void getMethods() {
        logger.debug("Testing get payment methods");
        List<PaymentMethod> showMe = new ArrayList<>();
        paymentMethodRepository.findAll().forEach(showMe::add);
        logger.debug(showMe);
    }

    @GetMapping(path = "/payment/method/{userID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void getMethodsByUserId(@PathVariable (value="userID") String userID) {
        logger.debug("Testing get payment methods by user ID");
        List<PaymentMethod> showMe = new ArrayList<>();
        logger.debug(paymentMethodRepository.findByPayerId(UUID.fromString(userID)));
    }

    @GetMapping(path = "/payee", produces = MediaType.APPLICATION_JSON_VALUE)
    public void getAllPayee() {
        logger.debug("Testing get all payees");
        logger.debug(payeeRepository.findAll());
    }

    @GetMapping(path = "/payment", produces = MediaType.APPLICATION_JSON_VALUE)
    public void getAllPayments() {
        logger.debug("Testing get all payments");
        logger.debug(paymentRepository.findAll());
    }

    @PostMapping(path = "/payment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentResponse> doPayment(@RequestBody PaymentRequest paymentRequest) {
        logger.debug("Making payment ...");
        Payment toBeMade = RequestConverter.toPayment(paymentRequest);
        PaymentResponse response = naiveRiskAnalysis.performAnalysis(Optional.of(paymentRequest));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
