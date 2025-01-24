package com.ipnet.Bank_backend.controllers;

import com.ipnet.Bank_backend.entities.Client;
import com.ipnet.Bank_backend.entities.Compte;
import com.ipnet.Bank_backend.repository.ClientRepository;
import com.ipnet.Bank_backend.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/compte")

public class ClientController {

    private final ClientService clientService;
    private final ClientRepository ClientRepository;

    public ClientController(ClientService clientService, ClientRepository clientRepository) {
        this.clientService = clientService;
        this.ClientRepository = clientRepository;
    }

    @PostMapping("/")
    public ResponseEntity<Client> save(@RequestBody Client client) {
        Client saved = this.clientService.createClient(client);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/")
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok(this. clientService.getAllClients());}


    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable(value = "id")Long id) {
        Client Client = this. clientService.getClientById(id);
        return ResponseEntity.ok(Client);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id,
                                         @RequestBody Client client) {
        Client update = this. clientService.updateClient(client, id);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this. clientService.delete(id);
    }
}
