package com.example.banking.service;

import com.example.banking.model.CreditCard;
import com.example.banking.repository.CreditCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService {

    private CreditCardRepository creditCardRepository;

    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public CreditCard saveCreditCard(CreditCard card) {

        try {
            return this.creditCardRepository.save(card);
        } catch(Exception e) {
            return CreditCard.builder()
                    .addId(null)
                    .addClientId(null)
                    .addName(null)
                    .addNumber(null)
                    .addBalance(null)
                    .addMessage("Not able to create this account at this time.").build();
        }
    }

    public List<CreditCard> getClientCreditCards(Long clientId) {
        return this.creditCardRepository.findAllByClientId(clientId);
    }

    public List<CreditCard> getAll() {

        return (List) this.creditCardRepository.findAll();
    }

    public CreditCard findCreditCardById(CreditCard updatedCard, Long id) {
        Optional<CreditCard> currentCard = this.creditCardRepository.findById(id);

        if(currentCard.isPresent()) {
            return this.creditCardRepository.save(CreditCard.builder()
                    .addId(currentCard.get().getId())
                    .addClientId(updatedCard.getClientId())
                    .addNumber(updatedCard.getNumber())
                    .addName(updatedCard.getName())
                    .addBalance(currentCard.get().getBalance())
                    .build());
        }

        return CreditCard.builder()
                .addId(null)
                .addClientId(null)
                .addName(null)
                .addNumber(null)
                .addBalance(null)
                .addMessage("Cannot update loan at this time").build();

    }

    public Boolean deleteCard(Long id) {
        Boolean success = true;

        try {
            this.creditCardRepository.deleteById(id);
        } catch (Exception e) {
            success = false;
        }

        return success;

    }
}
