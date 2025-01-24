package com.ipnet.Bank_backend.controllers;

import com.ipnet.Bank_backend.entities.Client;
import com.ipnet.Bank_backend.entities.Profession;
import com.ipnet.Bank_backend.repository.ProfessionRepository;
import com.ipnet.Bank_backend.services.ProfessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/compte")

public class ProfessionController {

    private final ProfessionService professionService;

    public ProfessionController(ProfessionService professionService) {
        this.professionService = professionService;
    }

    @PostMapping("/")
    public ResponseEntity<Profession> save(@RequestBody Profession profession) throws Exception {
        Profession saved = this.professionService.createProfession(profession);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/")
    public ResponseEntity<List<Profession>> findAll() throws Exception {
        return ResponseEntity.ok(this.professionService.getAllProfessions());}


    @GetMapping("/{id}")
    public ResponseEntity<Profession> findById(@PathVariable(value = "id")Long id) throws Exception {
        Profession Profession = this.professionService.getProfessionById(id);
        return ResponseEntity.ok(Profession);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Profession> update(@PathVariable Long id,
                                         @RequestBody Profession profession) throws Exception {
        Profession update = this.professionService.updateProfession(profession, id);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.professionService.delete(id);
    }
}
