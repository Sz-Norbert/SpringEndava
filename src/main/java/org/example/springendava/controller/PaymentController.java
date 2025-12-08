package org.example.springendava.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.example.springendava.exceptions.NotEnoughMoneyException;
import org.example.springendava.models.ErrorDetails;
import org.example.springendava.models.PaymentDetails;
import org.example.springendava.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private static Logger logger = Logger.getLogger(PaymentController.class.getName());


    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment(@RequestBody PaymentDetails paymentDetails) {

        logger.info("Received payment " +
                paymentDetails.getAmount());

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }
}
