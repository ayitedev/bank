package com.ipnet.Bank_backend.services;
import com.ipnet.Bank_backend.entities.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction create(Transaction transaction);

    List<Transaction> findAll();

    Transaction findById(Long id);

    Transaction update(Transaction transaction, Long id);

    List<Transaction> listeCompte();

    void delete(Long id);
}
