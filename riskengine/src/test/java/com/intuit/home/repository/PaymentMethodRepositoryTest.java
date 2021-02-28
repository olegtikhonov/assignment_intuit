package com.intuit.home.repository;

import com.intuit.home.entity.PaymentMethod;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AUTO_CONFIGURED)
public class PaymentMethodRepositoryTest {
    @Autowired private PaymentMethodRepository paymentMethodRepository;

    @Disabled
    @Test
    public void findByPayerId() {
        PaymentMethod paymentMethod = createPaymentMethod();
        paymentMethodRepository.save(paymentMethod);
        assertEquals(1, paymentMethodRepository.count());
    }

    private PaymentMethod createPaymentMethod() {
        return new PaymentMethod().setPayerId(UUID.randomUUID()).
                                   setBankAccount("0123456789012").
                                   setPaymentMethodId(UUID.randomUUID()).
                                   setPaymentMethodTypeId(12);
    }
}
