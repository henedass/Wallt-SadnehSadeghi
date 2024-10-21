package com.isc.wallet1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@Entity
public class Transaction {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Min(value = 100000, message = "The amount should be more than 100000")
        @Max(value = 10000000, message = "The amount should be less than 10000000")
        @Column(name = "amount", nullable = false)
        private Long amount; // Consider using BigDecimal for better precision

        @Column(name = "transactionDate", nullable = false)
        private LocalDate transactionDate;

        @Column(name = "transactionType", nullable = false)
        @Pattern(regexp = "deposit|withdrawal", message = "Transaction type must be 'deposit' or 'withdrawal'")
        private String transactionType; // Restrict to 'deposit' or 'withdrawal'

        @ManyToOne
        @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
        private Account account; // Proper foreign key reference to Account


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}