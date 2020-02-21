package com.example.banking.controller;

import com.example.banking.model.AutoLoan;
import com.example.banking.service.AutoLoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autoLoan/")
public class AutoLoanController {

    private AutoLoanService autoLoanService;

    public AutoLoanController(AutoLoanService autoLoanService) {
        this.autoLoanService = autoLoanService;
    }

    @PostMapping(value = "createLoan", produces = "application/json")
    public AutoLoan createLoan(@RequestBody AutoLoan newLoan) {

        return this.autoLoanService.saveLoan(newLoan);

    }


}
