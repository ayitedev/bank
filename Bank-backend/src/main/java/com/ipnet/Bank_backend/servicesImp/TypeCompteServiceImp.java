package com.ipnet.Bank_backend.servicesImp;

import com.ipnet.Bank_backend.entities.Compte;
import com.ipnet.Bank_backend.entities.TypeCompte;
import com.ipnet.Bank_backend.repository.CompteRepository;
import com.ipnet.Bank_backend.repository.TypeCompteRepository;
import com.ipnet.Bank_backend.services.CompteService;
import com.ipnet.Bank_backend.services.TypeCompteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeCompteServiceImp implements TypeCompteService {

    private final TypeCompteRepository typeCompteRepository;

    public TypeCompteServiceImp(TypeCompteRepository typeCompteRepository) {
        this.typeCompteRepository = typeCompteRepository;
    }


    @Override
    public TypeCompte create(TypeCompte typeCompte) {
        return null;
    }

    @Override
    public TypeCompte update(TypeCompte typeCompte, Long id) {
        return null;
    }

    @Override
    public List<TypeCompte> getAll() {
        return this.typeCompteRepository.findAll();
    }



    @Override
    public void delete(Long id) {

    }

    @Override
    public TypeCompte findById(Long id) {
        return null;
    }
}
