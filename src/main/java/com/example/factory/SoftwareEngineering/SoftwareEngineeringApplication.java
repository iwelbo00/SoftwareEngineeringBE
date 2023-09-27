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
	@Override
	public void run(String... args) throws Exception{

	}
}