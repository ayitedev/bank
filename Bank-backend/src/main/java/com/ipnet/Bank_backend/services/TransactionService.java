package com.ipnet.Bank_backend.services;

import com.ipnet.Bank_backend.entities.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction create (Transaction transaction);
    Transaction update (Transaction transaction, Long id);
    List<Transaction> listeTransaction();
    void delete (Long id);
    Transaction findById (Long id);
}
