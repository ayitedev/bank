package com.ipnet.Bank_backend.servicesImp;

import com.ipnet.Bank_backend.entities.Transaction;
import com.ipnet.Bank_backend.repository.TransactionRepository;
import com.ipnet.Bank_backend.services.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImp implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImp(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction create(Transaction transaction) {
        // Sauvegarde et retourne la transaction créée
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction update(Transaction transaction, Long id) {
        // Recherche si une transaction existe avec cet id
        return transactionRepository.findById(id)
                .map(existingTransaction -> {
                    // Met à jour les champs nécessaires
                    existingTransaction.setMontant(transaction.getMontant());
                    existingTransaction.setDate(transaction.getDate());
                    existingTransaction.setCompte(transaction.getCompte());
                    // Sauvegarde les modifications
                    return transactionRepository.save(existingTransaction);
                })
                .orElse(null); // Retourne null si l'entité n'existe pas
    }

    @Override
    public List<Transaction> listeTransaction() {
        // Retourne la liste de toutes les transactions
        return transactionRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        // Vérifie si une transaction existe avant de la supprimer
        transactionRepository.findById(id).ifPresent(transactionRepository::delete);
    }

    @Override
    public Transaction findById(Long id) {
        // Retourne une transaction si elle existe, sinon null
        return transactionRepository.findById(id).orElse(null);
    }
}
