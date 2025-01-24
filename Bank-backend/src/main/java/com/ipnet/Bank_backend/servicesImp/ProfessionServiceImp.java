package com.ipnet.Bank_backend.servicesImp;

import com.ipnet.Bank_backend.entities.Profession;
import com.ipnet.Bank_backend.services.ProfessionService;

import java.util.List;

public class ProfessionServiceImp implements ProfessionService {
    @Override
    public Profession getProfessionById(Long professionId) throws Exception {
        return null;
    }

    @Override
    public List<Profession> getAllProfessions() throws Exception {
        return List.of();
    }

    @Override
    public Profession createProfession(Profession profession) throws Exception {
        return null;
    }

    @Override
    public Profession updateProfession(Profession profession, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
