package com.example.factory.SoftwareEngineering.repository;

import com.example.factory.SoftwareEngineering.entity.rawMaterialDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface rawMaterialRepository extends JpaRepository<rawMaterialDetails, Long> {

}