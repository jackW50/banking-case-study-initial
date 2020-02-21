package com.example.banking.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditCard {

    @Id
    @GeneratedValue
    Long id;
    Long clientId;
    String number;
    String name;
    Double balance;
    String message;

    public CreditCard() {
    }

    public CreditCard(Long id, Long clientId, String number, String name, Double balance, String message) {
        this.id = id;
        this.clientId = clientId;
        this.number = number;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
        return "CreditCard{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", message='" + message + '\'' +
                '}';
    }

    public static InnerCreditCardBuilder builder() { return new InnerCreditCardBuilder(); }

    public static class InnerCreditCardBuilder {
        CreditCard creditCard;

        public InnerCreditCardBuilder() { this.creditCard = new CreditCard(); }

        Long id;
        Long clientId;
        String number;
        String name;
        Double balance;
        String message;

        public InnerCreditCardBuilder addId(Long id) {
            this.creditCard.id = id;
            return this;
        }

        public InnerCreditCardBuilder addClientId(Long clientId) {
            this.creditCard.clientId = clientId;
            return this;
        }

        public InnerCreditCardBuilder addNumber(String number) {
            this.creditCard.number = number;
            return this;
        }

        public InnerCreditCardBuilder addName(String name) {
            this.creditCard.name = name;
            return this;
        }

        public InnerCreditCardBuilder addBalance(Double balance) {
            this.creditCard.balance = balance;
            return this;
        }

        public InnerCreditCardBuilder addMessage(String message) {
            this.creditCard.message = message;
            return this;
        }

        public CreditCard build() {
            return this.creditCard;
        }
    }
}
