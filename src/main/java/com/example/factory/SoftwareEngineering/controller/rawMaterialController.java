package com.example.factory.SoftwareEngineering.controller;

import com.example.factory.SoftwareEngineering.entity.rawMaterialDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.factory.SoftwareEngineering.repository.rawMaterialRepository;

import java.util.List;

@RestController
@RequestMapping("/api/raw")
@CrossOrigin("http://localhost:8081/")

public class rawMaterialController {

    @Autowired
    private rawMaterialRepository rawMaterialRepository;

    @GetMapping("/getMaterials")
    public List<rawMaterialDetails> loginUser(){
        return rawMaterialRepository.findAll();
    }

}
