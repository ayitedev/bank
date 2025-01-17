package com.ipnet.Bank_backend.entities;

import jakarta.persistence.*;

@Entity
public class TypeTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libelle", nullable = false)
    private String libelle;

    // Constructeur par défaut
    public TypeTransaction() {
    }

    // Constructeur avec tous les champs
    public TypeTransaction(Long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    // Getter et Setter pour id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter et Setter pour libelle
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
