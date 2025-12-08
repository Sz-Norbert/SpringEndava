package org.example.springendava.controllers;

import lombok.RequiredArgsConstructor;
import org.example.springendava.models.Payment;
import org.example.springendava.proxy.PaymentsProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class PaymentsController {

    private final PaymentsProxy paymentsProxy;


    @PostMapping("/payment")
    public Mono<Payment> createPayment(
            @RequestBody Payment payment
    ) {
        String requestId = UUID.randomUUID().toString();
        return paymentsProxy.createPayment(requestId, payment);
    }
}
