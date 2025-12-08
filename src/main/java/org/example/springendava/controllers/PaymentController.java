package org.example.springendava.controllers;

import lombok.RequiredArgsConstructor;
import org.example.springendava.PaymentProxy;
import org.example.springendava.models.Payment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private static Logger logger =Logger.getLogger(PaymentController.class.getName());

    private final PaymentProxy paymentsProxy;

    @PostMapping("/payment")
    public Payment createPayment(
            @RequestBody Payment payment
    ) {
        String requestId = UUID.randomUUID().toString();
        logger.info("Processing payment with requestId: " + requestId);
        return paymentsProxy.createPayment(requestId,payment);
    }


}
