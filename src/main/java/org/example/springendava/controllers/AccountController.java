package org.example.springendava.controllers;

import lombok.RequiredArgsConstructor;
import org.example.springendava.dtos.TransferRequest;
import org.example.springendava.models.Account;
import org.example.springendava.services.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final TransferService  transferService;
    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest request
    ){
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount());
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return transferService.getAllAccounts();
    }

}
