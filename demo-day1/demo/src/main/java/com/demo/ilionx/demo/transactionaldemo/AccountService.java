package com.demo.ilionx.demo.transactionaldemo;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional //(dontRollbackOn = RuntimeException.class)
    public Account transferFunds(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
        Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
       // accountRepository.save(fromAccount);

        Account toAccount = accountRepository.findByAccountNumber(toAccountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        toAccount.setBalance(toAccount.getBalance().add(amount));
       // accountRepository.save(toAccount);

        return fromAccount;
    }


}
