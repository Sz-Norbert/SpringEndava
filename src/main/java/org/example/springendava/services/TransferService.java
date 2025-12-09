package org.example.springendava.services;

import lombok.RequiredArgsConstructor;
import org.example.springendava.dao.AccountRepository;
import org.example.springendava.models.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Transactional

@Service
public class TransferService {

    private final AccountRepository accountRepository;



    public List<Account> getAllAccounts() {
        return accountRepository.findAllAccounts();
    }


    @Transactional
    public void transferMoney(
            long idSender,
            long idReceiver,
            BigDecimal amount) {

        Account sender = accountRepository.findAccountById(idSender);
        Account receiver = accountRepository.findAccountById(idReceiver);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);

        throw new RuntimeException("Oh no! Something went wrong!");        }
}
