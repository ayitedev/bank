package com.ipnet.Bank_backend.repository;

import com.ipnet.Bank_backend.entities.Compte;
import com.ipnet.Bank_backend.entities.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeCompteRepository extends JpaRepository<TypeCompte, Long> {
}
