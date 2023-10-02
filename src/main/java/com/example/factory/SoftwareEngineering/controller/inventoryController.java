package com.example.factory.SoftwareEngineering.controller;

import com.example.factory.SoftwareEngineering.entity.inventoryDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.factory.SoftwareEngineering.repository.inventoryRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin("http://localhost:8081/")

public class inventoryController {

    @Autowired
    private inventoryRepository inventoryRepository;
    /**
     * Retrieves a list of inventory details.
     *
     * This endpoint allows users to retrieve a list of inventory details from the database.
     *
     * @return A list of inventory details.
     */
    @GetMapping("/getInventory")
    public List<inventoryDetails> loginUser(){
        List<inventoryDetails> inventoryList = inventoryRepository.findAll();
        Collections.sort(inventoryList, new Comparator<inventoryDetails>() {
            @Override
            public int compare(inventoryDetails item1, inventoryDetails item2) {
                // Compare in reverse order
                return Long.compare(item1.getItemId(), item2.getItemId());
            }
        });
        return inventoryList;
    }


}
