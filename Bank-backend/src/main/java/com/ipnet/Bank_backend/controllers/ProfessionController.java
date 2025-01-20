package com.ipnet.Bank_backend.controllers;

import com.ipnet.Bank_backend.entities.Profession;
import com.ipnet.Bank_backend.services.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/professions")
public class ProfessionController {

    private final ProfessionService professionService;

    @Autowired
    public ProfessionController(ProfessionService professionService) {
        this.professionService = professionService;
    }

    // Créer une nouvelle profession
    @PostMapping
    public ResponseEntity<Profession> createProfession(@RequestBody Profession profession) {
        Profession createdProfession = professionService.create(profession);
        return ResponseEntity.ok(createdProfession);
    }

    // Mettre à jour une profession existante
    @PutMapping("/{id}")
    public ResponseEntity<Profession> updateProfession(@PathVariable Long id, @RequestBody Profession profession) {
        Profession updatedProfession = professionService.update(profession, id);
        return ResponseEntity.ok(updatedProfession);
    }

    // Lister toutes les professions
    @GetMapping("/")
    public ResponseEntity<List<Profession>> getAllProfessions() {
        List<Profession> professions = professionService.listeProfession();
        return ResponseEntity.ok(professions);
    }

    // Récupérer une profession par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Profession> getProfessionById(@PathVariable Long id) {
        Profession profession = professionService.findById(id);
        return ResponseEntity.ok(profession);
    }

    // Supprimer une profession
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfession(@PathVariable Long id) {
        professionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
