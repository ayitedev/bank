package com.ipnet.Bank_backend.entities;
import jakarta.persistence.*;

import lombok.*;

@Data
@Entity

public class TypeCompte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libelle", nullable = false)
    private String libelle;

    public TypeCompte(Long id) {
        this.id = id;
    }

    public TypeCompte(Long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public TypeCompte() {
    }
}
