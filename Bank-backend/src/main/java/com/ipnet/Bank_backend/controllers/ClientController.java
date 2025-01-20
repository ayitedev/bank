package com.ipnet.Bank_backend.controllers;

import com.ipnet.Bank_backend.entities.Client;
import com.ipnet.Bank_backend.entities.Profession;
import com.ipnet.Bank_backend.services.ClientService;
import com.ipnet.Bank_backend.services.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clients")
public class ClientController {

    private final ClientService clientService;
    private final ProfessionService professionService;

    @Autowired
    public ClientController(ClientService clientService, ProfessionService professionService) {
        this.clientService = clientService;
        this.professionService = professionService;
    }

    // Créer un nouveau client
    @PostMapping("/")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client createdClient = clientService.create(client);
        return ResponseEntity.ok(createdClient);
    }

    // Mettre à jour un client existant
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        Client updatedClient = clientService.update(client, id);
        return ResponseEntity.ok(updatedClient);
    }

    // Lister tous les clients
    @GetMapping("/")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.listeClient();
        return ResponseEntity.ok(clients);
    }

    // Récupérer un client par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = clientService.findById(id);
        return ResponseEntity.ok(client);
    }

    // Supprimer un client
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Lister toutes les professions
    @GetMapping("/professions")
    public ResponseEntity<List<Profession>> getAllProfessions() {
        List<Profession> professions = professionService.listeProfession();
        return ResponseEntity.ok(professions);
    }
}
