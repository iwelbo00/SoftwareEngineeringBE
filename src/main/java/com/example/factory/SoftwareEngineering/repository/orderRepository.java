package com.example.factory.SoftwareEngineering.repository;

import com.example.factory.SoftwareEngineering.entity.orderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderRepository extends JpaRepository<orderDetails, Long> {

}
