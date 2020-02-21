package com.example.banking.service;

import com.example.banking.model.Deposit;
import com.example.banking.model.DepositWrapper;
import com.example.banking.repository.DepositRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class DepositService {

    private DepositRepository depositRepository;

    public DepositService(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    public Deposit saveDepositAccount(DepositWrapper depositWrapper) {

        try {
            StringBuilder generatedRandomAccountNumber = new StringBuilder();
            for(int i = 0; i < 9; i++) {
                generatedRandomAccountNumber.append(new Random().nextInt(10));
            }


            Deposit depositAccount = Deposit.builder()
                    .addClientId(depositWrapper.getClientId())
                    .addName(depositWrapper.getName())
                    .addBalance(depositWrapper.getInitialBalance())
                    .addAccountNumber(generatedRandomAccountNumber.toString()).build();


            return this.depositRepository.save(depositAccount);
        } catch(Exception e) {
            return Deposit.builder()
                    .addId(null)
                    .addClientId(null)
                    .addName(null)
                    .addAccountNumber(null)
                    .addBalance(null)
                    .addMessage("Not able to create this account at this time.").build();
        }
    }

    public List<Deposit> getDepositByClientId(Long clientId) {
        return this.depositRepository.findAllByClientId(clientId);
    }

    public List<Deposit> getAllDepositAccounts() {
        return (List) this.depositRepository.findAll();
    }

    public Deposit updateDepositAccount(Long id, Deposit updatedDeposit) {
        Optional<Deposit> currentDeposit = this.depositRepository.findById(id);

        if(currentDeposit.isPresent()) {
            return this.depositRepository.save(Deposit.builder()
                    .addId(currentDeposit.get().getId())
                    .addClientId(updatedDeposit.getClientId())
                    .addAccountNumber(updatedDeposit.getAccountNumber())
                    .addName(updatedDeposit.getName())
                    .addBalance(currentDeposit.get().getBalance())
                    .build());
        }

        return Deposit.builder()
                .addId(null)
                .addClientId(null)
                .addName(null)
                .addAccountNumber(null)
                .addBalance(null)
                .addMessage("Cannot update loan at this time").build();

    }

    public Boolean deleteDeposit(Long id) {

        Boolean success = true;

        try {
            this.depositRepository.deleteById(id);
        } catch (Exception e) {
            success = false;
        }

        return success;
    }
}
