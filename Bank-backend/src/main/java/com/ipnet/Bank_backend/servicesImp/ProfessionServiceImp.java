package com.ipnet.Bank_backend.servicesImp;

import com.ipnet.Bank_backend.entities.Profession;
import com.ipnet.Bank_backend.repository.ProfessionRepository;
import com.ipnet.Bank_backend.services.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessionServiceImp implements ProfessionService {

    @Autowired
    private ProfessionRepository professionRepository;

    @Override
    public Profession create(Profession profession) {
        // Sauvegarde de la profession
        return professionRepository.save(profession);
    }

    @Override
    public Profession update(Profession profession, Long id) {
        // Vérification de l'existence de la profession
        Optional<Profession> existingProfession = professionRepository.findById(id);
        if (existingProfession.isPresent()) {
            Profession updatedProfession = existingProfession.get();
            updatedProfession.setLibelle(profession.getLibelle());
            return professionRepository.save(updatedProfession);
        }
        throw new RuntimeException("Profession avec l'ID " + id + " non trouvée.");
    }

    @Override
    public List<Profession> listeProfession() {
        // Retourne toutes les professions
        return professionRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        // Vérification de l'existence avant suppression
        if (professionRepository.existsById(id)) {
            professionRepository.deleteById(id);
        } else {
            throw new RuntimeException("Profession avec l'ID " + id + " non trouvée.");
        }
    }

    @Override
    public Profession findById(Long id) {
        // Recherche par ID
        return professionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profession avec l'ID " + id + " non trouvée."));
    }
}
