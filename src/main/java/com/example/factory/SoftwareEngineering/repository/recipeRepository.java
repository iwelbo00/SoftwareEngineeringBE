package com.example.factory.SoftwareEngineering.repository;

import com.example.factory.SoftwareEngineering.entity.recipeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface recipeRepository extends JpaRepository<recipeDetails, Long> {

}