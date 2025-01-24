package com.ipnet.Bank_backend.entities;

import jakarta.persistence.*;

import lombok.*;

@Data
@Entity
@AllArgsConstructor
@Builder
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;

    // Constructeurs
    public Profession() {
    }

    public Profession(String libelle) {
        this.libelle = libelle;
    }

}
