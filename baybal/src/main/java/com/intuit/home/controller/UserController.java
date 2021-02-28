package com.intuit.home.controller;

import com.intuit.home.entity.Payer;
import com.intuit.home.service.PayerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final Logger logger = LogManager.getLogger(UserController.class);
    private PayerService payerService;

    public UserController(PayerService payerService) {
        this.payerService = payerService;
    }


    @GetMapping(path = "/users")
    public List<Payer> getRegisteredUsers() {
        logger.info("Getting users/payers");
        return payerService.getAllPayers();
    }

    @ExceptionHandler({ Throwable.class, Exception.class })
    public void handleException() {
        logger.error("An error occured");
    }
}
