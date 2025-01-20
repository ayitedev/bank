package com.ipnet.Bank_backend.services;

import com.ipnet.Bank_backend.entities.Client;

import java.util.List;

public interface ClientService {
    Client create (Client client);
    Client update (Client client, Long id);
    List<Client> listeClient();
    void delete (Long id);
    Client findById (Long id);
}
