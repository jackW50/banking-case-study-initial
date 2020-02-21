package com.example.banking.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import javassist.runtime.Inner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Deposit {

    @Id
    @GeneratedValue
    Long id;
    Long clientId;
    String accountNumber;
    String name;
    Double balance;
    String message;

    public Deposit() {
    }

    public Deposit(Long id, Long clientId, String accountNumber, String name, Double balance, String message) {
        this.id = id;
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", message='" + message + '\'' +
                '}';
    }

    public static InnerDepositBuilder builder() { return new InnerDepositBuilder(); }

    public static class InnerDepositBuilder {

        Deposit deposit;

        public InnerDepositBuilder() { this.deposit = new Deposit(); }

        public InnerDepositBuilder addId(Long id) {
            this.deposit.id = id;
            return this;
        }

        public InnerDepositBuilder addClientId(Long clientId) {
            this.deposit.clientId = clientId;
            return this;
        }

        public InnerDepositBuilder addAccountNumber(String accountNumber) {
            this.deposit.accountNumber = accountNumber;
            return this;
        }

        public InnerDepositBuilder addName(String name) {
            this.deposit.name = name;
            return this;
        }

        public InnerDepositBuilder addBalance(Double balance) {
            this.deposit.balance = balance;
            return this;
        }

        public InnerDepositBuilder addMessage(String message) {
            this.deposit.message = message;
            return this;
        }

        public Deposit build() {
            return this.deposit;
        }

    }
}
