package com.example.factory.SoftwareEngineering.controller;

import com.example.factory.SoftwareEngineering.entity.*;
import com.example.factory.SoftwareEngineering.entity.orderDetails;
import com.example.factory.SoftwareEngineering.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import com.example.factory.SoftwareEngineering.entity.userDetails;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin("http://localhost:8081/orders")
public class orderController {

    @Autowired
    private orderRepository orderRepository;
    @Autowired
    private userRepository userRepository;
    @Autowired
    private inventoryRepository inventoryRepository;
    @Autowired
    private transactionHistoryRepository transactionHistoryRepository;
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
    public ResponseEntity<String> postOrder(@RequestBody orderDetails orderDetails){
        userDetails user = userRepository.findByUsername(orderDetails.getUser().getUsername());
        orderDetails.setUser(user);
        inventoryDetails inventoryDetails = inventoryRepository.findByItemId(orderDetails.getInventory().getItemId());
        while(inventoryDetails.getQuantityOnHand() < orderDetails.getQuantity()){
            inventoryDetails.setQuantityOnHand(inventoryDetails.getQuantityOnHand() + inventoryDetails.getMinimumCreation());
            transactionHistoryDetails transactions = new transactionHistoryDetails();
            transactions.setUser(user);
            transactions.setTransactionType("Restocking");
            transactions.setTransactionDate();
        }


        if(orderDetails != null){
            orderRepository.save(orderDetails);
            return ResponseEntity.ok("Order Success");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Authentication failed");
        }
    }

}