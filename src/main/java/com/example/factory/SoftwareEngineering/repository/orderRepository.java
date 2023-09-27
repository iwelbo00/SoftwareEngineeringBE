package com.example.factory.SoftwareEngineering.repository;

import com.example.factory.SoftwareEngineering.entity.orderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface orderRepository extends JpaRepository<orderDetails, Long> {

    List<orderDetails> findByUser_UserId(int username);
}