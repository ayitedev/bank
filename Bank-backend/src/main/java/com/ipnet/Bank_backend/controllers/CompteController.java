package com.ipnet.Bank_backend.controllers;

import com.ipnet.Bank_backend.entities.Compte;
import com.ipnet.Bank_backend.entities.TypeCompte;
import com.ipnet.Bank_backend.repository.TypeCompteRepository;
import com.ipnet.Bank_backend.services.CompteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
 
@RequestMapping(path = "/api/compte")
public class CompteController {

    private final CompteService compteService;
    private final TypeCompteRepository typeCompteRepository;

    public CompteController(CompteService compteService, TypeCompteRepository typeCompteRepository) {
        this.compteService = compteService;
        this.typeCompteRepository = typeCompteRepository;
    }


     
    @PostMapping("/")
    public ResponseEntity<Compte> save(@RequestBody Compte compte) {
        Compte savedAnneeScolaire = this.compteService.create(compte);
        return ResponseEntity.ok(savedAnneeScolaire);
    }

     
    @GetMapping("/")
    public ResponseEntity<List<Compte>> findAll() {
        return ResponseEntity.ok(this. compteService.listeCompte());}

     
    @GetMapping("/{id}")
    public ResponseEntity<Compte> findById(@PathVariable (value = "id")Long id) {
        Compte Compte = this. compteService.findById(id);
        return ResponseEntity.ok(Compte);
    }

     
    @PutMapping("/{id}")
    public ResponseEntity<Compte> update(@PathVariable Long id,
                                                   @RequestBody Compte Compte) {
        Compte anneeScolaireUpdate = this. compteService.update(Compte, id);
        return ResponseEntity.ok(anneeScolaireUpdate);
    }

     
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, @RequestBody Compte Compte) {
        this. compteService.delete(Compte.getId());
    }
}
