package com.ipnet.Bank_backend.controllers;

import com.ipnet.Bank_backend.entities.Transaction;
import com.ipnet.Bank_backend.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Création d'une transaction
    @PostMapping("/")
    public ResponseEntity<Transaction> save(@RequestBody Transaction transaction) {
        Transaction savedTransaction = this.transactionService.create(transaction);
        return ResponseEntity.ok(savedTransaction);
    }

    // Récupération de toutes les transactions
    @GetMapping("/")
    public ResponseEntity<List<Transaction>> findAll() {
        return ResponseEntity.ok(this.transactionService.listeTransaction());
    }

    // Récupération d'une transaction par ID
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable(value = "id") Long id) {
        Transaction transaction = this.transactionService.findById(id);
        return ResponseEntity.ok(transaction);
    }

    // Mise à jour d'une transaction
    @PutMapping("/{id}")
    public ResponseEntity<Transaction> update(@PathVariable Long id, @RequestBody Transaction transaction) {
        Transaction updatedTransaction = this.transactionService.update(transaction, id);
        return ResponseEntity.ok(updatedTransaction);
    }

    // Suppression d'une transaction
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.transactionService.delete(id);
    }
}
