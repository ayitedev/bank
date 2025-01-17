package com.ipnet.Bank_backend.repository;

import com.ipnet.Bank_backend.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository  extends JpaRepository<Compte, Long> {
}
