package com.demo.ilionx.demo.transactionaldemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Account> transferMoney(@RequestBody TransferRequest transferRequest) {
        return ResponseEntity.ok(accountService.transferFunds(transferRequest.getFromAccount(), transferRequest.getToAccount(), transferRequest.getAmount()));
    }

}
