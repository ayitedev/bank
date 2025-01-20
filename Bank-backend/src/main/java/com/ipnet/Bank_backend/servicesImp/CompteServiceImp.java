package com.ipnet.Bank_backend.servicesImp;

import com.ipnet.Bank_backend.entities.Compte;
import com.ipnet.Bank_backend.repository.CompteRepository;
import com.ipnet.Bank_backend.services.CompteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompteServiceImp implements CompteService {

    private final CompteRepository compteRepository;

    public CompteServiceImp(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @Override
    public Compte create(Compte compte) {
        // Enregistrement d'un nouveau compte
        return compteRepository.save(compte);
    }

    @Override
    public Compte update(Compte compte, Long id) {
        // Vérifier si le compte existe
        Optional<Compte> existingCompte = compteRepository.findById(id);
        if (existingCompte.isPresent()) {
            Compte updatedCompte = existingCompte.get();
            updatedCompte.setProprietaire(compte.getProprietaire());
            updatedCompte.setBalance(compte.getBalance());
            updatedCompte.setTypeCompte(compte.getTypeCompte());
            return compteRepository.save(updatedCompte);
        }
        throw new RuntimeException("Compte avec l'ID " + id + " non trouvé.");
    }

    @Override
    public List<Compte> listeCompte() {
        // Retourner tous les comptes
        return compteRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        // Vérifier si le compte existe avant suppression
        if (compteRepository.existsById(id)) {
            compteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Compte avec l'ID " + id + " non trouvé.");
        }
    }

    @Override
    public Compte findById(Long id) {
        // Recherche par ID
        return compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte avec l'ID " + id + " non trouvé."));
    }
}
