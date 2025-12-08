package org.example.springendava.controllers;

import lombok.RequiredArgsConstructor;
import org.example.springendava.models.Payment;
import org.example.springendava.proxy.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentsController {
    private final PaymentsProxy paymentsProxy;

    @PostMapping("/payment")
    public Payment createPayment(
            @RequestBody Payment payment
    ) {
        return paymentsProxy.createPayment(payment);
    }
}
