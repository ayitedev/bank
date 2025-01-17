package com.ipnet.Bank_backend.servicesImp;

import com.ipnet.Bank_backend.entities.Transaction;
import com.ipnet.Bank_backend.repository.TransactionRepository;
import com.ipnet.Bank_backend.services.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImp implements TransactionService {

    private final TransactionRepository TransactionRepository;

    public TransactionServiceImp(TransactionRepository TransactionRepository) {
        this.TransactionRepository = TransactionRepository;
    }

    @Override
    public Transaction create(Transaction compte) {
        return TransactionRepository.save(compte);
    }

    @Override
    public List<Transaction> findAll() {
        return List.of();
    }

    @Override
    public Transaction update(Transaction compte, Long id) {
        return null;
    }

    @Override
    public List<Transaction> listeCompte() {
        return TransactionRepository.findAll();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Transaction findById(Long id) {
        return null;
    }
}
