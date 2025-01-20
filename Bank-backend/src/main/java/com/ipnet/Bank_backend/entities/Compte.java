package com.ipnet.Bank_backend.entities;

import jakarta.persistence.*;

@Entity
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client proprietaire;

    private Double balance;

    @ManyToOne
    @JoinColumn(name = "typeCompte_id", nullable = false)
    private TypeCompte typeCompte;

    // Constructeur par défaut
    public Compte() {
    }

    // Constructeur avec tous les champs
    public Compte(Long id, Client proprietaire, Double balance, TypeCompte typeCompte) {
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

    public Client getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Client proprietaire) {
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
