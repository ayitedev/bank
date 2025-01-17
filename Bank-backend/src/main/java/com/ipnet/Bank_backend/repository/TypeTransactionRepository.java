package com.ipnet.Bank_backend.repository;
import com.ipnet.Bank_backend.entities.TypeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeTransactionRepository extends JpaRepository<TypeTransaction, Long> {

}
