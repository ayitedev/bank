package com.ipnet.Bank_backend.servicesImp;

import com.ipnet.Bank_backend.entities.TypeTransaction;
import com.ipnet.Bank_backend.repository.TypeTransactionRepository;
import com.ipnet.Bank_backend.services.TypeTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeTransactionServiceImp implements TypeTransactionService {

    private final TypeTransactionRepository typeTransactionRepository;

    public TypeTransactionServiceImp(TypeTransactionRepository typeTransactionRepository) {
        this.typeTransactionRepository = typeTransactionRepository;
    }

    @Override
    public TypeTransaction create(TypeTransaction typeTransaction) {
        // Sauvegarde et retourne le nouveau type de transaction
        return typeTransactionRepository.save(typeTransaction);
    }

    @Override
    public TypeTransaction update(TypeTransaction typeTransaction, Long id) {
        // Recherche le type de transaction par ID, puis met à jour les champs nécessaires
        return typeTransactionRepository.findById(id)
                .map(existingType -> {
                    existingType.setLibelle(typeTransaction.getLibelle());
                    return typeTransactionRepository.save(existingType);
                })
                .orElse(null); // Retourne null si l'ID n'existe pas
    }


    @Override
    public List<TypeTransaction> getAll() {
        // Retourne tous les types de transaction
        return typeTransactionRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        // Supprime le type de transaction s'il existe
        typeTransactionRepository.findById(id).ifPresent(typeTransactionRepository::delete);
    }

    @Override
    public TypeTransaction findById(Long id) {
        // Retourne le type de transaction correspondant à l'ID ou null
        return typeTransactionRepository.findById(id).orElse(null);
    }
}
