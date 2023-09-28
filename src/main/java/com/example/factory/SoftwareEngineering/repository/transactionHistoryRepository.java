package com.example.factory.SoftwareEngineering.repository;

import com.example.factory.SoftwareEngineering.entity.transactionHistoryDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface transactionHistoryRepository extends JpaRepository<transactionHistoryDetails, Long> {
    transactionHistoryDetails findByUser_UserId(int userId);
}