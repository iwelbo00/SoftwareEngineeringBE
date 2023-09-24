package com.example.factory.SoftwareEngineering.controller;

import com.example.factory.SoftwareEngineering.entity.orderDetails;
import com.example.factory.SoftwareEngineering.repository.orderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class orderController {

    @Autowired
    private orderRepository orderRepository;

    @GetMapping("/orders")
    public List<orderDetails> fetchOrders(){
        return orderRepository.findAll();
    }


}