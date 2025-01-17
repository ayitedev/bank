package com.ipnet.Bank_backend.repository;

import com.ipnet.Bank_backend.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
