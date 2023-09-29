package com.example.factory.SoftwareEngineering.controller;

import com.example.factory.SoftwareEngineering.entity.transactionHistoryDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.factory.SoftwareEngineering.repository.transactionHistoryRepository;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
@CrossOrigin("http://localhost:8081/")

public class transactionController {

    @Autowired
    private transactionHistoryRepository transactionHistoryRepository;

    @GetMapping("/getTransaction")
    public List<transactionHistoryDetails> loginUser(){
        return transactionHistoryRepository.findAll();
    }

}
