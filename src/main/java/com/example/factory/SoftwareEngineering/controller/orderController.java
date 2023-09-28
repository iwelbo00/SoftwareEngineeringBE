package com.example.factory.SoftwareEngineering.controller;

import com.example.factory.SoftwareEngineering.entity.*;
import com.example.factory.SoftwareEngineering.entity.orderDetails;
import com.example.factory.SoftwareEngineering.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.factory.SoftwareEngineering.services.dateService;


import java.util.*;
import com.example.factory.SoftwareEngineering.entity.userDetails;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin("http://localhost:8081")
public class orderController {

    @Autowired
    private orderRepository orderRepository;
    @Autowired
    private userRepository userRepository;
    @Autowired
    private inventoryRepository inventoryRepository;
    @Autowired
    private transactionHistoryRepository transactionHistoryRepository;
    @Autowired
    private dateService dateService;
    @Autowired recipeRepository recipeRepository;
    @Autowired
    private rawMaterialRepository rawMaterialRepository;
    @GetMapping("/findAll")
    public List<orderDetails> fetchOrders(){
        return orderRepository.findAll();
    }
    @GetMapping("/findByUsername")
    public List<orderDetails> fetchByUsernameOrders(@RequestBody userDetails userDetails){
        userDetails temp = userRepository.findByUsername(userDetails.getUsername());
        return orderRepository.findByUser_UserId(temp.getUserId());
    }
    @PostMapping("/makeOrder")
    public ResponseEntity<String> postOrder(@RequestBody orderDetails orderDetails) {
        userDetails user = userRepository.findByUsername(orderDetails.getUser().getUsername());
        orderDetails.setUser(user);
        inventoryDetails inventoryDetails = inventoryRepository.findByItemId(orderDetails.getInventory().getItemId());
        while (inventoryDetails.getQuantityOnHand() < orderDetails.getQuantity()) {
            inventoryDetails.setQuantityOnHand(inventoryDetails.getQuantityOnHand() + inventoryDetails.getMinimumCreation());
            recipeDetails recipe = inventoryDetails.getRecipeId();
            rawMaterialDetails rawMaterials = recipe.getRawMaterialDetails();
            while (rawMaterials.getQtyOnHand() < recipe.getAmountToUse()) {
                transactionHistoryDetails transactions = craftTransactionHistoryDetails(user, "Restocking", ("Ordering " + rawMaterials.getMinToOrder()
                        + " " + rawMaterials.getName() + "s"));
                rawMaterials.setQtyOnHand(rawMaterials.getQtyOnHand() + rawMaterials.getMinToOrder());
                transactionHistoryRepository.save(transactions);
            }
            rawMaterials.setQtyOnHand(rawMaterials.getQtyOnHand() - recipe.getAmountToUse());
            rawMaterialRepository.save(rawMaterials);
            transactionHistoryDetails transactions = craftTransactionHistoryDetails(user, "Crafting more", ("Crafting " + inventoryDetails.getMinimumCreation() +
                    " " + inventoryDetails.getItemName() + "s"));
            transactionHistoryRepository.save(transactions);
        }
        inventoryDetails.setQuantityOnHand(inventoryDetails.getQuantityOnHand() - orderDetails.getQuantity());
        inventoryRepository.save(inventoryDetails);
        if (orderDetails != null) {
            orderRepository.save(orderDetails);
            return ResponseEntity.ok("Order Success");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Authentication failed");
        }
    }


    public transactionHistoryDetails craftTransactionHistoryDetails(userDetails user, String type, String description){
        transactionHistoryDetails transactions = new transactionHistoryDetails();

        transactions.setUser(user);
        transactions.setTransactionType(type);
        transactions.setTransactionDate(dateService.getDate());
        transactions.setDescription(description);
        return transactions;
    }

}