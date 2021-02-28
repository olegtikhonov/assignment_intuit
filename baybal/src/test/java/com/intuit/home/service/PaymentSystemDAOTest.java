package com.intuit.home.service;

import com.intuit.home.entity.Payee;
import com.intuit.home.entity.PaymentMethod;
import com.intuit.home.repository.PayeeRepository;
import com.intuit.home.repository.PaymentMethodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class PaymentSystemDAOTest {
    public static final int EXPECTED = 1;
    @InjectMocks
    PaymentSystemDAO paymentSystemDAO;
    @Mock
    private PaymentMethodRepository paymentRepository;
    @Mock
    private PayeeRepository payeeRepository;
    @Mock
    private PaymentMethod paymentMethod;
    @Mock
    private Payee payee;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getPaymentMethods() {
        UUID payerId = UUID.randomUUID();
        when(paymentRepository.findByPayerId(payerId)).thenReturn(Optional.empty());
        List<PaymentMethod> result = paymentSystemDAO.getPaymentMethods(payerId);
        assertNotNull(result);

        // case 2: not empty
        List<PaymentMethod> listOfEntities = new ArrayList<>();
        listOfEntities.add(paymentMethod);
        when(paymentRepository.findByPayerId(payerId)).thenReturn(Optional.of(listOfEntities));
        List<PaymentMethod> resultNotEmpty = paymentSystemDAO.getPaymentMethods(payerId);
        assertEquals(EXPECTED, resultNotEmpty.size());
    }

    @Test
    public void getPayees() {
        List<Payee> output = new ArrayList<>();
        output.add(payee);
        when(payeeRepository.findAll()).thenReturn(output);
        List<Payee> result = paymentSystemDAO.getPayees();
        assertEquals(EXPECTED, result.size());
    }
}
