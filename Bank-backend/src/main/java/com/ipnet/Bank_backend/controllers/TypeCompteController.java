package com.ipnet.Bank_backend.controllers;

import com.ipnet.Bank_backend.entities.Compte;
import com.ipnet.Bank_backend.entities.TypeCompte;
import com.ipnet.Bank_backend.services.CompteService;
import com.ipnet.Bank_backend.services.TypeCompteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
 
@RequestMapping(path = "/api/typeCompte")
public class TypeCompteController {

    private final TypeCompteService typeCompteService;

    public TypeCompteController(TypeCompteService typeCompteService) {
        this.typeCompteService = typeCompteService;
    }


    @ResponseStatus(value = HttpStatus.CREATED)
     
    @PostMapping("/")
    public ResponseEntity<TypeCompte> save(@RequestBody TypeCompte typeCompte) {
        TypeCompte savedTypeCompte = this.typeCompteService.create(typeCompte);
        return ResponseEntity.ok(savedTypeCompte);
    }

     
    @GetMapping("/")
    public ResponseEntity<List<TypeCompte>> findAll() {
        return ResponseEntity.ok(this.typeCompteService.getAll());}

     
    @GetMapping("/{id}")
    public ResponseEntity<TypeCompte> findById(@PathVariable (value = "id")Long id) {
        TypeCompte Compte = this.typeCompteService.findById(id);
        return ResponseEntity.ok(Compte);
    }

     
    @PutMapping("/{id}")
    public ResponseEntity<TypeCompte> update(@PathVariable Long id,
                                                   @RequestBody TypeCompte typeCompte) {
        TypeCompte typeCompteUpdate = this. typeCompteService.update(typeCompte, id);
        return ResponseEntity.ok(typeCompteUpdate);
    }

     
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, @RequestBody TypeCompte typeCompte) {
        this.typeCompteService.delete(typeCompte.getId());
    }
}
