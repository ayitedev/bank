package com.ipnet.Bank_backend.entities;

import jakarta.persistence.*;

import lombok.*;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private Double  monatnt;

    @ManyToOne
    @JoinColumn(name = "typeTransaction_id")
    private TypeTransaction typeTransaction;
}
