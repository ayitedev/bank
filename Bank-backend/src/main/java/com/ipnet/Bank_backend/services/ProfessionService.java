package com.ipnet.Bank_backend.services;

import com.ipnet.Bank_backend.entities.Profession;

import java.util.List;

public interface ProfessionService {
    Profession create (Profession profession);
    Profession update (Profession profession, Long id);
    List<Profession> listeProfession();
    void delete (Long id);
    Profession findById (Long id);
}
