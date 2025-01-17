package com.ipnet.Bank_backend.services;

import com.ipnet.Bank_backend.entities.Compte;
import com.ipnet.Bank_backend.entities.TypeCompte;

import java.util.List;

public interface TypeCompteService {

    TypeCompte create (TypeCompte typeCompte);
    TypeCompte update (TypeCompte typeCompte, Long id);
    List<TypeCompte>  getAll ();
    void  delete (Long id);
    TypeCompte  findById (Long id);
}
