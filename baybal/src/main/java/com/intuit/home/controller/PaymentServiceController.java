package com.intuit.home.controller;

import com.intuit.home.entity.Payee;
import com.intuit.home.entity.PaymentMethod;
import com.intuit.home.request.PaymentRequest;
import com.intuit.home.service.PaymentService;
import com.intuit.home.service.PaymentSystemDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;


@RestController
public class PaymentServiceController {
    private final Logger logger = LogManager.getLogger(PaymentServiceController.class);
    private PaymentService paymentService;
    private PaymentSystemDAO paymentSystemDAO;


    public PaymentServiceController(PaymentService paymentService, PaymentSystemDAO paymentSystemDAO) {
        this.paymentService = paymentService;
        this.paymentSystemDAO = paymentSystemDAO;
    }


    @RequestMapping(path = "/payment/method/{userID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<PaymentMethod>> getPaymentMethodByUserID(@PathVariable(value="userID") String userID) {
        return new ResponseEntity<>(paymentSystemDAO.getPaymentMethods(UUID.fromString(userID)), HttpStatus.OK);
    }

    @PostMapping(path = "/payment", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> makePayment(@RequestBody PaymentRequest paymentRequest) {
        paymentService.sendMessage(paymentRequest);
        return new ResponseEntity<>("Payment request accepted for further processing. Stay tuned.", HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/payee")
    public ResponseEntity<List<Payee>> getPayees() {
        return new ResponseEntity<>(paymentSystemDAO.getPayees(), HttpStatus.OK);
    }
}
