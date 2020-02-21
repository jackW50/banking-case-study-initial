package com.example.banking.repository;

import com.example.banking.model.AutoLoan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoLoanRepository extends CrudRepository<AutoLoan, Long> {


    List<AutoLoan> findAllByClientId(Long clientId);
}
