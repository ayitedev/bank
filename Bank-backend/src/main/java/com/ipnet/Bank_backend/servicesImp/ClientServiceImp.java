package com.ipnet.Bank_backend.servicesImp;

import com.ipnet.Bank_backend.entities.Client;
import com.ipnet.Bank_backend.repository.ClientRepository;
import com.ipnet.Bank_backend.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client create(Client client) {
        // Sauvegarde du client
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client, Long id) {
        // Vérification de l'existence du client
        Optional<Client> existingClient = clientRepository.findById(id);
        if (existingClient.isPresent()) {
            Client updatedClient = existingClient.get();
            updatedClient.setNom(client.getNom());
            updatedClient.setPrenom(client.getPrenom());
            updatedClient.setAdresse(client.getAdresse());
            updatedClient.setSexe(client.getSexe());
            updatedClient.setNumero(client.getNumero());
            updatedClient.setProfession(client.getProfession());
            return clientRepository.save(updatedClient);
        }
        throw new RuntimeException("Client avec l'ID " + id + " non trouvé.");
    }

    @Override
    public List<Client> listeClient() {
        // Retourne tous les clients
        return clientRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        // Vérification de l'existence avant suppression
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        } else {
            throw new RuntimeException("Client avec l'ID " + id + " non trouvé.");
        }
    }

    @Override
    public Client findById(Long id) {
        // Recherche par ID
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client avec l'ID " + id + " non trouvé."));
    }
}
