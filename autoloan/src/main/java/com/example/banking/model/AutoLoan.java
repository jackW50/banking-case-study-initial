package com.example.banking.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AutoLoan {

    @Id
    @GeneratedValue
    private Long id;
    private Long clientId;
    private String name;
    private Double balance;
    private String message;

    public AutoLoan() {
    }

    public AutoLoan(Long id, Long clientId, String name, Double balance, String message) {
        this.id = id;
        this.clientId = clientId;
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
        return "AutoLoan{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", message='" + message + '\'' +
                '}';
    }

    public static InnerAutoLoanBuilder builder() { return new InnerAutoLoanBuilder(); }

    public static class InnerAutoLoanBuilder {
        AutoLoan autoLoan;

        public InnerAutoLoanBuilder() {
            this.autoLoan = new AutoLoan();
        }

        public InnerAutoLoanBuilder addId(Long id) {
            this.autoLoan.id = id;
            return this;
        }

        public InnerAutoLoanBuilder addClientId(Long clientId) {
            this.autoLoan.clientId = clientId;
            return this;
        }

        public InnerAutoLoanBuilder addName(String name) {
            this.autoLoan.name = name;
            return this;
        }

        public InnerAutoLoanBuilder addBalance(Double balance) {
            this.autoLoan.balance = balance;
            return this;
        }

        public InnerAutoLoanBuilder addMessage(String message) {
            this.autoLoan.message = message;
            return this;
        }

        public AutoLoan build() { return this.autoLoan; }

    }
}
