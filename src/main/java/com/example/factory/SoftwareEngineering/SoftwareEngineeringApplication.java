package com.example.factory.SoftwareEngineering;
import com.example.factory.SoftwareEngineering.entity.orderDetails;
import com.example.factory.SoftwareEngineering.repository.orderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoftwareEngineeringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SoftwareEngineeringApplication.class, args);
	}

	@Autowired
	private orderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception{

		orderDetails orderDetails1 = orderDetails.builder()
				.creationDate("10-22-2023")
				.qty(3)
				.totalCost(23.23)
				.build();

		orderDetails orderDetails2 = orderDetails.builder()
				.creationDate("10-26-2023")
				.qty(1)
				.totalCost(28.23)
				.build();

		orderDetails orderDetails3 = orderDetails.builder()
				.creationDate("10-30-2023")
				.qty(8)
				.totalCost(25.23)
				.build();

		orderRepository.save(orderDetails1);
		orderRepository.save(orderDetails2);
		orderRepository.save(orderDetails3);

	}
}
