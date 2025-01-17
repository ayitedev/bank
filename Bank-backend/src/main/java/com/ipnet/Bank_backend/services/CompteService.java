package com.ipnet.Bank_backend.services;

import com.ipnet.Bank_backend.entities.Compte;

import java.util.List;

public interface CompteService {

    Compte create (Compte compte);
    Compte update (Compte compte, Long id);
    List<Compte>  listeCompte ();
    void  delete (Long id);
    Compte  findById (Long id);
}
