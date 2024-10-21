package com.isc.wallet1.controller;

import com.isc.wallet1.model.Account;
import com.isc.wallet1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping("/api/accounts")
    public class AccountController {

        @Autowired
        private AccountService accountService;

        @PostMapping
        public ResponseEntity<Account> createAccount(@RequestBody Account account) {
            Account savedAccount = accountService.createAccount(account);
            return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Account> getAccount(@PathVariable Long id) {
            return accountService.getAccount(id)
                    .map(account -> new ResponseEntity<>(account, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
            accountService.deleteAccount(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }


}
