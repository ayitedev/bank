package com.ipnet.Bank_backend.services;

import com.ipnet.Bank_backend.entities.TypeTransaction;

import java.util.List;

public interface TypeTransactionService {
    TypeTransaction create (TypeTransaction typeTransaction);
    TypeTransaction update (TypeTransaction typeTransaction, Long id);
    List<TypeTransaction> getAll();
    void delete (Long id);
    TypeTransaction findById (Long id);
}
