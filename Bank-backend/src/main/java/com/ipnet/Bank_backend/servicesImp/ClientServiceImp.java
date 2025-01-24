package com.ipnet.Bank_backend.servicesImp;

import com.ipnet.Bank_backend.entities.Client;
import com.ipnet.Bank_backend.services.ClientService;

import java.util.List;

public class ClientServiceImp implements ClientService {

    @Override
    public Client getClientById(Long clientId) {
        return null;
    }

    @Override
    public List<Client> getAllClients() {
        return List.of();
    }

    @Override
    public Client createClient(Client client) {
        return null;
    }

    @Override
    public Client updateClient(Client client, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
