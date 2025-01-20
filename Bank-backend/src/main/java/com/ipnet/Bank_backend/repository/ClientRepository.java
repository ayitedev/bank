package com.ipnet.Bank_backend.repository;

import com.ipnet.Bank_backend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
