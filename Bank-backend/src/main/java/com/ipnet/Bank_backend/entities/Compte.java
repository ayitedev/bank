package com.ipnet.Bank_backend.entities;

import jakarta.persistence.*;

@Entity
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String proprietaire;

    private Double balance;

    @ManyToOne
    @JoinColumn(name = "typeCompte_id")
    private TypeCompte typeCompte;

    // Constructeur par défaut
    public Compte() {
    }

    // Constructeur avec tous les champs
    public Compte(Long id, String proprietaire, Double balance, TypeCompte typeCompte) {
        this.id = id;
        this.proprietaire = proprietaire;
        this.balance = balance;
        this.typeCompte = typeCompte;
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public TypeCompte getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(TypeCompte typeCompte) {
        this.typeCompte = typeCompte;
    }
}
