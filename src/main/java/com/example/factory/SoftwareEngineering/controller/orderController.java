package com.example.factory.SoftwareEngineering.controller;

import com.example.factory.SoftwareEngineering.entity.orderDetails;
import com.example.factory.SoftwareEngineering.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        userDetails temp = userRepository.findByUsername(orderDetails.getUser().getUsername());
        orderDetails.setUser(temp);
        orderRepository.save(orderDetails);
        if(orderDetails != null){
            return ResponseEntity.ok("Order Success");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Authentication failed");
        }
    }

}