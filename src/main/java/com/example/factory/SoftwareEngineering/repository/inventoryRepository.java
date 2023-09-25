package com.example.factory.SoftwareEngineering.repository;

import com.example.factory.SoftwareEngineering.entity.inventoryDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface inventoryRepository extends JpaRepository<inventoryDetails, Long> {

}