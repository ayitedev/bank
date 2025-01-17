package com.ipnet.Bank_backend.servicesImp;

import com.ipnet.Bank_backend.entities.Compte;
import com.ipnet.Bank_backend.repository.CompteRepository;
import com.ipnet.Bank_backend.services.CompteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteServiceImp implements CompteService {

    private final CompteRepository compteRepository;

    public CompteServiceImp(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @Override
    public Compte create(Compte compte) {
        return compteRepository.save(compte);
    }

    @Override
    public Compte update(Compte compte, Long id) {
        return null;
    }

    @Override
    public List<Compte> listeCompte() {
        return compteRepository.findAll();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Compte findById(Long id) {
        return null;
    }
}
