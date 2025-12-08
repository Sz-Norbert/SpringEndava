package org.example.springendava.services;

import org.example.springendava.exceptions.NotEnoughMoneyException;
import org.example.springendava.models.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }

}
