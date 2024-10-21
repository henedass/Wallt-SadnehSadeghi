package com.isc.wallet1.controller;

import com.isc.wallet1.model.Transaction;
import com.isc.wallet1.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/api/transactions")
    public class TransactionController {

        @Autowired
        private TransactionService transactionService;

        // ایجاد تراکنش جدید
        @PostMapping
        public ResponseEntity<Transaction> createTransaction(
                @RequestParam Long accountId,
                @RequestParam Long amount,
                @RequestParam String transactionType) {
            try {
                Transaction transaction = transactionService.createTransaction(accountId, amount, transactionType);
                return new ResponseEntity<>(transaction, HttpStatus.CREATED);
            } catch (RuntimeException e) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }

        // نمایش لیست تراکنش‌های یک حساب
        @GetMapping("/account/{accountId}")
        public ResponseEntity<List<Transaction>> getTransactionsByAccount(@PathVariable Long accountId) {
            try {
                List<Transaction> transactions = transactionService.getTransactionsByAccount(accountId);
                return new ResponseEntity<>(transactions, HttpStatus.OK);
            } catch (RuntimeException e) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }


}
