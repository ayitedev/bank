package com.ipnet.Bank_backend.services;


import com.ipnet.Bank_backend.entities.Client;

import java.util.List;

public interface ClientService {

    Client getClientById(Long clientId);

    List<Client> getAllClients();

    Client createClient(Client client);

    Client updateClient(Client client, Long id);

    void delete(Long id);
}
