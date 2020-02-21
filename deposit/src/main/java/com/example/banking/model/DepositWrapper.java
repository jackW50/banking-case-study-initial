package com.example.banking.model;

public class DepositWrapper {

    private Long clientId;
    private String name;
    private Double initialBalance;

    public DepositWrapper() {
    }

    public DepositWrapper(Long clientId, String name, Double initialBalance) {
        this.clientId = clientId;
        this.name = name;
        this.initialBalance = initialBalance;
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

    public Double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(Double initialBalance) {
        this.initialBalance = initialBalance;
    }

    @Override
    public String toString() {
        return "DepositWrapper{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", initialBalance=" + initialBalance +
                '}';
    }
}
