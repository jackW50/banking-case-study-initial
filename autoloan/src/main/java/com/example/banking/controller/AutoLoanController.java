package com.example.banking.controller;

import com.example.banking.model.AutoLoan;
import com.example.banking.service.AutoLoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autoloan/")
public class AutoLoanController {

    private AutoLoanService autoLoanService;

    public AutoLoanController(AutoLoanService autoLoanService) {
        this.autoLoanService = autoLoanService;
    }

    @PostMapping(value = "createLoan", produces = "application/json")
    public AutoLoan createLoan(@RequestBody AutoLoan newLoan) {

        return this.autoLoanService.saveLoan(newLoan);

    }

    @GetMapping(value = "getLoansByClientId/{clientId}", produces = "application/json")
    public List<AutoLoan> getByClientId(@PathVariable Long clientId) {
        return this.autoLoanService.getAccountsByClientId(clientId);
    }

    @GetMapping(value = "getAllLoans", produces = "application/json")
    public List<AutoLoan> getAllLoans() {
        return this.autoLoanService.allLoans();
    }

    @PutMapping(value = "updateLoan/{loanId}", produces = "application/json")
    public AutoLoan updateLoan(@RequestBody AutoLoan loan, @PathVariable Long loanId) {
        return this.autoLoanService.updateClient(loan, loanId);
    }

    @DeleteMapping(value = "deleteLoan/{id}", produces = "application/json")
    public ResponseEntity<Boolean> deleteLoan(@PathVariable Long id) {
        Boolean success = this.autoLoanService.deleteAccount(id);
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
