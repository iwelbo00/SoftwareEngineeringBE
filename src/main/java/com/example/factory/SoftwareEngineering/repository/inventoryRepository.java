package com.example.factory.SoftwareEngineering.repository;

import com.example.factory.SoftwareEngineering.entity.inventoryDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface inventoryRepository extends JpaRepository<inventoryDetails, Long> {

    inventoryDetails findByItemId(long id);
}