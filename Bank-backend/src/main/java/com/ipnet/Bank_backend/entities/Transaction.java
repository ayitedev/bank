package com.ipnet.Bank_backend.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private Double montant;

    @ManyToOne
    @JoinColumn(name = "typeTransaction_id")
    private TypeTransaction typeTransaction;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte; // Relation avec l'entité Compte

    // Constructeur par défaut
    public Transaction() {
    }

    // Constructeur avec tous les champs
    public Transaction(Long id, Date date, Double montant, TypeTransaction typeTransaction, Compte compte) {
        this.id = id;
        this.date = date;
        this.montant = montant;
        this.typeTransaction = typeTransaction;
        this.compte = compte;
    }

    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public TypeTransaction getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(TypeTransaction typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
