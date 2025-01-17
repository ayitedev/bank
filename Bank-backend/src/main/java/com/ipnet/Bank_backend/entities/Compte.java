package com.ipnet.Bank_backend.entities;


import jakarta.persistence.*;

import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String proprietaire;

    private Double  balance;


    @ManyToOne
    @JoinColumn(name = "typeCompte_id")
    private TypeCompte typeCompte;
}
