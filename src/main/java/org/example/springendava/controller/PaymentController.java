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

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;


    @PostMapping("/payment")
    private ResponseEntity<?> makePayment() {
        try {
            PaymentDetails paymentDetails = new PaymentDetails();
            paymentService.processPayment();
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);
        }catch (NotEnoughMoneyException ex){
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Not enough money to make the payment.");
            return ResponseEntity
                    .badRequest()
                    .body(errorDetails);
        }
    }
}
