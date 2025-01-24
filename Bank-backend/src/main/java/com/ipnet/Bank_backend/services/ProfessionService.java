package com.ipnet.Bank_backend.services;

import com.ipnet.Bank_backend.entities.Profession;

import java.util.List;

public interface ProfessionService {
    
    Profession getProfessionById(Long professionId) throws Exception;
    
    List<Profession> getAllProfessions() throws Exception;
    
    Profession createProfession(Profession profession) throws Exception;
    
    Profession updateProfession(Profession profession, Long id) throws Exception;

    void delete(Long id);
}
