package com.example.banking.service;

import com.example.banking.model.AutoLoan;
import com.example.banking.repository.AutoLoanRepository;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoLoanService {

    private AutoLoanRepository autoLoanRepository;

    public AutoLoanService(AutoLoanRepository autoLoanRepository) {
        this.autoLoanRepository = autoLoanRepository;
    }

    public AutoLoan saveLoan(AutoLoan loan) {
        try {
            if(loan.getName() == null || loan.getName() == "") {
                    return AutoLoan.builder()
                            .addId(null)
                            .addClientId(null)
                            .addName(null)
                            .addBalance(null)
                            .addMessage("Cannot save account at this time").build();

            }
            return this.autoLoanRepository.save(loan);

        } catch (Exception e) {
            return AutoLoan.builder()
                    .addId(null)
                    .addClientId(null)
                    .addName(null)
                    .addBalance(null)
                    .addMessage("Cannot save account at this time").build();
        }

    }

    public List<AutoLoan> getAccountsByClientId(Long clientId) {

        return this.autoLoanRepository.findAllByClientId(clientId);
    }

    public List<AutoLoan> allLoans() {

        return (List) this.autoLoanRepository.findAll();
    }

    public AutoLoan updateClient(AutoLoan loan, Long loanId) {
        Optional<AutoLoan> currentLoan = this.autoLoanRepository.findById(loanId);

        if(currentLoan.isPresent()) {
            return this.autoLoanRepository.save(AutoLoan.builder()
                    .addId(currentLoan.get().getId())
                    .addClientId(loan.getClientId())
                    .addName(loan.getName())
                    .addBalance(currentLoan.get().getBalance())
                    .build());
        }

        return AutoLoan.builder()
                .addId(null)
                .addClientId(null)
                .addName(null)
                .addBalance(null)
                .addMessage("Cannot update loan at this time").build();


    }

    public Boolean deleteAccount(Long id) {
        Boolean success = true;

        try {
            this.autoLoanRepository.deleteById(id);
        } catch (Exception e) {
            success = false;
        }

        return success;
    }
}
