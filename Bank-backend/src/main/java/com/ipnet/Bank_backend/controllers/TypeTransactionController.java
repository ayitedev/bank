package com.ipnet.Bank_backend.controllers;

import com.ipnet.Bank_backend.entities.TypeTransaction;
import com.ipnet.Bank_backend.services.TypeTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/typeTransaction")
public class TypeTransactionController {

    private final TypeTransactionService typeTransactionService;

    public TypeTransactionController(TypeTransactionService typeTransactionService) {
        this.typeTransactionService = typeTransactionService;
    }

    // Création d'un type de transaction
    @PostMapping("/")
    public ResponseEntity<TypeTransaction> save(@RequestBody TypeTransaction typeTransaction) {
        TypeTransaction savedTypeTransaction = this.typeTransactionService.create(typeTransaction);
        return ResponseEntity.ok(savedTypeTransaction);
    }

    // Récupération de tous les types de transaction
    @GetMapping("/")
    public ResponseEntity<List<TypeTransaction>> findAll() {
        return ResponseEntity.ok(this.typeTransactionService.getAll());
    }

    // Récupération d'un type de transaction par ID
    @GetMapping("/{id}")
    public ResponseEntity<TypeTransaction> findById(@PathVariable(value = "id") Long id) {
        TypeTransaction typeTransaction = this.typeTransactionService.findById(id);
        return ResponseEntity.ok(typeTransaction);
    }

    // Mise à jour d'un type de transaction
    @PutMapping("/{id}")
    public ResponseEntity<TypeTransaction> update(@PathVariable Long id, @RequestBody TypeTransaction typeTransaction) {
        TypeTransaction updatedTypeTransaction = this.typeTransactionService.update(typeTransaction, id);
        return ResponseEntity.ok(updatedTypeTransaction);
    }

    // Suppression d'un type de transaction
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.typeTransactionService.delete(id);
    }
}
