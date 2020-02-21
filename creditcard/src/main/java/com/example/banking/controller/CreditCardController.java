package com.example.banking.controller;

import com.example.banking.model.CreditCard;
import com.example.banking.service.CreditCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creditcard/")
public class CreditCardController {

    private CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }


    @PostMapping(value = "createCreditCard", produces = "application/json")
    public CreditCard createCreditCard(@RequestBody CreditCard card) {
        return this.creditCardService.saveCreditCard(card);
    }

    @GetMapping(value = "getCreditCardsByClientId/{clientId}", produces = "application/json")
    public List<CreditCard> getCreditCardByClientId(@PathVariable Long clientId) {
        return this.creditCardService.getClientCreditCards(clientId);
    }

    @GetMapping(value = "getAllCreditCards", produces = "application/json")
    public List<CreditCard> getAllCreditCards() {
        return this.creditCardService.getAll();
    }

    @PutMapping(value = "updateCreditCard/{id}", produces = "application/json")
    public CreditCard updateCreditCardById(@RequestBody CreditCard creditCard, @PathVariable Long id) {
        return this.creditCardService.findCreditCardById(creditCard, id);
    }

    @DeleteMapping(value = "deleteCreditCard/{id}", produces = "application/json")
    public ResponseEntity<Boolean> deleteCard(@PathVariable Long id) {
        Boolean success = this.creditCardService.deleteCard(id);
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
