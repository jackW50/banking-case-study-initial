package com.example.banking.controller;

import com.example.banking.model.Deposit;
import com.example.banking.model.DepositWrapper;
import com.example.banking.service.DepositService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deposit/")
public class DepositController {

    private DepositService depositService;

    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @PostMapping(value= "createDepositAccount", produces = "application/json")
    public Deposit createDepositAccount(@RequestBody DepositWrapper depositWrapper) {
        return this.depositService.saveDepositAccount(depositWrapper);
    }

    @GetMapping(value = "getDepositAccountsByClientId/{clientId}", produces = "application/json")
    public List<Deposit> getDepositAccountsByClientId(@PathVariable Long clientId) {
        return this.depositService.getDepositByClientId(clientId);
    }

    @GetMapping(value = "getAllDepositAccounts", produces = "application/json")
    public List<Deposit> getAllDepositAccounts() {
        return this.depositService.getAllDepositAccounts();
    }

    @PutMapping(value = "updateDepositAccount/{id}", produces = "application/json")
    public Deposit updateDepositAccount(@PathVariable Long id, @RequestBody Deposit deposit) {
        return this.depositService.updateDepositAccount(id, deposit);
    }

    @DeleteMapping(value = "deleteDepositAccount/{id}", produces = "application/json")
    public ResponseEntity<Boolean> deleteCard(@PathVariable Long id) {
        Boolean success = this.depositService.deleteDeposit(id);
        HttpStatus status;
        String message = "";

        if (success) {
            status = HttpStatus.NO_CONTENT;
            message = "Successfully deleted.";
        } else {
            status = HttpStatus.NOT_FOUND;
            message = "Resource not found.";
        }

        return new ResponseEntity(message, status);
    }
}
