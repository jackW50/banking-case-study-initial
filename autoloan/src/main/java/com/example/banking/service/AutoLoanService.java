package com.example.banking.service;

import com.example.banking.model.AutoLoan;
import com.example.banking.repository.AutoLoanRepository;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AutoLoanService {

    private AutoLoanRepository autoLoanRepository;

    public AutoLoanService(AutoLoanRepository autoLoanRepository) {
        this.autoLoanRepository = autoLoanRepository;
    }

    public AutoLoan saveLoan(AutoLoan loan) {
        System.out.println(loan.getName());
        try {
            if(loan.getName() == null || loan.getName() == "") {
                    return new AutoLoan.InnerAutoLoanBuilder()
                            .addId(null)
                            .addClientId(null)
                            .addName(null)
                            .addBalance(null)
                            .addMessage("Cannot save account at this time").build();
            }
            return this.autoLoanRepository.save(loan);
        } catch (Exception e) {
            return new AutoLoan.InnerAutoLoanBuilder()
                    .addId(null)
                    .addClientId(null)
                    .addName(null)
                    .addBalance(null)
                    .addMessage("Cannot save account at this time").build();
        }

    }
}
