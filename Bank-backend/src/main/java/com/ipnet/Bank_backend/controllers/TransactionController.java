package com.ipnet.Bank_backend.controllers;

import com.ipnet.Bank_backend.entities.Transaction;
import com.ipnet.Bank_backend.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    // Constructor Dependency Injection
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Créer une transaction
    @PostMapping("/")
    public ResponseEntity<Transaction> save(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionService.create(transaction);
        return ResponseEntity.ok(savedTransaction);
    }

    // Obtenir la liste des transactions
    @GetMapping("/")
    public ResponseEntity<List<Transaction>> findAll() {
        return ResponseEntity.ok(transactionService.findAll());
    }

    // Obtenir une transaction par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable Long id) {
        Transaction transaction = transactionService.findById(id);
        return ResponseEntity.ok(transaction);
    }

    // Mettre à jour une transaction existante
    @PutMapping("/{id}")
    public ResponseEntity<Transaction> update(@PathVariable Long id, @RequestBody Transaction transaction) {
        Transaction updatedTransaction = transactionService.update(transaction, id);
        return ResponseEntity.ok(updatedTransaction);
    }

    // Supprimer une transaction par son ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        transactionService.delete(id);
    }
}
