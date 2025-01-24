package com.ipnet.Bank_backend.entities;


import jakarta.persistence.*;

import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String num;
    private String nom;
    private String prenoms;
    private String sexe;
    private String adresse;


    @ManyToOne(optional = false)
    @JoinColumn(name = "profession_id", nullable = false)
    private Profession profession;
}
